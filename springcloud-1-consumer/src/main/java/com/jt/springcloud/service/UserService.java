package com.jt.springcloud.service;

import com.jt.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wangning
 * @create 2021-02-11 10:36
 */
@FeignClient(value="provider-user")
public interface UserService {
	@RequestMapping("/findAll") //提供者路径
	List<User> findAll();

	@RequestMapping("/saveUser")
	String saveUser(@RequestBody User user);
}
