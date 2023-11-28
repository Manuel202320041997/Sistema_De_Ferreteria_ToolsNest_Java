package DaoImpl;
import java.util.List;

import javax.swing.JComboBox;


import Dao.Conexion;
import Dao.DetalleVentaDao;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Controller.VentaController;
import Model.DetalleVenta;

public class DetalleVentaDaoImpl implements DetalleVentaDao{
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public DetalleVentaDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};

	@Override
	public List<DetalleVenta> listarDetalleVenta() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public void agregarDetalleVenta(DetalleVenta detalle) {
		 try {
		        String consulta = "INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_venta) VALUES (?, ?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta);

		        statement.setInt(1, detalle.getId_venta());
		        statement.setInt(2, detalle.getId_producto());
		        statement.setInt(3, detalle.getCantidad());
		        statement.setDouble(4, detalle.getPrecio_venta());

		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	

	@Override
	public List<DetalleVenta> listarDetalleVentaPorIdVenta(int idFactura) {
		List<DetalleVenta> listaDetalleVenta = new ArrayList<>();
		
		try {
	        String consulta = "SELECT * FROM detalle_venta WHERE id_venta = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idFactura);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            int id_producto = resultSet.getInt("id_producto"); // Corregir el nombre de la columna
	            int cantidad = resultSet.getInt("cantidad");
	            double precio_venta = resultSet.getDouble("precio_venta");
	            
	            DetalleVenta detalle = new DetalleVenta();
	            detalle.setId_producto(id_producto);
	            detalle.setCantidad(cantidad);
	            detalle.setPrecio_venta(precio_venta);
	            listaDetalleVenta.add(detalle);
	        }
	}
		catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listaDetalleVenta;
	}

}

   
