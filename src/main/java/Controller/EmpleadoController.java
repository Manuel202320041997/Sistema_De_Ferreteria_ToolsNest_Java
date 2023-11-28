package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.EmpleadoDao;
import DaoImpl.EmpleadoDaoImpl;
import Model.Empleado;

public class EmpleadoController {
	private EmpleadoDao empleadodao = null;
	
	public EmpleadoController() {
		empleadodao = new EmpleadoDaoImpl();
	}
	
	public Empleado buscarEmpleadoPorDni(int dniEmpleado) {
		return empleadodao.buscarEmpleadoPorDni(dniEmpleado);
	}
	
	public int agregarEmpleado(Empleado empleado) {
		try {
			return empleadodao.agregarEmpleado(empleado);
	   	    } catch (Exception e) {
	   	        e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
	   	        return -1;
	   	    }
	}
	
	public void modificarEmpleado(Empleado empleado) {
		try {
			empleadodao.modificarEmpleado(empleado);
		} catch (Exception e) {
			System.err.println("Error al editar Empleado: "+ e.getMessage());
		}
	}
	
	public List<Empleado> listarEmpleados() {
        List<Empleado> listaEmpleado = empleadodao.listarEmpleados();

        if (listaEmpleado == null) {
            listaEmpleado = new ArrayList<>(); // o cualquier otra implementación de List que prefieras
        }
		return listaEmpleado;
    }
	
	public void cambiarEstadoEmpleadoaInactivo(int idEmpleado) {
		empleadodao.CambiarEstadoEmpleadoaInactivo(idEmpleado);
		
	}
	public void cambiarEstadoEmpleadoaActivo(int idEmpleado) {
		empleadodao.CambiarEstadoEmpleadoaActivo(idEmpleado);
	}
	
	public String obtenerNombreEmpleadoPorId(int idEmpleado) {
		return empleadodao.obtenerNombreEmpleadoPorId(idEmpleado);
	}
	
	public Empleado obtenerEmpleadoPorId(int idEmpleado) {
		return empleadodao.obtenerEmpleadoPorId(idEmpleado);
	}
}
