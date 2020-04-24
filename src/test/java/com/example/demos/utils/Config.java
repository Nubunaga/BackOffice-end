package com.example.demos.utils;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

//This config filé referes to a test db that contains no vital information!
@TestConfiguration
public class Config {

    @Bean
    @Primary
    public DataSource getDatasource(){
        DataSourceBuilder dBuilder = DataSourceBuilder.create();
        dBuilder.driverClassName("com.mysql.jdbc.Driver");
        dBuilder.url("jdbc:mysql://83.253.58.62:3306/db-test");
        dBuilder.username("Netanel");
        dBuilder.password("Netanel123");
        return dBuilder.build();
    }

}