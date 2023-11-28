package Dao;

import java.util.List;
import DaoImpl.ClienteDaoImpl;
import Model.Cliente;
import Model.Usuario;

public interface ClienteDao {
	public List<Cliente> listarCliente();
	
	public void agregarCliente(Cliente cliente);
	
    public void editarCliente(Cliente cliente);
    
    public boolean verificarSiExisteDni(int dniUsuario);
	
	public Cliente buscarClientePorId(int idCliente);

	public int obtenerIdClientePorNombre(String nombreCliente);
}
