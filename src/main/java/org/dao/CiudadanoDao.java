package org.dao;

import java.util.List;

import org.modelo.Ciudadano;

public interface CiudadanoDao {
	public void addCiudadano(Ciudadano ciudadano);
	public List<Ciudadano> listCiudadanos();
	public Ciudadano getCiudadanoById(int id);
	public void deleteCiudadano(int id);
}
