package com.ituwei.springbootJwt;

import com.ituwei.springbootJwt.dao.UserRepo;
import com.ituwei.springbootJwt.model.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootJwtApplication {

	@Autowired
	private UserRepo userRepo;

	@PostConstruct
	public void initUsers(){
		List<UserDetail> userDetails = Stream.of(
				new UserDetail(1,"ituwei","ituwei321","ituwei21@gmail.com"),
				new UserDetail(2,"naomi","ituwei","naomi@gmail.com"),
				new UserDetail(3,"mau","itu321","mau@gmail.com")
		).collect(Collectors.toList());
		userRepo.saveAll(userDetails);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJwtApplication.class, args);
	}

}
