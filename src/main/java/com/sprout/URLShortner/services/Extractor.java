package com.sprout.URLShortner.services;

import com.sprout.URLShortner.common.dto.ExtractServiceRequest;

public interface Extractor {

    public String getUrlForKey(ExtractServiceRequest extractServiceRequest);
}
