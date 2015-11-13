package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.dao.IAdminDao;
import com.crm.domain.BucketLeadDom;
import com.crm.domain.BucketTicketDom;

@Service
public class BucketManager implements IBucketManager{

	@Autowired
	IAdminDao adminDao;
	
	public List<BucketTicketDom> getBucketTicketList() {
		return adminDao.getBucketTicketDetails();
	}
	
	public List<BucketLeadDom> getBucketLeadList() {
		return adminDao.getBucketLeadList();
	}
}
