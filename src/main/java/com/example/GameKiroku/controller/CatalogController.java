package com.example.GameKiroku.controller;

import com.example.GameKiroku.entity.Game;
import com.example.GameKiroku.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CatalogController {
    private final GameService gameService;
    @GetMapping("/")
    public String rootUrl(Model model) {
        List<Game> games = gameService.readAll();
        model.addAttribute("games", games);
        return "catalog";
    }

    @GetMapping("/catalog")
    public String catalogUrl(Model model) {
        List<Game> games = gameService.readAll();
        model.addAttribute("games", games);
        return "catalog";
    }
}
