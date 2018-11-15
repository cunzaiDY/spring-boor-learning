package com.atguigu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    /*
    在.yml配置文件中配置的druid里面的基本配置，需要在这里写上这个配置类
    注入进去才会生效
    把我们自己配置的属性通过ConfigurationProperties与我们的Bean绑定起来
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1.配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParms = new HashMap<>();

        initParms.put("jmxUsername","admin");
        initParms.put("jmxPassword","111");
        //配置允许谁访问
        initParms.put("allow","");//默认允许所有访问
        //配置拒绝谁访问
        initParms.put("deny","127.0.0.1");

        bean.setInitParameters(initParms);
        return bean;
    }

    //2.配置一个web监控的filter    （Druid的管理后台）
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParms = new HashMap<>();
        //配置放行哪些请求
        initParms.put("exclusions","*.js,*.css,/druid/*");
        //设置filter的一些初始化参数
        bean.setInitParameters(initParms);

        //设置拦截哪些请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
