package com.jt.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import com.jt.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jt.springcloud.pojo.User;


@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/findAll")
	@HystrixCommand(fallbackMethod="hystrix_findAll")
	public List<User> findAll(){
		System.out.println("我是第一个服务");
//		int a = 1/0;
		return userService.findAll();
	}

	public List<User> hystrix_findAll(){
		List<User> userList =
				new ArrayList<>();
		User user = new User();
		user.setId(0).setName("服务器异常").setAge(0)
				.setSex("");
		userList.add(user);
		return userList;
	}

	/**
	 * 服务提供者 用户新增
	 */
//	@ResponseBody	//将对象转化为JSON
//	@RequestBody	//将json串转化为对象
	@RequestMapping("/saveUser")
	public String saveUser(@RequestBody User user) {

		return userService.saveUser(user);
	}

	/**
	 * 实现用户的删除 id = 54
	 */
	@RequestMapping("/delUser/{id}")
	public String delUser(@PathVariable Integer id) {
		return userService.delUser(id);

	}
}
