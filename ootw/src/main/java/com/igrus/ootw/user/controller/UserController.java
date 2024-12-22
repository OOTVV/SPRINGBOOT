package com.igrus.ootw.user.controller;

import com.igrus.ootw.user.domain.User;
import com.igrus.ootw.user.domain.enums.Gender;
import com.igrus.ootw.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 생성자를 통한 의존성 주입
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 엔드포인트
    @PostMapping("/register")
    public User registerUser(@RequestParam String nickname,
                             @RequestParam String email,
                             @RequestParam String password,
                             @RequestParam Gender gender) {
        return userService.registerUser(nickname, email, password, gender);
    }

    // 로그인 엔드포인트
    @PostMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }
}
