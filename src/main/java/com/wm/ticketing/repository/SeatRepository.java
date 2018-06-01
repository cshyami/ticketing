package com.wm.ticketing.repository;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wm.ticketing.entities.Seat;
import com.wm.ticketing.entities.Status;

@Repository
public class SeatRepository {
	List<Seat> seatList;
	
/*	@Autowired
	private ZoneRepository zoneRepository;*/
	
	@PostConstruct
	private void setupData() {
		
		Seat seat1=new Seat(1, 1,Status.AVAILABLE );
		Seat seat2=new Seat(2, 1,Status.AVAILABLE );
		Seat seat3=new Seat(3, 1,Status.AVAILABLE );
		Seat seat4=new Seat(4, 1,Status.AVAILABLE );
		
		Seat seat5=new Seat(5, 2,Status.AVAILABLE );
		Seat seat6=new Seat(6, 2,Status.AVAILABLE );
		Seat seat7=new Seat(7, 2,Status.AVAILABLE );
		Seat seat8=new Seat(8, 2,Status.AVAILABLE );
		
		Seat seat9=new Seat(9, 3,Status.AVAILABLE );
		Seat seat10=new Seat(10, 3,Status.AVAILABLE );
		Seat seat11=new Seat(11, 3,Status.AVAILABLE );
		Seat seat12=new Seat(12, 3,Status.AVAILABLE );
		
		
		seatList=Arrays.asList(seat1, seat2, seat3, seat4, seat5, seat6, seat7, seat8
				,seat9, seat10, seat11, seat12);
	}
	
	public int getNoOfAvailableSeats() { 
		System.out.println(seatList.size());
		return (int) seatList.stream().filter(y -> y.getStatus()==Status.AVAILABLE).count();}
	
	public int getNoOfAvailableSeatsByZone(int zoneId) { 
//		System.out.println(seatList.size());
		return (int) seatList.stream().filter(y -> y.getStatus()==Status.AVAILABLE
				&& y.getZoneId()==zoneId).count();}
}
