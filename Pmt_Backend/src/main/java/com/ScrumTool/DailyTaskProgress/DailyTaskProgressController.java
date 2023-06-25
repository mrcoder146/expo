package com.ScrumTool.DailyTaskProgress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class DailyTaskProgressController {

	@Autowired
	private DailyTaskProgressRepository dailyTaskProgressRepository;

	@GetMapping("/dailyTaskProgress")
	public List<DailyTaskProgress> getAllDailyTaskProgress() {
		return dailyTaskProgressRepository.findAll();
	}
}
