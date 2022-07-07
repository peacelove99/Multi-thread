package com.yyp.threadmethod.p4sleep;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        System.out.println("main__begin = " + System.currentTimeMillis());
//         subThread4.start(); //开启新的线程
        subThread.run(); //在main 线程中调用实例方法run(),没有开启新的线程
        System.out.println("main__end = " + System.currentTimeMillis());
    }
}
