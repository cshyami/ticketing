package com.wm.ticketing;

import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wm.ticketing.entities.SeatHold;
import com.wm.ticketing.entities.User;
import com.wm.ticketing.entities.Zone;
import com.wm.ticketing.repository.SeatHoldRepository;
import com.wm.ticketing.repository.UserRepository;
import com.wm.ticketing.repository.ZoneRepository;
import com.wm.ticketing.service.TicketServiceImpl;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
	public static void main( String[] args )
    {
    	ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

    	System.out.println("-------------------------------");
        System.out.println( "Starting Ticketing App" );
        
        //Check if DI works
        UserRepository userRep=ctx.getBean(UserRepository.class);
        ZoneRepository zoneRep = ctx.getBean(ZoneRepository.class);
        SeatHoldRepository seatRep = ctx.getBean(SeatHoldRepository.class);
        
        System.out.println("List of Zones:");
        List<Zone> zones=zoneRep.getAllZones();
        //zones.forEach(z -> System.out.println(z.getName() + " : Number of seats: " + z.getNoOfSeats()));
        
        System.out.println("SEAT CHART");
        for(Zone z: zones){
        	System.out.println(z.getName() + " : Number of seats: " + z.getNoOfSeats());
        	z.getSeats().forEach(s -> System.out.println("Seat Status: " + s.getStatus()));
        }
        
        System.out.println("-------------------------------");
        //Get Seats available
        TicketServiceImpl service=ctx.getBean(TicketServiceImpl.class);
        System.out.println("Number of seats available before holds:" + service.numSeatsAvailable());
        System.out.println("-------------------------------");
        
        System.out.println("Request 3 seats for UserC");
        int holdIdForReservation = 0;
        
	        try
	        {
	        SeatHold hold1=seatRep.holdSeats(3, userRep.getUserById(3).getEmail());
	        System.out.println("Hold Details: HoldId: " + hold1.getHoldId() + " for UserEmail: " + 
	        				hold1.getUser().getEmail() + " ; Number of seats: " + hold1.getNoOfSeats());
	        holdIdForReservation=hold1.getHoldId();
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Error during hold: " + e.getMessage());
	        }
	     
	        System.out.println("-------------------------------");
			System.out.println("Available Holds after processing request :" );
			seatRep.getAllHolds().forEach(h -> System.out.println("Id: " + h.getHoldId() + " User: " + h.getUser().getEmail() 
					+ " No of seats:" + h.getNoOfSeats() + " in zone " + h.getZone().getName()));
			
	        System.out.println("Total number of Available seats after hold: " + service.numSeatsAvailable());
	        
	        System.out.println("-------------------------------");
	        
	        System.out.println("Request 3 seats for User D");
	        try
	        {
	        SeatHold hold1=seatRep.holdSeats(3, userRep.getUserById(3).getEmail());
	        System.out.println("Hold Details: HoldId: " + hold1.getHoldId() + " for UserEmail: " + 
	        				hold1.getUser().getEmail() + " ; Number of seats: " + hold1.getNoOfSeats());
	        }
	        catch (Exception e)
	        {
	        	System.out.println("Error during hold: " + e.getMessage());
	        }
	        
	        System.out.println("-------------------------------");
	        
	        System.out.println("Confirm 3 seats for UserC using previous hold");

		        try
		        {
		        int confirmationId=seatRep.confirmHold(holdIdForReservation, userRep.getUserById(3).getEmail());
		        System.out.println("Confirmation Details: Id: " + confirmationId) ;
        	        
		        }
		        catch (Exception e)
		        {
		        	System.out.println("Error during reservation: " + e.getMessage());
		        }
		     
		        System.out.println("-------------------------------");
				System.out.println("Available Holds after processing confirmation :" );
				seatRep.getAllHolds().forEach(h -> System.out.println("Id: " + h.getHoldId() + " User: " + h.getUser().getEmail() 
						+ " No of seats:" + h.getNoOfSeats() + " in zone " + h.getZone().getName()));
				
		        System.out.println("Total number of Available seats after hold: " + service.numSeatsAvailable());
		        
		        System.out.println("-------------------------------");
		        
		        System.out.println("SEAT CHART");
		        for(Zone z: zones){
		        	System.out.println(z.getName() + " : Number of seats: " + z.getNoOfSeats());
		        	z.getSeats().forEach(s -> System.out.println("Seat Status: " + s.getStatus()));
		        }
        }
        
        
    
}
