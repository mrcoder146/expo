package com.ScrumTool.ReleaseSprintBacklog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ReleaseSprintBacklogController {
	@Autowired
	private ReleaseSprintBacklogRepository ReleaseSprintBacklogRepository;
	@GetMapping("/ReleaseSprintBacklog")
	public List<ReleaseSprintBacklog> getAllSprintBacklog(){
		return ReleaseSprintBacklogRepository.findAll();
	}
		
	}
