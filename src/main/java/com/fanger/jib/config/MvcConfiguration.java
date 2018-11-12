package com.fanger.jib.config;

import com.fanger.jib.filter.AdapterFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xiaofanger
 * @create 2018/11/12 0012
 */
@Configuration
public class MvcConfiguration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<AdapterFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new AdapterFilter());
        registration.addUrlPatterns("/*");
//        registration.addInitParameter("includeUri", includeUriStr.toString());
        registration.setName("adapterFilter");
        registration.setOrder(1);
        return registration;
    }

}
