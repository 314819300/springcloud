package com.jt.springcloud.service;

import java.util.List;

import com.jt.springcloud.factory.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jt.springcloud.pojo.User;

@FeignClient(value="provider-user", fallbackFactory= UserFallbackFactory.class)	//写入微服务名称
//@FeignClient(value="provider-user")
public interface UserService {
	
	@RequestMapping(value="/findAll")
	List<User> findAll();
	
	@RequestMapping("/saveUser")
	String saveUser(@RequestBody User user);
}
