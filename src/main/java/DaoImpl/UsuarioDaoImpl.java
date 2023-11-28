package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.UsuarioDao;
import Model.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public UsuarioDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
	@Override
	public List<Usuario> listarUsuario() {
		List<Usuario> listarUsuario = new ArrayList<>();
		
		try {
			String consulta = "SELECT * FROM usuario";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				/*Obtenemos datos de la base de datos y los almacenamos en variables*/
				int id = resultSet.getInt("id");
				int dni_empleado = resultSet.getInt("dni_empleado");
				String nombre = resultSet.getString("nombre");				
				String clave = resultSet.getString("clave");
				int rol = resultSet.getInt("rol");
				Boolean estado = resultSet.getBoolean("estado");
				
				Usuario usuario = new Usuario();
				usuario.setId(id);
				usuario.setDni(dni_empleado);
				usuario.setNombre(nombre);				
				usuario.setClave(clave);
				usuario.setId_rol(rol);
				usuario.setEstado(estado);
				
				listarUsuario.add(usuario);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listarUsuario;
	}

	@Override
	public void agregarUsuario(Usuario usuario) {
		try {
			String consulta = "INSERT INTO usuario (dni_empleado, nombre, clave, rol) VALUES (?, ?, ?, ?)";
			statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1, usuario.getDni());
	        statement.setString(2, usuario.getNombre());	        
	        statement.setString(3, usuario.getClave());	
	        statement.setInt(4, usuario.getId_rol());
	        statement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean verificarSiExisteDni(int dniUsuario) {
	    try {
	        String consulta = "SELECT COUNT(*) FROM empleado WHERE dni = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, dniUsuario);

	        ResultSet resultSet = statement.executeQuery();
	        resultSet.next();

	        return resultSet.getInt(1) > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false; 
	    }
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		try {
			String consulta = "UPDATE usuario SET estado = 0 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idUsuario);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void editarUsuario(Usuario usuario) {
		try {
			String consulta = "UPDATE usuario SET nombre = ?, clave = ?, rol = ? WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getClave());
			statement.setInt(3, usuario.getId_rol());
			statement.setInt(4, usuario.getId());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Usuario buscarUsuarioPorDni(int dniUsuario) {
		Usuario usuario = null;
		
		try {
			String consulta = "SELECT * FROM usuario WHERE dni_empleado = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, dniUsuario);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("id");
				int dni = resultSet.getInt("dni_empleado");
				String nombre = resultSet.getString("nombre");
				String clave = resultSet.getString("clave");
				int rol = resultSet.getInt("rol");
				
				usuario = new Usuario();
				
				usuario.setId(id);
				usuario.setDni(dni);
				usuario.setNombre(nombre);
				usuario.setClave(clave);
				usuario.setId_rol(rol);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public void CambiarEstadoInactivo(int id) {
		try {
			String consulta = "UPDATE usuario SET estado = 0 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void CambiarEstadoActivo(int id) {
		try {
			String consulta = "UPDATE usuario SET estado = 1 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
