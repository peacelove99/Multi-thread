package com.yyp.threadmethod.p6yield;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        //开启子线程,计算累加和
        SubThread subThread6 = new SubThread();
        subThread6.start();

        //在main 线程中计算累加和
        long begin = System.currentTimeMillis();
        long sum = 0;
        int times = 1000000;
        for(int i = 1; i <= times; i++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("main 方法用时: " + (end - begin));
    }
}
