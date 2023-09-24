package org.service;

import java.util.List;

import org.dao.CiudadanoDao;
import org.modelo.Ciudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceImpl implements CiudadanoService {
	@Autowired
	private CiudadanoDao dao;
	
	@Transactional
	public void addCiudadano(Ciudadano ciudadano) {
		dao.addCiudadano(ciudadano);
	}

	@Transactional
	public List<Ciudadano> listCiudadanos() {
		return dao.listCiudadanos();
	}

	@Transactional
	public Ciudadano getCiudadanoById(int id) {
		return dao.getCiudadanoById(id);
	}

	@Transactional
	public void deleteCiudadano(int id) {
		dao.deleteCiudadano(id);	
	}
}
