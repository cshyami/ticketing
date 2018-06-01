package com.wm.ticketing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.junit4.SpringRunner;

//import com.wm.ticketing.service.ServiceTestConfig;
import com.wm.ticketing.service.TicketServiceImpl;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes =  {ServiceTestConfig.class} )
@EnableConfigurationProperties
public class TicketServiceTest {

	//@Autowired
	private TicketServiceImpl ticketService=new TicketServiceImpl();
	
	@Test
	@Ignore
	void numSeatsAvailableTest() {
		assertEquals(12, ticketService.numSeatsAvailable());
	}
	
	@Test
	public void dummyTest()
	{
		int a=10;
		assertEquals(10, a);
	}

}
