package Controller;

import java.util.List;

import Dao.MarcaDao;
import DaoImpl.MarcaDaoImpl;
import Model.Marca;

public class MarcaController {
	private MarcaDao marcadao = null;
	
	public MarcaController() {
		marcadao = new MarcaDaoImpl();
	}
	
	public List<Marca> listarMarca(){
		List<Marca> listaMarca = null;
		listaMarca = marcadao.listarMarca();
		return listaMarca;
	}
	
	public int obtenerIdMarcaPorNombre(String nombreMarca) {
		return marcadao.obtenerIdMarcaPorNombre(nombreMarca);
	}
	
	public String obtenerNombreMarcaPorId(int idMarca) {
		return marcadao.obtenerNombreMarcaPorId(idMarca);
	}
	
	public void registrarMarca (Marca marca) {
		marcadao.registrarMarca(marca);
	}
}
