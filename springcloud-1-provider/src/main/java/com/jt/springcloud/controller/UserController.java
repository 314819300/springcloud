package com.jt.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jt.springcloud.pojo.User;
import com.jt.springcloud.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	
	@RequestMapping("/findAll")
	public List<User> findAll(){
		
		return userService.findAll();
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
