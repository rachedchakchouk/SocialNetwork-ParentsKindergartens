package se.pidev.controls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import se.pidev.entities.User;
import se.pidev.services.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	// http://localhost:8083/SpringMVC/servlet/retrieve-all-users
	@GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers() {
	List<User> list = userService.retrieveAllUsers();
	return list;
	}
	
	// http://localhost:8083/SpringMVC/servlet/retrieve-user/{user-id}
	@GetMapping("/retrieve-user/{user-id}")
	@ResponseBody
	public User retrieveUser(@PathVariable("user-id") String userId) {
	return userService.retrieveUser(userId);
	}

	// http://localhost:8083/SpringMVC/servlet/add-user
	@PostMapping("/add-user")
	@ResponseBody
	public User addUser(@RequestBody User u) {
	User user = userService.addUser(u);
	return user;
	}
	
	// http://localhost:8083/SpringMVC/servlet/remove-user/{user-id}
	@DeleteMapping("/remove-user/{user-id}")
	@ResponseBody
	public void removeUser(@PathVariable("user-id") String userId) {
	userService.deleteUser(userId);
	}
	
	// http://localhost:8083/SpringMVC/servlet/remove-all-users
	/*@DeleteMapping("/remove-all-users")
	@ResponseBody
	public void removeAllUsers() {
	userService.deleteAllUsers();
	}*/
	// http://localhost:8083/SpringMVC/servlet/modify-user
	@PutMapping("/modify-user")
	@ResponseBody
	public User modifyUser(@RequestBody User user) {
	return userService.addUser(user);
	}

}
