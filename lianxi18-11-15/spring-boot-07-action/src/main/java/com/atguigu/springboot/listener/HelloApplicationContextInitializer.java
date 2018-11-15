package com.atguigu.springboot.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//监听IOC容器的启动，需要在META-INF中配置
public class HelloApplicationContextInitializer implements
        ApplicationContextInitializer<ConfigurableApplicationContext> {


    //初始化方法
    @Override
    public void initialize(ConfigurableApplicationContext initialize) {
        System.out.println("ApplicationContextInitializer...initialize..."+initialize);
    }
}
