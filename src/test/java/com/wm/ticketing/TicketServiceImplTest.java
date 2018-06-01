package com.wm.ticketing;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	@Ignore
	public void getVenueTest()
	{		
		int avail=ticketService.numSeatsAvailable();		
		assertEquals(12,avail);
	}
	
	@Test
	public void dummyTest()
	{
		int a=10;
		assertEquals(10, a);
	}
	
}
