package com.example.GameKiroku.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameDTO {
    private String gameName;
    private String genre;
    private String developer;
    private String description;
    private String releaseDate;
    private float rating;
    private String img;
}
