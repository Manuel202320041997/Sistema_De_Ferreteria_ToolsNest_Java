package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.TransportistaDao;
import Model.Categoria;
import Model.Transportista;


public class TransportistaDaoImpl implements TransportistaDao {

	private PreparedStatement statement = null;
    private Connection conexion;
    
    public TransportistaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	
	
	@Override
	public List<Transportista> listarTransportista() {
		List<Transportista> listarTransportista = new ArrayList<>();
        try{
            String consulta = "SELECT * FROM transportista";
            statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                /*Obtenemos datos de la base de datos y los almacenamos en variables*/
                int id = resultSet.getInt("id");
                int dni = resultSet.getInt("dni");
                String nombres = resultSet.getString("nombres");
                String placa_vehiculo = resultSet.getString("placa_vehiculo");
                String modelo_vehiculo = resultSet.getString("modelo_vehiculo");
                String brevete = resultSet.getString("brevete");
                Boolean estado = resultSet.getBoolean("estado");
                
                /*Las variables con los datos las mandamos al set de la clase alumno*/
                Transportista transportista = new Transportista();
                transportista.setId(id);
                transportista.setDni(dni);
                transportista.setNombres(nombres);
                transportista.setPlaca_vehiculo(placa_vehiculo);
                transportista.setModelo_vehiculo(modelo_vehiculo);
                transportista.setBrevete(brevete);
                transportista.setEstado(estado);
                
                listarTransportista.add(transportista);
            }
         
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listarTransportista;
	}

	@Override
	public Transportista obtenerTransportistaPorNombre(String nombreTransportista) {
		try {
			String consulta = "SELECT * FROM transportista WHERE nombres = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setString(1, nombreTransportista); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {		        
                int id = resultSet.getInt("id");
                int dni = resultSet.getInt("dni");
                String nombres = resultSet.getString("nombres");
                String placa_vehiculo = resultSet.getString("placa_vehiculo");
                String modelo_vehiculo = resultSet.getString("modelo_vehiculo");
                String brevete = resultSet.getString("brevete");
                Boolean estado = resultSet.getBoolean("estado");
                
                /*Las variables con los datos las mandamos al set de la clase alumno*/
                Transportista transportista = new Transportista();
                transportista.setId(id);
                transportista.setDni(dni);
                transportista.setNombres(nombres);
                transportista.setPlaca_vehiculo(placa_vehiculo);
                transportista.setModelo_vehiculo(modelo_vehiculo);
                transportista.setBrevete(brevete);
                transportista.setEstado(estado);
		        return transportista;
			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

	@Override
	public Transportista obtenerTransportistaPorId(int idTransportista) {
		try {
			String consulta = "SELECT * FROM transportista WHERE id = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setInt(1, idTransportista); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {		        
                int id = resultSet.getInt("id");
                int dni = resultSet.getInt("dni");
                String nombres = resultSet.getString("nombres");
                String placa_vehiculo = resultSet.getString("placa_vehiculo");
                String modelo_vehiculo = resultSet.getString("modelo_vehiculo");
                String brevete = resultSet.getString("brevete");
                Boolean estado = resultSet.getBoolean("estado");
                
                /*Las variables con los datos las mandamos al set de la clase alumno*/
                Transportista transportista = new Transportista();
                transportista.setId(id);
                transportista.setDni(dni);
                transportista.setNombres(nombres);
                transportista.setPlaca_vehiculo(placa_vehiculo);
                transportista.setModelo_vehiculo(modelo_vehiculo);
                transportista.setBrevete(brevete);
                transportista.setEstado(estado);
		        return transportista;
			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}


	@Override
	public void registrarTransportista(Transportista transportista) {
		try (PreparedStatement registroStatement = conexion.prepareStatement("INSERT INTO transportista (dni, nombres, placa_vehiculo, modelo_vehiculo, brevete) VALUES (?, ?, ?, ?, ?)")) {
			 
            registroStatement.setInt(1, transportista.getDni());     
            registroStatement.setString(2, transportista.getNombres());
            registroStatement.setString(3, transportista.getPlaca_vehiculo());
            registroStatement.setString(4, transportista.getModelo_vehiculo());
            registroStatement.setString(5, transportista.getBrevete());
            registroStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }	
		
	}

}
