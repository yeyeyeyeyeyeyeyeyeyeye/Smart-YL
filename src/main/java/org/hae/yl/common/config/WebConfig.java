package org.hae.yl.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        System.out.println("注册拦截器...。。。。。。。。。");
        // 添加拦截器，并指定拦截路径
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")     // 拦截所有路径
                .excludePathPatterns(
                        "/publicapi/**", // 排除所有 /publicapi/ 开头的接口
                        "/api/**",
                        "/error",        // Spring 默认错误页面
                        "/favicon.ico"   // 防止浏览器请求图标被拦截
                )
                .order(0);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 允许跨域的路径
                .allowedOrigins("http://localhost:8080")  // 允许的来源
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的请求方法
                .allowedHeaders("*")  // 允许的请求头
                .allowCredentials(true);  // 是否允许发送Cookie信息
    }
}
