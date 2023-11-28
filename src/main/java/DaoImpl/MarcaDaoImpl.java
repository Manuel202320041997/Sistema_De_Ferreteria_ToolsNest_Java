package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.MarcaDao;
import Model.Marca;

public class MarcaDaoImpl implements MarcaDao{
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public MarcaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
	@Override
	public List<Marca> listarMarca() {
        List<Marca> marcasList = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM marca");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                boolean estado = resultSet.getBoolean("estado");

                Marca marca = new Marca();
                marca.setId(id);
                marca.setDescripcion(descripcion);
                marca.setEstado(estado);

                marcasList.add(marca);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return marcasList;
	}

	@Override
	public int obtenerIdMarcaPorNombre(String nombreMarca) {
        try (PreparedStatement statement = conexion.prepareStatement("SELECT id FROM marca WHERE descripcion = ?")) {
            statement.setString(1, nombreMarca);
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
	public String obtenerNombreMarcaPorId(int idMarca) {
	       try (PreparedStatement statement = conexion.prepareStatement("SELECT descripcion FROM marca WHERE id = ?")) {
	            statement.setInt(1, idMarca);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getString("descripcion");
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	}
	@Override
	public void registrarMarca(Marca marca) {
		try (PreparedStatement registroStatement = conexion.prepareStatement("INSERT INTO marca (descripcion) VALUES (?)")) {
			 
            registroStatement.setString(1, marca.getDescripcion());     
            registroStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }	
	}
	
	

}
