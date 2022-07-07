package com.yyp.createthread.p2;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-05
 */

public class Test {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable);

        thread.start();

        int times = 10;
        for (int i = 0; i < times; i++) {
            System.out.println("main==>"+i);
        }
    }
}
