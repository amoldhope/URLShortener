package com.innovecture.urlShortner.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UrlEntity {
    @Id
    private int hashcode;
    private String longUrl;

    public int getHashcode() {
        return hashcode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public UrlEntity(int hashcode, String longUrl) {
        this.hashcode = hashcode;
        this.longUrl = longUrl;
    }

    public UrlEntity() {
    }
}
