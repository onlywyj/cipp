package com.wyj.cipp.config;/*
 * @author WYJ
 * @data 2021/1/7 21:07
 * 概述：
 *       全局支持跨域
 *
 */

import com.wyj.cipp.Interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //需要支持跨域访问的文件路径
        registry.addMapping("/wyj/cipp/controller/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

    //注册连接器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/htlogin")
                .excludePathPatterns("/htuser/htlogin")
                .excludePathPatterns("/htmain")
                .excludePathPatterns("/x-admin/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //静态资源放行
        registry.addResourceHandler("/image/**").addResourceLocations("classpath:/image/");

    }

}
