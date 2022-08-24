package com.klef.ep.models;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="admendment")
public class Request implements Serializable
{
	 private static final long serialVersionUID = 1L;

		@Id
		@Column(name="Request_id")
		 private int RID;
		    
		@Column(name="Amendment_description")
	    private String RDECPT;

	   
		public int getRID() {
			return RID;
		}

		public void setRID(int rID) {
			RID = rID;
		}

		public String getRDECPT() {
			return RDECPT;
		}

		public void setRDECPT(String rDECPT) {
			RDECPT = rDECPT;
		}

		
	   
}
