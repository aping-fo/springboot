package com.app.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lucky on 2017/12/19.
 */
@Service
public class ServerService {

    @Resource(name="secondaryJdbcTemplate")
    JdbcTemplate jdbcTemplate;

    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from player", Integer.class);
    }
}
