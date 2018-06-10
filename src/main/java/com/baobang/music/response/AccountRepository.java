package com.baobang.music.response;
/**
  * @author BaoBang
  * @Created Jun 10, 2018
  * 
  */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.baobang.music.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {


	@Query("select a from Account a where a.username = :username and a.password = :password" )
	public Account findLogin(@Param("username")String username, @Param("password")String password);
}
