package com.example.wildfire.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wildfires")
public class Wildfire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "title")
	private String theName;
	
	@Column(name = "date")
	private String theDate;
	
	@Column(name = "category")
	private String theCategory;
	
	@Column(name = "coordinates")
	private String theCoordinates;
	
	public Wildfire() {
		
	}
	
	public Wildfire(String name, String date, String category, String coords)
	{
		super();
		theName = name;
		theDate = date;
		theCategory = category;
		theCoordinates = coords;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return theName;
	}
	public void setName(String name) {
		theName = name;
	}
	public String getDate() {
		return theDate;
	}
	public void setDate(String date) {
		theDate = date;
	}
	public String getCategory() {
		return theCoordinates;
	}
	public void setCategory(String category) {
		theCategory = category;
	}
	public String getCoordinates() {
		return theCoordinates;
	}
	public void setCoordinates(String coordinates) {
		theCoordinates = coordinates;
	}
}
