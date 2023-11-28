package Dao;

import java.util.List;

import Model.Guia_Ingreso;
import Model.Guia_Salida;

public interface Guia_IngresoDao {
	public List<Guia_Ingreso> listarGuiaIngreso();
	
	public List<Guia_Ingreso> listarGuiaIngresoIdGuia(int idGuiaIngreso);
	
	public void agregarGuiaIngreso(Guia_Ingreso guiaIngreso);
}