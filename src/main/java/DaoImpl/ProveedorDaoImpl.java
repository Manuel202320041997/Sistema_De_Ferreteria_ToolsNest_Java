package DaoImpl;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.Conexion;
import Dao.ProveedorDao;
import Model.Proveedor;

public class ProveedorDaoImpl implements ProveedorDao {
	
	private PreparedStatement statement = null;
	private Connection conexion;
	
	public ProveedorDaoImpl() {
		this.conexion = Conexion.obtenerConexion();
	}
	
	@Override
	public List<Proveedor> listarProveedor() {
		List<Proveedor> listaProveedor = new ArrayList<>();
		
		try {
			String consulta = "SELECT * FROM proveedor";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String razon_social = resultSet.getString("razon_social");
				String telefono = resultSet.getString("telefono");
				String direccion = resultSet.getString("direccion");
				String correo = resultSet.getString("correo");
				boolean estado = resultSet.getBoolean("estado");
				
				Proveedor proveedor = new Proveedor();
				
				proveedor.setId(id);
				proveedor.setRazon_social(razon_social);
				proveedor.setTelefono(telefono);
				proveedor.setDireccion(direccion);
				proveedor.setCorreo(correo);
				proveedor.setEstado(estado);
				
				listaProveedor.add(proveedor);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaProveedor;
	}

	@Override
	public void agregarProveedor(Proveedor proveedor) {
		try {
			String consulta = "INSERT INTO proveedor (razon_social, telefono, direccion, correo) VALUES (?, ?, ?, ?)";
			statement = conexion.prepareStatement(consulta);
			
			statement.setString(1, proveedor.getRazon_social());
			statement.setString(2, proveedor.getTelefono());
			statement.setString(3, proveedor.getDireccion());
			statement.setString(4, proveedor.getCorreo());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void eliminarProveedor(int idProveedor) {
		try {
			String consulta = "UPDATE proveedor SET estado = 0 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idProveedor);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void editarProveedor(Proveedor proveedor) {
		try {
			String consulta = "UPDATE proveedor SET razon_social = ?, telefono = ?, direccion = ?, correo = ? WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, proveedor.getRazon_social());
			statement.setString(2, proveedor.getTelefono());
			statement.setString(3, proveedor.getDireccion());
			statement.setString(4, proveedor.getCorreo());			
			statement.setInt(5, proveedor.getId());
			
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Proveedor buscarProveeedorPorId(int idProveedor) {
		Proveedor proveedor = null;
		try {
			String consulta = "SELECT * FROM proveedor WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idProveedor);
			
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("id");
				String razon_social = resultSet.getString("razon_social");
				String telefono = resultSet.getString("telefono");
				String direccion = resultSet.getString("direccion");
				String correo = resultSet.getString("correo");
				
				proveedor = new Proveedor();
				
				proveedor.setId(id);
				proveedor.setRazon_social(razon_social);
				proveedor.setTelefono(telefono);
				proveedor.setDireccion(direccion);
				proveedor.setCorreo(correo);
			}
				
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proveedor;
		
	}

	@Override
	public int buscarIdProveedorPorNombre(String nombreProveedor) {
        try (PreparedStatement statement = conexion.prepareStatement("SELECT id FROM proveedor WHERE razon_social = ?")) {
            statement.setString(1, nombreProveedor);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}

	@Override
	public void CambiarEstadoInactivo(int id) {
		try {
			String consulta = "UPDATE proveedor SET estado = 0 WHERE id = ?";
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
			String consulta = "UPDATE proveedor SET estado = 1 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, id);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
