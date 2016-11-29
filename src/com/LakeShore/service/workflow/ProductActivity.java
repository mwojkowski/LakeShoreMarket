package com.LakeShore.service.workflow;

import com.LakeShore.Manager.ProductManager;
import com.LakeShore.service.representation.ProductRepresentation;
import com.LakeShore.Model.Product;

import java.util.*;


public class ProductActivity {
	
	private static ProductManager pManager = new ProductManager();
	
	
	public ProductActivity(){
		
	}
	
	public Set<ProductRepresentation> getProducts(){
        Set<Product> Products = new HashSet<Product>();

        Set<ProductRepresentation> ProductRepresentations = new HashSet<ProductRepresentation>();

        Products = pManager.getAllProducts();
        Iterator<Product> cIterator = Products.iterator();
        while(cIterator.hasNext()){
            Product temp = (Product)cIterator.next();
            ProductRepresentation cusRepTemp = new ProductRepresentation();
            cusRepTemp.setID(temp.getID());
            cusRepTemp.setName(temp.getName());
            cusRepTemp.setDescription(temp.getDescription());


            ProductRepresentations.add(cusRepTemp);
        }//close while loop

        return ProductRepresentations;
    }//close getProducts()
    

    public ProductRepresentation getProductById(String id){
        Product prod = pManager.getProductById(Integer.valueOf(id));

        ProductRepresentation prodRep = new ProductRepresentation();
        prodRep.setID(prod.getID());
        prodRep.setName(prod.getName());
        prodRep.setDescription(prod.getDescription());

        return prodRep;

    }//close getProductById()
    
    public ProductRepresentation getProductByName(String name){
    	Product prod = pManager.getProductByName(name);
    	ProductRepresentation prodRep = new ProductRepresentation();
    	
    	prodRep.setID(prod.getID());
    	prodRep.setName(prod.getName());
    	prodRep.setDescription(prod.getDescription());
    	prodRep.setSellerID(prod.getSellerID());
    	prodRep.setQuantity(prod.getQuantity());
    	prodRep.setPrice(prod.getPrice());;
    	
    	
    	return prodRep;
    }//close getProductByName()

    public ProductRepresentation createProduct(String name, String description, String sellerID){
        Product prod = pManager.addProduct(name, description, Integer.valueOf(sellerID));

        ProductRepresentation prodRep = new ProductRepresentation();
        
        prodRep.setID(prod.getID());
        prodRep.setName(prod.getName());
        prodRep.setDescription(prod.getDescription());

        return prodRep;
    }//close createProduct
    
    public boolean updateName(String id, String name){
    	return pManager.updateName(Integer.valueOf(id), name);
    }//close updateZip()
    
    public boolean updateDescription(String id, String description){
    	return pManager.updateDescription(Integer.valueOf(id), description);
    }//close updateZip()
    
    public boolean updateQuantity(String id, String quantity){
    	return pManager.updateQuantity(Integer.valueOf(id), Integer.valueOf(quantity));
    }//close updateQuantity
    
    public boolean updatePrice(String id, String price){
    	return pManager.updatePrice(Integer.valueOf(id), Double.valueOf(price));
    }//close updatePrice


}
