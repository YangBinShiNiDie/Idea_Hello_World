package com.jwell.utils;

/**
 * @author yangbin
 * @date 2020-12-02 11:39
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     * @param string
     * @return
     */
    public boolean strIsNull(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * 判断字符串长度是否大于11
     * @param str
     * @return
     */
    public boolean strIsNumber(String str) {
        return str.length() > 11 ;
    }

}
