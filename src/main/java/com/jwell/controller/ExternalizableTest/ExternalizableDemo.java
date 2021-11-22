/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ExternalizableTest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author yangbin
 * @date 2021-11-03 10:58
 */
public class ExternalizableDemo implements Externalizable {
    private static final long serialVersionUID = 7668002620065184091L;
    private String name;
    private int number;

    public ExternalizableDemo() {
        System.out.println("****默认构造函数*****");
    }

    public ExternalizableDemo(String name, int number) {
        System.out.println("****带参构造函数*****");
        this.name = name;
        this.number = number;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("序列化对象属性");
        out.writeUTF(name);
        out.writeInt(number);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("反序列化对象属性");
        name = in.readUTF();
        number = in.readInt();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ExternalizableDemo{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
