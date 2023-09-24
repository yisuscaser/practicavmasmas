package org.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@Entity
public class Ciudadano {
	private int IDCIUDADANO;
	private String NOMBRE;
	private String APPATERNO;
	private String APPMATERNO;
	
	@Id
	@Column(nullable = false)
	@GeneratedValue

	//GETTERS AND SETTERS
	
	public int getIDCIUDADANO() {
		return IDCIUDADANO;
	}
	public void setIDCIUDADANO(int iDCIUDADANO) {
		IDCIUDADANO = iDCIUDADANO;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}
	public String getAPPATERNO() {
		return APPATERNO;
	}
	public void setAPPATERNO(String aPPATERNO) {
		APPATERNO = aPPATERNO;
	}
	public String getAPPMATERNO() {
		return APPMATERNO;
	}
	public void setAPPMATERNO(String aPPMATERNO) {
		APPMATERNO = aPPMATERNO;
	}
	
	
	

}
