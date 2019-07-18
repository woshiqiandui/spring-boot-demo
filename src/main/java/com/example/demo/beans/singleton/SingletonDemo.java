package com.example.demo.beans.singleton;

/**
 * @author 陈迁对
 * @date 2019-07-18 14:26
 * @description  单例模式 示例
 */
public class SingletonDemo {
    /**
     * 必须是私有的，静态的，表示其唯一性
     */
    private static SingletonDemo singletonDemo;
    private String name;

    private String scope;

    private String field;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    /**
     * 构造方法也是私有的
     *
     * @param name
     * @param scope
     * @param field
     */
    private SingletonDemo(String name, String scope, String field) {
        this.field = field;
        this.scope = scope;
        this.name = name;
    }

    /**
     * 唯一生成单一类的方式
     * 必须是静态方法
     * @date 2019-07-18 14:31
     */
    public static SingletonDemo getInstance(String name, String scope, String field) {
        // 单例模式，存在一个类对应只有一对象，如果已经存在就不能再添加了
        if(singletonDemo == null) {
            singletonDemo = new SingletonDemo(name, scope, field);
        }
        return singletonDemo;
    }


}
