package se.pidev.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import se.pidev.entities.User;
import se.pidev.repositories.UserRepository;
import se.pidev.services.UserService;
import se.pidev.services.UserServiceImpl;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			L.info("user +++ : " + user);
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		System.out.println("User Added Successfully");
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(String id) {
		 userRepository.deleteById(Long.parseLong(id));
		System.out.println("User Deleted Successfully");
		
	}


	@Override
	public User retrieveUser(String id) {
		return userRepository.findById(Long.parseLong(id)).get();
	}

}
