package com.rks.project.pointofsales;

import com.rks.project.pointofsales.category.Category;
import com.rks.project.pointofsales.category.CategoryRepository;
import com.rks.project.pointofsales.item.Item;
import com.rks.project.pointofsales.item.ItemRepository;
import com.rks.project.pointofsales.users.Cart;
import com.rks.project.pointofsales.users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Collection;
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
    ArrayList<Cart> carts = new ArrayList<>();
    int total;


    @RequestMapping(path = "/")
    public ModelAndView main(){
        return new ModelAndView("redirect:/home");
    }
    @RequestMapping(path = "/home")
    public ModelAndView home(Authentication authentication, Model model) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String url = "";
        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_Admin")){
                url = "admin";
                break;
            } else if (authority.getAuthority().equals("ROLE_User")){
                url = "user";
                carts = new ArrayList<>();
                break;
            }
        }
        return new ModelAndView("redirect:/" + url);
    }

    //    User Controller
    @GetMapping(path = "/user")
    public String user(@PathVariable(value = "search",required = false) Long searchCode, Model model) {
        if (searchCode != null){
            Optional<Item> item = itemRepository.findById(searchCode);
            if (item.isPresent()){
                for (Cart cart: carts) {
                    if (cart.getItem().getCode().equals(item.get().getCode())){
                        model.addAttribute("message", "Item already in cart");
                        model.addAttribute("items", carts);
                        total = 0;
                        for (Cart cart1 : carts) {
                            total += cart1.getAmount();
                        }
                        model.addAttribute("total", total);
                        model.addAttribute("cash", 0);
                        return "payment";
                    }
                }
                carts.add(new Cart(item.get()));
                model.addAttribute("items", carts);
                total = 0;
                for (Cart cart : carts) {
                    total += cart.getAmount();
                }
                model.addAttribute("total", total);
                model.addAttribute("cash", 0);
            } else {
                model.addAttribute("message", "Item not found");
            }
        }
        return "payment";
    }
    @PostMapping(path = "/user/purchase")
    public String purchase(@RequestParam(value = "paymentMethod") String paymentMethod,
                           @RequestParam(value = "totalCash", required = false) long cash,
                           @RequestParam(value = "totalCD", required = false) long credit,
                           @RequestParam(value = "referenceNumber", required = false) long card,
                           Model model) {
        if (paymentMethod.equals("Cash")){
            if (cash >= total) {
                long change = total - cash;
                model.addAttribute("message", "Cash Payment succesful with change: " + change + ".\nThank you");
                carts = new ArrayList<>();
                total = 0;
            } else {
                model.addAttribute("items", carts);
                total = 0;
                for (Cart cart : carts) {
                    total += cart.getAmount();
                }
                model.addAttribute("total", total);
                model.addAttribute("cash", cash);
            }
        } else if (paymentMethod.equals("Credit") || paymentMethod.equals("Debit")) {
            if (credit >= total) {
                model.addAttribute("message", "Payment succesful. Thank you");
                carts = new ArrayList<>();
                total = 0;
            } else {
                model.addAttribute("items", carts);
                total = 0;
                for (Cart cart : carts) {
                    total += cart.getAmount();
                }
                model.addAttribute("total", total);
                model.addAttribute("cash", cash);
            }
        } else {
            model.addAttribute("items", carts);
            total = 0;
            for (Cart cart : carts) {
                total += cart.getAmount();
            }
            model.addAttribute("total", total);
            model.addAttribute("message", "Select a payment method");
        }
        return "payment";
    }
    @GetMapping(path = "/user/add/{id}")
    public String add(@PathVariable("id") Long id, Model model){
        for (Cart cart : carts) {
            if (cart.getItem().getCode().equals(id)){
                cart.incrementQuantity();
                break;
            }
        }
        model.addAttribute("items", carts);
        total = 0;
        for (Cart cart : carts) {
            total += cart.getAmount();
        }
        model.addAttribute("total", total);
        model.addAttribute("cash", 0);
        return "payment";
    }
    @GetMapping(path = "/user/subtract/{id}")
    public String subtract(@PathVariable("id") Long id, Model model){
        for (Cart cart : carts) {
            if (cart.getItem().getCode().equals(id)){
                if (cart.getQuantity() > 1) {
                    cart.decrementQuantity();
                } else {
                    carts.remove(cart);
                }
                break;
            }
        }
        model.addAttribute("items", carts);
        total = 0;
        for (Cart cart : carts) {
            total += cart.getAmount();
        }
        model.addAttribute("total", total);
        model.addAttribute("cash", 0);
        return "payment";
    }

//    DONE
//    Admin Controller
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
            if (search.equalsIgnoreCase("All")) {
                List<Item> items = itemRepository.findAll();
                model.addAttribute("items", items);
            } else {
                Optional<Item> itemsByName = itemRepository.findByName(search);
                Optional<Category> category = categoryRepository.findByName(search);
                if (itemsByName.isPresent()) {
                    model.addAttribute("items", itemsByName.get());
                } else if (category.isPresent()) {
                    model.addAttribute("items", itemRepository.findByCategory(category.get()));
                } else {
                    model.addAttribute("message", "Item doesn't exist");
                }
            }
        }
        return "search";
    }
    @GetMapping(path = "/admin/manage")
    public String manage(@RequestParam(value = "search", required = false) String search,
                         Model model) {
        if (search != null) {
            Optional<Item> items = itemRepository.findByName(search);
            if (items.isPresent()) {
                model.addAttribute("items", items.get());
            }
        } else {
            List<Item> items = itemRepository.findAll();
            model.addAttribute("items", items);
        }return "manage";}
    @PostMapping(path = "/admin/manage/updated")
    public String updateSuccess(@RequestParam(value = "code") long barcode,
                                @RequestParam(value = "name") String name,
                                @RequestParam(value = "price") long price,
                                @RequestParam(value = "category") long category_id,
                                @RequestParam(value = "description") String description, Model model) {
        Category category = categoryRepository.findById(category_id).get();
        itemRepository.save(new Item(barcode, name, category, price, description));
        model.addAttribute("message", "Update success");
        return "manage";
    }
     @GetMapping(path = "/admin/manage/update/{id}")
     public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("item", itemRepository.findById(id).get());
        model.addAttribute("categories", categoryRepository.findAll());
        return "edit_item";
     }
    @GetMapping(path = "/admin/manage/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        Item item = itemRepository.findById(id).get();
        itemRepository.delete(item);
        model.addAttribute("message", item.getName() + " has been deleted");
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "manage";
    }
    @RequestMapping(path = "/logout")
    public String logout() { return "login";}
    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }
    @PostMapping(path = "/admin/item/create")
    public ModelAndView createItem(@RequestParam(value = "barcode") long barcode,
                             @RequestParam(value = "item_name") String name,
                             @RequestParam(value = "price") long price,
                             @RequestParam(value = "category") long category,
                             @RequestParam(value = "desc") String description, Model model){
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
