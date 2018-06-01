package com.wm.ticketing.entities;

public class Seat {

	private int zoneId;
	private Status seatStatus;
	
	public Seat(int id, int zoneId, Status seatStatus) {
		this.zoneId=zoneId;
		this.seatStatus=seatStatus;
	}
	public int getZoneId() {
		return zoneId;
	}

	public void setZone(int zoneId) {
		this.zoneId = zoneId;
	}
	
	public Status getStatus() { return seatStatus;}
	
	public void setStatus(Status status) {
		this.seatStatus=status;
	}

}
