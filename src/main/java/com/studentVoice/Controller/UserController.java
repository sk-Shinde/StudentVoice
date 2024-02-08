package com.studentVoice.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studentVoice.Entity.User;
import com.studentVoice.Service.UserService;
import com.studentVoice.dto.UserDto;



@Controller
@RequestMapping("/signup")
public class UserController {
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//	@GetMapping("/userhome")
//	public String userHome() {
//		return "UserHome";
//	}
	@GetMapping(value = {"/userhome", "/signup/userhome"})
	public String userHome() {
	    return "UserHome";
	}

	
	@GetMapping
	public String addNewUser(Model model) {
		UserDto user=new UserDto();
		model.addAttribute("user", user);
		return "SignupForUser";
	}
	
	@GetMapping("/allusers")
	public String getAllUsers(Model model){
		List<User> users=userService.getAll();
		model.addAttribute("users", users);
		return "Users";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserDto userDto) throws IOException {
		userService.save(userDto);
		return "redirect:/signup?success";
	}
	
	/*@GetMapping("/user")
	public String viewUserHomePage() {
		return "UserHome";
	}
	
	
	
	
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestParam("photo") MultipartFile file,@RequestParam String name,@RequestParam String email,@RequestParam String contact,@RequestParam String password,@RequestParam String about) throws IOException{
		userService.saveUser(file, name, email, contact, password, about);
		return "redirect:/user";
	}*/
}
