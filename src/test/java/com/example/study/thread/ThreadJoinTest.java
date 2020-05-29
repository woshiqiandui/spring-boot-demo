package com.example.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 子线程走完都停下，等主线程获得线程名称再结束
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"a1");
        Thread thread2 = new Thread(myThread,"a2");
        Thread thread3 = new Thread(myThread,"a3");
        Thread thread4 = new Thread(myThread,"a4");
        Thread thread5 = new Thread(myThread,"a5");
        Thread thread6 = new Thread(myThread,"a6");
        List<Thread>threadGroup = new ArrayList<>();
        threadGroup.add(thread1);
        threadGroup.add(thread2);
        threadGroup.add(thread3);
        threadGroup.add(thread4);
        threadGroup.add(thread5);
        threadGroup.add(thread6);
        getResult(threadGroup).forEach(System.out::println);
    }
    private static List<Integer> getResult(List<Thread> threads){
        List<Integer> result = new ArrayList<>();
        threads.forEach(Thread::start);
        threads.forEach(t->{
                    try{
                        System.out.println(t.getName()+"暂时被打断");
                        t.join();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
        );
        for (Thread t:
            threads ) {
            result.add(Integer.valueOf(t.getName().substring(1,2)));
        }
        return result;
    }
}
class MyThread implements Runnable{
    private Double ran;
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
        ran = Math.random();
    }

    public Double getRan() {
        return ran;
    }
}