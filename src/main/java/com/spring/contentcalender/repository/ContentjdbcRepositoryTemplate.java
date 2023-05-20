package com.spring.contentcalender.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContentjdbcRepositoryTemplate {
	@SuppressWarnings("unused")
	private final JdbcTemplate jdbctemplate;

	public ContentjdbcRepositoryTemplate(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}
}
