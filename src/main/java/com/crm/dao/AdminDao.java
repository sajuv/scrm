package com.crm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.RowMapper;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import com.crm.domain.BucketLeadDom;
import com.crm.domain.BucketTicketDom;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

@Repository
public class AdminDao  implements IAdminDao{
	
	@Autowired
	CassandraOperations cassandraOperations;
	
	public List<BucketTicketDom> getBucketTicketDetails() {
		
		List<BucketTicketDom> bucketTicketDom =  new ArrayList<BucketTicketDom>();
		String bucketStatus="new";
		Select select = QueryBuilder.select("source", "description", "postedon").from("bucket_tickets");
		try {
			bucketTicketDom = cassandraOperations.query(select, new BucketTicketMapper()) ;
		}
		catch(IllegalArgumentException argEx)
		{
			argEx.printStackTrace();
			
		}
		return bucketTicketDom == null ? new ArrayList<BucketTicketDom>() : bucketTicketDom;
	}

	public List<BucketLeadDom> getBucketLeadList() {
		
		List<BucketLeadDom> bucketLeadDom =  new ArrayList<BucketLeadDom>();
		Select select = QueryBuilder.select("source", "description", "postedon").from("bucket_leads");
		try {
			bucketLeadDom = cassandraOperations.query(select, new BucketLeadMapper()) ;
		}
		catch(IllegalArgumentException argEx)
		{
			argEx.printStackTrace();
			
		}
		return bucketLeadDom == null ? new ArrayList<BucketLeadDom>() : bucketLeadDom;
	}
	
	private class BucketTicketMapper implements RowMapper<BucketTicketDom>
	{

		@Override
		public BucketTicketDom mapRow(Row rs, int arg1) throws DriverException {
			BucketTicketDom bucketTicketDom = new BucketTicketDom();
			//bucketTicketDom.setInteractionId(rs.getString("interactionid"));
			bucketTicketDom.setDescription(rs.getString("description"));
			bucketTicketDom.setPostedOn(rs.getString("postedon"));
			bucketTicketDom.setSource(rs.getString("source"));
			return bucketTicketDom;
		}
	}
	
	private class BucketLeadMapper implements RowMapper<BucketLeadDom>
	{

		@Override
		public BucketLeadDom mapRow(Row rs, int arg1) throws DriverException {
			BucketLeadDom bucketLeadDom = new BucketLeadDom();
			//bucketTicketDom.setInteractionId(rs.getString("interactionid"));
			bucketLeadDom.setDescription(rs.getString("description"));
			bucketLeadDom.setPostedOn(rs.getString("postedon"));
			bucketLeadDom.setSource(rs.getString("source"));
			return bucketLeadDom;
		}
	}
	
}
