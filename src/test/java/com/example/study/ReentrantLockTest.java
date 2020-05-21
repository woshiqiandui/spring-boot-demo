package com.example.study;

import org.junit.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    // true 公平锁，不加或者false表示非公平
    static final Lock lock= new ReentrantLock(true);
    /**
     * 测试 reentrantLock 的 公平锁
     */
    @Test
    public void testReentrantFairHandler(){
        class MyThread implements Runnable{
            @Override
            public void run() {
                    try {
                        lock.lock();
                        System.out.println("This thread is " + Thread.currentThread().getName());
                        TimeUnit.MICROSECONDS.sleep(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
            }
        };
        MyThread myThread  =new MyThread();
         new Thread(myThread,"a").start();
         new Thread(myThread,"c").start();
         new Thread(myThread,"w").start();
         new Thread(myThread,"b").start();
    }

}
