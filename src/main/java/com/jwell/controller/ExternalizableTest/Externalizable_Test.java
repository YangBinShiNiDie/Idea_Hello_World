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
 * @date 2021-11-03 11:16
 */
public class Externalizable_Test {

    public static void main(String[] args) {
        try {
            //序列化ExternalizableDemo对象
            testExternalizable("E://test.txt");
           /* FileInputStream inputStream = new FileInputStream(new File("E://test.txt"));
            byte[] buf = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buf)) != -1) {
                String str = new String(buf, 0, length);
                System.out.println(str);
            }
            inputStream.close();*/


        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExternalizable(String filePath) throws IOException, ClassNotFoundException {
        com.jwell.controller.ExternalizableTest.ExternalizableDemo demo = new ExternalizableDemo();
        demo.setName("李四");
        demo.setNumber(20211103);

        FileOutputStream out = new FileOutputStream(filePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
        demo.writeExternal(objectOutputStream);
        objectOutputStream.flush();
        objectOutputStream.close();
        out.close();
        System.out.println("序列化完成");

        System.out.println("开始反序列化");
        FileInputStream in = new FileInputStream(filePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(in);
        com.jwell.controller.ExternalizableTest.ExternalizableDemo seg = (com.jwell.controller.ExternalizableTest.ExternalizableDemo) objectInputStream.readObject();
        objectInputStream.close();
        in.close();
        System.out.println(seg);
        System.out.println("反序列化完成");
    }

}
