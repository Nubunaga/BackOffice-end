package com.example.demos.repository;

import java.util.List;

import com.example.demos.model.Played_video;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayedVideoRepository extends CrudRepository<Played_video, Integer> {
    @Query(
        value=("SELECT * FROM heroku_7625137638b3157.played_video u WHERE u.order = :order ORDER BY 1 DESC LIMIT 1 "),
        nativeQuery = true
    )
    List<Played_video> findFirstByorder(@Param("order") String order );

    @Query(
        value = ("SELECT COUNT(video) FROM heroku_7625137638b3157.played_video u WHERE u.video =:video"),
        nativeQuery = true
    )
    Integer countVideo(@Param("video") Integer video);
}