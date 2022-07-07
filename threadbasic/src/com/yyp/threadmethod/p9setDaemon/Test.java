package com.yyp.threadmethod.p9setDaemon;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();

        //设置线程为守护线程
        subThread.setDaemon(true);
        //设置守护线程的代码应该在线程启动前
        subThread.start();

        //当前线程为main 线程
        int times = 10;
        for(int i = 1; i <= times ; i++){
            System.out.println("main== " + i);
        }
        //当main 线程结束, 守护线程thread 也销毁了
    }
}
