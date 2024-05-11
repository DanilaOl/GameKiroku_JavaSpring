package com.example.GameKiroku.repository;

import com.example.GameKiroku.entity.ContentList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<ContentList, Long> {
}
