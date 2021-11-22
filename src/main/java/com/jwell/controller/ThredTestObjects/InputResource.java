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
 * @date 2021-11-02 10:14
 */
public class InputResource implements Runnable {
    private Resource r;
    public InputResource(){

    }
    public InputResource(Resource r) {
        this.r=r;
    }

    //给Resource赋值
    @Override
    public void run() {
        int i = 1;
        while (i <= 50) {
            //添加同步代码块
            synchronized (r){
                //判断标记
                if (r.flag){
                    try {
                        //当前线程进入等待区 等待被唤醒执行代码
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(i%2 == 0) {
                    r.setName("张三");
                    r.setAge(20);
                }else {
                    r.setName("李四");
                    r.setAge(18);
                }
                r.setFlag(true);//赋值完成
                r.notify();//唤醒等待的线程
                System.out.println(Thread.currentThread().getName()+"线程赋值完成，被唤醒了,赋值内容"+r);
            }
            i++;
        }
    }
}
