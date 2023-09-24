package org.service;

import java.util.List;

import org.dao.CiudadanoDao;
import org.dao.DomicilioDao;
import org.modelo.Ciudadano;
import org.modelo.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DomicilioServiceImpl implements DomicilioService {
	@Autowired
	private DomicilioDao dao;

	@Transactional
	public void addDomicilio(Domicilio domicilio) {
		dao.addDomicilio(domicilio);
	}

	@Transactional
	public List<Domicilio> listDomicilios(Ciudadano ciudano) {
		return dao.listDomicilios(ciudano);
	}

	@Transactional
	public Domicilio getDomicilioById(int id) {
		return dao.getDomicilioById(id);
	}

	@Transactional
	public void deleteDomicilio(int id) {
		dao.deleteDomicilio(id);	
	}
}
