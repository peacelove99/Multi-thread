package com.yyp.threadmethod.p4sleep;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run, threadname=" + Thread.currentThread().getName() + " ,begin= " + System.currentTimeMillis());
            //当前线程睡眠2000 毫秒
            Thread.sleep(2000);
            System.out.println("run, threadname=" + Thread.currentThread().getName() + " ,end= " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
