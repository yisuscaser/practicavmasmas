package org.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.modelo.Ciudadano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CiudadanoDaoImpl implements CiudadanoDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCiudadano(Ciudadano ciudadano) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(ciudadano);
		} catch (Exception e) {
			System.out.println("Exception addCiudadano: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudadano> listCiudadanos() {
		List<Ciudadano> list = null;
		try {
			list = (List<Ciudadano>) sessionFactory.getCurrentSession().createQuery("from Ciudadano").list();
		} catch (Exception e) {
			System.out.println("Exception listCiudadanos: " + e.getMessage());

		}
		return list;
	}

	@Override
	public Ciudadano getCiudadanoById(int id) {
		Ciudadano ciudadano = null;
		try {
			ciudadano = (Ciudadano) sessionFactory.getCurrentSession().get(Ciudadano.class, id);
		} catch (Exception e) {
			System.out.println("Exception getCiudadanoById: " + e.getMessage());
		}
		return ciudadano;
	}

	@Override
	public void deleteCiudadano(int id) {
		Ciudadano ciudadano = null;
		try {
			ciudadano = (Ciudadano) sessionFactory.getCurrentSession().get(Ciudadano.class, id);
			sessionFactory.getCurrentSession().delete(ciudadano);
		} catch (Exception e) {
			System.out.println("Exception deleteCiudadano: " + e.getMessage());
		}
	}

}
