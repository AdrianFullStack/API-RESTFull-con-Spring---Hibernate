package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service("userSecurityService")
public class UserSecurityService implements UserDetailsService{
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		return new org.springframework.security.core.userdetails.User(
				user.getEmail(), user.getPassword(), true, true, true, true, buildGrante((byte)1) );
	}
	
	public List<GrantedAuthority> buildGrante(byte rol){
		String[] roles = {"read", "user", "admin"};
		List<GrantedAuthority> auths = new ArrayList<>();
		
		for(int i=0; i<rol; i++) {
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		
		return auths;
	}
}
