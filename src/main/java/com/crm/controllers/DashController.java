package com.crm.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crm.domain.BucketLeadDom;
import com.crm.domain.BucketTicketDom;
import com.crm.service.IBucketManager;
import com.crm.util.URLMapper;


@Controller
public class DashController {
	@Autowired
	IBucketManager bucketManager;
	
	 @RequestMapping(value=URLMapper.DASHBOARD)
  	   public ModelAndView getDashboard(){
		    List<BucketTicketDom> bucketTickets = null;
			bucketTickets=bucketManager.getBucketTicketList();
			List<BucketLeadDom> bucketLeads = null;
			bucketLeads=bucketManager.getBucketLeadList();
			 ModelAndView modelAndView=new ModelAndView("dashboard");
			 modelAndView.addObject("bucketTickets",bucketTickets);
			 modelAndView.addObject("bucketLeads",bucketLeads);
			 return modelAndView;
	 }
	 
	 @RequestMapping(value=URLMapper.HOME)
	   public String getHomePage(){
			 return "home";
	 }
	 
	 @RequestMapping(value=URLMapper.SETTINGS)
	   public String getConfPage(){
			 return "settings";
	 }
}
