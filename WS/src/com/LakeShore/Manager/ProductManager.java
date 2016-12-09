package com.LakeShore.Manager;


import com.LakeShore.DAO.ProductDAO;

import com.LakeShore.Model.Product;

import java.util.*;

public class ProductManager {
	public static ProductDAO dao = new ProductDAO();

    public ProductManager(){

    }//close underloaded Constructor


    public Product addProduct(String name, String description, int sellerID){
        Product x = dao.addProduct(name, description, sellerID);
        
        return x;
    }//close class

    public Set<Product> getAllProducts(){

        return dao.getAllProducts();
    }//close getAllProducts()

    public Product getProductById(int id){

        return dao.getProductById(id);
    }//close getProductById()
    
    public Set<Product> getProductByName(String name){
    	return dao.getProductByName(name);
    }
    
    public boolean updateName(int id, String name){
    	return dao.updateName(id, name);
    	
    }//close updateProduct Address
    
    public boolean updateDescription(int id, String description){
    	return dao.updateName(id, description);
    	
    }//close updateProduct Address

    public boolean deleteProduct(int id){
    	return dao.deleteProduct(id);
    }//close deleteProduct
    
    public boolean updateQuantity(int id, int quantity){
    	return dao.updateQuantity(id, quantity);
    }
    
    public boolean updatePrice(int id, double price){
    	return dao.updatePrice(id, price);
    }

	
	
}
