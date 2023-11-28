package Controller;

import java.util.ArrayList;
import java.util.List;

import DaoImpl.ClienteDaoImpl;
import Model.Cliente;
import Model.Usuario;
import Dao.ClienteDao;

public class ClienteController {
	
	private ClienteDaoImpl clienteDaoImpl = null;
	

    
    public ClienteController(){
        clienteDaoImpl = new ClienteDaoImpl();
        
    }

    public List<Cliente> listarCliente(){
    	List<Cliente> listaCompleta = clienteDaoImpl.listarCliente();
    	List<Cliente> listaFiltrada = new ArrayList<>();
    	
    	for (Cliente cliente : listaCompleta) {
            if (cliente.getEstado()) {//TRAE A TODOS LOS OBJETOS O FILAS DE DATOS QUE HAY EN LISTA COMPLETA, PERO SOLO ADMITE LOS QUE TIENEN DE ESTADO (TRUE)
                listaFiltrada.add(cliente);
            }
        }
    	return listaFiltrada;
    }
    
    public void agregarCliente(Cliente cliente) {
    	try {
   	        // Crear un objeto Alumno con los valores numéricos
   	     
   	        clienteDaoImpl.agregarCliente(cliente);
   	    } catch (Exception e) {
   	        e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
   	    }
    }
    
    public void editarCliente(Cliente cliente) {
        try {
            // Suponiendo que tienes un método en tu Dao para buscar cliente por ID
            Cliente clienteExistente = clienteDaoImpl.buscarClientePorId(cliente.getId());

            if (clienteExistente != null) {
                // Actualizar los campos del cliente existente
                clienteExistente.setDni(cliente.getDni());
                clienteExistente.setNombre(cliente.getNombre());
                clienteExistente.setCorreo(cliente.getCorreo());
                clienteExistente.setTelefono(cliente.getTelefono());

                // Luego, guarda los cambios en la base de datos
                clienteDaoImpl.editarCliente(clienteExistente);
            } else {
                // Manejar el caso donde el cliente no existe
                throw new IllegalArgumentException("Cliente no encontrado para editar");
            }
        } catch (Exception ex) {
            // Manejar excepciones específicas, si es necesario
            throw new RuntimeException("Error al editar el cliente", ex);
        }
    }
  
    public Cliente buscarClientePorId(int idCliente) {
        return clienteDaoImpl.buscarClientePorId(idCliente);
    }

    public boolean verificarSiExisteDni(int dniUsuario) {
		return clienteDaoImpl.verificarSiExisteDni(dniUsuario);
	}
    
    public int obtenerIdClientePorNombre(String nombreCliente){
		return clienteDaoImpl.obtenerIdClientePorNombre(nombreCliente);
   }


}
