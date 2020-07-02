package com.example.demo;

import com.example.demo.Service.UserService;
import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.dao.UserRoleRepository;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	private String driver = "org.h2.Driver";

	private String url = "jdbc:h2:file:./src/main/resources/db/IdConfigDB?useSSL=false";

	private String userName = "sa";

	private String password = "";


	@Test
	public void contextLoads() {
	}


	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Test
	public void initData() {
		List<User> userList = new ArrayList<>();
		userList.add(new User(1L, "admin", new BCryptPasswordEncoder().encode("admin"), null));
		userList.add(new User(2L, "user", new BCryptPasswordEncoder().encode("111111"), null));
		userList.add(new User(2L, "student", new BCryptPasswordEncoder().encode("111111"), null));

		List<Role> roleList = new ArrayList<>();
		roleList.add(new Role(1L, "admin"));
		roleList.add(new Role(2L, "teacher"));
		roleList.add(new Role(3L, "student"));

		List<UserRole> urList = new ArrayList<>();
		urList.add(new UserRole(1L, 1L, 1L));
		urList.add(new UserRole(2L, 2L, 2L));
		urList.add(new UserRole(3L, 3L, 3L));

		userRepository.saveAll(userList);
		roleRepository.saveAll(roleList);
		userRoleRepository.saveAll(urList);
	}
	//数据库find
	@Test
	public void findAll(){
		/*List<User> all = userRepository.findAll();
		System.out.println("有多少用户"+all.size());
		for (User user : all) {
			System.out.println("用户名,,,,,,,"+user.getUsername());
		}*/
	}
}
