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
 * @date 2021-11-04 10:24
 */
public class SiSuoTest2 implements Runnable {
    @Override
    public void run() {
        ThreadDemo04 demo04 = new ThreadDemo04();
        demo04.method2();
    }
}
