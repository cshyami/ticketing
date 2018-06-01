package com.wm.ticketing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wm.ticketing.entities.SeatHold;
import com.wm.ticketing.entities.Status;
import com.wm.ticketing.entities.Zone;
import com.wm.ticketing.repository.SeatHoldRepository;
import com.wm.ticketing.repository.ZoneRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private SeatHoldRepository seatHoldRepository;
	@Autowired
	private ZoneRepository zoneRepository;
	
/*	@Autowired
	public TicketServiceImpl(SeatHoldRepository seatHoldRepository, ZoneRepository zoneRepository) {
		this.seatHoldRepository=seatHoldRepository;
		this.zoneRepository=zoneRepository;
	}*/
	
	public int numSeatsAvailable() {
		// The number of seats in the venue that are neither held nor reserved
		return zoneRepository.getAvailableSeatCount(0);
	}

	public int numSeatsAvailableByZone(int zoneId) {
		return zoneRepository.getAvailableSeatCount(zoneId);
	}
	
	@Override
	public SeatHold findAndHoldSeats(int numSeats, String customerEmail) throws Exception {
		return seatHoldRepository.holdSeats(numSeats, customerEmail);
	}
	

	public String reserveSeats(int seatHoldId, String customerEmail) {
		try {
			return "Tickets have been confirmed. Confirmation Id:" + Integer.toString(seatHoldRepository.confirmHold(seatHoldId, customerEmail));
		} 
		catch (Exception e) {
			return "Error during reservation. " + e.getMessage();
		}
	}



}
