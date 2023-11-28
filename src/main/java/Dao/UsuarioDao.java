package Dao;

import java.util.List;
import Model.Usuario;

public interface UsuarioDao {
	public List<Usuario> listarUsuario();
	
	public void agregarUsuario(Usuario usuario);
	
    public void eliminarUsuario(int idUsuario);
    
    public void editarUsuario(Usuario usuario);
    
    public Usuario buscarUsuarioPorDni(int dniUsuario);
    
    public boolean verificarSiExisteDni(int dniUsuario);
    

	public void CambiarEstadoInactivo(int id);
	
	public void CambiarEstadoActivo(int id);
    
}