package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crm.domain.BucketLeadDom;
import com.crm.domain.BucketTicketDom;
import com.crm.service.IBucketManager;
import com.crm.util.URLMapper;

@Controller
public class BucketController {
	
	@Autowired
	IBucketManager bucketManager;
	
	@RequestMapping(value=URLMapper.BUCKET)
	   public ModelAndView getBucketList(){
		 List<BucketTicketDom> bucketTickets = null;
			bucketTickets=bucketManager.getBucketTicketList();
			List<BucketLeadDom> bucketLeads = null;
			bucketLeads=bucketManager.getBucketLeadList();
			 ModelAndView modelAndView=new ModelAndView("bucket");
			 modelAndView.addObject("bucketTickets",bucketTickets);
			 modelAndView.addObject("bucketLeads",bucketLeads);
			 return modelAndView;
			
	 }
	 
	 @RequestMapping(value=URLMapper.BUCKET_DETAILS)
	   public String getBucketDetails(){
			 return "bucketdetails";
	 }
	 
	 @RequestMapping(value=URLMapper.BUCKET_TICKETS_LIST)
	 @ResponseBody	
	   public List<BucketTicketDom> getBucketTicketList(){
		 System.out.println("Processing Ticket List");
		 return bucketManager.getBucketTicketList();
	 }
	 
}
