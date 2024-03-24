package com.sprout.URLShortner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/")
public class HealthCheckController {

    @GetMapping("/health.check")
    public String healthCheck() {
        return "Up and Running!";
    }

}
