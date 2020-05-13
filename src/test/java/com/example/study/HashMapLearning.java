package com.example.study;

import org.junit.Test;

/**
 * 测试 hashMap中的 与运算是否比取模运算高效
 */
public class HashMapLearning {

    @Test
     public void testHashCodeModeAnd() {
        int a = 999999999;
        // index = hashCode(key)&(length-1) 用位运算代替取模运算，效率较高

        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++) {
            int b = a & 255;
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("用时" + String.valueOf(t2 - t1));
    }

    @Test
    public void testHashCodeModeDiv() {
        int a = 999999999;
        // index = hashCode(key)%length
        Long t1 = System.currentTimeMillis();
        for (int i = 0; i < 999999999; i++) {
            int c = a % 256;
        }
        Long t2 = System.currentTimeMillis();
        System.out.println("用时" + String.valueOf(t2 - t1));

    }
}

