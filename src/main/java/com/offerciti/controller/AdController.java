package com.offerciti.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.offerciti.model.Ad;

@RestController
public class AdController {

    @RequestMapping("ads/create")
    public Ad createAd(@RequestParam(value="name", defaultValue="World") String name) {
        return new Ad("Hello World");
    }
}
