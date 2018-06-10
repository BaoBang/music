package com.baobang.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baobang.music.entities.PlayList;
import com.baobang.music.entities.Song;
import com.baobang.music.model.EndPoint;
import com.baobang.music.response.PlayListRepository;
import com.baobang.music.response.SongRepository;

import io.swagger.annotations.ApiOperation;

/**
  * @author BaoBang
  * @Created Jun 10, 2018
  * 
  */
@RestController
@RequestMapping("song")
public class SongController {
	@Autowired
	SongRepository mRepository;
	

	@RequestMapping(//
			value = { "", "/" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Lấy toàn bài hát")
	public EndPoint<List<Song>> findAll(){
	
		List<Song> songs = mRepository.findAll();
		
		return new EndPoint<List<Song>>(1, "Thành công", songs);
		
	}
	
	@RequestMapping(//
			value = { "/{id}" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Lấy bài hát theo id")
	public EndPoint<Song> findById(@PathVariable(value = "id") int id){
		Song song = mRepository.findById(id).get();
		return new EndPoint<Song>(1, "Thành công", song);
		
	}
	
	@RequestMapping(//
			value = { "", "/" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Tạo bài hát")
	public EndPoint<Song> save(@RequestBody Song song){
		
	
		song = mRepository.save(song);
		
		
		return new EndPoint<Song>(1, "Thành công", song);
		
	}
}
