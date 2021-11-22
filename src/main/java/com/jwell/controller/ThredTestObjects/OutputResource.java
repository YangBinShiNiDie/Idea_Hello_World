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
 * @date 2021-11-02 10:30
 */
public class OutputResource implements Runnable {
    private Resource r;
    public OutputResource(){}

    public OutputResource(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        int i = 1;
        while (i <= 50) {
            synchronized (r) {
                if (!r.flag) {
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName()+"开始输出resource的值:"+r);
                r.setFlag(false);
                r.notify();
            }
            i++;
        }
    }
}
