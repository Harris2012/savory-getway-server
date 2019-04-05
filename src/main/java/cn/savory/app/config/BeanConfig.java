package cn.savory.app.config;

import cn.savory.app.filters.AuthFilter;
import cn.savory.app.localtor.SavoryRouteLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author harriszhang
 * @date 2018/12/6.
 */
@Configuration
public class BeanConfig {

    @Autowired
    ZuulProperties zuulProperties;

    @Autowired
    DispatcherServletPath dispatcherServletPath;

    @Bean
    public AuthFilter authFilter() {

        System.out.println("authFilter() is called.");
        return  new AuthFilter();
    }

    @Bean
    public SavoryRouteLocator savoryRouteLocator() {

        System.out.println("savoryRouteLocator() is called.");

        return new SavoryRouteLocator(dispatcherServletPath.getPrefix(), zuulProperties);
    }
}
