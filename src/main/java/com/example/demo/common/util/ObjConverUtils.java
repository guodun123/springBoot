package com.example.demo.common.util;

public class ObjConverUtils {

    public static String Obj2String(Object object) {
        return null == object ? "" : object.toString();
    }

    public static String Obj2String(Object object,String defaultStr) {
        return null == object ? defaultStr : object.toString();
    }
}
