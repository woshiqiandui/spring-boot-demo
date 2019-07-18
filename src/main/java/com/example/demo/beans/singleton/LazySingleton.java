package com.example.demo.beans.singleton;

/**
 * @author cqd
 * @Title: 懒汉式单例类
 * @Description:
 * 优点:
 *
 * 延迟加载: 懒汉式单例类在第一次使用时创建，无须一直占用系统资源，实现了延迟加载
 * 缺点:
 *
 * 非线程安全: 多线程访问懒汉式单例类可能会创建多个实例
 *
 * 性能稍差通过双重检查锁定等机制保证线程安全，这将导致系统性能受到一定影响
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() { }

    /**
     *  synchronized 和 null 判断保证了唯一性
     */
    synchronized public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}