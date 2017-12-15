package com.winhe.institute.management.user;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.winhe.institute.management.util.jsonwrapper.JsonWrapper;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/users")
	public JsonWrapper getUsers(){
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	public JsonWrapper getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public JsonWrapper addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
	public JsonWrapper updateUser(@RequestBody User user, @PathVariable Integer id) {
		return userService.updateUser(id,user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public JsonWrapper deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}
	
	
	
}
