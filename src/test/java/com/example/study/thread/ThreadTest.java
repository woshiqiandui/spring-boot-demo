package com.example.study.thread;

import sun.awt.image.VSyncedBSManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 奇数和偶数交替打印,
 */

public class ThreadTest {
    public static void main(String[] args) {
        Num num = new Num();
        OddThread my = new OddThread();
        EvenThread my2 =  new EvenThread();
        my.setNum(num);
        my2.setNum(num);
        Thread thread = new Thread(my,"a1");
        Thread thread2 = new Thread(my2,"a2");

        List<Thread> threadList  =new ArrayList<>();
        threadList.add(thread);
        threadList.add(thread2);
        threadList.forEach(Thread::start);
    }
}

/**
 * 奇数和偶数线程共有的数据
 */
class Num{
    private int i = 0;
    private boolean flag = false;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

/**
 * 偶数线程
 */
class  EvenThread implements  Runnable{
    private  Num num;

    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        while(num.getI()<1000) {
            synchronized (num) {
                if (num.isFlag() == true) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    num.setI(num.getI()+1);
                    System.out.println(num.getI());
                    num.setFlag(true);
                    num.notify();
                }
            }
           // System.out.println(Thread.currentThread().getName());
        }

    }
}

/**
 * 奇数线程
 */
class OddThread implements Runnable{
    private  Num num;

    public Num getNum() {
        return num;
    }

    public void setNum(Num num) {
        this.num = num;
    }
    @Override
    public void run() {
        while(num.getI()<1000) {
            synchronized (num) {
                if (num.isFlag() == false) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    num.setI(num.getI()+1);
                    System.out.println(num.getI());
                    num.setFlag(false);
                    num.notify();
                }
            }
           // System.out.println(Thread.currentThread().getName());
        }
    }
}