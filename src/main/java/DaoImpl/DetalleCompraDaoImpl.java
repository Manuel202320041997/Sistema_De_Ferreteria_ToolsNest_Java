package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.DetalleCompraDao;
import Model.DetalleCompra;
import Model.DetalleVenta;

public class DetalleCompraDaoImpl implements DetalleCompraDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public DetalleCompraDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	
	@Override
	public List<DetalleCompra> listarDetalleCompra() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetalleCompra> listarDetalleCompraPorIdCompra(int idCompra) {
		List<DetalleCompra> listaDetalle = new ArrayList<>();
	    try {
	        String consulta = "SELECT id_producto, cantidad, precio_compra FROM detalle_compra WHERE id_compra = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idCompra);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int idProducto = resultSet.getInt("id_producto"); // Corregir el nombre de la columna
	            int cantidad = resultSet.getInt("cantidad");
	            double precio_compra = resultSet.getDouble("precio_compra");

	            DetalleCompra detalle = new DetalleCompra();
	            detalle.setId_producto(idProducto);
	            detalle.setCantidad(cantidad);
	            detalle.setPrecio_compra(precio_compra);

	            listaDetalle.add(detalle);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listaDetalle;
	}


	/*@Override
	public DetalleCompra obtenerDetallePorNumeroCompra(int idCompra) {
		List<DetalleCompra> listarDetalle = new ArrayList<>();
	    try {
	        String consulta = "SELECT id_producto, cantidad, precio_compra FROM detalle_compra WHERE id_compra = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idCompra);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            // Dentro del bucle, se procesan todas las filas
	            int idProducto = resultSet.getInt("id_producto");
	            int cantidad = resultSet.getInt("cantidad");
	            double precioUnitario = resultSet.getDouble("precio_compra");

	            // Crear un objeto DetalleVenta para cada fila y agregarlo a la lista
	            DetalleCompra detalle = new DetalleCompra();
	            detalle.setId_producto(idProducto);
	            detalle.setCantidad(cantidad);
	            detalle.setPrecio_compra(precioUnitario);

	            listarDetalle.add(detalle);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listarDetalle;
	}*/

	@Override
	public void agregarDetalleCompra(DetalleCompra detallecompra) {
	    try {
	        String consulta = "INSERT INTO detalle_compra (id_compra, id_producto, cantidad, precio_compra) VALUES (?, ?, ?, ?)";
	        statement = conexion.prepareStatement(consulta);
	        
	     // Imprimir valores antes de la inserción
	        System.out.println("Detalles de la compra a agregar:");
	        System.out.println("ID Compra: " + detallecompra.getId_compra());
	        System.out.println("ID Producto: " + detallecompra.getId_producto());
	        System.out.println("Cantidad: " + detallecompra.getCantidad());
	        System.out.println("Precio Compra: " + detallecompra.getPrecio_compra());
	        
	        statement.setInt(1, detallecompra.getId_compra());
	        statement.setInt(2, detallecompra.getId_producto());
	        statement.setInt(3, detallecompra.getCantidad());
	        statement.setDouble(4, detallecompra.getPrecio_compra());
	        
	        System.out.println("Query: " + statement.toString());
	        
	        statement.executeUpdate(); // Cambiado de executeQuery a executeUpdate
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
