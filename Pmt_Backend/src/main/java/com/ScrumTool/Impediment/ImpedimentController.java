package com.ScrumTool.Impediment;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ImpedimentController {

	@Autowired
	private ImpedimentRepository impedimentRepository;
	
	@GetMapping("/impediment")
	public Optional<Impediment> getAllImpediments(){	
		return impedimentRepository.findById(1);
	}
}
