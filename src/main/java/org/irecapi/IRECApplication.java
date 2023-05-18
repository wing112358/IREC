package org.irecapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class IRECApplication {
    public static void main(String[] args) {
        //用来运行SpringBoot的SpringApplication类中的run，通过run，就可以运行Springboot应用
        SpringApplication.run(IRECApplication.class,args);
    }
}