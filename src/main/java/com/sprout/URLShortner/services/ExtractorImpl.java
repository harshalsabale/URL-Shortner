package com.sprout.URLShortner.services;

import com.sprout.URLShortner.common.dto.ExtractServiceRequest;
import com.sprout.URLShortner.common.exception.NotFoundException;
import com.sprout.URLShortner.repository.LinkMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.sprout.URLShortner.common.constant.ErrorMessageConstant.NOT_FOUND_ERROR;

@Service
public class ExtractorImpl implements Extractor{

    @Autowired
    LinkMappingRepository linkMappingRepository;

    @Override
    public String getUrlForKey(ExtractServiceRequest extractServiceRequest) {
        String url = linkMappingRepository.getUrlForKey(extractServiceRequest.key());

        if(url == null) {
            throw new NotFoundException(NOT_FOUND_ERROR);
        }

        return url;

    }
}
