package Controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DaoImpl.DetalleVentaDaoImpl;
import Controller.VentaController;
import Model.DetalleVenta;


public class DetalleVentaController {
private DetalleVentaDaoImpl detalleventaDaoImpl = null;
private VentaController ventaController;
//private CategoriaController categoriaController = new CategoriaController();
    
    public DetalleVentaController(){
        detalleventaDaoImpl = new DetalleVentaDaoImpl();
        ventaController = new VentaController();
    }
    
    public List<DetalleVenta> listarDetalleVenta(){
    	List<DetalleVenta> listarDetalleVenta = null;
    	listarDetalleVenta = detalleventaDaoImpl.listarDetalleVenta();
    	return listarDetalleVenta;
    }
    
    public List<DetalleVenta> listarDetalleVentaPorNumeroFactura(String numeroFactura){
    	 List<DetalleVenta> listarDetalleVenta = new ArrayList<>();
    	    int idFactura = ventaController.obtenerIdFacturaPorNumeroFactura(numeroFactura);

    	    if (idFactura > 0) {
    	        listarDetalleVenta = detalleventaDaoImpl.listarDetalleVentaPorIdVenta(idFactura);
    	    } else {
    	        System.err.println("ERROR AL LISTAR EL DETALLE. ID DE FACTURA NO ENCONTRADO PARA EL NÚMERO DE FACTURA: " + numeroFactura);
    	        // Puedes lanzar una excepción aquí si prefieres manejar el error de esta manera.
    	    }

    	    return listarDetalleVenta;
    }
    
    public Map<String, Double> calcularVenta(String clienteSeleccionado, List<DetalleVenta> detalleProductos) {

    	//System.out.println("Datos recibidos en el controlador:");
        //System.out.println("Cliente Seleccionado: " + clienteSeleccionado);
        //System.out.println("Detalle de Productos: " + detalleProductos);
    	
    	//System.out.println("Entrando en calcularVenta"); // Mensaje de entrada para verificar que se está ejecutando
    	    double subTotal = 0;
    	    double descuento = 0;
    	    double igv = 0;
    	    double totalPagar = 0;

    	    for (DetalleVenta detalle : detalleProductos) {
    	    	
    	  //  	System.out.println("ID del Producto: " + detalle.getId_producto());
    	    //    System.out.println("Cantidad: " + detalle.getCantidad());
    	     //   System.out.println("Precio Unitario: " + detalle.getPrecioUnitario());
    	        double precioUnitario = detalle.getPrecio_venta();
    	        int cantidad = detalle.getCantidad();
    	        subTotal += precioUnitario * cantidad;
    	    }

    	    //System.out.println("Subtotal: " + subTotal); // Mensaje para verificar el valor del subtotal

    	    if (subTotal >= 500 && subTotal < 1000) {
    	        descuento = subTotal * 0.05;
    	    } else if (subTotal >= 1000 && subTotal <= 1500) {
    	        descuento = subTotal * 0.07;
    	    } else if (subTotal >= 1500) {
    	        descuento = subTotal * 0.10;
    	    }

    	    //System.out.println("Descuento: " + descuento); // Mensaje para verificar el valor del descuento

    	    igv = (subTotal - descuento) * 0.18;
    	    totalPagar = subTotal - descuento + igv;
    	    
    	    //DecimalFormat df = new DecimalFormat("#.##");
    	    
    	    double igvRedondeado = Math.round(igv * 100.0) / 100.0;
    	    double totalPagarRedondeado = Math.round(totalPagar * 100.0) / 100.0;
    	    
    	    // Resto del código

    	    Map<String, Double> resultados = new HashMap<>();
    	    resultados.put("subTotal", subTotal);
    	    resultados.put("descuento", descuento);
    	    resultados.put("igv", igvRedondeado);
    	    resultados.put("totalPagar", totalPagarRedondeado);

    	    return resultados;
    }    
        
    public void registrarDetalleVenta(DetalleVenta detalleventa) {
		
		detalleventaDaoImpl.agregarDetalleVenta(detalleventa);
    }
    
    
}