package com.video.domain;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
	protected List<User> users = new ArrayList<User>();
	
	public UserRepository() {
		
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public List<User> getUsers() {
		return users;
	}
}
