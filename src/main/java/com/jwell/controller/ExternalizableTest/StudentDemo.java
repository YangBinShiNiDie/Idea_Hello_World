/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ExternalizableTest;

import java.io.Serializable;

/**
 * @author yangbin
 * @date 2021-11-04 15:33
 */
public class StudentDemo implements Serializable {
    private static final long serialVersionUID = 4793268749024549426L;
    private String name;
    private transient int age;

    public StudentDemo() {
    }

    public StudentDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentDemo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
