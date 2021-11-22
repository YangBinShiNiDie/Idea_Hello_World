/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import java.util.concurrent.Callable;

/**
 * @author yangbin
 * @date 2021-11-01 17:25
 */
public class ThreadDemo03 implements Callable<Integer> {

    private int num;

    public ThreadDemo03(){
    }
    public ThreadDemo03(int num){
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum+=i;
        }
        return sum;
    }
}
