package com.rks.project.pointofsales;

import com.rks.project.pointofsales.Category.Category;
import com.rks.project.pointofsales.Category.CategoryRepository;
import com.rks.project.pointofsales.Item.Item;
import com.rks.project.pointofsales.Item.ItemRepository;
import com.rks.project.pointofsales.Users.Users;
import com.rks.project.pointofsales.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * Created by ASUS on 26/04/2018.
 */
@Controller
public class WebController {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ItemRepository itemRepository;

    @RequestMapping(path = "/")
    public String home() {
        return "login";
    }

    @RequestMapping(path = "/item")
    public String item() {
        return "create";
    }

    @RequestMapping(path = "/search")
    public String search() { return "search";}

    @RequestMapping(path = "/manage")
    public String manage() { return "manage";}

    @RequestMapping(path = "/logout")
    public String logout() { return "login";}

    @RequestMapping(path = "/category")
    public String category() { return "create_category";}

    @PostMapping(path = "/login")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password, Model model) {
        Optional<Users> users = usersRepository.findByUsernameAndPassword(username, password);
        if (users.isPresent()){
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            if (users.get().getRole().equalsIgnoreCase("Admin")){
                return "create";
            } else {
                model.addAttribute("role", users.get().getRole());
                return "user";
            }
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "login";
        }
    }

    @PostMapping(path = "/item/create")
    public String createItem(@RequestParam(value = "barcode") int barcode,
                             @RequestParam(value = "item_name") String name,
                             @RequestParam(value = "price") long price,
                             @RequestParam(value = "category") String category,
                             @RequestParam(value = "desc") String description, Model model){
        int category_id = categoryRepository.findByNama(category).get().getId();
        itemRepository.save(new Item(barcode, name, category_id, price, description));
        model.addAttribute("message", "Add new item successful");
        return "create";
    }

    @PostMapping(path = "/category/create")
    public String createCategory(@RequestParam(value = "new_category") String newCategory, Model model){
        Optional<Category> category = categoryRepository.findByNama(newCategory);
        if (!(category.isPresent())){
            categoryRepository.save(new Category(83910, newCategory));
            model.addAttribute("message", "Succesfully add '" + newCategory + "' category");
            return "create";
        } else {
            model.addAttribute("message", "Category already exist");
            return  "create";
        }
    }

}
