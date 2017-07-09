package com.tuankiet.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tuankiet.model.Song;
import com.tuankiet.services.CRUDMusicInterface;

@Controller
public class SongController {
	
	@Autowired 
	private CRUDMusicInterface crudMusic;
	
	@RequestMapping("/home")
	public String getLoginPage(){
		Song song = new Song();
		return "home";
	}
	
	@RequestMapping(value="/audio-api/{id}.mp3", method=RequestMethod.GET)
	public void play (HttpServletResponse reponse, @PathVariable("id")int id){
		Song song = crudMusic.findById(id);
		try {
			reponse.getOutputStream().write(song.getDataFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value="/audio-api-page/{id}.mp3", method=RequestMethod.GET)
	public String go (@PathVariable("id")int id, HashMap<String, Song> data){
		Song song = new Song();
		song.setId(id);
		data.put("song", song);
		return "audio-api-page";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String getSong(@PathParam("name") String name, HashMap<String, Object> data){
		if(name.equalsIgnoreCase("")){
			List<Song> listSong = crudMusic.findAll();
			data.put("listSong", listSong);
		}
		else {
			List<Song> listSong = crudMusic.findByName(name);
			data.put("listSong", listSong);
		}
		return "home";
	}
	
	@RequestMapping (value="/upload", method=RequestMethod.POST)
	public String create (@RequestParam("fileUpload")MultipartFile fileUpload){
		if (fileUpload==null){
			return null;
		}
		crudMusic.upload(fileUpload);
		return "home";
	}
	
	// introduct project
	@RequestMapping("/about")
	public String findAll (){
		return "function-introduction";
	}
	
}
