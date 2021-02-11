package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//排除数据源，因为没有配置数据源，加载的时候必然报错
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer			//定义为Eureka服务端，启动Rurake服务
public class EurekaServerApp_7000 {
	
	public static void main(String[] args) {
		
		SpringApplication.run(EurekaServerApp_7000.class, args);
	}
}
