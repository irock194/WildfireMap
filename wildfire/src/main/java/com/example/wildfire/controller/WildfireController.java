package com.example.wildfire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.wildfire.repository.*;
import com.example.wildfire.entity.*;
import com.example.wildfire.exception.ResourceNotFoundException;

@RestController
public class WildfireController {

	@Autowired
	private WildfireRepository wildfireRepository;
	
	@RequestMapping("/api/wildfires")
	public List<Wildfire> getAllWildfires(){
		return this.wildfireRepository.findAll();
	}
	
	@GetMapping("/api/wildfires/{id}")
	public Wildfire getWildfireById(@PathVariable (value = "id") long wildfireId) {
		return this.wildfireRepository.findById(wildfireId)
				.orElseThrow(() -> new ResourceNotFoundException("Wildfire not found with id :" + wildfireId));
	}
	
	@PostMapping
	public Wildfire createWildfire(@RequestBody Wildfire wildfire)
	{
		return this.wildfireRepository.save(wildfire);
	}
	
	@PutMapping("/{id}")
	public Wildfire updateWildfire(@RequestBody Wildfire wildfire, @PathVariable ("id") long wildfireId)
	{
		Wildfire existingWildfire = this.wildfireRepository.findById(wildfireId)
		.orElseThrow(() -> new ResourceNotFoundException("Wildfire not found with id :" + wildfireId));
		existingWildfire.setName(wildfire.getName());
		return this.wildfireRepository.save(existingWildfire);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Wildfire> deleteWildfire(@PathVariable ("id") long wildfireId){
		Wildfire existingWildfire = this.wildfireRepository.findById(wildfireId)
				.orElseThrow(() -> new ResourceNotFoundException("Wildfire not found with id :" + wildfireId));
		this.wildfireRepository.delete(existingWildfire);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getNASA")
	public String getNASA() {
		String url = "https://eonet.sci.gsfc.nasa.gov/api/v3/events";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
}
