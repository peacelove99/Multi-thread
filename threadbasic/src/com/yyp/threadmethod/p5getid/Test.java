package com.yyp.threadmethod.p5getid;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class Test {
    public static void main(String[] args) {
        System.out.println( Thread.currentThread().getName() + " , id = " + Thread.currentThread().getId());

        //子线程的id
        int times = 5;
        for(int i = 1; i <= times; i++){
            new SubThread().start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
