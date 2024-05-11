package com.example.GameKiroku.controller;

import com.example.GameKiroku.dto.ContentListDTO;
import com.example.GameKiroku.entity.ContentList;
import com.example.GameKiroku.entity.Game;
import com.example.GameKiroku.entity.MyUser;
import com.example.GameKiroku.service.ContentListService;
import com.example.GameKiroku.service.GameService;
import com.example.GameKiroku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;
    private final UserService userService;
    private final ContentListService listService;
    @GetMapping("/{id}")
    public String gameUrl(@PathVariable Long id,
                          @RequestParam(value="type", required = false) String type,
                          @RequestParam(value="rating", required = false) Integer rating,
                          Principal principal, Model model) {
        List<Game> games = gameService.readAll();
        Game currentGame = findGameById(id, games);
        MyUser user = userService.getUserByPrincipal(principal);
        if (type != null) {
            if (listService.findListByGameId(id, user) && !type.equals("delete")){}
            else if (type.equals("delete")) {
                Long listId = listService.findListIdByGameId(id);
                if (listId != null) {
                    listService.delete(listId);
                }
            }
            else {
                ContentListDTO dto = new ContentListDTO(currentGame, user, type, 0);
                listService.create(dto);
            }
        }
        if (rating != null && listService.findListByGameId(id, user)) {
            ContentList currentList = listService.findListByGame(id, user);
            currentList.setRate(rating);
            listService.update(currentList);
        }
        model.addAttribute("currentGame", currentGame);
        return "game";
    }

    public Game findGameById(long id, List<Game> list) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }
}
