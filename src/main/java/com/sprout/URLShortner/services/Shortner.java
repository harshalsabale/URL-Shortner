package com.sprout.URLShortner.services;

import com.sprout.URLShortner.common.dto.ShortServiceRequest;

public interface Shortner {

    public String getShortURL(ShortServiceRequest shortServiceRequest);

}
