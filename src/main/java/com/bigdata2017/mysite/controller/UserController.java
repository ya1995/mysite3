package com.bigdata2017.mysite.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata2017.mysite.service.UserService;
import com.bigdata2017.mysite.vo.GuestbookVo;
import com.bigdata2017.mysite.vo.UserVo;
import com.bigdata2017.security.Auth;
import com.bigdata2017.security.AuthUser;

@Controller
@RequestMapping( "/user" )
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping( value="/join", method=RequestMethod.GET )
	public String join() {
		return "user/join";
	}

	@RequestMapping( value="/join", method=RequestMethod.POST )
	public String join( @ModelAttribute UserVo userVo ) {
		userService.join(userVo);
		return "redirect:/user/joinsuccess";
	}
	
	@RequestMapping( "/joinsuccess" )
	public String joinSuccess() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@Auth(role="user")
	@RequestMapping( value="/modify", method=RequestMethod.GET )
	public String modify(@AuthUser UserVo authUser) {
		System.out.println( authUser );
		UserVo userVo = userService.getUser( authUser.getNo() );
		return "user/modify";
	}
}
