package com.innovecture.urlShortner.controller;
import com.innovecture.urlShortner.entity.UrlEntity;
import com.innovecture.urlShortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



import java.util.List;
@RestController
@RequestMapping("/api")
public class UrlController {
    Logger logger = LoggerFactory.getLogger(UrlController.class);

    @Autowired
    UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String url) {
        logger.info("succesfully hit shorten api");
        String shortenUrl = urlService.makeShortUrl(url);
        return new ResponseEntity("localhost:8080/api/"+shortenUrl, HttpStatus.OK);
    }

    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable int shortUrl) {
        UrlEntity url = urlService.findLongUrl(shortUrl);
        RedirectView rv = new RedirectView();
        rv.setUrl("http://" + url.getLongUrl());
        return rv;
    }


}
