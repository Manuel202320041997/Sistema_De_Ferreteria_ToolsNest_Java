package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.VentaConClienteDao;
import Model.Cliente;
import Model.Venta;
import Model.VentaConCliente;

public class VentaConClienteDaoImpl implements VentaConClienteDao {
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public VentaConClienteDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	@Override
	public List<VentaConCliente> listarVentasConCliente() {
	    List<VentaConCliente> ventasConCliente = new ArrayList<>();
	    try {
	        String consulta = "SELECT v.fecha_registro, v.numero_venta, c.nombres, c.id, c.telefono, c.dni, v.total " +
	                         "FROM venta v " +
	                         "LEFT JOIN cliente c ON v.id_cliente = c.id";
	        statement = conexion.prepareStatement(consulta);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            // Obtener datos de la base de datos y almacenarlos en variables
	            java.sql.Date fecha_registro = resultSet.getDate("fecha_registro");
	            String numero_venta = resultSet.getString("numero_venta");
	            String nombreCliente = resultSet.getString("nombres");
	            int idCliente = resultSet.getInt("id");
	            String telefonoCliente = resultSet.getString("telefono");
	            int dniCliente = resultSet.getInt("dni");
	            double total = resultSet.getDouble("total");

	            // Crear objetos de Venta y Cliente para almacenar los datos
	            Venta venta = new Venta();
	            venta.setFechaVenta(fecha_registro);
	            venta.setNumero_venta(numero_venta);
	            venta.setTotal(total);

	            Cliente cliente = new Cliente();
	            cliente.setNombre(nombreCliente);
	            cliente.setId(idCliente);
	            cliente.setTelefono(telefonoCliente);
	            cliente.setDni(dniCliente);

	            VentaConCliente ventaConCliente = new VentaConCliente(venta, cliente);
	            ventasConCliente.add(ventaConCliente);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return ventasConCliente;
	}

}
