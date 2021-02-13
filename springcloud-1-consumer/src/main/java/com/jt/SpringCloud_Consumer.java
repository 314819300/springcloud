package com.jt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 如果引入数据源包.在包内有对应的spring的注解,所以在启动项目时,Spring容器要求必须实例化数据源.(驱动/用户名/密码….)
 * 排除数据源之外加载
 */
@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
@EnableEurekaClient
@EnableFeignClients		//添加feign的支持
public class SpringCloud_Consumer {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_Consumer.class, args);
	}
}
