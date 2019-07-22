package com.example.demo.beans.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * @author 陈迁对
 * @date 2019-07-22 10:33
 * @company www.tydic.com
 * @description  @Inherited：
 *    注意：@Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。
 *    如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
 */
@Documented  // 标识可以在生成doc时生成注解
@Target({ElementType.TYPE}) // 注解运用在类型、类上
@Inherited // 标识该注解对应的类可以被继承，仅在Target 指向 TYPE 时有效
public @interface MyAnnotation {
    /**
     * 1. 类继承关系中@Inherited的作用
     *
     * 类继承关系中，子类会继承父类使用的注解中被@Inherited修饰的注解
     *
     * 2. 接口继承关系中@Inherited的作用
     *
     * 接口继承关系中，子接口不会继承父接口中的任何注解，不管父接口中使用的注解有没有被@Inherited修饰
     *
     * 3. 类实现接口关系中@Inherited的作用
     *
     * 类实现接口时不会继承任何接口中定义的注解
     */
}
