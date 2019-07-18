package com.example.demo.beans.singleton;

/**
 * @author cqd
 * @Title: IoDh技术
 * @Description: Java最好的单例实现模式
 * Initialization Demand Holder (IoDH)
 *
 */
public class IoDHSingleton {

    private IoDHSingleton() {
    }

    //静态内部类的成员变量才能是静态的
    private static class HolderClas{

        public static IoDHSingleton ioDHSingleton = new IoDHSingleton();
    }

    public static  IoDHSingleton getInstance(){
        return HolderClas.ioDHSingleton;
    }

    /**
     * 创建的单例对象s1和s2为同一对象。由于静态单例对象没有作为Singleton的成员变量直接实例化，
     * 因此类加载时不会实例化Singleton，第一次调用getInstance()时将加载内部类HolderClass，
     * 在该内部类中定义了一个static类型的变量instance，此时会首先初始化这个成员变量，
     * 由Java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。由于getInstance()方法没有任何线程锁定，
     * 因此其性能不会造成任何影响。
     *
     * 通过使用IoDH，我们既可以实现延迟加载，又可以保证线程安全，不影响系统性能
     */
    public static void main(String[] args) {
        IoDHSingleton s1,s2;
        s1 = IoDHSingleton.getInstance();
        s2 = IoDHSingleton.getInstance();
        System.out.println(s1 == s2);

    }
    /**
     * (1) 单例模式提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，
     * 所以它可以严格控制客户怎样以及何时访问它。
     *
     * (2) 由于在系统内存中只存在一个对象，因此可以节约系统资源，
     * 对于一些需要频繁创建和销毁的对象单例模式无疑可以提高系统的性能。
     *
     * (3) 允许可变数目的实例。基于单例模式我们可以进行扩展，
     * 使用与单例控制相似的方法来获得指定个数的对象实例，既节省系统资源，又解决了单例单例对象共享过多有损性能的问题。
     *
     * 5.2 缺点
     * (1) 由于单例模式中没有抽象层，因此单例类的扩展有很大的困难。
     *
     * (2) 单例类的职责过重，在一定程度上违背了“单一职责原则”。
     * 因为单例类既充当了工厂角色，提供了工厂方法，同时又充当了产品角色，包含一些业务方法，将产品的创建和产品的本身的功能融合到一起。
     *
     * (3) 现在很多面向对象语言(如Java、C#)的运行环境都提供了自动垃圾回收的技术，
     * 因此，如果实例化的共享对象长时间不被利用，系统会认为它是垃圾，会自动销毁并回收资源，下次利用时又将重新实例化，这将导致共享的单例对象状态的丢失
     */
}