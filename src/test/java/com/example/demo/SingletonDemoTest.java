package com.example.demo;

import com.example.demo.beans.SingletonDemo;

/**
 * @author 陈迁对
 * @date 2019-07-18 14:34
 * @company www.tydic.com
 * @description
 */
public class SingletonDemoTest {
    public static void main(String[] args) {
        SingletonDemo singletonDemo =  SingletonDemo.getInstance("cqd","scope","field");
        System.out.print("单例模式第一次赋值"+singletonDemo.getName());
        SingletonDemo singletonDemo1 = SingletonDemo.getInstance("cbd","scope","field");
        System.out.print("单例模式第二次赋值"+singletonDemo.getName()+"   "+singletonDemo1.getName());
        System.out.print("单例模式 仅会构造一个对象，后面的多次构造都为无效操作");
    }
}
