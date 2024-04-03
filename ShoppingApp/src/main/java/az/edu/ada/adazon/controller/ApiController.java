package az.edu.ada.adazon.controller;

import az.edu.ada.adazon.entity.User;
import az.edu.ada.adazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class ApiController {

    private final UserService userService;

    @Autowired
    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findUserByProductName")
    public ResponseEntity<List<User>> getUsersByProductName(@RequestParam String productName) {
        List<User> users = userService.findUsersByProductName(productName);
        return ResponseEntity.ok(users);
    }
}
