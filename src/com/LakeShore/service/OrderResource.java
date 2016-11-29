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

@Path("/OrderService")
public class OrderResource implements OrderService {
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/")
	public OrderRepresentation createOrder(@HeaderParam("CustomerID") String customerID){
		System.out.println("PUT Request to generate new order(cart) for customer with id: " + customerID + ".......");
		OrderActivity ordActivity = new OrderActivity();
		
		return ordActivity.createOrder(customerID);
	}//close createOrder()
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/Submit/{id}")
	public void submitOrder(@PathParam("id") String id){
		System.out.println("POST Request to submit order with id: " + id + "........");
		OrderActivity ordActivity = new OrderActivity();
		
		ordActivity.submitOrder(id);
		
	}//close submitOrder
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/Process/{id}")
	public void processOrder(@PathParam("id") String id){
		System.out.println("POST Request to process order with id: " + id + "........");
		
		OrderActivity ordActivity = new OrderActivity();
		
		ordActivity.processOrder(id);
	}//close processOrder
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/Ship/{id}")
	public void shipOrder(@PathParam("id") String id){
		System.out.println("POST Request to ship order with id: " + id + "........");
		
		OrderActivity ordActivity = new OrderActivity();
		
		ordActivity.shipOrder(id);
	}//close processOrder
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/Deliver/{id}")
	public void deliverOrder(@PathParam("id") String id){
		System.out.println("POST Request to deliver order with id: " + id + "........");
		
		OrderActivity ordActivity = new OrderActivity();
		
		ordActivity.deliverOrder(id);
	}//close processOrder
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/{id}")
	public void cancelOrder(@PathParam("id") String id){
		System.out.println("POST Request to cancel order with id: " + id + "........");
		
		OrderActivity ordActivity = new OrderActivity();
		
		ordActivity.cancelOrder(id);
	}//close processOrder
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/{id}")
	public OrderRepresentation lookupOrder(@PathParam("id") String id){
		System.out.println("GET Request to lookup order with id: " + id + "........");
		OrderActivity ordActivity = new OrderActivity();
		
		return ordActivity.lookupOrder(id);
	}//close lookupOrder
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Orders/Item/")
	public void addItem(@HeaderParam("OrderID") String orderID, @HeaderParam("PartnerID") String partnerID, @HeaderParam("ProductID") String productID, 
			@HeaderParam("Quantity") String quantity, @HeaderParam("Price") String price){
		System.out.println("PUT Request to add item with id: " + productID + "to order with id: " + orderID + "........");
		OrderActivity ordActivity = new OrderActivity();
		
		ordActivity.addItem(orderID, partnerID, productID, quantity, price);
		
	}//close addItem
	
	
	
}//close class
