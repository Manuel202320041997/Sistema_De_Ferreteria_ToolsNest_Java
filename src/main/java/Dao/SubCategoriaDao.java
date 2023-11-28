package Dao;

import java.util.List;

import Model.SubCategoria;

public interface SubCategoriaDao {

	public List<SubCategoria> listarSubCategoria();

	public void registrarSubCategoria(SubCategoria subcategoria);

    public void eliminarSubCategoria(int id);

    public int obtenerIdSubCategoriaPorNombre (String nombresubcategoria);

    public String obtenerNombreSubCategoriaPorId(int idsubcategoria);   

}
