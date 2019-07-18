package com.example.demo.beans.singleton;

/**
 * @author cqd
 * @Title: 饿汉式单例
 * @Description:
 * 优点:
 *
 * 线程安全: 饿汉式单例类在类被加载时就将自己实例化，它的优点在于无须考虑多线程访问问题，可以确保实例的唯一性
 *
 * 调用速度优于懒汉式: 从调用速度和反应时间角度来讲，由于单例对象一开始就得以创建，因此要优于懒汉式单例
 *
 * 缺点: 资源利用效率不如懒汉式且加载时间较长无论系统在运行时是否需要使用该单例对象，由于在类加载时该对象就需要创建，因此从资源利用效率角度来讲，
 * 饿汉式单例不及懒汉式单例，而且在系统加载时由于需要创建饿汉式单例对象，加载时间可能会比较长
 */
public class EagerSingleton {
    /**
     * final 保证唯一性
     */
    private static final EagerSingleton instance = new EagerSingleton();
    private EagerSingleton() { }
    public static EagerSingleton getInstance() {
        return instance;
    }
}