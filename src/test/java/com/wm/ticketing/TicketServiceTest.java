package com.wm.ticketing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.junit4.SpringRunner;

import com.wm.ticketing.service.ServiceTestConfig;
import com.wm.ticketing.service.TicketServiceImpl;

import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =  {ServiceTestConfig.class} )
@EnableConfigurationProperties
class TicketServiceTest {

	//@Autowired
	private TicketServiceImpl ticketService=new TicketServiceImpl();
	
	@Test
	void testNumSeatsAvailable() {
		assertEquals(12, ticketService.numSeatsAvailable());
	}


}
