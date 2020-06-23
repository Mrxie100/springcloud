package com.demo.test;

/*
 * @author  xiehongyu
 * @date  2020/6/24 7:15
 * @Email:salong0503@aliyun.com
 */

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.故障现象
 *java.util.ConcurrentModificationException(并发修改的异常)
 *
 * 2.导致原因
 *
 * 3.解决方法
 *3.1   new Vector()
 * 3.2  Collections.synchronizedList(new ArrayList<>()); Collections是Collection的工具类
 * 3.3  new CopyOnWriteArrayList<>()  写时复制，与ArrayList同样实现了List接口
 * 4.优化建议（同样的错误不犯第二次）
 */
public class NotSafeDemo
{
    public static void main(String[] args)
    {
        List<String> list = new CopyOnWriteArrayList<>();
//                Collections.synchronizedList(new ArrayList<>());
// new Vector<>();new ArrayList<>
        //        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.forEach(System.out::println);
        for (int i = 1; i <=30; i++)
        {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}