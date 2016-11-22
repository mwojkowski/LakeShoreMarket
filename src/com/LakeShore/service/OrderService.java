package com.LakeShore.service;

import com.LakeShore.service.representation.OrderRepresentation;
import com.LakeShore.service.representation.OrderRequest;

import javax.jws.WebService;

import java.util.Set;


public interface OrderService {
	public OrderRepresentation createOrder(String CustomerID);

}
