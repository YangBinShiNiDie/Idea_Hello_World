/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import java.io.File;
import java.io.IOException;

/**
 * @author yangbin
 * @date 2021-11-03 10:27
 */
public class MyException  extends Exception{

    public MyException(String msg,Throwable e) {
        super(msg,e);
    }

    public static void main(String[] args){
        File file = new File("H://test.txt");
        if (file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                try {
                    throw new MyException("文件创建失败", e);
                } catch (MyException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
