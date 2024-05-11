package com.example.GameKiroku.controller;

import com.example.GameKiroku.entity.ContentList;
import com.example.GameKiroku.entity.MyUser;
import com.example.GameKiroku.service.ContentListService;
import com.example.GameKiroku.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final ContentListService listService;
    @GetMapping("/user")
    public String userUrl(Model model, Principal principal) {
        MyUser user = userService.getUserByPrincipal(principal);
        List<ContentList> planned = listService.findPlanned(user);
        List<ContentList> completed = listService.findCompleted(user);
        List<ContentList> playing = listService.findPlaying(user);
        List<ContentList> postponed = listService.findPostponed(user);
        int plannedCount = planned.size();
        int completedCount = completed.size();
        int playingCount = playing.size();
        int postponedCount = postponed.size();
        model.addAttribute("planned", planned);
        model.addAttribute("completed", completed);
        model.addAttribute("playing", playing);
        model.addAttribute("postponed", postponed);

        model.addAttribute("plannedCount", plannedCount);
        model.addAttribute("completedCount", completedCount);
        model.addAttribute("playingCount", playingCount);
        model.addAttribute("postponedCount", postponedCount);
        return "user";
    }
}
