package com.example.demo.common.util;

import java.util.Collection;
import java.util.Map;

public class ArrayUtils {
    /**
     * list判空校验
     * @param collection
     * @return
     */
    public static boolean listIsEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * map判空校验
     * @param map
     * @return
     */
    public static boolean mapIsEmpty(Map map) {
        return map == null || map.isEmpty();
    }
}
