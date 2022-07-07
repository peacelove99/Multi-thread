package com.yyp.threadmethod.p5getid;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread name = " + Thread.currentThread().getName() + ", id == " + this.getId() );
    }
}
