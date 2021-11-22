/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author yangbin
 * @date 2021-11-02 13:54
 */
public class Producer implements Runnable {
    //构建一个私有生产队列(阻塞队列)
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                queue.put(produce());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int produce() {
        int n = new Random().nextInt(10000);
        System.out.println(Thread.currentThread().getName()+"线程生产了一个数据: "+n);
        return n;
    }

}
