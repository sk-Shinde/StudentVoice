package com.studentVoice.Service;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
import java.util.Collections;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//import com.studentVoice.Entity.Role;
import com.studentVoice.Entity.User;
import com.studentVoice.Repository.UserRepo;
import com.studentVoice.dto.UserDto;
//import com.studentVoice.util.ImageUtils;




@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public User save(UserDto dto) throws IOException {
		User user=new User();
		//user.setPhoto(ImageUtils.compressImage(dto.getPhoto().getBytes()));
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setContact(dto.getContact());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		user.setLocation(dto.getLocation());
		//user.setRoles(Arrays.asList(new Role("ROLE_USER")));
		return userRepo.save(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=userRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),Collections.emptyList());
	}
	
//	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//		return roles.stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//	}
	
	@Override
	public List<User> getAll(){
		List<User> userCompressed=new ArrayList<>();
		List<User> users=userRepo.findAll();
		for(User user:users) {
			//user.setPhoto(ImageUtils.decompressImage(user.getPhoto()));
			user.setName(user.getName());
			user.setEmail(user.getEmail());
			user.setContact(user.getContact());
			user.setPassword(user.getPassword());
			user.setLocation(user.getLocation());
			userCompressed.add(user);
		}
		return userCompressed;
	}
}
