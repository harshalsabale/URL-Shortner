package com.sprout.URLShortner.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisCacheRepository {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private static final String CACHE_KEY = "short";

    public String getOriginalURLByShortUrl(String shortURL) {
        return (String) redisTemplate.opsForHash().get(CACHE_KEY, shortURL);
    }

    public void saveToCache(String shortURL, String orgURL) {
        redisTemplate.opsForHash().put(CACHE_KEY, shortURL, orgURL);
    }

}
