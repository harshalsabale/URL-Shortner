package com.sprout.URLShortner.common.dto;


import com.sprout.URLShortner.common.exception.ValidationException;
import lombok.Builder;
import org.apache.commons.text.StringEscapeUtils;

import static com.sprout.URLShortner.common.constant.Constant.URL_VALIDATION_REGEX;
import static com.sprout.URLShortner.common.constant.ErrorMessageConstant.*;

@Builder
public record ShortServiceRequest(String url) {
    public void validate() {

        String sanitisedInput = StringEscapeUtils.escapeHtml4(url);

        if(url == null || url.isEmpty() || url.trim().isEmpty()) {
            throw new ValidationException(EMPTY_URL_ERROR);
        }

        if(!url.matches(URL_VALIDATION_REGEX)) {
            throw new ValidationException(NOT_URL_ERROR);
        }

        if(!url.equalsIgnoreCase(sanitisedInput)) {
            throw new ValidationException(INVALID_URL_ERROR);
        }
    }
}
