package com.rks.project.pointofsales;

import com.rks.project.pointofsales.Users.Users;
import com.rks.project.pointofsales.Users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by ASUS on 26/04/2018.
 */

@Controller
@RequestMapping(path = "/")
public class LoginController {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping(path = "/loginProcess")
    public String login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password, Model model) {
        Optional<Users> users = usersRepository.findByUsernameAndPassword(username, password);
        if (users.isPresent()){
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("role", users.get().getRole());
            return "admin page/create";
        } else {
            model.addAttribute("message", "Invalid username or password");
            return "login/index";
        }
    }
}
