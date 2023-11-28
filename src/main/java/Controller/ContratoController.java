package Controller;

import java.util.ArrayList;

import java.util.List;

import Dao.ContratoDao;

import DaoImpl.ContratoDaoImpl;

import Model.Contrato;

public class ContratoController {
	private ContratoDao contratodao = null;
	
	public ContratoController() {
		 contratodao = new ContratoDaoImpl();
	}

	public void agregarPlanilla(Contrato contrato) {
	    try {
	        Contrato contratobeneficio = calcularBeneficiosContrato(contrato);
	        System.out.println(contratobeneficio);
	        contratodao.agregaPlanilla(contratobeneficio);
	    } catch (Exception e) {
	        e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
	    }
	}

	private Contrato calcularBeneficiosContrato(Contrato contrato) {
	    Double sueldoMensualContrato = contrato.getSueldo_mensual();

	    /*GRATIFICACION*/
	    Double sueldoMultiplicado = sueldoMensualContrato * 6;
	    Double gratificacion = sueldoMultiplicado / 12;
	    contrato.setGratificacion(gratificacion);

	    /*CTS*/
	    Double ctsCalculado = sueldoMensualContrato * (1.0 / 6.0);
	    contrato.setCts(ctsCalculado);

	    return contrato;
	}
	
	
	public List<Contrato> listarContrato() {
		
		 List<Contrato> listaContratos = contratodao.listarContratos();

		    // Manejar el caso en el que contratodao.listarContratos() devuelve null
		    if (listaContratos == null) {
		        listaContratos = new ArrayList<>(); // o cualquier otra implementación de List que prefieras
		    }

		    // Imprimir los datos en la consola
		    for (Contrato contrato : listaContratos) {
		        System.out.println("ID Empleado: " + contrato.getId_empleado());
		        System.out.println("Sueldo Mensual: " + contrato.getSueldo_mensual());
		        // Agrega más líneas según los campos que quieras imprimir
		        System.out.println("Fecha de Registro: " + contrato.getFecha_registro());
		        System.out.println("-------------------------------------");
		    }

		    return listaContratos;
	    
    }
	
	public Contrato obtenerContratoPorIdEmpleado(int idEmpleado) {
		if(idEmpleado <= 0) {
			System.err.println("id empleado es menor o igual a 0");
		}
		else {
			return contratodao.obtenerContratoPorIdEmpleado(idEmpleado);
		}
		return null;
	}
	
	public void actualizarSueldo(Contrato contrato) {
		Contrato contratoSueldoActualizado = calcularBeneficiosContrato(contrato);
		
		contratodao.actualizarSueldo(contratoSueldoActualizado);
	}
}
	

