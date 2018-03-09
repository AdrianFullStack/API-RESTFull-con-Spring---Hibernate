package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.entity.User;
import com.example.demo.model.UserModel;

@Component("converter")
public class Converter {
	public List<UserModel> coverterList(List<User> users){
		List<UserModel> musers = new ArrayList<>();
		for(User user : users) {
			musers.add(new UserModel(user));
		}
		return musers;
	}
}
