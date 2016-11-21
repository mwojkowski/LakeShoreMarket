package com.LakeShore.Manager;

import com.LakeShore.DAO.*;
import com.LakeShore.Model.Partner;

import java.util.*;


public class PartnerManager {
	public static PartnerDAO dao = new PartnerDAO();

    public PartnerManager(){

    }//close underloaded Constructor


    public Partner addPartner(String firstName, String lastName, String company){
        Partner x = dao.addPartner(firstName, lastName, company);
        
        return x;
    }//close class

    public Set<Partner> getAllPartners(){

        return dao.getAllPartners();
    }//close getAllCustomers()

    public Partner getPartnerById(int id){

        return dao.getPartnerById(id);
    }//close getCustomerById()
    
    public void updatePartnerAddress(int id, String address){
    	dao.updatePartnerAddress(id, address);
    	
    }//close updateCustomer Address
    
    public void updatePhoneNumber(int id, String phoneNumber){
    	dao.updatePhoneNumber(id,  phoneNumber);
    }//close updatePhoneNumber()
    
    public void updateCity(int id, String city){
    	dao.updateCity(id, city);
    }//close updateCity()
    
    public void updateState(int id, String state){
    	dao.updateState(id, state);
    }//close updateState()
    
    public void updateZip(int id, String zip){
    	dao.updateZip(id, zip);
    }//close updateZip()
    
    
}
