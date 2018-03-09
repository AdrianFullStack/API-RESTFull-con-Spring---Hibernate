package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@GetMapping("/user")
	public List<UserModel> list(){
		return userService.all();
	}
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable("id") Long user_id){
		return userService.find(user_id);
	}
	
	@GetMapping("/users")
	public List<UserModel> list(Pageable pageable){
		return userService.pagination(pageable);
	}
	
	@PostMapping("/user")
	public boolean create(@RequestBody @Valid User user) {
		return userService.create(user);
	}
	
	@PutMapping("/user/{id}")
	//@RequestMapping(value = "/user", method = RequestMethod.PUT, headers ="Accept=application/json")
	public ResponseEntity<User> update(@PathVariable("id") Long user_id, @RequestBody @Valid User user) {
		return userService.update(user_id, user);
	}
	
	@DeleteMapping("/user/{id}")
	public boolean delete(@PathVariable("id") Long user_id) {
		return userService.delete(user_id);
	}
}
