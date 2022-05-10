package com.example.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
/**
 *在项目启动类上面使用@EnableEurekaServer，可以将项目作为Spring Cloud的注册中心（启动 Eureka 服务注册中心）
 */
/**
 * 点击@EnableEurekaServer查看源码，可以看到介绍是这样的:激活Eureka服务器相关配置EurekaServerMarkerConfiguration的注释。
 * 可以将@EnableEurekaServer注解看作是一个开关，开启时，会激活相关配置，会作为注册中心。
 * 同时，他又引用了EurekaServerMarkerConfiguration类
 */
/**
 * 点击查看EurekaServerMarkerConfiguration类的源码，可以看到介绍是：负责添加一个标记来激活配置类EurekaServerMarkerConfiguration。
 * 这个类中，向容器注入了一个类EurekaServerMarkerConfiguration.Marker,作用就是激活配置类。
 */
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}

/**
 * 点击到这里，我们发现 spring.factories文件: org.springframework.cloud.netflix.eureka.server.EurekaServerAutoConfiguration
 * 点击EurekaServerAutoConfiguration，发现标注的这个注解：@ConditionalOnBean({Marker.class})
 *
 * @ConditionalOnBean： 条件注入
 * 也就是当有 EurekaServerMarkerConfiguration.Marker.class时，才会注入。
 * 所以@EnableEurekaServer就是一个开关，zhi要写了该注解，spring就会帮我们把EurekaServerAutoConfiguration类注入进来。
 */
