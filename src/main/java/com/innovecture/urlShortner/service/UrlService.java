package com.innovecture.urlShortner.service;

import com.innovecture.urlShortner.entity.UrlEntity;
import com.innovecture.urlShortner.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public String makeShortUrl(String url) {

        if (urlRepository.existsById(url.hashCode())) {
            UrlEntity entity = urlRepository.findById(url.hashCode()).get();
            entity.setHits(entity.getHits() + 1);
            urlRepository.save(entity);
            return "" + url.hashCode();
        }
        UrlEntity urlEntity = new UrlEntity(+url.hashCode(), url, new Date());
        urlRepository.save(urlEntity);
        return "" + url.hashCode();
    }

    public List<UrlEntity> getAllUrl() {
        List<UrlEntity> urls = (List<UrlEntity>) urlRepository.findAll();
        return urls;
    }

    public UrlEntity findLongUrl(int hashcode) {
        if (urlRepository.existsById(hashcode)) {
            UrlEntity entity = urlRepository.findById(hashcode).get();
            return entity;
        }
        return null;
    }

}
