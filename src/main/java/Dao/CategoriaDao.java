package Dao;

import java.util.List;
import Model.Categoria;

public interface CategoriaDao {
	
	public List<Categoria> listarCategoria();
	
	public void registrarCategoria(Categoria categoria);
    
    public void eliminarCategoria(int id);
    
    public Categoria obtenerCategoriaPorNombre (String nombreCategoria);
    
    public String obtenerNombreCategoriaPorId(int idCategoria);   

}