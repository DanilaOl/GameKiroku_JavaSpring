package com.example.GameKiroku.service;

import com.example.GameKiroku.dto.GameDTO;
import com.example.GameKiroku.entity.Game;
import com.example.GameKiroku.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
public class GameService {
    private final GameRepository repository;

    public Game create(GameDTO dto) {
        Game game = Game.builder()
                .gameName(dto.getGameName())
                .genre(dto.getGenre())
                .developer(dto.getDeveloper())
                .description(dto.getDescription())
                .releaseDate(dto.getReleaseDate())
                .rating(dto.getRating())
                .img(dto.getImg())
                .build();
        return repository.save(game);
    }

    public List<Game> readAll() {
        return repository.findAll();
    }

    public Game update(Game game) {
        return repository.save(game);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
