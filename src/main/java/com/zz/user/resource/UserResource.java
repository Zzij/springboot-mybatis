package com.zz.user.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zz.user.mapper.UserMapper;
import com.zz.user.object.User;
@RestController
@RequestMapping("/aaa")
public class UserResource {

	@Autowired(required=false)
	private UserMapper userMapper;
	
	private Logger logger = LoggerFactory.getLogger(UserResource.class);
	@GetMapping("/bbb")
	public List<User> getUser(@PathParam("name") String name) {
		logger.info(name);
		List<User> user = userMapper.findUserByName(name);
		if(user != null)
			logger.info(user.toString());
		else 
			logger.info("user is null");
		return user;
	}
	
	@PostMapping("/postUser")
	public boolean insertPostUser(@RequestBody(required = false) User user) {
		try {
			logger.info(user.toString());
			userMapper.insertUser(user);
			return true;
		}catch(Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
	
	@GetMapping("/user")
	public boolean insertUser(@RequestBody(required=false) User user) {
		try {
			logger.info(user.toString());
			userMapper.insertUser(user);
			return true;
		}catch(Exception e) {
			logger.error(e.getMessage());
			return false;
		}
	}
	
	@DeleteMapping("delete")
	public String deleteUser(@PathParam("name") String name) {
		try {
			logger.info(String.valueOf(userMapper.deleteUser(name)));
			logger.info("delete success");
			return "success";
		} catch (Exception e) {
			logger.error("delete fail" + e.getMessage());
			return "fail";
		}
	}
}
