/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangbin
 * @date 2021-11-04 10:14
 */
public class ThreadDemo04 {

    //lock锁和synchronized的区别在于 lock使用在并发访问同意个资源时或同一段代码是锁定资源不让其他线程更改
    //而synchronized使用在并发访问同一个对象时 对对象的资源锁定 不让其他线程更改。
    Lock lock = new ReentrantLock();

    public void method1() {
        synchronized (String.class) {
            System.out.println("锁住String类对象");
            synchronized (Integer.class) {
                System.out.println("锁住Integer类对象");
            }
        }
    }

    public void method2() {
        synchronized (Integer.class) {
            System.out.println("锁住Integer类对象");
            synchronized (String.class) {
                System.out.println("锁住String类对象");
            }
        }
    }

    public static void main(String[] args) {
        //t1线程启动后进入锁中 把String类对象锁住  t2线程启动后进入锁中 把Integer类对象锁住
        //t1线程后续的代码需要对Integer类对象进行操作并锁定，但这时t2线程把Integer类对象锁住了并没有释放 所以t1线程拿不到
        //类对象权限，无法进行后续代码操作，陷入t2线程释放锁资源的等待中。 而t2线程后续代码执行，需要对String类对象进行锁定，
        //可是String类对象在t1线程操作中并没有被释放出来,所以t2线程也陷入了t1线程释放所资源的等待中，造成死锁。
        //如果需要解决死锁  我们需要把ThreadDemo04中的2个方法的锁对象调整为一致即可避免死锁
        SiSuoTest1 siSuoTest1 = new SiSuoTest1();
        SiSuoTest2 siSuoTest2 = new SiSuoTest2();
        Thread t1 = new Thread(siSuoTest1);
        Thread t2 = new Thread(siSuoTest2);
        t1.setName("1号线程");
        t2.setName("2号线程");
        t1.start();
        t2.start();

    }

}
