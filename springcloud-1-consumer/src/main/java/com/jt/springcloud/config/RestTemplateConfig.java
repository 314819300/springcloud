package com.jt.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean
	@LoadBalanced	//使用负载均衡，默认为轮询
	public RestTemplate getRestTemplate() {
		
		return new RestTemplate();
	}

	@Bean
	public IRule myRule() {

		return new RoundRobinRule();   //轮询策略
		//return new RandomRule();		 //随机策略
		//return new AvailabilityFilteringRule(); //首先会过滤掉故障机或者并发链接数超过阈值的服务器.剩余的机器轮询配置
		//new WeightedResponseTimeRule();	 //服务器影响时间越快,则权重越高
		//new BestAvailableRule();          //最大可用策略，即先过滤出故障服务器后，选择一个当前并发请求数最小的;
	}
}
