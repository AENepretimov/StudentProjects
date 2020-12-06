package com.test.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createDB(){
        jdbcTemplate.execute("CREATE SCHEMA IF NOT EXISTS test1");
        jdbcTemplate.execute("USE test1");
        jdbcTemplate.execute("DROP TABLE IF EXISTS student");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS student " +
                "(id INT AUTO_INCREMENT PRIMARY KEY," +
                " name VARCHAR (50)," +
                " gr INT )");

        return "create DB";
    }


}
