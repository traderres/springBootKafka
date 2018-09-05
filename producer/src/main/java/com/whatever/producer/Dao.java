package com.whatever.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by adam on 8/29/18.
 */
@Service
public class Dao
{
    private static final Logger logger = LoggerFactory.getLogger(Dao.class);

    @Resource
    private DataSource postgresDataSource;

    public Dao()
    {
        logger.debug("DAO() constructor called.");
    }


    @PostConstruct
    public void postConstruct()
    {
        logger.debug("postConstruct() called.");
    }


    public String getCurrentDateTime()
    {
        logger.debug("getCurrentDateTime() started.");
        JdbcTemplate jt = new JdbcTemplate(this.postgresDataSource);
        String sql = "select now()";

        String dateTime = jt.queryForObject(sql, String.class);
        return dateTime;
    }

}
