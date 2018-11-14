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
    @Autowired
    private JedisPool jedisPool;

    private   Jedis getJedis(){
      return jedisPool.getResource();
    }

    public  String set(String key, Object value, Integer timeout) {
        Jedis jedis = null;
        String result = null;

        try {
            jedis = this.getJedis();
            result = jedis.set(key.getBytes(), this.objectToBytes(value));
            if (null != timeout) {
                jedis.expire(key, timeout);
            }else {
                jedis.expire(key, 86400);
            }
        } finally {
            this.close(jedis);
        }

        return result;
    }

    public Object get(String key) {
        Jedis jedis = null;

        Object result;
        try {
            jedis = this.getJedis();
            byte[] str = jedis.get(key.getBytes());
            result = str == null ? null : SerializationUtils.deserialize(str);
        } finally {
            this.close(jedis);
        }

        return result;
    }
    private byte[] objectToBytes(Object obj) {
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
    private void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }

    }
}
