package Dao;

import java.util.List;

import Model.Guia_Salida;



public interface Guia_SalidaDao {
	public List<Guia_Salida> listarGuiaSalida();
	
	public List<Guia_Salida> listarGuiaSalidaPorIdGuia(int idGuiaSalida);
	
	public void agregarGuiaSalida(Guia_Salida guiaSalida);
}
