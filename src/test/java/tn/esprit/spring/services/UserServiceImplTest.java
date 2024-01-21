package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {

    @Autowired
    IUserService us;

	@Test
	@Order(1)
	public void testRetrieveAllUsers()  {
		List<User> listUsers= us.retrieveAllUsers();
		Assertions.assertEquals(0, listUsers.size());
	}

	@InjectMocks
	private UserServiceImpl userService;

	@Mock
	private UserRepository userRepository;

	@Test
	public void testRetrieveUser() {
		// Create a User object for testing
		User user = new User("f1", "l1", new Date(), Role.ADMINISTRATEUR);

		// Mock behavior for UserRepository
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

		// Test the UserService
		User user1 = userService.retrieveUser("2");
		Assertions.assertNotNull(user1);
	}

	@Test
	public void testRetrieveUserM() {
		// Create a User object for testing
		User user = new User("f1", "l1", new Date(), Role.ADMINISTRATEUR);

		// Mock behavior for UserRepository
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(user));

		// Test the UserService
		User user1 = userService.retrieveUser("2");
		Assertions.assertNotNull(user1);
	}
}