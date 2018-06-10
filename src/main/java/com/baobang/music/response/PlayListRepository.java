package com.baobang.music.response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baobang.music.entities.PlayList;

/**
  * @author BaoBang
  * @Created Jun 10, 2018
  * 
  */
@Repository
public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

}
