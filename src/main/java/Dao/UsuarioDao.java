package Dao;

import java.util.List;
import Model.Usuario;

public interface UsuarioDao {
	public List<Usuario> listarUsuario();
	
	public void agregarUsuario(Usuario usuario);
	
    public void eliminarUsuario(int idUsuario);
    
    public void editarUsuario(int idUsuario);
    
    public Usuario buscarUsuarioPorId(int idUsuario);
}