package com.jt.springcloud.controller;

import java.net.URL;
import java.util.List;

import com.jt.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jt.springcloud.pojo.User;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
//	private static final String provider_url = "http://localhost:8000";
	private static final String provider_url = "http://PROVIDER-USER";
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")	//压制警告
	@RequestMapping("/consumer/findAll")
	public List<User> findAll(){
		System.out.println("使用feign进行请求");
//		return restTemplate.getForObject(provider_url+"/findAll", List.class);
		return userService.findAll();
	}

	/**
	 * 编辑消费者的Controller
	 * @return
	 * request 请求发送的参数
	 */
	@RequestMapping("/consumer/{name}/{age}/{sex}")
	public String saveUser(User user) {
		String postUrl = provider_url + "/saveUser";
		return restTemplate.postForObject(postUrl, user, String.class);
	}

	/**
	 * 实现用户的删除 id=54
	 */
	@RequestMapping("/consumer/{id}")
	public String delUser(@PathVariable Integer id) {
		//第一种
		String delUrl = provider_url + "/delUser/" + id;
		//第二种
		String delUrl2 = provider_url + "/delUser?id=" + id;
		return restTemplate.getForObject(delUrl, String.class);

	}
}
