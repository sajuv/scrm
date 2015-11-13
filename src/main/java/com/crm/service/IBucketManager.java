package com.crm.service;

import java.util.List;

import com.crm.domain.BucketLeadDom;
import com.crm.domain.BucketTicketDom;

public interface IBucketManager {
	
	List<BucketTicketDom> getBucketTicketList();
	List<BucketLeadDom> getBucketLeadList();

}
