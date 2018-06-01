package com.wm.ticketing.entities;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class SeatHold {
	private int holdId;
	private int reservationId;
	private Zone zone;
	private int numberOfSeats;
	private User user;
	private Instant holdTime=null;
	private Instant reservedTime=null;
	private List<Seat> seats;
	
	public SeatHold(int holdId, int numberOfSeats, Instant holdTime) {
		this.holdId=holdId;
		this.numberOfSeats=numberOfSeats;
		this.holdTime=holdTime;
	}
	public int getHoldId() { return holdId; }
	public void setHoldId(int holdId) { this.holdId=holdId;}
	
	public int getReservationId() { return reservationId; }
	public void setReservationId(int reservationId) { this.reservationId=reservationId; }
	
	public Zone getZone() { return zone;}
	public void setZone(Zone zone) { this.zone=zone; }
	
	public int getNoOfSeats() { return this.numberOfSeats;}
	public void setNoOfSeats(int numberOfSeats) { this.numberOfSeats=numberOfSeats;}
	
	public User getUser() {return user;}
	public void setUser(User user) { this.user=user;}
	
	public Instant getHoldTime() { return holdTime;}
	public void setHoldTime(Instant holdTime) { this.holdTime=holdTime; }
	
	public Instant getReservedTime() { return reservedTime;}
	public void setReservedTime(Instant reservedTime) { this.reservedTime=reservedTime; }
	
	public List<Seat> getSeats() { return seats;}
	public void setSeats(List<Seat> seats) { this.seats=seats;}
}
