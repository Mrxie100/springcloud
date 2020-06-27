package com.demo.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Shradata{
    public int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public  void increment() throws Exception {
        lock.lock();
        try {
            while (number != 0 ){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public  void decrement() throws Exception {
        lock.lock();
        try {
            while (number == 0 ){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            condition.signalAll();
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
 * @date 2020/6/27 16:38
 */
public class LockTest {
    public static void main(String[] args) throws Exception{
        Shradata shradata = new Shradata();
        new Thread(()->{
            for (int i = 1;i < 10;i++){
                try {
                    shradata.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1;i < 10;i++){
                try {
                    shradata.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
//        new Thread(()->{
//            for (int i = 1;i < 10;i++){
//                shradata.decrement();
//            }
//        },"C").start();
//        new Thread(()->{
//            for (int i = 1;i < 10;i++){
//                shradata.decrement();
//            }
//        },"D").start();
    }
}
