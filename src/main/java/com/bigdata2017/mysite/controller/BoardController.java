package com.bigdata2017.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigdata2017.security.Auth;

@Controller
@RequestMapping( "/board" )
public class BoardController {

	@Auth
	@RequestMapping( value="/write", method=RequestMethod.GET )
	public String write() {
		return "board/write";
	}
}
