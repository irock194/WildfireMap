package com.example.wildfire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.json.*;


@CrossOrigin
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

	@CrossOrigin
	@GetMapping(path = "/getNASA", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getNASA() {
		String url = "https://eonet.sci.gsfc.nasa.gov/api/v2.1/events";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}

	@CrossOrigin
	@GetMapping(path = "/api/insertNASA")
	public List<Wildfire> insertNASA() {
		String url = "https://eonet.sci.gsfc.nasa.gov/api/v2.1/events";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		JSONObject obj = new JSONObject(result);
		List<Wildfire> wildfires = new ArrayList<Wildfire>();
		JSONArray eventsArr = obj.getJSONArray("events");
		for(int i = 0; i < eventsArr.length(); i++)
		{
			Wildfire wildfireToAdd = new Wildfire();
			String title = eventsArr.getJSONObject(i).getString("title");
			wildfireToAdd.setName(title);
			JSONArray categoriesArr = eventsArr.getJSONObject(i).getJSONArray("categories");
			for(int j = 0; j < categoriesArr.length(); j++)
			{
				String category = categoriesArr.getJSONObject(j).getString("title");
				wildfireToAdd.setCategory(category);
			}

			JSONArray geometriesArr = eventsArr.getJSONObject(i).getJSONArray("geometries");
			for(int j = 0; j < geometriesArr.length(); j++)
			{
				String date =  geometriesArr.getJSONObject(j).getString("date");
				wildfireToAdd.setDate(date);
				JSONArray coordinatesArr = geometriesArr.getJSONObject(j).getJSONArray("coordinates");
				for(int k = 0; k < coordinatesArr.length(); k++)
				{
					double coordinate = coordinatesArr.getBigDecimal(k).doubleValue();
					if(k == 0)
						wildfireToAdd.setXCoordinates(coordinate);
					else
						wildfireToAdd.setYCoordinates(coordinate);
				}
			}

			wildfires.add(wildfireToAdd);
		}

		for(Wildfire currentWildfire: wildfires)
		{
			System.out.println(currentWildfire.getId() + " "  + currentWildfire.getDate() + " " + currentWildfire.getXCoordinates() + ":" + currentWildfire.getYCoordinates() + " " + currentWildfire.getName());
		}
		

		return this.wildfireRepository.saveAll(wildfires);
	}
}

