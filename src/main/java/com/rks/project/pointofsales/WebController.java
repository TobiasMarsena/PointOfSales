package com.rks.project.pointofsales;

import com.rks.project.pointofsales.category.Category;
import com.rks.project.pointofsales.category.CategoryRepository;
import com.rks.project.pointofsales.item.Item;
import com.rks.project.pointofsales.item.ItemRepository;
import com.rks.project.pointofsales.users.Users;
import com.rks.project.pointofsales.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
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
        return "user";
    }

    @RequestMapping(path = "/user")
    public String user() {
        return "user";
    }

    @RequestMapping(path = "/admin")
    public String admin(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }

    @RequestMapping(path = "/admin/item")
    public String item(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "create";
    }

    @RequestMapping(path = "/admin/category")
    public String category() { return "create_category";}

    @RequestMapping(path = "/admin/search")
    public String search() { return "search";}

    @RequestMapping(path = "/admin/manage")
    public String manage() { return "manage";}

    @RequestMapping(path = "/logout")
    public String logout() { return "login";}

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(path = "/admin/item/create")
    public ModelAndView createItem(@RequestParam(value = "barcode") int barcode,
                             @RequestParam(value = "item_name") String name,
                             @RequestParam(value = "price") long price,
                             @RequestParam(value = "category") long category,
                             @RequestParam(value = "desc") String description, Model model){
        long category_id = categoryRepository.findById(category).get().getId();
        itemRepository.save(new Item(barcode, name, category_id, price, description));
        model.addAttribute("message", "Add new item successful");
        return new ModelAndView("redirect:/admin");
    }

    @PostMapping(path = "/admin/category/create")
    public ModelAndView createCategory(@RequestParam(value = "new_category") String newCategory, Model model){
        Optional<Category> category = categoryRepository.findByName(newCategory);
        if (!(category.isPresent())){
            categoryRepository.save(new Category(newCategory));
            model.addAttribute("message", "Succesfully add '" + newCategory + "' category");
            return new ModelAndView("redirect:/admin");
        } else {
            model.addAttribute("message", "category already exist");
            return  new ModelAndView("redirect:/admin");
        }
    }

}
