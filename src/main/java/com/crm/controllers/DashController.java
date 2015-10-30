package com.crm.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crm.util.URLMapper;


@Controller
public class DashController {
	 @RequestMapping(value=URLMapper.DASHBOARD)
  	   public String getStartPage(){
			 return "dashboard";
	 }
}
