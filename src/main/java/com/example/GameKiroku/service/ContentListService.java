package com.example.GameKiroku.service;

import com.example.GameKiroku.dto.ContentListDTO;
import com.example.GameKiroku.entity.ContentList;
import com.example.GameKiroku.entity.MyUser;
import com.example.GameKiroku.repository.ListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContentListService {
    private final ListRepository repository;
    public ContentList create(ContentListDTO dto) {
        ContentList list = ContentList.builder()
                .game(dto.getGame())
                .user(dto.getUser())
                .type(dto.getType())
                .rate(dto.getRate())
                .build();
        return repository.save(list);
    }

    public List<ContentList> readAll() {
        return repository.findAll();
    }

    public ContentList update(ContentList contentList) {
        return repository.save(contentList);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<ContentList> findPlanned (MyUser user) {
        List<ContentList> allLists = repository.findAll();
        List<ContentList> planned = new ArrayList<>();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getUser() == user && allLists.get(i).getType().equals("planned")){
                planned.add(allLists.get(i));
            }
        }
        return planned;
    }

    public List<ContentList> findCompleted (MyUser user) {
        List<ContentList> allLists = repository.findAll();
        List<ContentList> completed = new ArrayList<>();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getUser() == user && allLists.get(i).getType().equals("completed")){
                completed.add(allLists.get(i));
            }
        }
        return completed;
    }

    public List<ContentList> findPlaying (MyUser user) {
        List<ContentList> allLists = repository.findAll();
        List<ContentList> playing = new ArrayList<>();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getUser() == user && allLists.get(i).getType().equals("playing")){
                playing.add(allLists.get(i));
            }
        }
        return playing;
    }

    public List<ContentList> findPostponed (MyUser user) {
        List<ContentList> allLists = repository.findAll();
        List<ContentList> postponed = new ArrayList<>();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getUser() == user && allLists.get(i).getType().equals("postponed")){
                postponed.add(allLists.get(i));
            }
        }
        return postponed;
    }

    public Long findListIdByGameId(long id) {
        List<ContentList> allLists = repository.findAll();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getGame().getId() == id) {
                return allLists.get(i).getId();
            }
        }
        return null;
    }

    public boolean findListByGameId(long id, MyUser user) {
        List<ContentList> allLists = repository.findAll();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getGame().getId() == id && allLists.get(i).getUser() == user) {
                return true;
            }
        }
        return false;
    }

    public ContentList findListByGame(long id, MyUser user) {
        List<ContentList> allLists = repository.findAll();
        for (int i = 0; i < allLists.size(); ++i) {
            if (allLists.get(i).getGame().getId() == id && allLists.get(i).getUser() == user) {
                return allLists.get(i);
            }
        }
        return null;
    }
}
