package com.LakeShore.Model;

/**
 * Created by matthewwojkowski on 11/29/16.
 * 
 * NOTES: 
 * This class was created to provide a generic response template for the API.
 * All RESTful requests will flow through this class so that all responses can be forged to the specific situation.
 * Errors can be returned with error codes, classes can be returned, etc.
 * 
 * All classes for the final API will cascade through this class so that any generic response can be given in any given situation.
 * 
 */

import com.LakeShore.Model.*;
import com.LakeShore.service.representation.CustomerRepresentation;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	private Set<Customer> customers;
	private Set<Order> orders;
	private Set<Partner> partners;
	private Set<Product> products;
	private String responseInfo;//will contain any success codes for things that could be void methods
	
	public Response(){
		customers = Collections.emptySet();
		orders = Collections.emptySet();
		
	}//close Response underloaded constructor
	
	public void addCustomers(Set<Customer> x){
		customers.addAll(x);
	}//close addCustomers()
	
	public void addCustomer(Customer x){
		customers.add(x);
	}//close addCustomer()
	
	public void addOrders(Set<Order> x){
		for(Order i:x)
			orders.add(i);
	}//close addOrders()
	
	public void addPartners(Set<Partner> x){
		for(Partner i:x)
			partners.add(i);
	}//close addPartnerS()
	
	public void addProduct(Set<Product> x){
		for(Product i:x)
			products.add(i);
	}//close addProducts();
	
	public void setResponseInfo(boolean x){
		if(x){
			responseInfo = "Success";
		}//close if statement
		else{
			responseInfo = "Error";
		}//close else
	}//close setResponseInfo
	
	public Set<Customer> getCustomer(){
		return customers;
	}//close getCustomer
	
	public Set<Order> getOrders(){
		return orders;
	}//close getOrders()
	
	public Set<Partner> getPartner(){
		return partners;
	}//close getPartners()
	
	public Set<Product> getProduct(){
		return products;
	}//close getProducts()
	
	public String getResponseInfo(){
		return responseInfo;
	}//close getResponseInfo()
	
	

}//close Response
