package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.Guia_DetalleDao;
import Model.Guia_Detalle;

public class GuiaDetalleDaoImpl implements Guia_DetalleDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public GuiaDetalleDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	@Override
	public List<Guia_Detalle> listarGuiaDetalle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Guia_Detalle> listarDetalleGuiaPorIdGuia(int idGuia) {
		List<Guia_Detalle> listaDetalle = new ArrayList<>();
	    try {
	        String consulta = "SELECT id_producto, cantidad FROM guia_detalle WHERE id_guia = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idGuia);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {	        	 
	            int idProducto = resultSet.getInt("id_producto"); // Corregir el nombre de la columna
	            int cantidad = resultSet.getInt("cantidad");

	            Guia_Detalle detalle = new Guia_Detalle();
	            detalle.setId_producto(idProducto);
	            detalle.setCantidad(cantidad);

	            listaDetalle.add(detalle);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listaDetalle;
	}

	@Override
	public void agregarDetalleGuia(Guia_Detalle detalleguia) {
		try {
	        String consulta = "INSERT INTO guia_detalle (id_guia, id_producto, cantidad) VALUES (?, ?, ?)";
	        statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1, detalleguia.getId_guia());
	        statement.setInt(2, detalleguia.getId_producto());
	        statement.setInt(3, detalleguia.getCantidad());
	        
	        System.out.println("Query: " + statement.toString());
	        
	        statement.executeUpdate(); // Cambiado de executeQuery a executeUpdate
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
