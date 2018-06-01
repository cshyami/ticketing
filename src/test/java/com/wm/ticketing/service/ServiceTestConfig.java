package com.wm.ticketing.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.wm.ticketing.service.TicketService;
import com.wm.ticketing.service.TicketServiceImpl;

@Configuration
@ComponentScan(basePackages = {"com.wm.ticketing.service"})
public class ServiceTestConfig {
	
	@Bean
	public TicketService ticketService() {
		return new TicketServiceImpl();
	}
}
