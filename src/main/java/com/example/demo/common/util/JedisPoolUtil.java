package com.example.demo.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.SerializationUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

@Component
public class JedisPoolUtil {
    private static Jedis getJedis() {
        JedisPool jedisPool = new JedisPool();
        return jedisPool.getResource();
    }

    public static String set(String key, Object value, Integer timeout) {
        Jedis jedis = null;
        String result = null;

        try {
            jedis = getJedis();
            result = jedis.set(key.getBytes(), objectToBytes(value));
            if (null != timeout) {
                jedis.expire(key, timeout);
            } else {
                jedis.expire(key, 86400);
            }
        } finally {
            close(jedis);
        }

        return result;
    }

    public static Object get(String key) {
        Jedis jedis = null;

        Object result;
        try {
            jedis = getJedis();
            byte[] str = jedis.get(key.getBytes());
            result = str == null ? null : SerializationUtils.deserialize(str);
        } finally {
            close(jedis);
        }

        return result;
    }

    private static byte[] objectToBytes(Object obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            byte[] bytes = bos.toByteArray();
            oos.close();
            bos.close();
            return bytes;
        } catch (IOException var5) {
            throw new RuntimeException(var5);
        }
    }

    private static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }

    }
}
