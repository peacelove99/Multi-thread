package com.yyp.threadmethod.p8interrupt;

/**
 * @author Warmwind
 * 作者：元昱鹏
 * 时间：2022-07-06
 */

public class SubThread extends Thread{
    @Override
    public void run() {
        super.run();

        int times = 10000;
        for(int i = 1; i <= times; i++){
            //判断线程的中断标志,线程有isInterrupted()方法,该方法返回线程的中断标志
            if (this.isInterrupted()){
                System.out.println("子线程要结束了");
                //中断循环, run()方法体执行完毕,子线程运行完毕
//                break;

                //直接结束当前run()方法的执行
                return;
            }
            System.out.println("sub thread --> " + i);
        }
    }
}
