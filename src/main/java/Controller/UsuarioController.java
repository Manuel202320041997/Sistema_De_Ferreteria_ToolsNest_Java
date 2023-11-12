package Controller;

import java.util.List;

import Dao.UsuarioDao;
import DaoImpl.UsuarioDaoImpl;
import Model.Usuario;

public class UsuarioController {
	private UsuarioDao usuariodao = null;
	
	public UsuarioController() {
		usuariodao = new UsuarioDaoImpl();		
	}
	
	public List<Usuario> listarUsuario(){
			List<Usuario> listaUsuario = null;
			listaUsuario = usuariodao.listarUsuario();
			return listaUsuario;
	}
}
