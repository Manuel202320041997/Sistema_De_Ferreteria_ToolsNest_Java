package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Dao.Conexion;
import Dao.GuiaDao;
import Model.Categoria;
import Model.Guia;

public class GuiaDaoImpl implements GuiaDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public GuiaDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	
	@Override
	public int agregarGuia(Guia guia) {
		int idGenerado = -1;
		
		try {
			String consulta = "INSERT INTO guia (numero_guia, id_empleado, motivo) VALUES (?, ?, ?)";
			statement = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, guia.getNumero_guia());
			statement.setInt(2, guia.getId_empleado());
			statement.setString(3, guia.getMotivo());
			
			statement.executeUpdate();
			
			ResultSet idCompraGenerado = statement.getGeneratedKeys();
			if(idCompraGenerado.next()) {
				idGenerado = idCompraGenerado.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idGenerado;
	}

	@Override
	public String obtenerUltimoNumeroGuia() {
		String ultimoNumeroGuia = null;
		
		try {
			String consulta = "SELECT numero_guia FROM guia ORDER BY id DESC LIMIT 1";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				ultimoNumeroGuia = resultSet.getString("numero_guia");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ultimoNumeroGuia;
	}

	@Override
	public void actualizarNumeroGuia(String nuevoNumeroGuia) {
		try {
			String consulta = "UPDATE guia SET numero_guia = ? WHERE id = (SELECT MAX(id) FROM guia)";
			statement.setString(1, nuevoNumeroGuia);
			
			statement.executeQuery();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}
	
	
	
	@Override
	public int obtenerIdGuiaPorNumeroGuia(String numeroGuia) {
		int id = 0;
	    
	    try {
	        String consulta = "SELECT id FROM guia WHERE numero_guia = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setString(1, numeroGuia);
	        ResultSet resultSet = statement.executeQuery();
	        
	        if (resultSet.next()) {
	            id = resultSet.getInt("id");
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cerrar la conexión en el bloque finally
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return id;
	}

	@Override
	public Guia obtenerGuiaPorId(int idGuia) {
		Guia guia = null;
		
		try {
			String consulta = "SELECT * FROM guia WHERE id = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setInt(1, idGuia);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("id");
				String numeroGuia = resultSet.getString("numero_guia");
				int id_empleado = resultSet.getInt("id_empleado");
				String motivo = resultSet.getString("motivo");
				boolean estado = resultSet.getBoolean("estado");
				
				guia = new Guia();
				guia.setId(id);
				guia.setNumero_guia(numeroGuia);
				guia.setId_empleado(id_empleado);
				guia.setMotivo(motivo);
				guia.setEstado(estado);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();        
		}
		return guia;
	}


	

}
