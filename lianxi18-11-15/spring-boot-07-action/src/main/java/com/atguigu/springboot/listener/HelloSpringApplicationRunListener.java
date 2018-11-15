package com.atguigu.springboot.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

//需要在META-INF中配置
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {

    //写一个有参构造器SpringApplication application, String[] args,
    // 把spring应用application和命令行参数args都传过来
    public HelloSpringApplicationRunListener(SpringApplication application, String[] args){

    }

    //监听容器开始
    @Override
    public void starting() {
        System.out.println("SpringApplicationRunListener...starting...");
    }

    //环境准备好
    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        //获取操作系统的系统属性
        Object o = environment.getSystemProperties().get("os.name");
        System.out.println("SpringApplicationRunListener...environmentPrepared..."+o);
    }

    //表示IOC容器准备好了
    @Override
    public void contextPrepared(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SpringApplicationRunListener...contextPrepared...");
    }

    //表示容器环境已经加载完成
    @Override
    public void contextLoaded(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("SpringApplicationRunListener...contextLoaded...");
    }

    //整个IOC容器创建完成
    @Override
    public void finished(ConfigurableApplicationContext configurableApplicationContext, Throwable throwable) {
        System.out.println("SpringApplicationRunListener...finished...");
    }
}
