package com.yyp.createthread.p2;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-05
 */

public class MyRunnable implements Runnable{
    @Override
    public void run() {

        int times = 10;
        for(int i = 1; i<=times; i++){
            System.out.println( "sub thread --> " + i);
        }
    }
}
