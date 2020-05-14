package com.example.study;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 布隆过滤器测试
 */
public class bloomFilterTest {
    /**
     * 测试布隆过滤器的错误比例
     */
    @Test
    public void TestBloomErrorRatio(){
        // 测试容量大小
        int size = 20000;
        // 期望误判率
        double expectedRatio = 0.01;
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,0.01);
        for(int i = 0;i< 20000;i++){
            bloomFilter.put(i);
        }
        List<Integer> errorList = new ArrayList<>();
        for(int i= 20000;i<40000;i++){
            if(bloomFilter.mightContain(i)){
                errorList.add(i);
            }
        }
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数

        System.out.println("总共误判数量"+errorList.size()+",误判比率"+ df.format((float)errorList.size()/size)+",误判详情如下："+errorList);
    }
}
