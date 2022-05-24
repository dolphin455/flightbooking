package com.flight.booking.user.dao;

import java.util.List;

import com.flight.booking.user.entity.User;

public interface UserDao {
	
	int create(User user);
	
	
	List<User> findUsers();


}
