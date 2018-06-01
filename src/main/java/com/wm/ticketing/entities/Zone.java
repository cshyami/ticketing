package com.wm.ticketing.entities;

import java.math.BigDecimal;
import java.util.List;

public class Zone {
	
	private int id;
	private Venue venue;
	private String name;
	//private int noOfRows;
	private int noOfSeats;
	private BigDecimal pricePerSeat;
	private List<Seat> seats;
	//private static int availableSeatId;
	
	public Zone(int id, String name, int noOfSeats, BigDecimal pricePerSeat) {
		this.id=id;
		this.name=name;
		this.noOfSeats=noOfSeats;
		this.pricePerSeat=pricePerSeat;
	}
	
	public int getId() { return id; }
	
	public void setId(int id) { this.id=id; }
	
	public Venue getVenue() { return venue; }
	
	public void setVenue(Venue venue) { this.venue=venue; }

	public String getName() { return name; }
	
	public void setName(String name) { this.name = name; }
	
/*	public int getNoOfRows() { return noOfRows; }
	
	public void setNoOfRows(int noOfRows) { this.noOfRows= noOfRows; }*/
	
	public int getNoOfSeats() { return noOfSeats; }
	
	public void setNoOfSeats(int noOfSeats) { this.noOfSeats= noOfSeats; }
	
	public BigDecimal getPrice() { return pricePerSeat; }
	
	public void setPrice(BigDecimal price) { this.pricePerSeat=price; }

	public List<Seat> getSeats() { return seats; }
	
	public void setSeats(List<Seat> seats) { this.seats = seats; }
	
/*	public int getAvailableSeatId() { return availableSeatId; }
	
	public void setAvailableSeatId(int availableSeatId) { this.availableSeatId=availableSeatId; }*/
}
