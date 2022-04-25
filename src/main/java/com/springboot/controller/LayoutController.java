package com.springboot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Layout;
import com.springboot.repository.LayoutRepository;

@RestController
public class LayoutController {
	@Autowired
	private LayoutRepository layoutRepository;
	
	/*
	 * Fetch all Layouts
	 */
	@GetMapping("/layouts")
	public List<Layout> getLayouts() {
		return layoutRepository.findAll();
	}
	
	/*
	 * Fetch layout based on ThLevel
	 */
	@GetMapping("/layouts/thLevel/{thLevel}")
	public List<Layout> getLayoutsByThLevel(@PathVariable("thLevel") int thLevel) {
		List<Layout> list = layoutRepository.getLayoutByThLevel(thLevel);
		return list;
	}
	
	/*
	 * Post Layouts ("thLevel": int, "imageUrl": String)
	 */
	@PostMapping("/layouts")
	public Layout postLayout(@RequestBody Layout layout) {
		layout.setUploadDate(LocalDate.now());
		return layoutRepository.save(layout);
	}
}
