package com.yyp;

import com.yyp.core.Downloader;
import com.yyp.util.LogUtils;

import java.util.Scanner;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-07
 */

public class Main {
    public static void main(String[] args) {
        String url;

        if(args == null || args.length == 0){
            do {
                LogUtils.info("请输入下载地址");
                Scanner in = new Scanner(System.in);
                url = in.next();
            } while (url == null);
        }else {
            url = args[0];
        }
        LogUtils.info("正在下载{}",url);
        Downloader downloader = new Downloader();
        downloader.downloader(url);
    }
}
