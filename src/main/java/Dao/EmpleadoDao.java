package Dao;

import java.util.List;

import Model.Empleado;

public interface EmpleadoDao {
	public Empleado buscarEmpleadoPorDni(int dniEmpleado);
	
	public String obtenerNombreEmpleadoPorId(int idEmpleado);
	
	public int agregarEmpleado(Empleado empleado);
	
	public void CambiarEstadoEmpleadoaInactivo(int idEmpleado);
	
	public void CambiarEstadoEmpleadoaActivo(int idEmpleado);

	public void modificarEmpleado(Empleado empleado);

	public List<Empleado> listarEmpleados();
	
	public Empleado obtenerEmpleadoPorId(int idEmpleado);	
}
