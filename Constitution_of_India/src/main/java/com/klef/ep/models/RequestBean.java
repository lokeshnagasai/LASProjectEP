package com.klef.ep.models;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.klef.ep.services.RequestService;

@ManagedBean(name = "reqBean", eager = true)
public class RequestBean {
	private int Rid;
	private String Rdecpt;
	private String response;
	
	@EJB(lookup = "java:global/Constitution_of_India/RequestServiceImpl!com.klef.ep.services.RequestService")
    RequestService requestService;

	public int getRid() {
		return Rid;
	}

	public void setRid(int rid) {
		Rid = rid;
	}

	public String getRdecpt() {
		return Rdecpt;
	}

	public void setRdecpt(String rdecpt) {
		Rdecpt = rdecpt;
	}
	
	  public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

	public void insertrequest()
	  {
	    try
	    {
	      Request req=new Request();
	      req.setRID(Rid);
	      req.setRDECPT(Rdecpt);
	   
	     response =requestService.insertReqAmnd(req);
	    }
	    catch(Exception e)
	    {
	      response=e.getMessage();
	    }
	  }
}
