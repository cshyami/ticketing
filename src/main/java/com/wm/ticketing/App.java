package com.wm.ticketing;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wm.ticketing.repository.UserRepository;
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

        System.out.println( "Hello World!" );
        
        //Check if DI works
        UserRepository userRep=ctx.getBean(UserRepository.class);
        System.out.println(userRep.getUserById(1).getName());
        
        //Get Seats available
        TicketServiceImpl ticket=ctx.getBean(TicketServiceImpl.class);
        System.out.println(ticket.numSeatsAvailable());
        
    }
}
