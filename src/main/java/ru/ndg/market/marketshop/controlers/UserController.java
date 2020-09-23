package ru.ndg.market.marketshop.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ndg.market.marketshop.model.Role;
import ru.ndg.market.marketshop.model.User;
import ru.ndg.market.marketshop.services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> users = userService.findAlluser();
        model.addAttribute("users", users);
        return "all_users";
    }

    @GetMapping("/edit/{id}")
    public String showEditUserForm(@PathVariable(name = "id") Long id, Model model) {
        User user = userService.getuserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String showAddUserForm() {
        return "add_user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user, @ModelAttribute Role role) {
        userService.addUser(user, role);
        return "redirect:/users";
    }
}
