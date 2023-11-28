package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.SubCategoriaDao;
import DaoImpl.SubCategoriaDaoImpl;
import Model.SubCategoria;

public class SubCategoriaController {
	
	private SubCategoriaDao subcategoriadao = null;
	
	public SubCategoriaController() {
		subcategoriadao = new SubCategoriaDaoImpl();		
	}
	
	public List<SubCategoria> listarCategoria(){
    	List<SubCategoria> listaSubCategoria = null;
    	listaSubCategoria = subcategoriadao.listarSubCategoria();
    	
    	return listaSubCategoria;
    }
	
	public void registrarSubCategoria(SubCategoria subcategoria){
		 	subcategoriadao.registrarSubCategoria(subcategoria);
	}
		 
	public void eliminarSubCategoria(int id) {
			subcategoriadao.eliminarSubCategoria(id);
	}
	
	public int obtenerIdSubCategoriaPorNombre(String nombreSubCategoria) {
		return subcategoriadao.obtenerIdSubCategoriaPorNombre(nombreSubCategoria);
	}
	
	public String obtenerNombreSubCategoriaPorId(int id) {
		return subcategoriadao.obtenerNombreSubCategoriaPorId(id);
	}	
	
}
