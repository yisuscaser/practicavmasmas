package org.service;

import java.util.List;

import org.modelo.Ciudadano;
import org.modelo.Domicilio;


public interface DomicilioService {
	public void addDomicilio(Domicilio domicilio);
	public List<Domicilio> listDomicilios(Ciudadano ciudadano);
	public Domicilio getDomicilioById(int id);
	public void deleteDomicilio(int id);

}
