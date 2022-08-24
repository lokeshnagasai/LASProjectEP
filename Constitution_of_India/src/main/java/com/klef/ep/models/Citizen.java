package com.klef.ep.models;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="CitizenLoginDetails")
public class Citizen implements Serializable
{
	 private static final long serialVersionUID = 1L;
	 
	 @Column(name="Citizen_Name")
	 private String ICName;
	
	@Column(name="Citizen_Gender")
    private String ICGender;
	    
	@Column(name="Citizen_MobileNumber")
    private String ICMobileNo;
	
	@Column(name="Citizen_State")
    private String ICState;
	    
	    
	    @Id
	    @Column(name="Citizen_AadhaarNumber")
	    private int ICAadhaar;
	    

	    @Column(name="Citizen_Email")
	    private String ICEmail;
	    
	    @Column(name="Citizen_Passwords")
	    private String ICPwd;
		
		
		
		public String getICName() {
			return ICName;
		}

		public void setICName(String iCName) {
			ICName = iCName;
		}

		public String getICState() {
			return ICState;
		}

		public void setICState(String iCState) {
			ICState = iCState;
		}

		public String getICGender() {
			return ICGender;
		}

		public void setICGender(String iCGender) {
			ICGender = iCGender;
		}

		public String getICMobileNo() {
			return ICMobileNo;
		}

		public void setICMobileNo(String iCMobileNo) {
			ICMobileNo = iCMobileNo;
		}

		public String getICEmail() {
			return ICEmail;
		}

		public void setICEmail(String iCEmail) {
			ICEmail = iCEmail;
		}

		public String getICPwd() {
			return ICPwd;
		}

		public void setICPwd(String iCPwd) {
			ICPwd = iCPwd;
		}

		public int getICAadhaar() {
			return ICAadhaar;
		}

		public void setICAadhaar(int iCAadhaar) {
			ICAadhaar = iCAadhaar;
		}

	   
}
