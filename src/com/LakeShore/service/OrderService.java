package com.LakeShore.service;

import com.LakeShore.service.representation.OrderRepresentation;
import com.LakeShore.service.representation.OrderRequest;

import javax.jws.WebService;

import java.util.Set;


public interface OrderService {
	public OrderRepresentation createOrder(String CustomerID);
	public void submitOrder(String id);
	public void processOrder(String id);
	public void shipOrder(String id);
	public void deliverOrder(String id);
	public void cancelOrder(String id);
	public OrderRepresentation lookupOrder(String id);
	public void addItem(String orderID, String PartnerID, String productID, String quantity, String Price);

}//close OrderService
