package com.spring.bakery.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseConfig {

    @Bean
    public DataSource getConexion() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://pxukqohrckdfo4ty.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/qju279a6gz92bvt9");
        dataSource.setUsername("bqiwsmdrbd3robo5");
        dataSource.setPassword("jmmbm19uazz52ky4");
        return dataSource;
    }

}
