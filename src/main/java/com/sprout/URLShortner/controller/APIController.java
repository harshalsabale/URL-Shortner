package com.sprout.URLShortner.controller;

import com.sprout.URLShortner.common.dto.ExtractServiceRequest;
import com.sprout.URLShortner.common.dto.ResponseDTO;
import com.sprout.URLShortner.common.dto.ShortServiceRequest;
import com.sprout.URLShortner.services.Extractor;
import com.sprout.URLShortner.services.Shortner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sprout.URLShortner.infrastructure.TransformResponse.toCreateResponse;
import static com.sprout.URLShortner.infrastructure.TransformResponse.toRedirectResponse;

@RestController
@RequestMapping(path = "/")
public class APIController {

    @Autowired
    Shortner shortner;

    @Autowired
    Extractor extractor;

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

    @GetMapping("/sprout/{key}")
    @ResponseBody
    public ResponseEntity<ResponseDTO> getUrlFromKey(@PathVariable("key") String key) {
        ExtractServiceRequest extractServiceRequest = ExtractServiceRequest.builder()
                .key(key)
                .build();
        extractServiceRequest.validate();
        String longUrl = extractor.getUrlForKey(extractServiceRequest);
        return toRedirectResponse(longUrl);
    }

}
