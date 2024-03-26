package com.sprout.URLShortner.common.dto;
import com.sprout.URLShortner.common.exception.NotFoundException;
import lombok.Builder;

import static com.sprout.URLShortner.common.constant.Constant.NUMBER_OF_CHARACTERS_IN_SHORT_URL;
import static com.sprout.URLShortner.common.constant.Constant.SHORT_URL_REGEX;
import static com.sprout.URLShortner.common.constant.ErrorMessageConstant.NOT_FOUND_ERROR;

@Builder
public record ExtractServiceRequest(String key) {

    public void validate() {

        if(key == null || key.isEmpty() || key.trim().isEmpty()) {
            throw new NotFoundException(NOT_FOUND_ERROR);
        }

        if(!key.matches(String.format(SHORT_URL_REGEX, NUMBER_OF_CHARACTERS_IN_SHORT_URL))) {
            throw new NotFoundException(NOT_FOUND_ERROR);
        }
    }

}
