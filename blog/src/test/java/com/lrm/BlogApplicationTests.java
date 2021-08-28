package com.lrm;

import com.lrm.dao.UserRepository;
import com.lrm.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		String username = "aaa";
		String password = "aaa";
		User user = userRepository.findByUsernameAndPassword(username, password);
		System.out.println(user);
	}

}
