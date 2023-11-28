package DaoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.CargoDao;
import Model.Cargo;

public class CargoDaoImpl implements CargoDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public CargoDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	@Override
	public List<Cargo> listarCargo() {
		List<Cargo> listarCargo = new ArrayList<>();
		
		try {
			String consulta = "SELECT * FROM cargo";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String descripcion = resultSet.getString("descripcion");
				
				Cargo cargo = new Cargo();
				cargo.setId(id);
				cargo.setDescripcion(descripcion);
				
				listarCargo.add(cargo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarCargo;
	}

	@Override
	public int obtenerIdCargoPorNombre(String nombreCargo) {
		int idCargo = 0;
	    try {
	        String consulta = "SELECT id FROM cargo WHERE descripcion = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setString(1, nombreCargo); // Corregir el índice aquí
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            idCargo = resultSet.getInt("id"); // Corregir aquí, usar el nombre de la columna
	            return idCargo;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Asegúrate de cerrar el ResultSet y el PreparedStatement en la sección "finally"
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return 0;
	}
	

	@Override
	public String obtenerNombreCargoPorId(int idCargo) {
		String nombreCargo = null;
		
		try {
			String consulta = "SELECT descripcion FROM cargo WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idCargo);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				nombreCargo = resultSet.getString("descripcion");
				return nombreCargo;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
	        // Asegúrate de cerrar el ResultSet y el PreparedStatement en la sección "finally"
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		 return null;
	}
	

}
