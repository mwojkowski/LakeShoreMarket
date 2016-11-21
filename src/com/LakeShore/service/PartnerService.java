package com.LakeShore.service;


import com.LakeShore.service.representation.CustomerRepresentation;
import com.LakeShore.service.representation.PartnerRepresentation;
import com.LakeShore.service.representation.PartnerRequest;

import javax.jws.WebService;

import java.util.Set;

public interface PartnerService {
	
	
	public Set<PartnerRepresentation> getPartners();
    public PartnerRepresentation getPartnerById(String id);
    public PartnerRepresentation createPartner(String firstName, String lastName, String company);
    public void updatePartnerAddress(String id, String address);
    public void updatePhoneNumber(String id, String phoneNumber);
    public void updateCity(String id, String city);
    public void updateState(String id, String state);
    public void updateZip(String id, String zip);
    
    
}//close interface
