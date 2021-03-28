package se.pidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import se.pidev.UserServiceImplTest;
import se.pidev.entities.User;
import se.pidev.repositories.UserRepository;
import se.pidev.services.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
private static final Logger l = LogManager.getLogger(UserServiceImplTest.class);
	
	@Autowired
	UserServiceImpl us;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void testretrieveAllUsers() {
		us.retrieveAllUsers();
	}
	
	
	@Test
	public void testAddUser() throws java.text.ParseException {
		User u = new User(Long.parseLong("1"),"test@test.com","12345678");
		us.addUser(u);
		
	}
	
	@Test
	public void testdeleteUser() {
		us.deleteUser("1");
	}
	
	@Test
	public void testupdateUser() {
		User u = userRepository.findById(Long.parseLong("1")).get();
		u.setUser_Password("87654321");
		us.addUser(u);
	}
	
	@Test
	public void testretrieveUser() {
		User u = userRepository.findById(Long.parseLong("1")).get();
		us.retrieveUser("1").getClass();
		System.out.println(u);
	}

}
