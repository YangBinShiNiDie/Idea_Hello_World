/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.BalanceThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangbin
 * @date 2021-11-05 10:46
 */
public class Account {
    //账户余额
    private double balance = 0;
    //账户锁
    private Lock lock = new ReentrantLock();

    /**
     * 存钱
     */
    public void deposit(double money) {
        lock.lock();
        try {
            double newBalance = balance + money;
            Thread.sleep(200);
            balance = newBalance;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }

}
