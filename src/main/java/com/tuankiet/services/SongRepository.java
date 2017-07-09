package com.tuankiet.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tuankiet.model.Song;

public interface SongRepository extends CrudRepository<Song, Long>{
	public Song findById(String id);
	public List<Song> findByName(String name);
	public Song save (Song song);
}
