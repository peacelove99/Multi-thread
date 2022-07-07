package com.yyp.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-07
 */

public class HttpUtils {

    /**
     *  获取下载文件大小
     * @param url   文件下载地址
     * @return
     * @throws IOException
     */
    public static long getHttpFileContentLength(String url) throws IOException {
        int contentLength;
        HttpURLConnection httpUrlConnection = null;
        try {
            httpUrlConnection = getHttpUrlConnection(url);
            contentLength = httpUrlConnection.getContentLength();
        } finally {
            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
            }
        }
        return contentLength;
    }

    /**
     *  分块下载
     * @param url       下载地址
     * @param startPos  下载文件起始位置
     * @param endPos    下载文件的结束位置
     * @return
     */
    public static HttpURLConnection getHttpUrlConnection(String url, long startPos, long endPos) throws IOException {
        HttpURLConnection HttpUrlConnection = getHttpUrlConnection(url);
        LogUtils.info("下载的区间是：{}-{}",startPos,endPos);

        if (endPos != 0) {
            HttpUrlConnection.setRequestProperty("RANGE","bytes="+startPos + "-" + endPos);
        }else {
            HttpUrlConnection.setRequestProperty("RANGE","bytes="+startPos + "-");
        }

        return HttpUrlConnection;
    }

    /**
     * 获取HttpsURLConnection链接对象
     * @param url 文件地址
     * @return
     */
    public static HttpURLConnection getHttpUrlConnection(String url) throws IOException {
        URL httpUrl = new URL(url);
        HttpURLConnection httpUrlConnection = (HttpURLConnection) httpUrl.openConnection();
        //向文件所在的服务器发送标识信息
        httpUrlConnection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1");
        return httpUrlConnection;
    }

    /**
     * 获取文件的名字
     * @param url 文件地址
     * @return
     */
    public static String getHttpFileName(String url){
        int index = url.lastIndexOf("/");
        return url.substring(index+1);
    }
}
