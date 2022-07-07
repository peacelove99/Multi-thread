package com.yyp.threadmethod.p1currentthread;

/**
 * 测试当前线程
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        System.out.println("main 方法中打印当前线程:" + Thread.currentThread().getName());

        //创建子线程, 调用SubThread1()构造方法, 在main 线程中调用构造方法,所以构造方法中的当前线程就是main 线程
        SubThread subThread1 = new SubThread();

        subThread1.start(); //启动子线程,子线程会调用run()方法,所以run()方法中的当前线程就是Thread-0 子线程

        subThread1.run();//在main 方法中直接调用run()方法,没有开启新的线程,所以在run 方法中的当前线程就是main 线程
    }
}
