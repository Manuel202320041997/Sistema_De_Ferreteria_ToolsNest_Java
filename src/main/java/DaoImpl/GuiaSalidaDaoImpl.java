package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.Guia_SalidaDao;
import Model.Guia_Salida;

public class GuiaSalidaDaoImpl implements Guia_SalidaDao{
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public GuiaSalidaDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	@Override
	public List<Guia_Salida> listarGuiaSalida() {
		List<Guia_Salida> listarGuiaSalida = new ArrayList<>();
		
		try {
			String consulta = "SELECT * FROM guia_salidas";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int id_guia = resultSet.getInt("id_guia");
				String destinatario = resultSet.getString("destinatario");
				String fechaRegistro = resultSet.getString("fecha_registro");
				
				Guia_Salida guiasalida = new Guia_Salida();
				guiasalida.setId(id);
				guiasalida.setId_guia(id_guia);
				guiasalida.setDestinatario(destinatario);
				guiasalida.setFecha_registro(fechaRegistro);
				
				listarGuiaSalida.add(guiasalida);
			}
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		return listarGuiaSalida;
	}

	@Override
	public List<Guia_Salida> listarGuiaSalidaPorIdGuia(int idGuiaSalida) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarGuiaSalida(Guia_Salida guiaSalida) {
		try {
	        String consulta = "INSERT INTO guia_salidas (id_guia, destinatario) VALUES (?, ?)";
	        statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1, guiaSalida.getId_guia());
	        statement.setString(2, guiaSalida.getDestinatario());
	        
	        System.out.println("Query: " + statement.toString());
	        
	        statement.executeUpdate(); // Cambiado de executeQuery a executeUpdate
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		
	}

}
