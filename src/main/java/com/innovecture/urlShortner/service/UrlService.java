package com.innovecture.urlShortner.service;

import com.innovecture.urlShortner.entity.UrlEntity;
import com.innovecture.urlShortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public String makeShortUrl(String url) {
        UrlEntity urlEntity = new UrlEntity(+url.hashCode(), url);
        urlRepository.save(urlEntity);
        return "" + url.hashCode();
    }

    public List<UrlEntity> getAllUrl() {
        List<UrlEntity> urls = (List<UrlEntity>) urlRepository.findAll();
        return urls;
    }

    public UrlEntity findLongUrl(int hashcode) {
        System.out.println("hashcode to be search in derby " + hashcode);
        if (urlRepository.existsById(hashcode)) {
            UrlEntity entity = urlRepository.findById(hashcode).get();
            return entity;
        }
        return null;
    }
}
