/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

/**
 * @author yangbin
 * @date 2021-11-02 09:21
 */
public class TickerTest implements Runnable {
    //100张票
    private int ticker = 1;
    //锁对象
    private Object obj = new Object();

    @Override
    public void run() {
        while (ticker<=100) {
            synchronized (obj){
                if(ticker<=100){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"出售第"+ ticker++ +"张票");
                }
            }
        }
    }
}
