package com.g8Dic5.demo;

import com.g8Dic5.demo.repositories.CRUD.IClotheCrudRepository;
import com.g8Dic5.demo.repositories.CRUD.IOrderCrudRepository;
import com.g8Dic5.demo.repositories.CRUD.IUserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class G8Dic5Application implements CommandLineRunner {

	@Autowired
	private IClotheCrudRepository clotheCrudRepository;
	@Autowired
	private IUserCrudRepository userCrudRepository;
	@Autowired
	private IOrderCrudRepository orderCrudRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(G8Dic5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//IClotheCrudRepository.deleteAll();
		//IUserCrudRepository.deleteAll();
		//IOrderCrudRepository.deleteAll();

	}
}
