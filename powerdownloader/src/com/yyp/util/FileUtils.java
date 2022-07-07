package com.yyp.util;

import java.io.File;

/**
 * 获取本地文件的大小
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-07
 */

public class FileUtils {
    public static long getFileContentLength(String path) {
        File file = new File(path);

        return file.exists() && file.isFile() ? file.length() : 0;
    }
}
