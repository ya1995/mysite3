package com.bigdata2017.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bigdata2017.security.Auth;


@Controller
@Auth(role="admin")
@RequestMapping( "/admin" )
public class AdminController {
}
