package com.klef.ep.models;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="GOILogin")
public class GOILogin implements Serializable{
 

  private static final long serialVersionUID = 1L;
  @Id  
  @Column(name="oficial_govtid")
    private int GID;
  @Column(name="Govt_EmpName")
    private String GEMPNAME;  
  @Column(name="Password")
  private String GPWD;
public int getGID() {
	return GID;
}
public void setGID(int gID) {
	GID = gID;
}
public String getGEMPNAME() {
	return GEMPNAME;
}
public void setGEMPNAME(String gEMPNAME) {
	GEMPNAME = gEMPNAME;
}
public String getGPWD() {
	return GPWD;
}
public void setGPWD(String gPWD) {
	GPWD = gPWD;
}
  
}