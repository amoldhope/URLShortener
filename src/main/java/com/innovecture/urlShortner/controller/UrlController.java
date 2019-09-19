package com.innovecture.urlShortner.controller;
import com.innovecture.urlShortner.entity.UrlEntity;
import com.innovecture.urlShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String url) {
        String shortenUrl = urlService.makeShortUrl(url);
        return new ResponseEntity(shortenUrl, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable int shortUrl) {
        List<UrlEntity> urls = urlService.getAllUrl();
        UrlEntity url = urlService.findLongUrl(shortUrl);
        RedirectView rv = new RedirectView();
        rv.setUrl("" + url.getLongUrl());
        return new RedirectView("http://" + url.getLongUrl());
    }


}
