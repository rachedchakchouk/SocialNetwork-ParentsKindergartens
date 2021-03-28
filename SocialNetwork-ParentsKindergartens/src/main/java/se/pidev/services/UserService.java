package se.pidev.services;

import java.util.List;

import se.pidev.entities.User;

public interface UserService {
	
	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(String id);
	User retrieveUser(String id);

}
