package com.LakeShore.service;

import com.LakeShore.service.representation.ResponseRepresentation;
import com.LakeShore.service.representation.ResponseRequest;

import javax.jws.WebService;

import java.util.Set;

/**
 * Created by matthewwojkowski on 11/8/16.
 */
public interface ResponseService {
	
	
	//CUSTOMER METHODS
	
	public ResponseRepresentation getCustomers();
	public ResponseRepresentation createCustomer(String firstName, String lastName);
	public ResponseRepresentation deleteCustomer(String id);
	public ResponseRepresentation getCustomerById(String id);
	public ResponseRepresentation updateCity(String id, String city);
	public ResponseRepresentation updateCustomerAddress(String id, String address);
	public ResponseRepresentation updateState(String id, String state);
	public ResponseRepresentation updateZip(String id, String zip);
	public ResponseRepresentation updatePhoneNumber(String id, String phoneNumber);
	
	
	
	//PARTNER METHODS
	public ResponseRepresentation createPartner(String firstName, String lastName, String company);
	public ResponseRepresentation getPartnerById(String id);
	public ResponseRepresentation getPartners();
	public ResponseRepresentation updatePartnerCity(String id, String city);
	public ResponseRepresentation updatePartnerAddress(String id, String address);
	public ResponseRepresentation updatePartnerPhoneNumber(String id, String phoneNumber);
	public ResponseRepresentation updatePartnerState(String id, String state);
	
	
	
	//PRODUCT METHODS
	public ResponseRepresentation createProduct(String name, String description, String sellerID);
	public ResponseRepresentation getProductById(String id);
	public ResponseRepresentation getProductByName(String name);
	public ResponseRepresentation getProducts();
	public ResponseRepresentation updateName(String id, String name);
	public ResponseRepresentation updateDescription(String id, String description);
	public ResponseRepresentation updateQuantity(String id, String quantity);
	public ResponseRepresentation updatePrice(String id, String price);
	
	
	//ORDER METHODS
	public ResponseRepresentation cancelOrder(String id);
	public ResponseRepresentation createOrder(String customerID);
	public ResponseRepresentation deliverOrder(String id);
	public ResponseRepresentation lookupOrder(String id);
	public ResponseRepresentation processOrder(String id);
	public ResponseRepresentation shipOrder(String id);
	public ResponseRepresentation submitOrder(String id);
	public ResponseRepresentation checkStatus(String id);
	public ResponseRepresentation addItem(String orderID, String partnerID, String productID, String quantity, String price);
	public ResponseRepresentation buyItemNow(String productId, String customerID, String partnerID);
	

}//close ResponseService
