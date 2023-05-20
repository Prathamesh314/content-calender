package com.spring.contentcalender.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.spring.contentcalender.model.Content;

public interface ContentRepository extends ListCrudRepository<Content,Integer>{
	
}
