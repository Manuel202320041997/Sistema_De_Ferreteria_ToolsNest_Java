package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.Guia_IngresoDao;
import Model.Guia_Ingreso;

public class GuiaIngresoDaoImpl implements Guia_IngresoDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public GuiaIngresoDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};


	@Override
	public List<Guia_Ingreso> listarGuiaIngreso() {
		List<Guia_Ingreso> listarGuiaIngreso = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM guia_ingresos";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				int idguia = resultSet.getInt("id_guia");
				int idProveedor = resultSet.getInt("id_proveedor");
				int idTransportista = resultSet.getInt("id_transportista");
				String observacion = resultSet.getString("observacion");
				String fecharegistro = resultSet.getString("fecha_registro");
				
				Guia_Ingreso guiaingreso = new Guia_Ingreso();
				guiaingreso.setId(id);
				guiaingreso.setId_guia(idguia);
				guiaingreso.setId_proveedor(idProveedor);
				guiaingreso.setId_transportista(idTransportista);
				guiaingreso.setObservacion(observacion);
				guiaingreso.setFecha_registro(fecharegistro);
				
				listarGuiaIngreso.add(guiaingreso);
			}
		}  catch(SQLException e){
            e.printStackTrace();
        }
		return listarGuiaIngreso;
	}

	@Override
	public List<Guia_Ingreso> listarGuiaIngresoIdGuia(int idGuiaIngreso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void agregarGuiaIngreso(Guia_Ingreso guiaIngreso) {
		try {
	        String consulta = "INSERT INTO guia_ingresos (id_guia, id_proveedor, id_transportista, observacion) VALUES (?, ?, ?, ?)";
	        statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1, guiaIngreso.getId_guia());
	        statement.setInt(2, guiaIngreso.getId_proveedor());
	        statement.setInt(3, guiaIngreso.getId_transportista());
	        statement.setString(4,guiaIngreso.getObservacion());
	        
	        System.out.println("Query: " + statement.toString());
	        
	        statement.executeUpdate(); // Cambiado de executeQuery a executeUpdate
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
