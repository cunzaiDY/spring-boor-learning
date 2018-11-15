package com.atguigu.springboot.listener;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//表示放在容器中
@Component
public class HelloCommandLineRunner implements CommandLineRunner {

    //里面用的是可变数组的形式
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("CommandLineRunner...run..."+ Arrays.asList(strings));
    }
}
