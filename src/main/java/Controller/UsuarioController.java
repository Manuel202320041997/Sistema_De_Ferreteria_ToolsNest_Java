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
	
	public Usuario validarLogin(int dni, String clave) {
	    List<Usuario> listaUsuarios = listarUsuario();

	    for (Usuario usuario : listaUsuarios) {
	        // Intenta la comparación directa
	        if (usuario.getDni() == dni && usuario.getClave().equals(clave) && usuario.getEstado()) {
	            return usuario;
	        }


	        if (usuario.getDni() == dni && usuario.getClave().equals(clave) && usuario.getEstado()) {
	            return usuario;
	        }
	    }

	    return null;
	}
	public void agregarUsuario(Usuario usuario) {
		try {
			 
	            usuario.setClave(usuario.getClave());
			
   	     Usuario usuarioObj = new Usuario();
   	     	  usuarioObj.setDni(usuario.getDni());
		   	  usuarioObj.setNombre(usuario.getNombre());		   	  
		   	  usuarioObj.setClave(usuario.getClave());
		   	  usuarioObj.setId_rol(usuario.getId_rol());
   	        // Llamar a DAO para agregar el alumno a la base de datos
   	        usuariodao.agregarUsuario(usuarioObj);
   	    } catch (Exception e) {
   	        e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
   	    }
	}
	
	public Usuario obtenerUsuarioPorDni(int dniUsuario) {		 
		return usuariodao.buscarUsuarioPorDni(dniUsuario);		 
	}
	
	public void editarUsuario(Usuario usuario) {
		try {
			Usuario usuarioObj = new Usuario();
			usuarioObj.setNombre(usuario.getNombre());
			usuarioObj.setClave(usuario.getClave());
			usuarioObj.setId_rol(usuario.getId_rol());
			usuarioObj.setId(usuario.getId());
			
			usuariodao.editarUsuario(usuarioObj);
		} catch (Exception e) {
			System.err.println("Error al editar usuario: "+ e.getMessage());
		}
	}
	
	public boolean verificarSiExisteDni(int dniUsuario) {
		return usuariodao.verificarSiExisteDni(dniUsuario);
	}
	
	public void eliminarUsuario(int idUsuario) {
		usuariodao.eliminarUsuario(idUsuario);
	}
	
	public void cambiarEstadoInactivo(int id) {
		usuariodao.CambiarEstadoInactivo(id);
		
	}
	public void cambiarEstadoEmpleadoaActivo(int id) {
		usuariodao.CambiarEstadoActivo(id);
	}
}
