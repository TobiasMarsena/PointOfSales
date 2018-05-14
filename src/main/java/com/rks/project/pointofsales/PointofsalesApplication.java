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
//
//			categoryRepository.deleteAll();
//			categoryRepository.save(new Category("Makanan Instan"));
//			categoryRepository.save(new Category("Makanan Ringan"));
//			categoryRepository.save(new Category("Makanan Anak"));
//			categoryRepository.save(new Category("Makanan Kaleng"));
//			categoryRepository.save(new Category("Minuman"));
//			categoryRepository.save(new Category("Susu"));
//			categoryRepository.save(new Category("Peralatan Mandi"));
//
//			itemRepository.deleteAll();
//			itemRepository.save(new Item(10046,"Indomie",categoryRepository.findById(Long.valueOf(1)).get(),2500, ""));
//			itemRepository.save(new Item(20046,"Pop mie",categoryRepository.findById(Long.valueOf(1)).get(),4500, ""));
//			itemRepository.save(new Item(10045,"Aqua",categoryRepository.findById(Long.valueOf(5)).get(),3500, ""));
//			itemRepository.save(new Item(20045,"Frestea",categoryRepository.findById(Long.valueOf(5)).get(),4000, ""));
//			itemRepository.save(new Item(10246,"Lays",categoryRepository.findById(Long.valueOf(2)).get(),9500, ""));
//			itemRepository.save(new Item(20246,"Doritos",categoryRepository.findById(Long.valueOf(2)).get(),8800, ""));
//			itemRepository.save(new Item(10346,"Cerelac sereal",categoryRepository.findById(Long.valueOf(3)).get(),9300, ""));
//			itemRepository.save(new Item(20346,"Sun marie",categoryRepository.findById(Long.valueOf(3)).get(),9000, ""));
//			itemRepository.save(new Item(10446,"Pronas kornet",categoryRepository.findById(Long.valueOf(4)).get(),26500,""));
//			itemRepository.save(new Item(20446,"Vinisi tuna",categoryRepository.findById(Long.valueOf(4)).get(),10500,""));
//			itemRepository.save(new Item(10245,"Ultra milk",categoryRepository.findById(Long.valueOf(6)).get(),5000,""));
//			itemRepository.save(new Item(20245,"Bear brand",categoryRepository.findById(Long.valueOf(6)).get(),8300,""));
//			itemRepository.save(new Item(10044,"Biore body foam",categoryRepository.findById(Long.valueOf(7)).get(),9400,""));
//			itemRepository.save(new Item(20044,"Zinc shampoo",categoryRepository.findById(Long.valueOf(7)).get(),18600,""));

			for (Users users : repository.findAll()) {
				log.info(users.toString());
			}
		};
	}
}
