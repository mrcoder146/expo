package com.ScrumTool.Role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RoleController {
	@Autowired
	private RoleRepository roleRepository;

	@GetMapping("/role")
	public List<Role> getAllRole() {
		return roleRepository.findAll();
	}

}
