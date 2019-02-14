package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/users")
public class UserController {
	
	private List<User> userList = Arrays.asList(
		new User (1L, "First1 Last1", "f.last1@gmail.com"),
		new User (2L, "First2 Last2", "f.last2@gmai.com")
	);
	
	@GetMapping ("") 
	public List<User> findAllUsers () {
		return userList;
	}
	
	@GetMapping("/{userId}")
	public User findUser (@PathVariable Long userId) {
		return userList.stream().filter(b -> b.getId().equals(userId)).findFirst().orElse(null);
	}

}
