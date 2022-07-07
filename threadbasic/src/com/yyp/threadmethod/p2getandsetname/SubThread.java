package com.yyp.threadmethod.p2getandsetname;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    public SubThread() {
        System.out.println("构造方法中,Thread.currentThread().getName() : " + Thread.currentThread().getName() );
        System.out.println("构造方法,this.getName() : " + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run 方法中,Thread.currentThread().getName() : " + Thread.currentThread().getName() );
        System.out.println("run 方法,this.getName() : " + this.getName());
    }
}
