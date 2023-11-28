package DaoImpl;

import Dao.CategoriaDao;
import Model.Categoria;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import Dao.Conexion;

public class CategoriaDaoImpl implements CategoriaDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public CategoriaDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
    @Override
    public List<Categoria> listarCategoria() {
        List<Categoria> listarCategoria = new ArrayList<>();
        try{
            String consulta = "SELECT * FROM categoria";
            statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                /*Obtenemos datos de la base de datos y los almacenamos en variables*/
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");                
                Boolean estado = resultSet.getBoolean("estado");
                
                /*Las variables con los datos las mandamos al set de la clase alumno*/
                Categoria categoria = new Categoria();
                categoria.setId(id);
                categoria.setDescripcion(descripcion);
                categoria.setEstado(estado);
                
                listarCategoria.add(categoria);
            }
         
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return listarCategoria;
        
    }

	@Override
	public void registrarCategoria(Categoria categoria) {
		 try {
		        String consulta = "INSERT INTO categoria (descripcion) VALUES (?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta);
		        
		        statement.setString(1, categoria.getDescripcion());		        
		        
		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();        
		    }
	}

	@Override
	public void eliminarCategoria(int id) {
		try{
			String consulta = "UPDATE categoria SET estado = 0 WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1,id);
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
		
	}

	@Override
	public Categoria obtenerCategoriaPorNombre(String nombreCategoria) {
		try {
			String consulta = "SELECT * FROM categoria WHERE descripcion = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setString(1, nombreCategoria); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {
		        Categoria categoria = new Categoria();
		        categoria.setId(resultSet.getInt("id"));
	            categoria.setDescripcion("descripcion"); // Asigna el valor correcto
		        return categoria;
			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

	@Override
	public String obtenerNombreCategoriaPorId(int idCategoria) {
		try {
			String consulta = "SELECT descripcion FROM categoria WHERE id = ?";
		    statement = conexion.prepareStatement(consulta);
		    statement.setInt(1, idCategoria); // Establece el valor del parámetro
		    ResultSet resultSet = statement.executeQuery();
			
		    if (resultSet.next()) {
		    	return resultSet.getString("descripcion");			
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null; // En caso de error o si no se encuentra la categoría
	}

}
