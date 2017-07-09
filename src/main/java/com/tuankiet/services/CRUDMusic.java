package com.tuankiet.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tuankiet.model.Song;

@Service
public class CRUDMusic implements CRUDMusicInterface {
	@Autowired
	private SongRepository songRepository;
	
	@Override
	public List<Song> findAll() {
		return (List<Song>) songRepository.findAll();
	}

	@Override
	public List<Song> findByName(String name) {
		List<Song> listSong = null;
		if(name==""){
			listSong = (List<Song>) songRepository.findAll();
		}
		listSong = songRepository.findByName(name);
		return listSong;
	}

	@Override
	public Song findById(String id) {
		return songRepository.findById(id);
	}
	
	@Override
	public Song upload(MultipartFile fileUpload) {
		Song song = new Song();
		song.setName(fileUpload.getOriginalFilename());
		try {
			byte[] data = fileUpload.getBytes();
			song.setDataFile(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		songRepository.save(song);
		return song;
	}

}
