package com.yyp.threadmethod.p3isAlive;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        SubThread subThread3 = new SubThread();
        //false,在启动线程之前
        System.out.println("begin==" + subThread3.isAlive());
        subThread3.start();
        //结果不一定,打印这一行时,如果t3线程还没结束就返回true, 如果t3 线程已结束,返回false
        System.out.println("end==" + subThread3.isAlive());
    }
}
