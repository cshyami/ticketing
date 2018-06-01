package com.wm.ticketing;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wm.ticketing.entities.SeatHold;
import com.wm.ticketing.repository.SeatHoldRepository;
import com.wm.ticketing.service.ServiceTestConfig;
import com.wm.ticketing.service.TicketService;
import com.wm.ticketing.service.TicketServiceImpl;

import junit.framework.TestCase;

//@ContextConfiguration(classes = {ServiceTestConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketServiceImplTest  extends TestCase {

	 @TestConfiguration
	    static class TicketServiceImplTestContextConfiguration {
	  
	        @Bean
	        public TicketService ticketService() {
	            return new TicketServiceImpl();
	        }
	    }
	 
	@Autowired
	private TicketServiceImpl ticketService;
	
	@Test
	public void getVenueTest()
	{		
		int avail=ticketService.numSeatsAvailable();		
		assertEquals(12,avail);
	}
	
}
