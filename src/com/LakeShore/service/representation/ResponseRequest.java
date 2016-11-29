package com.LakeShore.service.representation;

import com.LakeShore.Model.*;

import java.util.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 * Created by matthewwojkowski on 11/8/16.
 */
@XmlRootElement(name = "Response")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ResponseRequest {
	
	private Set<CustomerRepresentation> customers;
	private Set<OrderRepresentation> orders;
	private Set<PartnerRepresentation> partners;
	private Set<ProductRepresentation> products;
	private String responseInfo;//will contain any success codes for things that could be void methods
	
	public ResponseRequest(){
		customers = new HashSet<CustomerRepresentation>();
		orders = new HashSet<OrderRepresentation>();
		partners = new HashSet<PartnerRepresentation>();
		products = new HashSet<ProductRepresentation>();
	}//close Response underloaded constructor
	
	
	public void addCustomers(Set<CustomerRepresentation> x){
		customers.addAll(x);
	}//close addCustomers()
	
	public void addCustomer(CustomerRepresentation x){
		customers.add(x);
	}//close addCustomer()
	
	public void addOrders(Set<OrderRepresentation> x){
		for(OrderRepresentation i:x)
			orders.add(i);
	}//close addOrders()
	
	public void addOrder(OrderRepresentation x){
		orders.add(x);
	}//close addOrdeR()
	
	public void addPartners(Set<PartnerRepresentation> x){
		for(PartnerRepresentation i:x)
			partners.add(i);
	}//close addPartnerS()
	
	public void addPartner(PartnerRepresentation x){
		partners.add(x);
	}//close addPartner()
	
	public void addProducts(Set<ProductRepresentation> x){
		for(ProductRepresentation i:x)
			products.add(i);
	}//close addProducts();
	
	public void addproduct(ProductRepresentation x){
		products.add(x);
	}
	
	public void setResponseInfo(String x){
		this.responseInfo = x;
	}//close setResponseInfo
	
	public Set<CustomerRepresentation> getCustomer(){
		return customers;
	}//close getCustomer
	
	public Set<OrderRepresentation> getOrders(){
		return orders;
	}//close getOrders()
	
	public Set<PartnerRepresentation> getPartner(){
		return partners;
	}//close getPartners()
	
	public Set<ProductRepresentation> getProduct(){
		return products;
	}//close getProducts()
	
	public String getResponseInfo(){
		return responseInfo;
	}//close getResponseInfo()
	
}//close class
