package com.example.mall.service.impl;

/**
 * 操作redis
 *
 * @author Ming
 * @date 2021/12/8 14:50
 */

import com.example.mall.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);

    }

    @Override
    public void set(String key, String value, long expire) {
        stringRedisTemplate.opsForValue().set(key, value);
        stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    public Boolean lockRedis(final String key, final String value, final long timeout) {

        log.debug("lockRedis request:key={},value={}", key, value);
        if (timeout < 0) {
            log.warn("lockRedis Fail lock Time gt 0");
            return Boolean.FALSE;
        }
        byte[] redisKey = stringRedisTemplate.getStringSerializer().serialize(key);
        byte[] redisValue = stringRedisTemplate.getStringSerializer().serialize(value);
        Boolean result = stringRedisTemplate.execute((RedisCallback<Boolean>) connection -> {
            Boolean lock = Boolean.FALSE;
            try {
                lock = connection.setNX(redisKey, redisValue);
                log.debug("lockRedis Lock Result:{}", lock);
                Boolean setTimeOutResult = connection.expire(redisKey, timeout);
                log.debug("lockRedis setTimeOutResult TimeOut:{} Result:{}", timeout, setTimeOutResult);
                if (lock && setTimeOutResult) {
                    return Boolean.TRUE;
                }
                if (!setTimeOutResult) {
                    connection.del(redisKey);
                    return Boolean.FALSE;
                }
            } catch (Exception e) {
                if (lock) {
                    connection.del(redisKey);
                }
                log.warn("lockRedis Fail Exception:{}", e);
            }
            return Boolean.FALSE;
        });
        log.debug("lockRedis request Result:{}", result);
        return result;
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}

