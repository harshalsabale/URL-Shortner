package com.sprout.URLShortner.services;

import com.sprout.URLShortner.common.dto.ShortServiceRequest;
import com.sprout.URLShortner.common.exception.ServerException;
import com.sprout.URLShortner.postgress.entities.LinkMappingEntity;
import com.sprout.URLShortner.repository.LinkMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.sprout.URLShortner.common.constant.Constant.*;

@Service
public class ShortnerImpl implements Shortner {

    @Autowired
    private LinkMappingRepository linkMappingRepository;

    @Value("${custom.api.base.url}")
    private String baseURL;

    @Override
    public String getShortURL(ShortServiceRequest shortServiceRequest) {
        try {
            LinkMappingEntity linkMapping = saveBaseLinkMappingEntity(shortServiceRequest.url());
            String shortKey = getUniqueIdFromPrimaryKey(linkMapping, Math.random());

            updateLinkMappingEntity(linkMapping, shortKey);

            return baseURL.concat(shortKey);
        } catch (Exception e) {
            throw new ServerException(e.getMessage());
        }
    }

    public LinkMappingEntity saveBaseLinkMappingEntity(String url) {
        LocalDateTime now =  LocalDateTime.now();
        LinkMappingEntity linkMapping = new LinkMappingEntity();
        linkMapping.setValue(url);
        linkMapping.setCreatedBy(SYSTEM_CREATOR);
        linkMapping.setCreatedAt(now);
        return linkMappingRepository.save(linkMapping);
    }

    public void updateLinkMappingEntity(LinkMappingEntity linkMapping, String key) {
        linkMapping.setKey(key);
        linkMappingRepository.save(linkMapping);
    }

    private String getUniqueIdFromPrimaryKey(LinkMappingEntity linkMapping, double random) {
        long primaryKey = linkMapping.getUniqueId();
        long salt = (long) Math.ceil((random + 1.0) * 100) * SALTING_KEY;

        StringBuilder shortURL = convertToBase62(primaryKey * salt);

        return String.valueOf(shortURL);
    }

    private StringBuilder convertToBase62(long saltedKey) {

        StringBuilder shortURL = new StringBuilder();

        while(saltedKey > 0) {
            int index = (int) (saltedKey % ALLOWED_CHARACTERS_IN_URL_COUNT);
            shortURL.append(ALLOWED_CHARACTERS_IN_URL_LIST.get(index));
            saltedKey /= ALLOWED_CHARACTERS_IN_URL_COUNT;
        }
        shortURL.reverse();

        return shortURL;
    }
}
