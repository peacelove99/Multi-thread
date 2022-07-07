package com.yyp.threadmethod.p4sleep;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SimpleTimer {
    public static void main(String[] args) {
        //从60 秒开始计时
        int remaining = 60;

        //读取main 方法的参数
        if (args.length == 1){
            remaining = Integer.parseInt(args[0]);
        }

        while(true){
            System.out.println("Remaining: " + remaining);
            remaining--;
            if (remaining < 0 ){
                break;
            }
            try {
                //线程休眠
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done!!");
    }
}
