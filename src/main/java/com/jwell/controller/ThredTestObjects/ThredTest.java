/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import com.jwell.controller.ExternalizableTest.StudentDemo;
import com.sun.xml.internal.xsom.impl.scd.Iterators;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author yangbin
 * @date 2021-11-01 16:56
 */
public class ThredTest {

    @Test
    public void test01(){
        //demo01是一个线程  test01方法是一个线程  2个线程执行的速度不一样，导致数据出来的结果不一样。谁先谁后取决于demo01线程的启动速度
        ThreadDemo01 demo01 = new ThreadDemo01();
        Thread t1 = new Thread(demo01);
        t1.start();
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println("test : "+i);
        }
    }

    @Test
    public void test02() {
        ThreadDemo02 demo02 = new ThreadDemo02();
        Thread t1 = new Thread(demo02);
        t1.start();
        Thread t2 = new Thread(demo02);
        t2.start();
    }

    @Test
    public void test03(){
        //创建2个线程的线程池对象
        ExecutorService es = Executors.newFixedThreadPool(2);
        //线程池中抽取一个有空的线程执行线程任务
        es.submit(new ThreadDemo02());
        es.submit(new ThreadDemo02());
        //关闭线程池
        es.shutdown();

    }

    @Test
    public void test04() throws Exception{
        //创建2个线程的线程池对象
        ExecutorService es = Executors.newFixedThreadPool(2);
        //获取call方法执行后的Future对象
        Future<Integer> ft = es.submit(new ThreadDemo03(100));
        Future<Integer> ft2 = es.submit(new ThreadDemo03(200));
        //从Future对象中获取返回值
        System.out.println(ft.get());
        System.out.println(ft2.get());
        //销毁线程池
        es.shutdown();

    }

    @Test
    public void test05() {
        TickerTest tickerTest = new TickerTest();
        Thread t1 = new Thread(tickerTest);
       /* Thread t2 = new Thread(tickerTest);
        Thread t3 = new Thread(tickerTest);*/
        t1.start();
        /*t2.start();
        t3.start();*/
    }

    @Test
    public void test06() {
        int[] a = new int[]{6,5,9,8,1,3};
        Arrays.sort(a);
        System.out.println(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test07() {
        List<StudentDemo> list = new ArrayList<>();
        list.add(new StudentDemo("张三", 20));
        list.add(new StudentDemo("李四", 18));
        list.add(new StudentDemo("王五", 15));
        list.add(new StudentDemo("二麻子", 22));
        list.add(new StudentDemo("李晓雷", 26));
       /* Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            if ("李四".equals(name)){
                iterator.remove();
            }
        }*/
        System.out.println(list);
        Collections.sort(list, new Comparator<StudentDemo>() {
            @Override
            public int compare(StudentDemo o1, StudentDemo o2) {
                return o1.getAge() == o2.getAge() ? 0 : (o1.getAge() < o2.getAge() ? -1 : 1);
            }
        });
        System.out.println(list);
    }

    @Test
    public void test08() {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);
    }

    @Test
    public void test09() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -5);
        System.out.println("getActualMaximum方法 获取当前月最后一天的号数为"+calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        System.out.println("Calendar 类输出5天前的当前时间");
        System.out.println(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(calendar.getTime()));
        //java8新增的日期转换  LocalDate中是不包含时分秒的，想要格式化时分秒需要用LocalDateTime这个类
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDate date2 = LocalDate.now();
        System.out.println(date2.format(newFormatter));
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));

        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR)+"年 "+cal.get(Calendar.MONTH)+"月 "
                +cal.get(Calendar.DATE)+"日 "+cal.get(Calendar.HOUR_OF_DAY)+"时 "
                +cal.get(Calendar.MINUTE)+"分 "+cal.get(Calendar.SECOND)+"秒");
        System.out.println("Calendar 类输出的月份是从0到11的--当前月份"+cal.get(Calendar.MONTH));    // 0 - 11

        // Java_8
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt.getYear()+"年 "+dt.getMonthValue()+"月 "+dt.getDayOfMonth()+"日 "
                            +dt.getHour()+"时 "+dt.getMinute()+"分 "+dt.getSecond()+"秒");
        System.out.println("LocalDateTime 输出的月份是从1到12--当前月份"+dt.getMonthValue());     // 1 - 12
    }

    @Test
    public void test10() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String str = "hello";
        Method method = str.getClass().getMethod("toUpperCase");
        System.out.println(method.invoke(str));
    }

    @Test
    public void quChong() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(3);
        list.add(9);
        list.add(7);
        System.out.println("原集合数据：" + list);

        //去重  contains判断去重
        List<Integer> newList = new ArrayList<>(list.size());
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }
        System.out.println("contains去重后的数据：" + newList);

        //HashSet去重
        HashSet<Integer> hashSet = new HashSet<>(list);
        System.out.println("HashSet去重后的数据：" + hashSet);

        //LinkedHashSet去重
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("linkedHashSet去重后的数据：" + linkedHashSet);

        //TreeSet去重
        TreeSet<Integer> treeSet = new TreeSet<>(list);
        System.out.println("treeSet去重后的数据：" + treeSet);

    }

    public static void main(String[] args) {

        /*TickerTest02 tt02 = new TickerTest02();
        Thread t1 = new Thread(tt02);
        Thread t2 = new Thread(tt02);
        Thread t3 = new Thread(tt02);
        t1.start();
        t2.start();
        t3.start();*/

        /*Resource r = new Resource();
        InputResource in = new InputResource(r);
        OutputResource out = new OutputResource(r);
        Thread tin = new Thread(in);
        Thread tin2 = new Thread(in);
        Thread tout = new Thread(out);
        tin.start();
        tin2.start();
        tout.start();*/

        //创建一个长度为100的阻塞队列
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        //创建一个生产者 2个消费者
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        //当队列里面的数据装满时 线程p会被挂起等待 c1、c2消费了数据之后唤醒p线程继续生产数据
        new Thread(p).start();
        new Thread(c1).start();
        new Thread(c2).start();

    }

}
