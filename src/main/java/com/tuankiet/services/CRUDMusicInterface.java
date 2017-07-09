package com.tuankiet.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tuankiet.model.Song;

@Service
public interface CRUDMusicInterface {
	public Song upload(MultipartFile file);
	public List<Song> findAll();
	public List<Song> findByName(String name);
	public Song findById(int id);
}
