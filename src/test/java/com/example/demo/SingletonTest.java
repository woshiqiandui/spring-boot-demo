package com.example.demo;

import com.example.demo.beans.singleton.EagerSingleton;
import com.example.demo.beans.singleton.LazySingleton;
import com.example.demo.beans.singleton.SingletonDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 陈迁对
 * @date 2019-07-18 14:34
 * @company
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages="com.example.demo.*")

public class SingletonTest {
    @Test
    public void testSingletonDemo() {
        SingletonDemo singletonDemo =  SingletonDemo.getInstance("cqd","scope","field");
        System.out.println("普通单例模式第一次赋值"+singletonDemo.getName());
        SingletonDemo singletonDemo1 = SingletonDemo.getInstance("cbd","scope","field");
        System.out.println("普通单例模式第二次赋值"+singletonDemo.getName()+"   "+singletonDemo1.getName());
        System.out.println("普通单例模式 1.仅会构造一个对象，2.后续构建时会指向第一个对象 3.后面的多次构造都为无效操作,可以修改对象的属性");
        singletonDemo.setName("ccc");
        System.out.println("普通单例模式第三次赋值"+singletonDemo.getName()+"   "+singletonDemo1.getName());
    }
    @Test
    public void testEagerSingleton(){
        EagerSingleton eagerSingleton =  EagerSingleton.getInstance();
        eagerSingleton.setName("cqd");
        System.out.println("饿汉单例模式第一次赋值"+eagerSingleton.getName());
        EagerSingleton eagerSingleton1 =  EagerSingleton.getInstance();
        eagerSingleton1.setName("cbd");
        System.out.println("饿汉单例模式第二次赋值"+eagerSingleton.getName()+eagerSingleton1.getName());
        eagerSingleton.setName("ccc");
        System.out.println("饿汉单例模式第三次赋值"+eagerSingleton.getName()+eagerSingleton1.getName());
    }

    public void testLazySingleton(){
        LazySingleton lazySingleton = LazySingleton.getInstance();
        lazySingleton.setName("cqd");
    }

}
