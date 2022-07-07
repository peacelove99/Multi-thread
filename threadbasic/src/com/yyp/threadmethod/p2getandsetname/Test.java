package com.yyp.threadmethod.p2getandsetname;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        //创建子线程对象
        SubThread subThread2 = new SubThread();
        //设置线程的名称
        subThread2.setName("subThread2");
        subThread2.start();

        //Thread(Runnable)构造方法形参是Runnable 接口,调用时传递的实参是接口的实现类对象
        Thread subThread3 = new Thread(subThread2);
        subThread3.start();
    }
}
