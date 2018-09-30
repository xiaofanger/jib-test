package com.fanger.jib.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@MapperScan(value = {""})
public class DataSourceConfiguration {

    @Value(value = "${spring.datasource.driver-class-name}")
    private String jdbcDriver;
    @Value(value = "${spring.datasource.url}")
    private String jdbcUrl;
    @Value(value = "${spring.datasource.username}")
    private String jdbcUserName;
    @Value(value = "${spring.datasource.password}")
    private String jdbcPassword;

    @Bean(name = "dataSource")
    public DruidDataSource createDataSource() {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUserName);
        dataSource.setPassword(jdbcPassword);

        return dataSource;

    }

}
