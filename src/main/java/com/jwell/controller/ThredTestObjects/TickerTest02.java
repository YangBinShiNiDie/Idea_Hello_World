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
 * @date 2021-11-02 09:21
 */
public class TickerTest02 implements Runnable {
    //100张票
    private int ticker = 1;
    //lock锁对象
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (ticker<=100) {
            //获取锁对象
            lock.lock();
            if(ticker<=100){
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"出售第"+ ticker++ +"张票");
            }
            //释放锁  如果不释放  资源会被第一个进来的线程一直占用知道程序完成也不会退出程序  而是一直占用这cpu资源
            lock.unlock();
        }
    }
}
