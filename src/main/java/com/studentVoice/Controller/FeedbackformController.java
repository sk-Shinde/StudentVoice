package com.studentVoice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentVoice.Entity.*;
import com.studentVoice.Repository.FeedbackFormRepo;

@Controller
public class FeedbackformController 
{
	@Autowired
	private FeedbackFormRepo fed;	
    @GetMapping("/showfeedbackForm")
	    public String showForm(Model model) {
	        model.addAttribute("feedbackForm", new FeedbackForm());
	        return "feedbackform";
    }
    
    @GetMapping("/feedbackSuccess")
    public String showSuccess() {
    	return "FeedbackSucces";
    }
    
    @GetMapping("/allFeedbacks")
    public String showAllFeedbacks(Model model) {
        List<FeedbackForm> allFeedbacks = fed.findAll();
        model.addAttribute("allFeedbacks", allFeedbacks);
        return "allFeedbacks";
    }

	    @PostMapping("/feedbackForm")
	    public String submitForm(@ModelAttribute FeedbackForm form) {
	        // Process the form data (you can add more logic here)
	       fed.save(form);
	        // Redirect to a success page or back to the form
	        return "redirect:/feedbackSuccess";
	    }
}

	
	
	


