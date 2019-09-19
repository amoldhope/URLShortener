package com.innovecture.urlShortner.repository;

import com.innovecture.urlShortner.entity.UrlEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UrlRepository extends CrudRepository<UrlEntity,Integer> {

}
