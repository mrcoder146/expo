package com.ScrumTool.RetrospectionDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RetrospectionDetailsController {
	@Autowired
	private RetrospectionDetailsRepository retrospectionDetailsRepository;

	@GetMapping("/retrospectionDetails")
	public List<RetrospectionDetails> getAllRetrospectionDetails() {
		return retrospectionDetailsRepository.findAll();
	}

}