package com.yyp.threadmethod.p1currentthread;

/**
 * 定义线程类
 * 分别在构造方法中和run 方法中打印当前线程
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    public SubThread() {
        System.out.println("构造方法打印当前线程的名称: " + Thread.currentThread().getName());
    }

    @Override
    public void run(){
        System.out.println("run 方法打印当前线程名称:" + Thread.currentThread().getName());
    }
}
