package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.converter.Converter;
import com.example.demo.entity.User;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service("userService")
public class UserService {
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	public boolean create(User user) {
		try {
			userRepository.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public ResponseEntity<User> update(Long user_id, User user) {
		try {			
			user.setId(user_id);			
			userRepository.save(user);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public boolean delete(long id) {
		try {
			User user = userRepository.findOne(id);
			userRepository.delete(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	public List<UserModel> all() {			
		return converter.coverterList(userRepository.findAll());
	}
}
