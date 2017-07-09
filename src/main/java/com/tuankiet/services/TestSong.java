package com.tuankiet.services;

import org.springframework.data.repository.CrudRepository;

import com.tuankiet.model.Song;

public interface TestSong extends CrudRepository<Song, Long> {

}
