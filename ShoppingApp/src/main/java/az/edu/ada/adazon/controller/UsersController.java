package az.edu.ada.adazon.controller;

import az.edu.ada.adazon.entity.User;
import az.edu.ada.adazon.service.UserService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.Page;



import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/add")
    public String addUser(){
        return "adduser";
    }

    @PostMapping("/save")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/user/add";
    }


    @GetMapping("/list")
    public String listUser(Model model,
                           @RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size,
                           @RequestParam(defaultValue = "id") String sortField,
                           @RequestParam(defaultValue = "asc") String sortDir) {
        Page<User> userPage = userService.listUser(page, size, sortField, sortDir);
        model.addAttribute("users", userPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", userPage.getTotalPages());
        model.addAttribute("totalUsers", userPage.getTotalElements());
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        return "users";
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") Long id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edituser";
    }

    @PostMapping("/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

}