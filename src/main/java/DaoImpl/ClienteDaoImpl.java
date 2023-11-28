package DaoImpl;

import java.util.List;
import Dao.ClienteDao;
import Model.Cliente;
import Dao.Conexion;

import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDaoImpl implements ClienteDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public ClienteDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	
	@Override
	public List<Cliente> listarCliente() {
		List<Cliente> listarCliente = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM cliente";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				/*Obtenemos datos de la base de datos y los almacenamos en variables*/
				int id = resultSet.getInt("id");
				int dni = resultSet.getInt("dni");
				String nombre = resultSet.getString("nombres");
				String correo = resultSet.getString("correo");
				String telefono = resultSet.getString("telefono");				
				Boolean estado = resultSet.getBoolean("estado");
				
				Cliente cliente = new Cliente();
				cliente.setId(id);				
				cliente.setDni(dni);
				cliente.setNombre(nombre);
				cliente.setCorreo(correo);
				cliente.setTelefono(telefono);
				cliente.setEstado(estado);
				
				listarCliente.add(cliente);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listarCliente;
	}

	@Override
	public void agregarCliente(Cliente cliente) {
		try {
	        String consulta = "INSERT INTO cliente (dni, nombres, correo, telefono) VALUES (?, ?, ?, ?)";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1, cliente.getDni());
	        statement.setString(2, cliente.getNombre());
	        statement.setString(3, cliente.getCorreo());
	        statement.setString(4, cliente.getTelefono());	        
	        statement.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();        
	    }
		
	}
	

	@Override
	  public Cliente buscarClientePorId(int idCliente) {
        try {
            String consulta = "SELECT id, dni, nombres, correo, telefono FROM cliente WHERE id = ?";
            statement = conexion.prepareStatement(consulta);
            statement.setInt(1, idCliente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int dni = resultSet.getInt("dni");
                String nombre = resultSet.getString("nombres");
                String correo = resultSet.getString("correo");
                String telefono = resultSet.getString("telefono");

                Cliente cliente = new Cliente();
                cliente.setId(id);
                cliente.setDni(dni);
                cliente.setNombre(nombre);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);

                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
	public void editarCliente(Cliente cliente) {
	    try (PreparedStatement statement = conexion.prepareStatement("UPDATE cliente SET dni = ?, nombres = ?, correo = ?, telefono = ? WHERE id = ?")) {
	    	
	        statement.setInt(1, cliente.getDni());
	        statement.setString(2, cliente.getNombre());
	        statement.setString(3, cliente.getCorreo());
	        statement.setString(4, cliente.getTelefono());
	        statement.setInt(5, cliente.getId());

	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public int obtenerIdClientePorNombre(String nombreCliente) {
		int idCliente = -1; // Valor predeterminado en caso de no encontrar el producto

		try {
			String consulta = "SELECT id FROM cliente WHERE nombres = ?";
			PreparedStatement statement = conexion.prepareStatement(consulta);
			statement.setString(1, nombreCliente);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				idCliente = resultSet.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

    return idCliente;
	}

	@Override
	public boolean verificarSiExisteDni(int dniUsuario) {
		// TODO Auto-generated method stub
		return false;
	}


}
