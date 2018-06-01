package com.wm.ticketing.entities;

import java.util.List;

public class Venue {
	
	private int id;
	private String name;
	private int capacity;
	private List<Zone> zones;

	public int getVenueId() { return id; }
	
	public void setVenueId(int id) { this.id=id; }
	
	public String getVenueName() { return name; }
	
	public void setVenueName(String name) { this.name=name; }
	
	public int getCapacity() { return capacity; }
	
	public void setCapacity(int capacity) { this.capacity=capacity; }
	
	public List<Zone> getZones() { return zones; }

	
}
