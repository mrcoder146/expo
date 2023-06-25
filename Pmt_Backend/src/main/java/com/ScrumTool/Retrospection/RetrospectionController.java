package com.ScrumTool.Retrospection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RetrospectionController {
@Autowired
private RetrospectionRepository  retrospectionRepository;
 
@GetMapping("/retrospection")
public List<Retrospection>getAllRetrospection(){
	return  retrospectionRepository.findAll();
}
}