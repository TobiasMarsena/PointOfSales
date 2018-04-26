package com.rks.project.pointofsales;

import com.rks.project.pointofsales.Category.Category;
import com.rks.project.pointofsales.Category.CategoryRepository;
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
@RequestMapping
public class AdminController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping(path = "/create")
    public String createCategory(@RequestParam(value = "new_category") String newCategory, Model model){
        Optional<Category> category = categoryRepository.findByNama(newCategory);
        if (!(category.isPresent())){
            categoryRepository.save(new Category(12345, newCategory));
            model.addAttribute("message", "Succesfully add " + newCategory + " category");
            return "create";
        } else {
            model.addAttribute("message", "Category already exist");
            return  "create";
        }
    }

}
