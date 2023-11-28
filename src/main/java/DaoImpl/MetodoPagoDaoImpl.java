package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.MetodoPagoDao;
import Model.MetodoPago;

public class MetodoPagoDaoImpl implements MetodoPagoDao{
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public MetodoPagoDaoImpl(){    	
    	this.conexion = Conexion.obtenerConexion();
    }
	
	@Override
	public List<MetodoPago> listarMetodoPago() {
		List<MetodoPago> listaMetodoPago = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM modo_pago";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("descripcion");
				boolean estado = resultSet.getBoolean("estado");
				
				MetodoPago metodopago = new MetodoPago();
				metodopago.setId(id);
				metodopago.setDescripcion(nombre);
				metodopago.setEstado(estado);
				
				listaMetodoPago.add(metodopago);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaMetodoPago;
	}

	@Override
	public int obtenerIdMetodoPagoPorNombre(String nombreMetodoPago) {
		 try {
		        String consulta = "SELECT id FROM modo_pago WHERE descripcion = ?";
		        statement = conexion.prepareStatement(consulta);
		        statement.setString(1, nombreMetodoPago);

		        try (ResultSet resultSet = statement.executeQuery()) {
		            if (resultSet.next()) {
		                return resultSet.getInt("id");
		            }
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Considera lanzar una excepción personalizada aquí para manejar errores de base de datos.
		    }
		    return 0;
	}

	@Override
	public String obtenerNombreMetodoPagoPorId(int idMetodoPago) {
		try {
			String consulta = "SELECT descripcion FROM modo_pago WHERE id = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setInt(1, idMetodoPago); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {
		    	return resultSet.getString("descripcion");			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

}
