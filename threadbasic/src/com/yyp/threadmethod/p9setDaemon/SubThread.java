package com.yyp.threadmethod.p9setDaemon;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            System.out.println("sub thread.....");
        }
    }
}
