package com.binara.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.binara")
public class HelloWorldConfiguration {

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();

//        driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
//        driverManagerDataSource.setUrl("jdbc:postgresql://localhost:5432/auth_module");
//        driverManagerDataSource.setUsername("dev");
//        driverManagerDataSource.setPassword("123");

        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/auth_module?useSSL=false&verifyServerCertificate=false");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123");

        return driverManagerDataSource;
    }

}