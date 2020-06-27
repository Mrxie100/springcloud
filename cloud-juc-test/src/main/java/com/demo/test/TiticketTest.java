package com.demo.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//资源类   实例变量+实例方法
class Tiket{
    public int count = 50;

    public Lock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {
            if (count > 0){
                System.out.println(Thread.currentThread().getName()+"\t卖出第:"+(count--)+"\t还剩下:"+count);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * @author xie
 * @version 1.0
 * @date 2020/6/27 16:24
 */
public class TiticketTest {
    public static void main(String[] args) {
        Tiket tiket = new Tiket();
        //原始方法
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0;i < 40;i++){
//                    tiket.sale();
//                }
//            }
//        },"A").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0;i < 40;i++){
//                    tiket.sale();
//                }
//            }
//        },"B").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0;i < 40;i++){
//                    tiket.sale();
//                }
//            }
//        },"C").start();

        /**
         * 复制小括号  写死右箭头   落地大括号(具体逻辑)
         */
        //使用lamada表达式
        new Thread(()->{for (int i = 0;i < 60;i++) tiket.sale();},"A").start();
        new Thread(()->{for (int i = 0;i < 60;i++) tiket.sale();},"B").start();
        new Thread(()->{for (int i = 0;i < 60;i++) tiket.sale();},"C").start();
    }
}
