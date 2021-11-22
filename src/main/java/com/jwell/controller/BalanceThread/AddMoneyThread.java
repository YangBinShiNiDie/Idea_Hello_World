/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.BalanceThread;

/**
 * @author yangbin
 * @date 2021-11-05 10:49
 */
public class AddMoneyThread implements Runnable {
    //银行账户
    private Account account;
    //存入金额
    private double money;

    public AddMoneyThread(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        account.deposit(money);
        System.out.println(account.getBalance());
    }
}
