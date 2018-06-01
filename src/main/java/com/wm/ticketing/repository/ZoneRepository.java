package com.wm.ticketing.repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wm.ticketing.entities.Seat;
import com.wm.ticketing.entities.Status;
import com.wm.ticketing.entities.Venue;
import com.wm.ticketing.entities.Zone;

@Repository
public class ZoneRepository {
	
	@Autowired
	SeatRepository seatRepository;
	
	List<Zone> zones;
	
	@PostConstruct
	private void setupData() {
		Venue theater=new Venue();
		theater.setVenueName("Theater1");
		theater.setVenueId(1);
		theater.setCapacity(600);
		
		Zone zone1=new Zone(1, "Orchestra", 4, new BigDecimal(200));
		zone1.setSeats(seatRepository.seatList.stream().filter(x -> x.getZoneId()==1).collect(Collectors.toList()));
		zone1.setVenue(theater);
		Zone zone2= new Zone(2, "Mezzanine", 4, new BigDecimal(150));
		zone2.setSeats(seatRepository.seatList.stream().filter(x -> x.getZoneId()==2).collect(Collectors.toList()));
		zone2.setVenue(theater);
		Zone zone3=new Zone(3, "Balcony", 4, new BigDecimal(100));
		zone3.setSeats(seatRepository.seatList.stream().filter(x -> x.getZoneId()==3).collect(Collectors.toList()));
		zone3.setVenue(theater);
	
		zones=Arrays.asList(zone1, zone2, zone3);
	}
		
	
	public List<Zone> getAllZones(){
		return zones;
	}
	
	public Zone getZoneById(int zoneId) {
		return zones.stream().filter(x -> x.getId()==zoneId).findFirst().get() ; 
	}
	
	public BigDecimal getTicketPrice(int zoneId) {
		return getZoneById(zoneId).getPrice();
	}
	
	public int getTotalSeats(int zoneId) {
		return getZoneById(zoneId).getNoOfSeats();
	}
	
	public int getAvailableSeatCount(int zoneId) {
		int availableSeatsCount=0;
		
		if (zoneId==0) //get all available seats in all zones
					availableSeatsCount+= seatRepository.getNoOfAvailableSeats();
		else
			availableSeatsCount= seatRepository.getNoOfAvailableSeatsByZone(zoneId);
		
		return availableSeatsCount;
	}
	
	public List<Seat> getAvailableSeats(int zoneId){
		return getZoneById(zoneId).getSeats().stream()
				.filter(x -> x.getStatus()==Status.AVAILABLE).collect(Collectors.toList());
	}
}
