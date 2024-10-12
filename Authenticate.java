package com.digiAuth.authenticate;

import java.util.HashMap;

import com.digiAuth.user.User;

public class Authenticate {

	private HashMap<String, User> credentials = new HashMap<>();
	
	public boolean register(String username, String password) {
		
		if(credentials.containsKey(username)) {
			return false;
		}
		
		credentials.put(username,new User(username,password));
		return true;
	}
	
	
	public boolean login(String username, String password) {
		User user = credentials.get(username);
		return user != null && user.getPassword().equals(password);
	}
}
