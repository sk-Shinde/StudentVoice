package com.studentVoice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentVoice.Entity.User;



public interface UserRepo extends JpaRepository<User,Long>{
	User findByEmail(String email);
}
