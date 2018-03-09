package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>, 
	PagingAndSortingRepository<User, Serializable>{
	
	public abstract User findById(long id);
	
	public abstract User findByEmail(String email);
	
	public abstract Page<User> findAll(Pageable pageable);
}
