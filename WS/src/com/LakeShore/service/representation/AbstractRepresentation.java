package com.LakeShore.service.representation;

import com.LakeShore.Model.Link;

import java.util.*;

import javax.xml.bind.annotation.XmlElement;

public abstract class AbstractRepresentation {
	
	@XmlElement(name="Link", namespace = "")
	protected List<Link> links;
	
	
	
	public List<Link> getLinks(){
		return links;
	}
	
	public void setLinks(Link...links){
		this.links = Arrays.asList(links);
	}
	
	public void addLinks(Link link){
		links.add(link);
	}
	
}//close class
