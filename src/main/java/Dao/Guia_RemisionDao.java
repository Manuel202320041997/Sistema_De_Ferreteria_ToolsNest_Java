package Dao;

import java.util.List;

import Model.Guia_Remision;

public interface Guia_RemisionDao {
public List<Guia_Remision> listarGuiaRemision();
	
	public List<Guia_Remision> listarGuiaRemisionPorIdGuia(int idGuiaRemision);
	
	public void agregarGuiaRemision(Guia_Remision guiaRemision);
}
