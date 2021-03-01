package com.jt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author wangning
 * @create 2021-03-01 17:02
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableZuulProxy	//开启API网关
public class SpringCloud_Zuul {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_Zuul.class, args);
	}
}
