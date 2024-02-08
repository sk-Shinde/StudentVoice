package com.studentVoice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentVoice.Entity.Batch;
import com.studentVoice.Service.BatchServiceImpl;

@Controller
public class BatchController {
	
	@Autowired
	private BatchServiceImpl batchServiceImpl;
	@GetMapping("/BatchIndex")
	public String viewHomePage(Model model) {
		model.addAttribute("allbatchlist", batchServiceImpl.getAllBatches());
		return "BatchIndex";
	}

	@GetMapping("/addnew")
	public String addNewBatch(Model model) {
		Batch batch = new Batch();
		model.addAttribute("batch", batch);
		return "new_batch";
	}

	@PostMapping("/save")
	public String saveBatch(@ModelAttribute("batch") Batch batch) {
		batchServiceImpl.save(batch);
		return "redirect:/BatchIndex";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		Batch batch = batchServiceImpl.getById(id);
		model.addAttribute("batch", batch);
		return "update_batch";
	}

	@GetMapping("/deleteBatch/{id}")
	public String deleteThroughId(@PathVariable(value = "id") long id) {
		batchServiceImpl.deleteViaId(id);
		return "redirect:/BatchIndex";

	}
}
