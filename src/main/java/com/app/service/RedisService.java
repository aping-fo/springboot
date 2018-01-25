package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by lucky on 2018/1/22.
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    public String get(String key) {
        String result = redisTemplate.execute((RedisConnection connect) -> {
            byte[] value = connect.get(key.getBytes());
            return new String(value);
        });
        return result;
    }

    public byte[] get(byte[] key) {
        byte[] result = redisTemplate.execute((RedisConnection connect) -> connect.get(key));
        return result;
    }

    /*public byte[] get(final String key) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] value = connection.get(key.getBytes());
                return value;
            }
        });
        return result;
    }*/
}
