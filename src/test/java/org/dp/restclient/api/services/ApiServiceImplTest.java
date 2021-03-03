package org.dp.restclient.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.dp.restclient.api.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiServiceImplTest {
	@Autowired
	ApiService apiService;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void getUsersTest() {

		List<User> users = apiService.getUsers(3);
		assertEquals(3, users.size());

	}

}
