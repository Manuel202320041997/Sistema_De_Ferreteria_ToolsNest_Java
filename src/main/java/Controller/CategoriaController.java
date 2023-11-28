package Controller;

import java.util.ArrayList;
import java.util.List;
import DaoImpl.CategoriaDaoImpl;
import Model.Categoria;

public class CategoriaController {
	
	private CategoriaDaoImpl categoriaDaoImpl = null;
	
	public CategoriaController() {
		categoriaDaoImpl = new CategoriaDaoImpl();
	}
	
	public List<Categoria> listarCategoria(){
    	List<Categoria> listaCompleta = categoriaDaoImpl.listarCategoria();
    	List<Categoria> listaFiltrada = new ArrayList<>();
    	
    	for (Categoria categoria : listaCompleta) {
            if (categoria.getEstado()) {//TRAE A TODOS LOS OBJETOS O FILAS DE DATOS QUE HAY EN LISTA COMPLETA, PERO SOLO ADMITE LOS QUE TIENEN DE ESTADO (TRUE)
                listaFiltrada.add(categoria);
            }
        }
    	return listaFiltrada;
    }
	
	 public void registrarCategoria(Categoria categoria){
	    categoriaDaoImpl.registrarCategoria(categoria);
	}
	 
	public void eliminarCategoria(int id) {
		categoriaDaoImpl.eliminarCategoria(id);
	}
	 
	
	public int obtenerIdCategoriaPorNombre(String nombreCategoria) {
		try {
	        System.out.println("Intentando obtener ID de categoria para: " + nombreCategoria);
	        Categoria categoria = categoriaDaoImpl.obtenerCategoriaPorNombre(nombreCategoria);

	        if (categoria != null) {
	            System.out.println("ID de categoria encontrado: " + categoria.getId());
	            return categoria.getId();
	        } else {
	            //JOptionPane.showMessageDialog(null, "La categoria no se encuentra en la base de datos.", "Categoria no encontrada", JOptionPane.WARNING_MESSAGE);
	            System.err.println("La categoria no se encuentra en la base de datos.");
	            return -1;
	        }
	    } catch (Exception e) { // Captura cualquier excepción genérica
	        e.printStackTrace(); // Imprime la información de la excepción en la consola para depuración
	        //JOptionPane.showMessageDialog(null, "Error al obtener el ID de la categoria.", "Error", JOptionPane.ERROR_MESSAGE);
	        System.err.println("Error al obtener el ID de la categoria.");
	        return -1;
	    }
	}
	
	public String obtenerNombreCategoriaPorId(int idCategoria) {
		try {
			System.out.println("Intentando obtener Nombre de Categoria de: " + idCategoria);
			String nombreCategoria = categoriaDaoImpl.obtenerNombreCategoriaPorId(idCategoria);
			
			if (nombreCategoria != null) {
	            System.out.println("Nombre de categoria encontrado: " + nombreCategoria);
	            return nombreCategoria;
	        } else {
	           System.err.println("La categoria no se encuentra en la base de datos.");
	            return null;
	        }
			
		} catch (Exception e) {
			 e.printStackTrace(); // Imprime la información de la excepción en la consola para depuración
	
		     return null;
		}
	}
	
}