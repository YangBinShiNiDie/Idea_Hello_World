/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.BalanceThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangbin
 * @date 2021-11-05 10:51
 */
public class TestBalance {

    public static void main(String[] args) {
        Account account = new Account();
        //创建100个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 1; i <= 100; i++) {
            pool.execute(new AddMoneyThread(account, 1));
        }
        pool.shutdown();
    }

}
