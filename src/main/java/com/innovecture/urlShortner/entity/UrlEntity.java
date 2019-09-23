package com.innovecture.urlShortner.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="urllist")

public class UrlEntity {
    @Id
    @Column(name="hashcode")
    private int hashcode;

    @Column(name="longurl")
    private String longUrl;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="hits")
    private int hits=1;

    @Column(name="timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestamp;

    public UrlEntity() {
    }

    public UrlEntity(int hashcode, String longUrl, Date timestamp) {
        this.hashcode = hashcode;
        this.longUrl = longUrl;
        this.timestamp = timestamp;
    }

    public int getHashcode() {
        return hashcode;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
                   this.hits=hits;
    }
}
