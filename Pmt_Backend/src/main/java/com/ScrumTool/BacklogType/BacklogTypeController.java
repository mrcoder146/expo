package com.ScrumTool.BacklogType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")

public class BacklogTypeController {
	@Autowired
	private BacklogTypeRepository backlogTypeRepository;

	@GetMapping("/backlogType")
	public List<BacklogType> getAllBacklogType() {

		return backlogTypeRepository.findAll();

	}
}
