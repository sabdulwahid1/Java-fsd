package com.example.Authentication;

import com.example.Authentication.entities.User;
import com.example.Authentication.repositories.UserRepository; import com.example.Authentication.services.UserService; import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager; import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;



@DataJpaTest

public class UserRepoTests {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Test
	public void whenFindByName_thenReturnUser() {
	
	
	User dummyUser = new User(); dummyUser.setName("Dummy"); dummyUser.setEmail("test@test.com");
	dummyUser.setPassword("password"); entityManager.persist(dummyUser); entityManager.flush();
	
	
	Optional<User> found = userRepository.findByName(dummyUser.getName()); User founded = found.get();
	assertEquals(founded.getName(), dummyUser.getName());
	}
	


}
