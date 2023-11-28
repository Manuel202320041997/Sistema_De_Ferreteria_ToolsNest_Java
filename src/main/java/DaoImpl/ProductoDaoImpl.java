package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.Conexion;
import Dao.ProductoDao;
import Model.Producto;

public class ProductoDaoImpl implements ProductoDao {
	
	private PreparedStatement statement = null;
    private Connection conexion;
    
    public ProductoDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
	@Override
	public List<Producto> listarProducto() {
		List<Producto> listarProducto = new ArrayList<>();
		try {
			String consulta = "SELECT * FROM producto";
			statement = conexion.prepareStatement(consulta);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				/*Obtenemos datos de la base de datos y los almacenamos en variables*/
				int id = resultSet.getInt("id");
				String descripcion = resultSet.getString("descripcion");
				int id_marca = resultSet.getInt("id_marca");
				int precio_compra = resultSet.getInt("precio_compra");
				int precio_venta = resultSet.getInt("precio_venta");
				int stock = resultSet.getInt("stock");
				int id_subcategoria = resultSet.getInt("id_subcategoria");				
				Boolean estado = resultSet.getBoolean("estado");
				
				Producto producto = new Producto();
				producto.setId(id);
				producto.setDescripcion(descripcion);
				producto.setId_marca(id_marca);
				producto.setPrecio_compra(precio_compra);
				producto.setPrecio_venta(precio_venta);
				producto.setStock(stock);
				producto.setId_subcategoria(id_subcategoria);
				producto.setEstado(estado);
				
				listarProducto.add(producto);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listarProducto;
	}

	@Override
	public void registrarProducto(Producto producto) {
		 try {
		        String consulta = "INSERT INTO producto (descripcion, id_marca, stock, precio_compra, precio_venta, id_subcategoria) VALUES (?, ?, ?, ?, ?, ?)";
		        PreparedStatement statement = conexion.prepareStatement(consulta);
		    
		        statement.setString(1, producto.getDescripcion());
		        statement.setInt(2, producto.getId_marca());
		        statement.setInt(3, producto.getStock());
		        statement.setDouble(4, producto.getPrecio_compra());
		        statement.setDouble(5, producto.getPrecio_venta());
		        statement.setInt(6, producto.getId_subcategoria());	        
		        
		        statement.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();        
		    }
		
	}

	@Override
	public Producto obtenerProductoPorId(int idProducto) {
		Producto producto = null; // Inicializa el producto como nulo
	    
	    try {
	        String consulta = "SELECT * FROM producto WHERE id = ?";
	        statement = conexion.prepareStatement(consulta);
	        statement.setInt(1, idProducto); // Establece el valor del parámetro
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            // Obtenemos datos de la base de datos y los almacenamos en variables
	            int id = resultSet.getInt("id");
	            String descripcion = resultSet.getString("descripcion");
	            int precio_compra = resultSet.getInt("precio_compra");
	            int precio_venta = resultSet.getInt("precio_venta");
	            int stock = resultSet.getInt("stock");
	            int id_subcategoria = resultSet.getInt("id_subcategoria");
	            Boolean estado = resultSet.getBoolean("estado");

	            producto = new Producto();
	            producto.setId(id);
	            producto.setDescripcion(descripcion);
	            producto.setStock(stock);
	            producto.setPrecio_compra(precio_compra);
	            producto.setPrecio_venta(precio_venta);
	            producto.setId_subcategoria(id_subcategoria);
	            producto.setEstado(estado);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return producto; // Devuelve un solo producto o null si no se encontró
	}

	@Override
	public void actualizarStock(int idProducto, int nuevoStock) {
		try {
	        String consulta = "UPDATE producto SET stock = stock + ? WHERE id = ?";
	        PreparedStatement statement = conexion.prepareStatement(consulta);
	        
	        statement.setInt(1, nuevoStock);
	        statement.setInt(2, idProducto);        
	        
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();        
	    }		
	}

	@Override
	public void eliminarProducto(int idProducto) {
		try{
			String consulta = "UPDATE producto SET estado = 0 WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1,idProducto);
            statement.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }		
	}

	@Override
	public Producto obtenerProductoPorNombre(String nombreProducto) {
		Producto producto = null; 
		try{
			String consulta = "SELECT * FROM producto WHERE descripcion = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1,nombreProducto);
            ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				
				producto = new Producto();
				producto.setId(resultSet.getInt("id"));
				producto.setDescripcion(resultSet.getString("descripcion"));
				producto.setId_marca(resultSet.getInt("id_marca"));
				producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
				producto.setPrecio_compra(resultSet.getDouble("precio_compra"));
				producto.setStock(resultSet.getInt("stock"));
				producto.setId_subcategoria(resultSet.getInt("id_subcategoria")); // Corrección aquí
				producto.setEstado(resultSet.getBoolean("estado"));
			} 
			
        }
		catch(SQLException e){
			e.printStackTrace();
		}

		return producto;
	}

	@Override
	public int obtenerIdProductoPorNombre(String nombreProducto) {
		int idProducto = -1; // Valor predeterminado en caso de no encontrar el producto

		try {
			String consulta = "SELECT id FROM producto WHERE descripcion = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, nombreProducto);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				idProducto = resultSet.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return idProducto;
	}

	@Override
	public void actualizarPrecioCompraPorcentaje(double numeroActualizar, int marca) {
		try {
			String consulta = "UPDATE producto SET precio_compra = precio_compra * (1 + ?) WHERE id_marca = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setDouble(1, numeroActualizar);
			statement.setInt(2, marca);
			
			int filasActualizadas = statement.executeUpdate();
			System.out.println("Filas actualizadas: " + filasActualizadas + "Productos de la Marca: " + marca);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarPrecioCompraSoles(double numeroActualizar, int marca) {
		try {
			String consulta = "UPDATE producto SET precio_compra = precio_compra + ? WHERE id_marca = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setDouble(1, numeroActualizar);
			statement.setInt(2, marca);
			
			int filasActualizadas = statement.executeUpdate();
			System.out.println("Filas actualizadas: " + filasActualizadas + "Productos de la Marca: " + marca);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void actualizarPrecioVentaPorcentaje(double numeroActualizar, int marca) {
		try {
			String consulta = "UPDATE producto SET precio_venta = precio_venta * (1 + ?) WHERE id_marca = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setDouble(1, numeroActualizar);
			statement.setInt(2, marca);
			
			int filasActualizadas = statement.executeUpdate();
			System.out.println("Filas actualizadas: " + filasActualizadas + "Productos de la Marca: " + marca);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void actualizarPrecioVentaSoles(double numeroActualizar, int marca) {
		try {
			String consulta = "UPDATE producto SET precio_venta = precio_venta + ? WHERE id_marca = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setDouble(1, numeroActualizar);
			statement.setInt(2, marca);
			
			int filasActualizadas = statement.executeUpdate();
			System.out.println("Filas actualizadas: " + filasActualizadas + "Productos de la Marca: " + marca);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Producto> listarProductoPorColumna(String columna, String descripcionBusqueda) {
	    List<Producto> listaFiltrada = new ArrayList<>();
	    PreparedStatement statement = null;

	    try {
	        // Crear la consulta SQL dinámica con LIKE para búsquedas parciales
	        String consultaSQL = "SELECT * FROM producto WHERE " + columna + " LIKE ?";

	        // Configurar el valor en función de la columna seleccionada
	        switch (columna.toUpperCase()) {
	            case "ID":
	                // Configurar el parámetro para búsquedas parciales
	                statement = conexion.prepareStatement(consultaSQL);
	                statement.setString(1, "%" + descripcionBusqueda + "%");
	                break;
	            case "DESCRIPCION":
	                // Configurar el parámetro para búsquedas parciales
	                statement = conexion.prepareStatement(consultaSQL);
	                statement.setString(1, "%" + descripcionBusqueda + "%");
	                break;
	            default:
	                // Si la columna no es reconocida, retornar la lista vacía
	                return listaFiltrada;
	        }

	        // Ejecutar la consulta
	        ResultSet resultSet = statement.executeQuery();

	        // Procesar los resultados
	        while (resultSet.next()) {
	            Producto producto = new Producto();
	            producto.setId(resultSet.getInt("id"));
	            producto.setDescripcion(resultSet.getString("descripcion"));
	            producto.setId_marca(resultSet.getInt("id_marca"));
	            producto.setPrecio_compra(resultSet.getDouble("precio_compra"));
	            producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
	            producto.setStock(resultSet.getInt("stock"));
	            producto.setId_subcategoria(resultSet.getInt("id_subcategoria"));
	            producto.setEstado(resultSet.getBoolean("estado"));

	            // Agregar el producto a la lista filtrada
	            listaFiltrada.add(producto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        // Cerrar recursos en el bloque finally
	        try {
	            if (statement != null) {
	                statement.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return listaFiltrada;
	}

	@Override
	public List<Producto> buscarProductos(String textoBuscar) {
	    List<Producto> productos = new ArrayList<>();

	    // Ejemplo de consulta SQL (puede variar según tu estructura de base de datos)
	    // Modificado para buscar descripciones que contengan la palabra incompleta
	    String query = "SELECT * FROM productos WHERE id LIKE ? OR descripcion LIKE ? OR id_marca LIKE ? " +
	                   "OR precio_compra LIKE ? OR precio_venta LIKE ? OR stock LIKE ? OR id_subcategoria LIKE ?";
	   
	 
	    try (Connection connection = Conexion.obtenerConexion();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Establece los parámetros de la consulta
	        for (int i = 1; i <= 7; i++) {
	            preparedStatement.setString(i, "%" + textoBuscar + "%");
	        }

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                // Mapea los resultados a objetos Producto y agrégales a la lista
	                Producto producto = new Producto();
	                producto.setId(resultSet.getInt("id"));
	                producto.setDescripcion(resultSet.getString("descripcion"));
	                producto.setId_marca(resultSet.getInt("id_marca"));
	                producto.setPrecio_compra(resultSet.getDouble("precio_compra"));
	                producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
	                producto.setStock(resultSet.getInt("stock"));
	                producto.setId_subcategoria(resultSet.getInt("id_subcategoria"));

	                productos.add(producto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Manejo adecuado de excepciones en un entorno real
	    }

	    return productos;
	}
	
	@Override
	public List<Producto> buscarProductosPorDescripcion(String textoBuscar) {
	    List<Producto> productos = new ArrayList<>();

	    // Ejemplo de consulta SQL para MySQL (puede variar según tu estructura de base de datos)
	    String query = "SELECT * FROM producto WHERE UPPER(descripcion) LIKE UPPER(?)";

	    try (Connection connection = Conexion.obtenerConexion();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Establece el parámetro de la consulta
	        preparedStatement.setString(1, "%" + textoBuscar + "%");

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                // Mapea los resultados a objetos Producto y agrégales a la lista
	                Producto producto = new Producto();
	                producto.setId(resultSet.getInt("id"));
	                producto.setDescripcion(resultSet.getString("descripcion"));
	                producto.setId_marca(resultSet.getInt("id_marca"));
	                producto.setPrecio_compra(resultSet.getDouble("precio_compra"));
	                producto.setPrecio_venta(resultSet.getDouble("precio_venta"));
	                producto.setStock(resultSet.getInt("stock"));
	                producto.setId_subcategoria(resultSet.getInt("id_subcategoria"));

	                productos.add(producto);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Manejo adecuado de excepciones en un entorno real
	    }

	    return productos;
	}

	@Override
	public void darSalidaProducto(Producto producto) {
		try (PreparedStatement statement = conexion.prepareStatement("UPDATE producto SET stock = stock - ? WHERE id = ?")) {
	        statement.setInt(1, producto.getStock());
	        statement.setInt(2, producto.getId());

	        int filasActualizadas = statement.executeUpdate();
	        System.out.println("Filas actualizadas: " + filasActualizadas);

	        // Validación de stock no negativo (puedes ajustar según tu lógica de negocio)
	        if (filasActualizadas > 0 && producto.getStock() < 0) {
	            System.out.println("¡Alerta! El stock es negativo después de la actualización.");
	        }

	    } catch (SQLException e) {
	        // Manejo de la excepción: Puedes registrarla, lanzar una excepción personalizada, o realizar otra acción significativa para tu aplicación.
	        e.printStackTrace();
	    }
	}
	
}
