package com.example.GameKiroku.service;

import com.example.GameKiroku.dto.UserDTO;
import com.example.GameKiroku.entity.Game;
import com.example.GameKiroku.entity.MyUser;
import com.example.GameKiroku.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private PasswordEncoder passwordEncoder;

    public MyUser addUser(UserDTO dto) {
        MyUser user = MyUser.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .roles(dto.getRoles())
                .build();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public List<MyUser> readAll() {
        return repository.findAll();
    }

    public MyUser update(MyUser user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public MyUser getUserByPrincipal(Principal principal) {
        if (principal == null) return null;
        return repository.findByName(principal.getName()).get();
    }
}
