package com.example.study.thread;

import java.util.concurrent.TimeUnit;

public class InterruptThreadTest {
    public static void main(String[] args) {
        System.out.println("Main thread is interrupted1?"+ Thread.currentThread().getName()+"  "+Thread.interrupted());
        // false
        Thread.currentThread().interrupt();

        System.out.println("Main thread is interrupted2?"+Thread.currentThread().getName()+"  " +Thread.currentThread().isInterrupted());
         System.out.println("Main thread is interrupted3?"+ Thread.currentThread().getName()+"  "+Thread.interrupted());
        // 上一行会导致中断标识擦除，不会进入catch 语句
        System.out.println("Main thread is interrupted4?"+Thread.currentThread().getName()+"  " +Thread.currentThread().isInterrupted());
        // true
        try{
            TimeUnit.MINUTES.sleep(1);
        }catch (Exception e){
            System.out.println("I will be interrupted still.");

        }
    }
}
