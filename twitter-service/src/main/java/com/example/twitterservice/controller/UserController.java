package com.example.twitterservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twitterservice.model.User;
import com.example.twitterservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;

	@GetMapping
	public User getsample(){
		User user = new User();
		user.setName("rajan");
		user.setEmail("rajan@gmail.com");
		user.setPasswordHash("abc@");
		user.setPhone("8888-8888-8888");
		
		return user;
	}
	
	@PostMapping
	public User createUpdate(@RequestBody User user){
		User u = userRepo.save(user);
		
		return u;
	}
	
	@PutMapping("/{id}")
	public User update(@RequestBody User user, @PathVariable("id")Integer id){
		user.setId(id);
		User u = userRepo.save(user);
		return u;
	}
}
