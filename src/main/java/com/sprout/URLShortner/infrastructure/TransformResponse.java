package com.sprout.URLShortner.infrastructure;

import com.sprout.URLShortner.common.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class TransformResponse {

    public static ResponseEntity<ResponseDTO> toCreateResponse(String message) {
        ResponseDTO responseDTO = new ResponseDTO(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                message);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }
}
