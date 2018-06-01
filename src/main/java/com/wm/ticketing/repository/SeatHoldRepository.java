package com.wm.ticketing.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wm.ticketing.entities.Seat;
import  com.wm.ticketing.entities.SeatHold;
import com.wm.ticketing.entities.Status;
import com.wm.ticketing.entities.User;
import com.wm.ticketing.entities.Zone;

@Repository
public class SeatHoldRepository {
	
	@Autowired 
	private ZoneRepository zoneRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	List<SeatHold> listSeatHolds;
	final Long seatHoldExpireTime=60L;	// default
	int holdId=4;
	int confirmationId=1;
	
	@PostConstruct
	private void setupData() {
		//Setup mock SeatHold records. Records will be retrieved from db in real world scenario

		SeatHold hold1=new SeatHold(1, 1, Instant.now());
		hold1.setUser(userRepository.getUserById(1));
		hold1.setZone(zoneRepository.getZoneById(1));
		//zoneRepository.getZoneById(1).setAvailableSeatId(2);

		SeatHold hold2=new SeatHold(2, 2,Instant.now().plusSeconds(60));
		hold2.setUser(userRepository.getUserById(2));
		hold2.setZone(zoneRepository.getZoneById(2));
		//zoneRepository.getZoneById(2).setAvailableSeatId(3);
		
		SeatHold hold3=new SeatHold(3, 3, Instant.now().minusSeconds(60));
		hold3.setUser(userRepository.getUserById(3));
		hold3.setZone(zoneRepository.getZoneById(3));
		//zoneRepository.getZoneById(3).setAvailableSeatId(4);
		
		listSeatHolds=Arrays.asList(hold1, hold2, hold3);
	}
	
	
	public List<SeatHold> getAllHolds(){
		return listSeatHolds;
	}
	
	public void clearExpiredHolds(){
		//Check if the hold has expired
		long now = Instant.now().getEpochSecond();
		
		listSeatHolds.removeIf(x -> now-x.getHoldTime().getEpochSecond() >  seatHoldExpireTime);
	}
	
	public SeatHold holdSeats(int noOfSeats, String email) throws Exception {
		clearExpiredHolds();
		
		//If no zone is provided, get the seats from best zone available.
		List<Zone> zones=zoneRepository.getAllZones();
	    Collections.sort(zones, new Comparator<Zone>() {
	        public int compare(Zone z1, Zone z2) {
	            return Integer.compare( z2.getId(),z1.getId());
	        }
	    });
	    
	    for(Zone z: zones) {
	    	int availableSeats=zoneRepository.getAvailableSeatCount(z.getId());
	    	
	    	//Hold seats if available
	    	if (availableSeats>noOfSeats)
	    	{
	    		return processHold(noOfSeats, email, z.getId());
	    	}
	    }
	    throw new Exception("Number of consecutive seats not available in any zone. Try booking lesser number of seats");
	}
	
	private SeatHold processHold(int noOfSeats, String email, int zoneId ) throws Exception {
	
		holdId++;
		SeatHold hold=new SeatHold(holdId, noOfSeats, Instant.now());
		hold.setUser(userRepository.getUserByEmail(email));
		hold.setZone(zoneRepository.getZoneById(zoneId));
		
		//update the seatStatus of the seats put on hold
		List<Seat> seatsHeld=zoneRepository.getAvailableSeats(zoneId).stream().limit(noOfSeats).collect(Collectors.toList());
		seatsHeld.forEach(x -> x.setStatus(Status.HOLD));
		
		hold.setSeats(seatsHeld);
		
		listSeatHolds.add(hold);
		return hold;
	}
	
	public int confirmHold(int holdId, String email) throws Exception {
		clearExpiredHolds();
		
		//check if the hold is still available
		SeatHold hold=listSeatHolds.stream().filter(x -> x.getHoldId()==holdId && x.getUser().getEmail().equals(email)).findFirst().get();
		
		if (hold==null)
			throw new Exception("The hold has expired. Please proceed to make a new reservation.");
		
		//Proceed to update the seats as Reserved after processing payment
		//Delete the current hold
		confirmationId++;
		List<Seat> seatsHeld=hold.getSeats();
		seatsHeld.forEach(x -> x.setStatus(Status.RESERVED));
		
		listSeatHolds.remove(hold);
		return confirmationId;
	}
	
}
