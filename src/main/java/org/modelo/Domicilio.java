package org.modelo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@Entity
public class Domicilio {
	private int IDDOMICILIO;
	private int IDCIUDADANO;
	private String CALLE;
	private int NUMEXT;
	private int NUMINT;
	private String COLONIA;
	private String CP;
	private String CIUDAD;
	private String ESTADO;

	@Id
	@Column(nullable = false)
	@GeneratedValue

	// GETTERS AND SETTERS

	public int getIDDOMICILIO() {
		return IDDOMICILIO;
	}

	public void setIDDOMICILIO(int iDDOMICILIO) {
		IDDOMICILIO = iDDOMICILIO;
	}

	public int getIDCIUDADANO() {
		return IDCIUDADANO;
	}

	public void setIDCIUDADANO(int iDCIUDADANO) {
		IDCIUDADANO = iDCIUDADANO;
	}

	public String getCALLE() {
		return CALLE;
	}

	public void setCALLE(String cALLE) {
		CALLE = cALLE;
	}

	public int getNUMEXT() {
		return NUMEXT;
	}

	public void setNUMEXT(int nUMEXT) {
		NUMEXT = nUMEXT;
	}

	public int getNUMINT() {
		return NUMINT;
	}

	public void setNUMINT(int nUMINT) {
		NUMINT = nUMINT;
	}

	public String getCOLONIA() {
		return COLONIA;
	}

	public void setCOLONIA(String cOLONIA) {
		COLONIA = cOLONIA;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getCIUDAD() {
		return CIUDAD;
	}

	public void setCIUDAD(String cIUDAD) {
		CIUDAD = cIUDAD;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

}
