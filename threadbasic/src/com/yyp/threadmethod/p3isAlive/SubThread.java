package com.yyp.threadmethod.p3isAlive;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    @Override
    public void run() {
        //运行状态,true
        System.out.println("run 方法, isalive = " + this.isAlive());
    }
}
