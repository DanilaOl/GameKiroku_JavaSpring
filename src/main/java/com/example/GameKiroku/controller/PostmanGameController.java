package com.example.GameKiroku.controller;

import com.example.GameKiroku.dto.GameDTO;
import com.example.GameKiroku.entity.Game;
import com.example.GameKiroku.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostmanGameController {
    private final GameService gameService;

    @RequestMapping(value = "/postman/game", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> readAll() {
        return new ResponseEntity<>(gameService.readAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/postman/game", method = RequestMethod.POST)
    public ResponseEntity<Game> create(@RequestBody GameDTO dto) {
        return new ResponseEntity<>(gameService.create(dto), HttpStatus.OK);
    }

    @RequestMapping(value = "/postman/game", method = RequestMethod.PUT)
    public ResponseEntity<Game> update(@RequestBody Game game) {
        return new ResponseEntity<>(gameService.update(game), HttpStatus.OK);
    }

    @DeleteMapping("/postman/game/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        gameService.delete(id);
        return HttpStatus.OK;
    }
}
