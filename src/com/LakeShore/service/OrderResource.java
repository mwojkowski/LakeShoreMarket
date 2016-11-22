package com.LakeShore.service;

import com.LakeShore.service.workflow.OrderActivity;
import com.LakeShore.service.representation.OrderRepresentation;

import javax.ws.rs.Path;import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.HeaderParam;
import java.util.Set;

@Path("/OrderService")
public class OrderResource implements OrderService {
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/")
	public OrderRepresentation createOrder(@HeaderParam("CustomerID") String customerID){
		System.out.println("PUT Request to generate new order for customer with id: " + customerID + ".......");
		OrderActivity ordActivity = new OrderActivity();
		
		return ordActivity.createOrder(customerID);
	}//close createOrder()
	
	
}//close class
