package me.dragon.app;

import me.dragon.base.controller.ControllerDemo;
import me.dragon.base.controller.RestControllerDemo;
import me.dragon.biz.controller.TestInterfaceController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * 添加了兼容JSP的依赖
 * 在SpringBootStartApplication.configure中需要返回所有Controller，待优化模块
 * @ComponentScan(basePackages = {"me.dragon"})
 * @EnableAutoConfiguration
 */

@ComponentScan(basePackages = {"me.dragon"})
@EnableAutoConfiguration
@SpringBootApplication
public class SpringBootStartApplication extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(
                SpringBootStartApplication.class,
                ControllerDemo.class,
                RestControllerDemo.class,
                TestInterfaceController.class
        );
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootStartApplication.class,args);
    }
}
