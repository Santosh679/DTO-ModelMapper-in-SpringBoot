package com.dtotaskwithspringboot.dtoproject;

import com.dtotaskwithspringboot.dtoproject.model.Location;
import com.dtotaskwithspringboot.dtoproject.model.User;
import com.dtotaskwithspringboot.dtoproject.repository.LocationRepository;
import com.dtotaskwithspringboot.dtoproject.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoProjectApplication implements CommandLineRunner {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(DtoProjectApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public void run(String... args) throws Exception {
		Location location = new Location();
		location.setPlace("Kathmandu");
		location.setDescription("Kathmandu is a great place to live");
		location.setLongitude(40.5);
		location.setLatitude(30.6);
		locationRepository.save(location);

		User user1 = new User();
		user1.setFirstName("Laxman");
		user1.setLastName("Mandal");
		user1.setEmail("mandal@gmail.com");
		user1.setPassword("password");
		user1.setLocation(location);
		userRepository.save(user1);

		User user2 = new User();
		user2.setFirstName("Aaditya");
		user2.setLastName("Kumar Shah");
		user2.setEmail("aaditya@gmail.com");
		user2.setPassword("password");
		user2.setLocation(location);
		userRepository.save(user2);
	}
}
