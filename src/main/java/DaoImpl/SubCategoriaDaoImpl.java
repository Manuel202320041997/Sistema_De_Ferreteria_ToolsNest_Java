package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.SubCategoriaDao;
import Model.Categoria;
import Model.SubCategoria;

public class SubCategoriaDaoImpl implements SubCategoriaDao{
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public SubCategoriaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
	@Override
	public List<SubCategoria> listarSubCategoria() {
		List<SubCategoria> listarSubCategoria = new ArrayList<>();
        try (PreparedStatement statement = conexion.prepareStatement("SELECT * FROM subcategoria");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                int id_categoria = resultSet.getInt("id_categoria");
                Boolean estado = resultSet.getBoolean("estado");

                SubCategoria subcategoria = new SubCategoria();
                subcategoria.setId(id);
                subcategoria.setDescripcion(descripcion);
                subcategoria.setId_categoria(id_categoria);
                subcategoria.setEstado(estado);

                listarSubCategoria.add(subcategoria);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listarSubCategoria;
	}

	@Override
	public void registrarSubCategoria(SubCategoria subcategoria) {
		 try (PreparedStatement registroStatement = conexion.prepareStatement("INSERT INTO subcategoria (descripcion, id_categoria) VALUES (?, ?)")) {
			 
	            registroStatement.setString(1, subcategoria.getDescripcion());
	            registroStatement.setInt(2, subcategoria.getId_categoria());
	            registroStatement.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }		
	}

	@Override
	public void eliminarSubCategoria(int id) {
		try{
			String consulta = "UPDATE subcategoria SET estado = 0 WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
		
	}

	@Override
	public int obtenerIdSubCategoriaPorNombre(String nombresubcategoria) {
		int idSubCategoria = 0;
		try {
			String consulta = "SELECT id FROM subcategoria WHERE descripcion = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setString(1, nombresubcategoria); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {
		    	
		    	idSubCategoria = resultSet.getInt("id");
		    	
		    	
		        return idSubCategoria;
			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0; // En caso de error o si no se encuentra la categoría
	}

	@Override
	public String obtenerNombreSubCategoriaPorId(int idsubcategoria) {
		String nombreSubCategoria = null;
		try {
			String consulta = "SELECT descripcion FROM subcategoria WHERE id = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setInt(1, idsubcategoria); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {		    	
		    	nombreSubCategoria = resultSet.getString("descripcion");	    	
		    	
		        return nombreSubCategoria;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

}
