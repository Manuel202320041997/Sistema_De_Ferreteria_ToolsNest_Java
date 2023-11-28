package Dao;

import java.util.List;

import Model.Marca;

public interface MarcaDao {
	public List<Marca> listarMarca();
	
    public int obtenerIdMarcaPorNombre (String nombreMarca);
    
    public String obtenerNombreMarcaPorId(int idMarca);   
    
    public void registrarMarca(Marca marca);
}
