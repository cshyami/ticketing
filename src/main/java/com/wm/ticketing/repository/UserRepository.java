package com.wm.ticketing.repository;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.wm.ticketing.entities.*;

@Repository
public class UserRepository {

	List<User> userList;
	
	@PostConstruct
	private void setupData() {
		User user1=new User(1, "user1@email.com", "UserA");
		User user2=new User(2, "user2@email.com", "UserB");
		User user3=new User(3, "user3@email.com", "UserC");
		User user4=new User(4, "user4@email.com", "UserD");
		User user5=new User(5, "user5@email.com", "UserE");
		
		userList=Arrays.asList(user1, user2, user3, user4, user5);
	}
	
	public User getUserById(int id) {
		return userList.stream().filter(x -> x.getId()==id).findFirst().get() ; 
	}
	
	public User getUserByEmail(String email) {
				return userList.stream().filter(x -> x.getEmail().equals(email)).findFirst().get();
	}
}
