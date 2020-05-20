package com.example.study;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池创建学习
 */
public class ThreadPoolTest {
    private static ExecutorService executor = Executors.newFixedThreadPool(15);

    @Test
    public void test() {
        for(int i=0;i<120;i++){
            executor.execute(new SubThread());
        }
    }
}
class SubThread implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("现在线程为"+Thread.currentThread());
            //Thread.sleep(1000000);
            TimeUnit.SECONDS.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}