package com.yyp.threadmethod.p7setpriority;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class ThreadA extends Thread{
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        long sum = 0 ;
        int times = 100000000;
        for(long i = 0 ; i<= times; i++){
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("thread a : " + (end - begin));
    }
}
