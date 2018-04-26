package com.rks.project.pointofsales;

import com.rks.project.pointofsales.Users.Users;
import com.rks.project.pointofsales.Users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PointofsalesApplication {

	private static final Logger log = LoggerFactory.getLogger(PointofsalesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PointofsalesApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UsersRepository repository){
		return (args) -> {
//			repository.save(new Users("Tobias", "1234", "User", "FroZEn"));
//			repository.save(new Users("William", "4321", "User", "W.S."));
//			repository.save(new Users("Rosa", "passme", "Admin", "R.G."));
			for (Users users : repository.findAll()) {
				log.info(users.toString());
			}
			String username = "Tobias";
			String password = "1234";
			repository.findByUsernameAndPassword(username, password).
					ifPresent(users -> {
						log.info("Login as " + users.getRole());
						log.info("Welcome, " + users.getUsername() + '(' + users.getNama_user() + ')');
					});
		};
	}
}
