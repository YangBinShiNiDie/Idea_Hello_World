/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ExternalizableTest;

import java.io.*;

/**
 * @author yangbin
 * @date 2021-11-04 15:34
 */
public class StudentSeralizable {

    public static void main(String[] args) {
        File file = new File("E://student.txt");
        try {
            System.out.println("*****开始序列化学生对象*****");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            StudentDemo demo = new StudentDemo("李四", 18);
            out.writeObject(demo);
            out.close();
            System.out.println(demo);
            System.out.println("*****序列化对象完成*****");
            System.out.println("*****开始反序列化对象*****");
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            StudentDemo stu = (StudentDemo) in.readObject();
            System.out.println(stu);
            in.close();
            System.out.println("*****反序列化对象成功*****");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
