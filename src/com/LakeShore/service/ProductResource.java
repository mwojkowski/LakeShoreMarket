package com.LakeShore.service;

import com.LakeShore.service.workflow.ProductActivity;
import com.LakeShore.service.workflow.ProductActivity;
import com.LakeShore.service.representation.ProductRepresentation;
import com.LakeShore.service.representation.ProductRepresentation;

import javax.ws.rs.Path;import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.HeaderParam;
import java.util.Set;

@Path("/ProductService/")
public class ProductResource implements ProductService {
	
	@GET
    //@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/")
    public Set<ProductRepresentation> getProducts(){
    	System.out.println("GET Request for all Products.....");
        ProductActivity prodActivity = new ProductActivity();
        return prodActivity.getProducts();
    }//close getProducts()
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/Products/{id}")
    public ProductRepresentation getProductById(@PathParam("id") String id){
    	System.out.println("GET Request for Product with id: " + id + ".....");
    	ProductActivity prodActivity = new ProductActivity();
    	return prodActivity.getProductById(Integer.valueOf(id));
    }//close getProductById()
    
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/Products/")
	public ProductRepresentation createProduct(@HeaderParam("Name") String name, @HeaderParam("Description") String description){
    	System.out.println("PUT Request for Product with name: " + name + ".....");
    	ProductActivity prodActivity = new ProductActivity();
    	return prodActivity.createProduct(name, description);
    	
    }//close addProduct
    
    
    //PUT Request to update a user's address based on the parameter given in the header
    @PUT
    @Path("/Products/name/")
    public void updateName(@HeaderParam("id") String id, @HeaderParam("Name") String name){
    	System.out.println("PUT Request for product id: " + id + ". Update name to: " + name + "....");
    	ProductActivity prodActivity = new ProductActivity();
    	
    	prodActivity.updateName(id,  name);
    	System.out.println("SUCCESS");
    	
    }//close updateName()
    
  //PUT Request to update a user's address based on the parameter given in the header
    @PUT
    @Path("/Products/name/")
    public void updateDescription(@HeaderParam("id") String id, @HeaderParam("Description") String description){
    	System.out.println("PUT Request for user id: " + id + ". Update address to: " + description + "....");
    	ProductActivity prodActivity = new ProductActivity();
    	
    	prodActivity.updateName(id, description);
    	System.out.println("SUCCESS");
    	
    }//close updateDescription()
	
	

}
