package com.flight.booking.daos;

import java.util.List;

import com.flight.booking.entities.User;

public interface UserDao {
	
	int create(User user);
	
	
	List<User> findUsers();


}
