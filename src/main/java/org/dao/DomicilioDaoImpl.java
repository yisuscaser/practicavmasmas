package org.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.modelo.Ciudadano;
import org.modelo.Domicilio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DomicilioDaoImpl implements DomicilioDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addDomicilio(Domicilio domicilio) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(domicilio);
		} catch (Exception e) {
			System.out.println("Exception addDomicilio: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Domicilio> listDomicilios(Ciudadano ciudadano) {
		int idCiudadano = ciudadano.getIDCIUDADANO();
		List<Domicilio> list = null;
		try {
			list = (List<Domicilio>) sessionFactory.getCurrentSession().createQuery("from Domicilio where IDCIUDADANO =:idCiudadano").setLong("idCiudadano", idCiudadano).list();
		} catch (Exception e) {
			System.out.println("Exception listDomicilios: " + e.getMessage());

		}
		return list;
	}

	@Override
	public Domicilio getDomicilioById(int id) {
		Domicilio domicilio = null;
		try {
			domicilio = (Domicilio) sessionFactory.getCurrentSession().get(Domicilio.class, id);
		} catch (Exception e) {
			System.out.println("Exception getDomicilioById: " + e.getMessage());
		}
		return domicilio;
	}

	@Override
	public void deleteDomicilio(int id) {
		Domicilio domicilio = null;
		try {
			domicilio = (Domicilio) sessionFactory.getCurrentSession().get(Domicilio.class, id);
			sessionFactory.getCurrentSession().delete(domicilio);
		} catch (Exception e) {
			System.out.println("Exception deleteCiudadano: " + e.getMessage());
		}
	}

}
