package com.baobang.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baobang.music.entities.Account;
import com.baobang.music.entities.PlayList;
import com.baobang.music.model.EndPoint;
import com.baobang.music.response.PlayListRepository;

import io.swagger.annotations.ApiOperation;

/**
  * @author BaoBang
  * @Created Jun 10, 2018
  * 
  */
@RestController
@RequestMapping("play-list")
public class PlayListController {
	@Autowired
	PlayListRepository mRepository;
	

	@RequestMapping(//
			value = { "", "/" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Lấy toàn bộ play list")
	public EndPoint<List<PlayList>> findAll(){
	
		List<PlayList> playLists = mRepository.findAll();
		
		return new EndPoint<List<PlayList>>(1, "Thành công", playLists);
		
	}
	
	@RequestMapping(//
			value = { "/{id}" }, //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Lấy play list theo id")
	public EndPoint<PlayList> findById(@PathVariable(value = "id") int id){
		PlayList pl = mRepository.findById(id).get();
		return new EndPoint<PlayList>(1, "Thành công", pl);
		
	}
	
	@RequestMapping(//
			value = { "", "/" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Tạo Play List")
	public EndPoint<PlayList> save(@RequestBody PlayList playList){
		
	
		playList = mRepository.save(playList);
		
		
		return new EndPoint<PlayList>(1, "Thành công", playList);
		
	}
}
