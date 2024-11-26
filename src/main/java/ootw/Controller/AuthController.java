package ootw.Controller;

import ootw.Entity.User;
import ootw.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestParam String email,
                           @RequestParam String password,
                           @RequestParam String username) {
        try {
            userService.registerUser(email, password, username);
            return "User registered successfully";
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        try {
            User user = userService.loginUser(email, password);
            return "Welcome, " + user.getUsername();
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
