package com.demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * @author  xiehongyu
 * @date  2020/6/23 19:41
 * @Email:salong0503@aliyun.com
 */
class Titicket
{
    public int number = 50;

    Lock lock = new ReentrantLock();

    public void sale()
    {
        lock.lock();
        try {
            if (number > 0)
            {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩下："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Titicket titicket = new Titicket();
        new Thread(new Runnable() {
            @Override
            public void run() {
                titicket.sale();
            }
        },"A").start();
        //lamda表达式
        new Thread(()->{for (int i =1; i <= 60; i++) titicket.sale();},"A").start();
    }
}
