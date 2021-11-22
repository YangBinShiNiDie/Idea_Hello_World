/*
 * Copyright 2021 tu.cn All right reserved. This software is the
 * confidential and proprietary information of tu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tu.cn
 */
package com.jwell.controller.ThredTestObjects;

import org.joda.time.DateTime;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangbin
 * @date 2021-11-03 09:44
 */
public class Joda_Time_Dome {

    //joda 转 str
    @Test
    public void testJodaToStr() {
        DateTime dateTime1 = new DateTime();
        System.out.println(dateTime1); // out: 2016-02-26T16:02:57.582+08:00
        DateTime dateTime2 = new DateTime(2016,2,14,0,0,0);
        System.out.println(dateTime2); // out: 2016-02-14T00:00:00.000+08:00
        DateTime dateTime3 = new DateTime(1456473917004L);
        System.out.println(dateTime3); // out: 2016-02-26T16:05:17.004+08:00
        DateTime dateTime4 = new DateTime(new Date());
        System.out.println(dateTime4); // out: 2016-02-26T16:07:59.970+08:00
        DateTime dateTime5 = new DateTime("2016-02-15T00:00:00.000+08:00");
        System.out.println(dateTime5); // out: 2016-02-15T00:00:00.000+08:00

        DateTime dateTime2000Year = new DateTime(2000,2,29,0,0,0);
        System.out.println(dateTime2000Year); // out: 2000-02-29T00:00:00.000+08:00
        //with开头的方法（比如：withYear）：用来设置DateTime实例到某个时间
        DateTime dateTime1997Year =
                dateTime2000Year.withYear(1997);
        System.out.println(dateTime1997Year); // out: 1997-02-28T00:00:00.000+08:00
        //plus/minus开头的方法（比如：plusDay, minusMonths）：用来返回在DateTime实例上增加或减少一段时间后的实例。
        DateTime now = new DateTime();
        System.out.println(now); // out: 2016-02-26T16:27:58.818+08:00
        DateTime tomorrow = now.plusDays(1);
        System.out.println(tomorrow); // out: 2016-02-27T16:27:58.818+08:00
        DateTime lastMonth = now.minusMonths(1);
        System.out.println(lastMonth); // out: 2016-01-26T16:27:58.818+08:00

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));

    }

}
