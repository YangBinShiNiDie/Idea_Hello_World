/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import java.util.concurrent.BlockingQueue;

/**
 * @author yangbin
 * @date 2021-11-02 14:07
 */
public class Consumer implements Runnable {
    //构建一个私有生产队列(阻塞队列)
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
                consume(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume(Integer n) {
        System.out.println(Thread.currentThread().getName() + "线程 消费了数据: " + n);
    }
}
