package Dao;

import java.util.List;

import Model.Contrato;

public interface ContratoDao {
	
	public List<Contrato> listarContratos();
	
	public void agregaPlanilla(Contrato contrato);
	
	public Contrato obtenerContratoPorIdEmpleado(int idEmpleado);
	
	public void actualizarSueldo(Contrato contrato);
}