package com.yyp.threadmethod.p6yield;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0;
        int times = 1000000;
        for(int i = 1; i <= times; i++){
            sum += i;
            //线程让步, 放弃CPU 执行权
            Thread.yield();
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程 用时: " + (end - begin));
    }
}
