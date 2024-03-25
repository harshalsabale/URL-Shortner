package com.sprout.URLShortner.controller;

import com.sprout.URLShortner.common.dto.ResponseDTO;
import com.sprout.URLShortner.common.dto.ShortServiceRequest;
import com.sprout.URLShortner.services.Shortner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sprout.URLShortner.infrastructure.TransformResponse.toCreateResponse;

@RestController
@RequestMapping(path = "/")
public class APIController {

    @Autowired
    Shortner shortner;

    @PostMapping("/short.it")
    @ResponseBody
    public ResponseEntity<ResponseDTO> getShortURL(@RequestParam(name = "url") String url) {
        ShortServiceRequest shortServiceRequest = ShortServiceRequest.builder()
                .url(url)
                .build();
        shortServiceRequest.validate();
        String key = shortner.getShortURL(shortServiceRequest);
        return toCreateResponse(key);
    }

}
