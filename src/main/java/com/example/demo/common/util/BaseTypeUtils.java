package com.example.demo.common.util;

public class BaseTypeUtils {
    /**
     * string判空
     * @param value
     * @return
     */
    public static boolean strIsEmpty(String value){
        int strLen;
        if (value != null && (strLen = value.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(value.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }
}
