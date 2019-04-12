package com.swpu.diet_healthyweb.configur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer{
	//设置初始页面
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("").setViewName("/login");
	}

	//配置拦截器
	@Autowired
	private MyInterceptor myInterceptor;
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(myInterceptor).addPathPatterns("/**").excludePathPatterns("/",
				 "/toManagerLogin", "/static/**", "/webjars/**", "/js/**", 
				"/images/**", "/css/**", "/imgvrifyControllerDefaultKaptcha",
				"/defaultKaptcha", "/login.html", "/upload/cook/**", "/upload/food/**");
    }

    /**
     * 设置虚拟路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///H:/images/");
    }
}
