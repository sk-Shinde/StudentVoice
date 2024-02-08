package com.studentVoice.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	
	@GetMapping("/home")
	public String Home() {
		return "Home";
	}
	@GetMapping("/about")
	public String About() {
		return "about";
	}
	
	@GetMapping("/login")
	public String login() {
		return "LoginForUser";
	}
	
	@GetMapping("/goToSignupOptions")
	public String goToSignupOtptions(){
		return "SignupOptions";
	}
	
	@GetMapping("/goToLoginOptions")
	public String goToLoginOptions() {
		return "LoginOptions";
	}
	
	
	
	
	
}
