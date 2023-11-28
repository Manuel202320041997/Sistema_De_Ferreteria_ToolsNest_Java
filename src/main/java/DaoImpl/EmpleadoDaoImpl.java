package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.EmpleadoDao;
import Model.Empleado;

public class EmpleadoDaoImpl implements EmpleadoDao{
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public EmpleadoDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
    @Override
	public List<Empleado> listarEmpleados() {
		
	        List<Empleado> listaEmpleados = new ArrayList<>();

	        try {
	            String consulta = "SELECT * FROM empleado";
	            statement = conexion.prepareStatement(consulta);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                Empleado empleado = new Empleado();
	                empleado.setId(resultSet.getInt("id"));
	                empleado.setDni(resultSet.getInt("dni"));
	                empleado.setNombres(resultSet.getString("nombres"));
	                empleado.setCorreo(resultSet.getString("correo"));
	                empleado.setDireccion(resultSet.getString("direccion"));
	                empleado.setId_cargo(resultSet.getInt("id_cargo"));
	                empleado.setEstado(resultSet.getBoolean("estado"));

	                listaEmpleados.add(empleado);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return listaEmpleados;
	    }

	@Override
	public void CambiarEstadoEmpleadoaActivo(int idEmpleado) {
		try {
			String consulta = "UPDATE empleado SET estado = 1 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idEmpleado);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    
	@Override
	public Empleado buscarEmpleadoPorDni(int dniEmpleado) {
		try {
			String consulta = "SELECT * FROM empleado WHERE DNI = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, dniEmpleado);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(resultSet.getInt("id"));
				empleado.setDni(resultSet.getInt("dni"));
				empleado.setNombres(resultSet.getString("nombres"));
				empleado.setCorreo(resultSet.getString("correo"));
				empleado.setDireccion(resultSet.getString("direccion"));
				empleado.setId_cargo(resultSet.getInt("id_cargo"));
				empleado.setEstado(resultSet.getBoolean("estado"));
				
				return empleado;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public void CambiarEstadoEmpleadoaInactivo(int idEmpleado) {
		try {
			String consulta = "UPDATE empleado SET estado = 0 WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idEmpleado);
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void modificarEmpleado(Empleado empleado) {
		try {
			String consulta = "UPDATE empleado SET  nombres = ?, correo = ?, direccion = ?, Id_cargo = ? WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			
			statement.setString(1, empleado.getNombres());
			statement.setString(2, empleado.getCorreo());
			statement.setString(3, empleado.getDireccion());
			statement.setInt(4, empleado.getId_cargo());
			statement.setInt(5, empleado.getId());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int agregarEmpleado(Empleado empleado) {
		try {
		    String consulta = "INSERT INTO empleado (dni, nombres, correo, direccion, id_cargo) VALUES (?, ?, ?, ?, ?)";
		    statement = conexion.prepareStatement(consulta, statement.RETURN_GENERATED_KEYS);

		    statement.setInt(1, empleado.getDni());
		    statement.setString(2, empleado.getNombres());
		    statement.setString(3, empleado.getCorreo());
		    statement.setString(4, empleado.getDireccion());
		    statement.setInt(5, empleado.getId_cargo());
		    int filasAfectadas = statement.executeUpdate();

		    // Verificar si se insertó correctamente y obtener el ID generado
		    if (filasAfectadas > 0) {
		        ResultSet generatedKeys = statement.getGeneratedKeys();
		        if (generatedKeys.next()) {
		            int idGenerado = generatedKeys.getInt(1);
		            // Aquí puedes usar idGenerado como necesites
		            return idGenerado;
		        } else {
		            // Manejar el caso en el que no se pudo obtener el ID generado
		            System.err.println("No se pudo obtener el ID generado.");
		            return -1; // o lanzar una excepción, dependiendo de tus necesidades
		        }
		    } else {
		        // Manejar el caso en el que no se insertó ninguna fila
		        System.err.println("No se insertó ninguna fila.");
		        return -1; // o lanzar una excepción, dependiendo de tus necesidades
		    }
		}
		catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public String obtenerNombreEmpleadoPorId(int idEmpleado) {
		try {
			String consulta = "SELECT nombres FROM empleado WHERE id = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setInt(1, idEmpleado); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {
		    	return resultSet.getString("nombres");			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

	@Override
	public Empleado obtenerEmpleadoPorId(int idEmpleado) {
		try {
			String consulta = "SELECT * FROM empleado WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idEmpleado);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				Empleado empleado = new Empleado();
				empleado.setId(resultSet.getInt("id"));
				empleado.setDni(resultSet.getInt("dni"));
				empleado.setNombres(resultSet.getString("nombres"));
				empleado.setCorreo(resultSet.getString("correo"));
				empleado.setDireccion(resultSet.getString("direccion"));
				empleado.setId_cargo(resultSet.getInt("id_cargo"));
				empleado.setEstado(resultSet.getBoolean("estado"));
				
				return empleado;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
