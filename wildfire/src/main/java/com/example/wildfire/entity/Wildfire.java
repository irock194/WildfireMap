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
	
	@Column(name = "x_coordinate")
	private double xCoordinate;
	
	@Column(name = "y_coordinate")
	private double yCoordinate;
	
	public Wildfire() {
		
	}
	
	public Wildfire(String name, String date, String category, double xCoord, double yCoord)
	{
		super();
		theName = name;
		theDate = date;
		theCategory = category;
		xCoordinate = xCoord;
		yCoordinate = yCoord;
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
		return theCategory;
	}
	public void setCategory(String category) {
		theCategory = category;
	}
	public double getXCoordinates() {
		return xCoordinate;
	}
	public void setXCoordinates(double xCoordinates) {
		xCoordinate = xCoordinates;
	}
	public double getYCoordinates() {
		return yCoordinate;
	}
	public void setYCoordinates(double yCoordinates) {
		yCoordinate = yCoordinates;
	}
}
