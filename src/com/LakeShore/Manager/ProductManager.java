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
    
    public void updateName(int id, String name){
    	dao.updateName(id, name);
    	
    }//close updateProduct Address
    
    public void updateDescription(int id, String description){
    	dao.updateName(id, description);
    	
    }//close updateProduct Address

    
    public void deleteProduct(int id){
    	dao.deleteProduct(id);
    }//close deleteProduct

	
	
}
