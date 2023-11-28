package Controller;

import DaoImpl.VentaDaoImpl;

import java.util.List;

import Model.Venta;
import Model.DetalleVenta;

public class VentaController {
	
	
	private VentaDaoImpl ventaDao = null;
	
	public VentaController(){
		ventaDao = new VentaDaoImpl();
	}
	
	public List<Venta> listarVentas(){
		List<Venta> listaVenta = null;
		listaVenta = ventaDao.listarVentas();
		return listaVenta;
	}
	
	public String generarNumeroFactura() {
		String ultimoNumeroVenta = obtenerUltimoNumeroFactura();
		
		if(ultimoNumeroVenta != null) {
			char letraActual = ultimoNumeroVenta.charAt(0);;
			int numeroActual = Integer.parseInt(ultimoNumeroVenta.substring(1));
			
			if(numeroActual < 999999) {
				numeroActual++;
			}
			
			else {
				numeroActual = 1;
				letraActual = (char) (letraActual + 1); // aumenta la letra en uno: A, B, C, D, E
			}
			String numeroVenta = letraActual + String.format("%06d", numeroActual);
			
			return numeroVenta;
			
		}
		else {
			return null;
		}
		
	}
	
	public int registrarVenta(String numeroVenta, int idCliente, double totalVenta, int idModoPago, int idEmpleado) {
		
		 if (numeroVenta == null || numeroVenta.isEmpty() || totalVenta <= 0 || idCliente <= 0 || idModoPago <= 0 || idEmpleado <= 0) {
		        throw new IllegalArgumentException("Los parámetros proporcionados no son válidos");
		    }

		    try {
		        Venta venta = new Venta();
		        venta.setNumero_venta(numeroVenta);
		        venta.setId_cliente(idCliente);
		        venta.setTotal(totalVenta);
		        venta.setId_modo_pago(idModoPago);
		        venta.setId_empleado(idEmpleado);

		        return ventaDao.agregarVenta(venta);
		    } catch (Exception e) {
		        // Puedes personalizar este bloque catch según tus necesidades
		        e.printStackTrace();
		        throw new RuntimeException("Error al registrar la venta", e);
		    }
	}
	
	private String obtenerUltimoNumeroFactura() {
	    return ventaDao.obtenerUltimoNumeroFactura();
	}

	private void actualizarNumeroFactura(String nuevoNumeroFactura) {
	    ventaDao.actualizarNumeroFactura(nuevoNumeroFactura);
	}


	public int obtenerIdFacturaPorNumeroFactura(String numeroFactura) {
		return ventaDao.obtenerIdFacturaPorNumeroFactura(numeroFactura);
	}	
	
	public Venta obtenerVentaPorNumeroVenta(String numeroVenta) {
		return ventaDao.obtenerVentaPorNumeroVenta(numeroVenta);
	}
}