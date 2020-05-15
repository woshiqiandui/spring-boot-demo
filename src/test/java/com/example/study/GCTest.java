package com.example.study;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * GC 测试，故意让堆内存溢出
 * 参数： -Xmx100m -Xms60m -XX:+PrintGCDetails -XX:-UseGCOverheadLimit -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=C:\Users\woshi\Desktop
 */
public class GCTest {
   @Test
    public void testPrintGcDetail(){
       HashMap<String, List> gcMap = new HashMap<>(999999);
         for(int i=0;i<999999;i++){
             List<String> gcList = new LinkedList<String>();
             gcMap.put(String.valueOf(i),gcList);
         }
         System.out.println("over");
   }
}
