package com.crm.dao;

import java.util.List;

import com.crm.domain.BucketLeadDom;
import com.crm.domain.BucketTicketDom;

public interface IAdminDao {

	List<BucketTicketDom> getBucketTicketDetails(); 
	
	List<BucketLeadDom> getBucketLeadList();
}
