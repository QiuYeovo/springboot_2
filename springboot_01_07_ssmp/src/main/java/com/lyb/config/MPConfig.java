package com.lyb.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//配置类
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.定义MP拦截器
        MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
        //2.添加具体的拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());//分页拦截器
        return interceptor;
    }


}
