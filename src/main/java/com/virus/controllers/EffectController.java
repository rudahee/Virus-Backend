package com.virus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virus.services.entity.EffectService;

@RestController
@RequestMapping(path = "/effect")
public class EffectController {
	
	@Autowired
	protected EffectService service;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		ResponseEntity<?> response = null;
		
		response = ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
		
		return response;
	}
	
	@GetMapping("/get/all")
	public ResponseEntity<?> getById() {
		ResponseEntity<?> response = null;
		
		response = ResponseEntity.status(HttpStatus.OK).body(service.findAll());
		
		return response;
	}
}