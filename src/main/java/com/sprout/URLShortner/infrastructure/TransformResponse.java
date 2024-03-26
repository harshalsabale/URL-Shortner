package com.sprout.URLShortner.infrastructure;

import com.sprout.URLShortner.common.dto.ResponseDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public class TransformResponse {

    public static ResponseEntity<ResponseDTO> toCreateResponse(String message) {
        ResponseDTO responseDTO = new ResponseDTO(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                message);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    public static ResponseEntity<ResponseDTO> toRedirectResponse(String url) {
        ResponseDTO responseDTO = new ResponseDTO(
                HttpStatus.MOVED_PERMANENTLY.value(),
                HttpStatus.MOVED_PERMANENTLY.getReasonPhrase(),
                url);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(url));
        return new ResponseEntity<>(responseDTO, headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
