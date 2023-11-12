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
		
		
	}

	@Override
	public void eliminarUsuario(int idUsuario) {
		
		
	}

	@Override
	public void editarUsuario(int idUsuario) {
		
		
	}

	@Override
	public Usuario buscarUsuarioPorId(int idUsuario) {
		
		return null;
	}

}
