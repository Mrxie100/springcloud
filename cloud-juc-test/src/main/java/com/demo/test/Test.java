package com.demo.test;

import java.util.*;

/**
 * @author xie
 * @version 1.0
 * @date 2020/6/24 9:30
 */
public class Test {
    public static void main(String[] args){
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 1; i <=30; i++)
        {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
