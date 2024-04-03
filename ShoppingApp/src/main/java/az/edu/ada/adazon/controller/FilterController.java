package az.edu.ada.adazon.controller;

import az.edu.ada.adazon.entity.User;
import az.edu.ada.adazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/filter")
public class FilterController {

    private final UserService userService;

    @Autowired
    public FilterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String filterUsers(@RequestParam(required = false) Long id,
                              @RequestParam(required = false) String username,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String surname,
                              @RequestParam(required = false) String email,
                              @RequestParam(required = false) String phone,
                              @RequestParam(required = false) LocalDate dateOfBirth,
                              Model model) {
        List<User> users = userService.findByCriteria(id, username, name, surname, email, phone, dateOfBirth);
        model.addAttribute("users", users);
        return "filter";
    }
}
