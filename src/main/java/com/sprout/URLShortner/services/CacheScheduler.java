package com.sprout.URLShortner.services;

import com.sprout.URLShortner.postgress.entities.LinkMappingEntity;
import com.sprout.URLShortner.repository.LinkMappingRepository;
import com.sprout.URLShortner.repository.RedisCacheRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CacheScheduler {
    @Autowired
    LinkMappingRepository linkMappingRepository;

    @Autowired
    RedisCacheRepository cacheRepository;

    @PostConstruct
    public void init() {
        loadCacheOnStartUp();
    }

    public void loadCacheOnStartUp() {
        for (LinkMappingEntity mapping : linkMappingRepository.findAll()) {
            cacheRepository.saveToCache(mapping.getKey(), mapping.getValue());
        }
    }
}