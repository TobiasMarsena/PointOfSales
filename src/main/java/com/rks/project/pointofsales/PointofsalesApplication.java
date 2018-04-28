package com.rks.project.pointofsales;

import com.rks.project.pointofsales.category.Category;
import com.rks.project.pointofsales.category.CategoryRepository;
import com.rks.project.pointofsales.item.Item;
import com.rks.project.pointofsales.item.ItemRepository;
import com.rks.project.pointofsales.users.Users;
import com.rks.project.pointofsales.users.UsersRepository;
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
	public CommandLineRunner demo(UsersRepository repository, CategoryRepository categoryRepository, ItemRepository itemRepository){
		return (args) -> {
//			repository.save(new Users("Rosa", "passme", "Admin", "rosauthe"));
//			repository.save(new Users("Tobias", "1234", "User", "FroZEn"));
//			repository.save(new Users("William", "4321", "User", "Wilse00"));

//			categoryRepository.save(new Category("Makanan Instan"));
//			categoryRepository.save(new Category("Makanan Ringan"));
//			categoryRepository.save(new Category("Makanan Anak"));
//			categoryRepository.save(new Category("Makanan Kaleng"));
//			categoryRepository.save(new Category("Minuman"));
//			categoryRepository.save(new Category("Susu"));
//			categoryRepository.save(new Category("Peralatan Mandi"));

//			itemRepository.save(new Item(10046,"Indomie",1,2500, ""));
//			itemRepository.save(new Item(20046,"Pop mie",1,4500, ""));
//			itemRepository.save(new Item(10045,"Aqua",5,3500, ""));
//			itemRepository.save(new Item(20045,"Frestea",5,4000, ""));
//			itemRepository.save(new Item(10246,"Lays",2,9500, ""));
//			itemRepository.save(new Item(20246,"Doritos",2,8800, ""));
//			itemRepository.save(new Item(10346,"Cerelac sereal",3,9300, ""));
//			itemRepository.save(new Item(20346,"Sun marie",3,9000, ""));
//			itemRepository.save(new Item(10446,"Pronas kornet",4,26500,""));
//			itemRepository.save(new Item(20446,"Vinisi tuna",4,10500,""));
//			itemRepository.save(new Item(10245,"Ultra milk",6,5000,""));
//			itemRepository.save(new Item(20245,"Bear brand",6,8300,""));
//			itemRepository.save(new Item(10044,"Biore body foam",7,9400,""));
//			itemRepository.save(new Item(20044,"Zinc shampoo",7,18600,""));

			for (Users users : repository.findAll()) {
				log.info(users.toString());
			}
		};
	}
}
