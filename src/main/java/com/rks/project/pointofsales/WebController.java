package com.rks.project.pointofsales;

import com.rks.project.pointofsales.category.Category;
import com.rks.project.pointofsales.category.CategoryRepository;
import com.rks.project.pointofsales.item.Item;
import com.rks.project.pointofsales.item.ItemRepository;
import com.rks.project.pointofsales.users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(PointofsalesApplication.class);

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

    @GetMapping(path = "/admin/search")
    public String searchResult(@RequestParam(value = "search", required = false) String search,
                               Model model) {
        if (search != null) {
            Optional<Item> items = itemRepository.findByName(search);
            if (items.isPresent()) {
                model.addAttribute("items", items.get());
            }
        } else {
            List<Item> items = itemRepository.findAll();
            model.addAttribute("items", items);
        }
        return "search";
    }

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
        itemRepository.save(new Item(barcode, name, categoryRepository.findById(category).get(), price, description));
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
