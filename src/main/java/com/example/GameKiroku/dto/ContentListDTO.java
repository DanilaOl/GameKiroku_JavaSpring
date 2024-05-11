package com.example.GameKiroku.dto;

import com.example.GameKiroku.entity.Game;
import com.example.GameKiroku.entity.MyUser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ContentListDTO {
    private Game game;
    private MyUser user;
    private String type;
    private int rate;
}
