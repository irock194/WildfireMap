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
	
	@Column(name = "the_name")
	private String theName;
	
	public Wildfire() {
		
	}
	
	public Wildfire(String name)
	{
		super();
		theName = name;
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
}
