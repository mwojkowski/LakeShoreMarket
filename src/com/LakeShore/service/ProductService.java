package com.LakeShore.service;

import com.LakeShore.service.representation.ProductRepresentation;
import com.LakeShore.service.representation.ProductRequest;


import javax.jws.WebService;

import java.util.Set;


public interface ProductService {

	public Set<ProductRepresentation> getProducts();
	public ProductRepresentation getProductById(String id);
	public ProductRepresentation createProduct(String name, String description);
	public void updateName(String id, String name);
	public void updateDescription(String id, String description);
	
}//close interface