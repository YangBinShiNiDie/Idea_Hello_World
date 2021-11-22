/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import java.util.*;

/**
 * @author yangbin
 * @date 2021-11-02 15:20
 */
public class CollectionTest {

    class Dog{
        public int age;
        public String name;
        public Dog(int age, String name) {
            super();
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return "Dog{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<Dog> list = new ArrayList<>();
        list.add(new CollectionTest().new Dog(5, "DogA"));
        list.add(new CollectionTest().new Dog(3, "DogB"));
        list.add(new CollectionTest().new Dog(7, "DogC"));
        list.add(new CollectionTest().new Dog(8, "DogD"));
        list.add(new CollectionTest().new Dog(4, "DogE"));
        list.add(new CollectionTest().new Dog(10, "DogF"));
        list.add(new CollectionTest().new Dog(11, "DogG"));
        Collections.sort(list, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.age - o2.age;
            }
        });
        System.out.println("给狗狗按照年龄倒序："+list);
        Collections.sort(list, new Comparator<Dog>() {

            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        System.out.println("给狗狗按名字字母顺序排序："+list);

        /*List<Integer> linkedList = new LinkedList<>();
        for (int i = 1; i < 100; i++) {
            list.add((int) (Math.random()*1000));
            linkedList.add((int) (Math.random()*1000));
        }
        Collections.sort(list);
        Collections.sort(linkedList);
        for (Integer itme:list) {
            System.out.println(itme);
        }
        for (Integer itme:linkedList) {
            System.out.println(itme);
        }*/




    }

}
