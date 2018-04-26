package com.rks.project.pointofsales;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by ASUS on 23/04/2018.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login/index");
        registry.addViewController("/login").setViewName("login/index");
        registry.addViewController("/main").setViewName("admin page/create");
    }
}
