/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author yangbin
 * @date 2021-11-11 09:14
 */
public class ListThreadTest {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("二麻子");
        list.add("小明");
        list.add("小红");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<String> iterator = list.iterator();
                while (iterator.hasNext()){
                    System.out.println(iterator.next());
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> list1 = new ArrayList(list);
                Iterator<String> iterator = list1.iterator();
                while (iterator.hasNext()){
                    if (iterator.next().equals("小红")) {
                        iterator.remove();
                    }
                }
                System.out.println("list1输出的数据："+list1.toString());
            }
        });
        t1.start();
        t2.start();

        String string = "hello wrold";
        StringBuilder builder = new StringBuilder(string);
        System.out.println(builder.reverse().toString());

    }

}
