package com.example.GameKiroku.controller;

import com.example.GameKiroku.dto.UserDTO;
import com.example.GameKiroku.entity.MyUser;
import com.example.GameKiroku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class RegisterController {
    private final UserService userService;
    @GetMapping("/register")
    public String regUrl(Model model) {
        return "register";
    }

    @GetMapping("/login")
    public String loginUrl(Model model) {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<MyUser> create(@RequestParam String nickname, @RequestParam String email,
                                         @RequestParam String password, @RequestParam String repeat,
                                         Model model) {
        if (password.equals(repeat)) {
            UserDTO dto = new UserDTO(nickname, password, email, "USER");
            return new ResponseEntity<>(userService.addUser(dto), HttpStatus.OK);
        }
        else {
            return null;
        }
    }
}
