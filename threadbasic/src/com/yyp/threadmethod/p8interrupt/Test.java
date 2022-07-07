package com.yyp.threadmethod.p8interrupt;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.start();

        int times = 100;
        for(int i = 1; i <= times; i++){
            System.out.println("main --> " + i);
        }

        //中断子线程
        //仅仅是给子线程标记中断,
        subThread.interrupt();
    }
}
