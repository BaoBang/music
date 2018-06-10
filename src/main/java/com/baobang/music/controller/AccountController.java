package com.baobang.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baobang.music.entities.Account;
import com.baobang.music.model.EndPoint;
import com.baobang.music.response.AccountRepository;

import io.swagger.annotations.ApiOperation;


/**
  * @author BaoBang
  * @Created Jun 10, 2018
  * 
  */
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	AccountRepository mRepository;
	
	@RequestMapping(//
			value = { "", "/" }, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Tạo tài khoản")
	public EndPoint<Account> save(@RequestBody Account account){
		
	
		account = mRepository.save(account);
		
		
		return new EndPoint<Account>(1, "Thành công", account);
		
	}
	
	@RequestMapping(//
			value = { "login"}, //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE })
	@ApiOperation(value = "Đăng nhập")
	public EndPoint<Account> login(@RequestBody Account account){
		
		Account a = mRepository.findLogin(account.getUsername(), account.getPassword());
		
		if (a == null ) {
			return new EndPoint<Account>(0, "Tài khoản hoặc mật khẩu không đúng", a);
		}else {
			return new EndPoint<Account>(1, "Đăng nhập thành công", a);
		}
		
	}
}
