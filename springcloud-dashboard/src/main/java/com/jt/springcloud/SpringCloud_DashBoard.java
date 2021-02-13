package com.jt.springcloud;

import org.apache.http.util.Args;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author wangning
 * @create 2021-02-13 19:19
 */
@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
@EnableHystrixDashboard    //启动仪表盘监控程序
public class SpringCloud_DashBoard {
	public static void main(String[] args) {
		SpringApplication.run(SpringCloud_DashBoard.class, args);

	}
}
