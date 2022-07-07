package com.yyp.core;

import com.yyp.constant.Constant;
import com.yyp.util.FileUtils;
import com.yyp.util.HttpUtils;
import com.yyp.util.LogUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-07
 */

public class Downloader {

    public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    /**
     * 线程池对象
     */
    public ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(Constant.THREAD_NUM, Constant.THREAD_NUM, 0, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(Constant.THREAD_NUM),new ThreadPoolExecutor.AbortPolicy());

    private final CountDownLatch countDownLatch = new CountDownLatch(Constant.THREAD_NUM);

    /**
     * 文件下载
     */
    public void downloader(String url){
        //获取文件名
        String httpFileName = HttpUtils.getHttpFileName(url);
        //拼接文件储存地址
        httpFileName = Constant.PATH + httpFileName;

        //获取本地文件的大小
        long localFileLength = FileUtils.getFileContentLength(httpFileName);

        //获取连接对象
        HttpURLConnection httpUrlConnection = null;
        DownloadInfoThread downloadInfoThread;
        try {
            httpUrlConnection = HttpUtils.getHttpUrlConnection(url);
            //获取下载文件的总大小
            int contentLength = httpUrlConnection.getContentLength();

            //判断文件是否已下载过
            if (localFileLength >= contentLength) {
                LogUtils.info("{}已下载完毕，无需重新下载",httpFileName);
                return;
            }

            //创建获取下载信息的任务对象
            downloadInfoThread = new DownloadInfoThread(contentLength);
            //将任务交给线程执行，每隔1秒执行一次
            scheduledExecutorService.scheduleAtFixedRate(downloadInfoThread,1,1, TimeUnit.SECONDS);

            //切分任务
            ArrayList<Future> list = new ArrayList<>();
            spilt(url, list);

            countDownLatch.await();

            //合并文件
            if (merge(httpFileName)) {
                //清除临时文件
                clearTemp(httpFileName);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.print("\r");
            System.out.print("下载完成");
            //关闭连接对象
            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }

            //关闭
            scheduledExecutorService.shutdownNow();

            //关闭线程池
            poolExecutor.shutdown();
        }
    }

    /**
     *  文件切分
     * @param url
     * @param futureList
     */
    public void spilt(String url, ArrayList<Future> futureList) {

        try {
            //获取下载文件大小
            long contentLength = HttpUtils.getHttpFileContentLength(url);

            //计算切分后的文件大小
            long size = contentLength / Constant.THREAD_NUM;

            //计算分块个数
            for (int i = 0; i < Constant.THREAD_NUM; i++) {
                //计算下载起始位置
                long startPos = i * size;
                //计算结束位置
                long endPos;

                if (i == Constant.THREAD_NUM - 1) {
                    //下载最后一块，下载剩余的部分
                    endPos = 0;
                }else {
                    endPos = startPos + size;
                }

                //如果不是第一块，起始位置要+1
                if (startPos != 0) {
                    startPos++;
                }

                //创建任务对象
                DownloaderTask downloaderTask = new DownloaderTask(url, startPos, endPos,i,countDownLatch);

                //将任务提交到线程池中
                Future<Boolean> future = poolExecutor.submit(downloaderTask);

                futureList.add(future);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  文件合并
     * @param fileName
     * @return
     */
    public boolean merge(String fileName) {
        LogUtils.info("开始合并文件{}", fileName);
        byte[] buffer = new byte[Constant.BYTE_SIZE];
        int len = -1;
        try (RandomAccessFile accessFile = new RandomAccessFile(fileName, "rw")) {
            for (int i = 0; i < Constant.THREAD_NUM ; i++) {
                try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileName + ".temp" + i))) {
                    while ((len = bis.read(buffer)) != -1) {
                        accessFile.write(buffer,0,len);
                    }
                }
            }
            LogUtils.info("文件合并完毕{}",fileName);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * 清除临时文件
     * @param fileName
     * @return
     */
    public boolean clearTemp(String fileName) {
        for (int i = 0; i < Constant.THREAD_NUM; i++) {
            File file = new File(fileName + ".temp" + i);
            file.delete();
        }

        return true;
    }
}
