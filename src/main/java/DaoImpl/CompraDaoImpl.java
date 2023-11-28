package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Dao.CompraDao;
import Dao.Conexion;
import Model.Categoria;
import Model.Compra;

public class CompraDaoImpl implements CompraDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public CompraDaoImpl() {
    	 this.conexion = Conexion.obtenerConexion();
	};
	
	@Override
	public int agregarOrdenCompra(Compra compra) {
		int idGenerado = -1;
		
		try {
			String consulta = "INSERT INTO compra (numero_compra, id_proveedor, total, id_modo_pago, id_empleado) VALUES (?, ?, ?, ?, ?)";
			statement = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, compra.getNumero_compra());
			statement.setInt(2, compra.getId_proveedor());
			statement.setDouble(3, compra.getTotal());
			statement.setInt(4, compra.getId_modo_pago());
			statement.setInt(5, compra.getId_empleado());
			
			statement.executeUpdate();
			
			ResultSet idCompraGenerado = statement.getGeneratedKeys();
			if(idCompraGenerado.next()) {
				idGenerado = idCompraGenerado.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idGenerado;
	}

	@Override
	public String obtenerUltimoNumeroCompra() {
		String ultimoNumeroCompra = null;
		
		try {
			String consulta = "SELECT numero_compra FROM compra ORDER BY id DESC LIMIT 1";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				ultimoNumeroCompra = resultSet.getString("numero_compra");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ultimoNumeroCompra;
	}

	@Override
	public void actualizarNumeroCompra(String nuevoNumeroCompra) {
		try {
			String consulta = "UPDATE compra SET numero_compra = ? WHERE id = (SELECT MAX(id) FROM compra)";
			statement.setString(1, nuevoNumeroCompra);
			
			statement.executeQuery();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public int obtenerIdCompraPorNumeroCompra(String numeroCompra) {
		 int id = 0;
		    
		    try {
		        String consulta = "SELECT id FROM compra WHERE numero_compra = ?";
		        statement = conexion.prepareStatement(consulta);
		        statement.setString(1, numeroCompra);
		        ResultSet resultSet = statement.executeQuery();
		        
		        if (resultSet.next()) {
		            id = resultSet.getInt("id");
		        }
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        // Cerrar la conexión en el bloque finally
		        try {
		            if (statement != null) {
		                statement.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		    
		    return id;
	}

	@Override
	public List<Compra> listarCompras() {
		List<Compra> listarCompras = new ArrayList<>();
        try{
            String consulta = "SELECT * FROM compra";
            statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                /*Obtenemos datos de la base de datos y los almacenamos en variables*/
                int id = resultSet.getInt("id");
                String numero_compra = resultSet.getString("numero_compra");                
                int id_proveedor = resultSet.getInt("id_proveedor");
                double total = resultSet.getDouble("total");
                int id_modo_pago = resultSet.getInt("id_modo_pago");
                int id_empleado = resultSet.getInt("id_empleado");
                String fecha_compra = resultSet.getString("fecha_registro");
                Boolean estado = resultSet.getBoolean("estado");
                
                /*Las variables con los datos las mandamos al set de la clase alumno*/
                Compra compra = new Compra();
                compra.setId(id);
                compra.setNumero_compra(numero_compra);
                compra.setId_proveedor(id_proveedor);
                compra.setTotal(total);
                compra.setId_modo_pago(id_modo_pago);
                compra.setId_empleado(id_empleado);
                compra.setFecha_compra(fecha_compra);
                compra.setEstado(estado);
                
                listarCompras.add(compra);
            }
            return listarCompras;
        }catch (SQLException e) {
        	e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
