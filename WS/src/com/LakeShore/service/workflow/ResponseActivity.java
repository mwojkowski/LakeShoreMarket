package com.LakeShore.service.workflow;

import com.LakeShore.Manager.*;
import com.LakeShore.service.representation.*;
import com.LakeShore.Model.*;

import com.LakeShore.service.workflow.*;

import java.util.*;

/**
 * Created by matthewwojkowski on 11/8/16.
 */
public class ResponseActivity {
	private static CustomerManager cManager = new CustomerManager();
	private static CustomerActivity custActivity = new CustomerActivity();
	private static PartnerActivity partActivity = new PartnerActivity();
	private static OrderActivity ordActivity = new OrderActivity();
	private static ProductActivity prodActivity = new ProductActivity();
	
	public ResponseActivity(){
		
	}//close underloaded constructor
	
	/*
	 * 
	 * CUSTOMER MODIFICATION METHODS
	 * 
	 * 
	 */
	
	public Set<CustomerRepresentation> getCustomers(){
        ResponseRepresentation reprep = new ResponseRepresentation();
        
        Set<Customer> customers = new HashSet<Customer>();

        Set<CustomerRepresentation> customerRepresentations = new HashSet<CustomerRepresentation>();

        customers = cManager.getAllCustomers();
        Iterator<Customer> cIterator = customers.iterator();
        while(cIterator.hasNext()){
            Customer temp = (Customer)cIterator.next();
            CustomerRepresentation cusRepTemp = new CustomerRepresentation();
            cusRepTemp.setID(temp.getID());
            cusRepTemp.setFirstName(temp.getFirstName());
            cusRepTemp.setLastName(temp.getLastName());
            cusRepTemp.setAddress(temp.getAddress());
            cusRepTemp.setPhoneNumber(temp.getPhoneNumber());
            cusRepTemp.setCity(temp.getCity());
            cusRepTemp.setState(temp.getState());
            cusRepTemp.setZip(temp.getZip());

            customerRepresentations.add(cusRepTemp);
        }//close while loop
        
        return customerRepresentations;
    }//close getCustomers()
	
	public ResponseRepresentation getCustomerById(String id){
		ResponseRepresentation temp = new ResponseRepresentation();
		try{
			temp.addCustomer(custActivity.getCustomerById(Integer.valueOf(id)));
		}//close try
		catch(Exception e){
			temp.setResponseInfo("Error : User not found using this ID.");
		}//close catch statement
		
		return temp;
	}//close getCustomerById
	
	public ResponseRepresentation addCustomer(String firstName, String lastName){
		ResponseRepresentation temp = new ResponseRepresentation();
		try{
			temp.addCustomer(custActivity.createCustomer(firstName, lastName));
		}//close try statement
		catch(Exception e){
			temp.setResponseInfo("Error : Failed to create new user.");
		}//close catch
		return temp;
	}//close addCustomer
	
	public ResponseRepresentation updateAddress(String id, String address){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(custActivity.updateCustomerAddress(id, address)){
			temp.setResponseInfo("Success");
		}//close else
		else{
			temp.setResponseInfo("Error: Failed to update address.");
		}
		return temp;
	}//
	
	public ResponseRepresentation updatePhoneNumber(String id, String phoneNumber){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(custActivity.updatePhoneNumber(id, phoneNumber)){
			temp.setResponseInfo("Success");
		}//close else
		else{
			temp.setResponseInfo("Error: Failed to update phone number.");
		}
		return temp;
	}//
	
	public ResponseRepresentation updateCity(String id, String city){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(custActivity.updateCity(id, city)){
			temp.setResponseInfo("Success");
		}//close if
		else{
			temp.setResponseInfo("Error: Failed to update city.");
		}//close else
		return temp;
	}//
	
	public ResponseRepresentation updateState(String id, String state){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(custActivity.updateState(id, state)){
			temp.setResponseInfo("Success");
		}//close if
		else{
			temp.setResponseInfo("Error: Failed to update state.");
		}//close else
		
		return temp;
	}//
	
	public ResponseRepresentation updateZip(String id, String zip){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(custActivity.updateState(id, zip)){
			temp.setResponseInfo("Success");
		}//close if
		else{
			temp.setResponseInfo("Error: Failed to update zip code.");
		}//close else
		
		return temp;
	}//
	
	public ResponseRepresentation deleteCustomer(String id){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(custActivity.deleteCustomer(id)){
			temp.setResponseInfo("Success");
		}//close if
		else{
			temp.setResponseInfo("Error: Unable to delete user.");
		}//close else
		return temp;
	}//
	
	
	
	/*
	 * 
	 * PARTNER MODIFICATION METHODS
	 * 
	 * 
	 */
	
	public ResponseRepresentation createPartner(String firstName, String lastName, String company){
		ResponseRepresentation temp = new ResponseRepresentation();
		try{
			temp.addPartner(partActivity.createPartner(firstName, lastName, company));
		}//close try statement
		catch(Exception e){
			temp.setResponseInfo("Error : Failed to create new user.");
		}//close catch
		
		
		return temp;
	}//close createPartner
	
	public ResponseRepresentation getPartnerById(String id){
		ResponseRepresentation temp = new ResponseRepresentation();
		try{
			temp.addPartner(partActivity.getPartnerById(Integer.valueOf(id)));
		}
		catch(Exception e){
			temp.setResponseInfo("Error : Failed to find user with id.");
		}
		return temp;
	}//close getPartnerById()
	
	public ResponseRepresentation getPartners(){
		ResponseRepresentation temp = new ResponseRepresentation();
		try{
			temp.addPartners(partActivity.getPartners());
		}
		catch(Exception e){
			temp.setResponseInfo("Error : Failed to get all partners.");
		}
		return temp;
	}//close
	
	public ResponseRepresentation updatePartnerAddress(String id, String address){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(partActivity.updatePartnerAddress(id, address)){
			temp.setResponseInfo("Success");
		}//close if statement
		else{
			temp.setResponseInfo("Error: Failed to update partner's address.");
		}//close else statement
		return temp;
	}//close
	
	public ResponseRepresentation updatePartnerPhoneNumber(String id, String phoneNumber){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(partActivity.updatePhoneNumber(id, phoneNumber)){
			temp.setResponseInfo("Success");
		}//close if statement
		else{
			temp.setResponseInfo("Error: Failed to update partner's address.");
		}//close else statement
		return temp;
	}//close
	
	public ResponseRepresentation updatePartnerCity(String id, String city){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(partActivity.updateCity(id, city)){
			temp.setResponseInfo("Success");
		}//close if statement
		else{
			temp.setResponseInfo("Error: Failed to update partner's address.");
		}//close else statement
		return temp;
	}//close
	
	public ResponseRepresentation updatePartnerState(String id, String state){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(partActivity.updateState(id, state)){
			temp.setResponseInfo("Success");
		}//close if statement
		else{
			temp.setResponseInfo("Error: Failed to update partner's address.");
		}//close else statement
		return temp;
	}//close
	
	public ResponseRepresentation updatePartnerZip(String id, String zip){
		ResponseRepresentation temp = new ResponseRepresentation();
		if(partActivity.updateZip(id, zip)){
			temp.setResponseInfo("Success");
		}//close if statement
		else{
			temp.setResponseInfo("Error: Failed to update partner's address.");
		}//close else statement
		return temp;
	}//close
	
	
	/*
	 * 
	 * PRODUCT MODIFICATION METHODS
	 * 
	 * 
	 */
	
	 public ResponseRepresentation newProduct(String name, String description, String sellerID){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 try{
			 temp.addproduct(prodActivity.createProduct(name, description, sellerID));
		 }//close try
		 catch(Exception e){
			 temp.setResponseInfo("Error: Failed to create new product.");
		 }//close catch
		 return temp;
	 }//close
	 
	 public ResponseRepresentation getProductById(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 try{
			 temp.addproduct(prodActivity.getProductById(id));
		 }//close try
		 catch(Exception e){
			 temp.setResponseInfo("Error: Could not get product by the given id.");
		 }//close catch
		 return temp;
	 }//close getProductById()
	 
	 public ResponseRepresentation getProductByName(String name){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 try{
			 temp.addProducts(prodActivity.getProductByName(name));
		 }//close try
		 catch(Exception e){
			 temp.setResponseInfo("Error: Could not find product by given name");
		 }//close catch
		 return temp;
	 }//close getProductByName
	 
	 public ResponseRepresentation getProducts(){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 
		 try{
			 temp.addProducts(prodActivity.getProducts());
		 }//close try
		 catch(Exception e){
			 temp.setResponseInfo("Error: Could not retreive all products.");
		 }//close catch
		 
		 return temp;
	 }//close getProducts()
	 
	 public ResponseRepresentation updateName(String id, String name){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(prodActivity.updateName(id, name)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error: Could not update product name.");
		 }//close else statement
		 
		 return temp;
	 }//close updateName
	 
	 public ResponseRepresentation updateDescription(String id, String description){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(prodActivity.updateName(id, description)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error: Could not update product description.");
		 }//close else statement
		 return temp;
	 }//close updateDescription
	 
	 public ResponseRepresentation updateQuantity(String id, String quantity){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(prodActivity.updateQuantity(id, quantity)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Could not update product quantity.");
		 }
		 
		 return temp;
	 }//close updateQuantity()
	 
	 public ResponseRepresentation updatePrice(String id, String price){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(prodActivity.updatePrice(id, price)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Could not update product price.");
		 }
		 
		 return temp;
	 }//close updateQuantity()
	
	
	 /*
		 * 
		 * ORDER MODIFICATION METHODS
		 * 
		 * 
		 */
	 
	 public ResponseRepresentation getCustomerOrders(String customerID){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 temp.addOrders(ordActivity.getCustomerOrders(customerID));
		 return temp;
	 }
	 
	 public ResponseRepresentation addItem(String orderID, String partnerID, String productID, String quantity, String price){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 String tempString = ordActivity.checkStatus(orderID);
		 if(tempString.equalsIgnoreCase("Cart"))
			 if(ordActivity.addItem(orderID, partnerID, productID, quantity, price)){
				 temp.setResponseInfo("Success");
			 }
			 else{
				 temp.setResponseInfo("Error : Failed to add the item to your order.");
			 }//close inner else
		 else{
			 temp.setResponseInfo("Error : You may not add items to a submitted order.");
		 }//close outer else
		 return temp;
	 }//close addItem
	 
	 public ResponseRepresentation cancelOrder(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(ordActivity.cancelOrder(id)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Failed to cancel your order.");
		 }
		 return temp;
	 }//close cancelOrder()
	 
	 public ResponseRepresentation createOrder(String customerID){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 try{
			 temp.addOrder(ordActivity.createOrder(customerID));
		 }//close try statement
		 catch(Exception e){
			 temp.setResponseInfo("Error : Could not create a new order.");
		 }//close catch statement
		 
		 return temp;
	 }//close createOrder()
	 
	 public ResponseRepresentation deliverOrder(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(ordActivity.deliverOrder(id)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Order cannot be delivered at this time.");
		 }
		 return temp;
	 }//close deliverOrder
	 
	 public ResponseRepresentation processOrder(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(ordActivity.processOrder(id)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Order cannot be processed at this time.");
		 }
		 return temp;
	 }//close deliverOrder
	 
	 public ResponseRepresentation lookupOrder(String id){
			ResponseRepresentation temp = new ResponseRepresentation();
			
			temp.addOrder(ordActivity.lookupOrder(id));
			
			return temp;
	 }//close lookupOrder
	 
	 public ResponseRepresentation submitOrder(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(ordActivity.submitOrder(id)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Order cannot be submitted at this time.");
		 }
		 return temp;
	 }//close deliverOrder
	 
	 public ResponseRepresentation shipOrder(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(ordActivity.shipOrder(id)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Order cannot be submitted at this time.");
		 }
		 return temp;
	 }//close deliverOrder
	 
	 public ResponseRepresentation checkStatus(String id){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 temp.setResponseInfo(ordActivity.checkStatus(id));
		 return temp;
	 }
	 
	 public ResponseRepresentation removeItem(String orderID, String productID){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 String tempString = ordActivity.checkStatus(orderID);
		 
		 //if the order is still carted, submitted, or processing, seller should be able to make it work...
		 //if it is anything after, too late, return on receipt. 
		 if(tempString.equalsIgnoreCase("Cart") || tempString.equalsIgnoreCase("Submitted") || tempString.equalsIgnoreCase("Processing")){
			 if(ordActivity.removeItem(orderID, productID)){
				 temp.setResponseInfo("Success");
			 }
			 else{
				 temp.setResponseInfo("Error : Failed to remove the item to your order.");
			 }
		 }
		 else{
			 temp.setResponseInfo("Error: Your order has already been shipped. You may return your item upon receipt.");
		 }//close else statement
		 return temp;
	 }//close removeItem
	 
	 public ResponseRepresentation buyItemNow(String customerID, String productID, String partnerID){
		 ResponseRepresentation temp = new ResponseRepresentation();
		 if(ordActivity.buyItemNow(customerID, productID, partnerID)){
			 temp.setResponseInfo("Success");
		 }
		 else{
			 temp.setResponseInfo("Error : Unable to complete your purchase");
		 }
		 return temp;
	 }//close buyItemNow
	 
	 
	 
	 
	
	/*		TEMPLATE
	public ResponseRepresentation (String id){
		ResponseRepresentation temp = new ResponseRepresentation();
		
		//Code Here
		
		return temp;
	}//close
	*/
	

}//close ResponseActivity class 
