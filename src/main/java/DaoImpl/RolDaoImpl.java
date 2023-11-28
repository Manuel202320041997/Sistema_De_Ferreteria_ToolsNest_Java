package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.RolDao;
import Model.Rol;

public class RolDaoImpl implements RolDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public RolDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	@Override
	public List<Rol> listarRol() {
		List<Rol> listarRol = new ArrayList<>();
		
		try {
			String consulta = "SELECT * FROM rol";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String descripcion = resultSet.getString("descripcion");
				
				Rol rol = new Rol();
				rol.setId(id);
				rol.setDescripcion(descripcion);
				
				listarRol.add(rol);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listarRol;
	}

	@Override
	public int obtenerIdRolPorNombre(String nombreRol) {
		int idRol = 0;
	    try {
	        String consulta = "SELECT id FROM rol WHERE descripcion = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setString(1, nombreRol); // Corregir el índice aquí
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            idRol = resultSet.getInt("id"); // Corregir aquí, usar el nombre de la columna
	            return idRol;
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
	public String obtenerNombreRolPorId(int idRol) {
		String nombreRol = null;
		
		try {
			String consulta = "SELECT descripcion FROM rol WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idRol);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				nombreRol = resultSet.getString("descripcion");
				return nombreRol;
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
