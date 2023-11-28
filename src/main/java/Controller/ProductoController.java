package Controller;

import java.util.ArrayList;
import java.util.List;

import DaoImpl.ProductoDaoImpl;
import Model.Producto;
import Model.Usuario;

public class ProductoController {
	private ProductoDaoImpl productoDaoImpl = null;
	//private CategoriaController categoriaController = new CategoriaController();
	    
	    public ProductoController(){
	        productoDaoImpl = new ProductoDaoImpl();
	    }
	    
	    public List<Producto> listarProducto(){
	    	List<Producto> listaCompleta = productoDaoImpl.listarProducto();
    	    List<Producto> listaFiltrada = new ArrayList<>();

    	    for (Producto producto : listaCompleta) {
    	        if (producto.getEstado()) { // Filtra solo los productos con estado true
    	            listaFiltrada.add(producto);
    	        }
    	    }
    	    return listaFiltrada;
	    }
	    
	    public void agregarProducto(Producto producto){
	      	 try {
	      		 productoDaoImpl.registrarProducto(producto);
	      	    } catch (Exception e) {
	      	        e.printStackTrace(); // Manejo de excepciones, puedes personalizarlo según tus necesidades
	      	    }
	      }
	    
	    public Producto obtenerProductoPorId(int idProducto) {
	    	 List<Producto> productos = listarProducto(); // Obtener la lista filtrada

		 	    // Buscar el producto por ID en la lista filtrada
		 	    for (Producto producto : productos) {
		 	        if (producto.getId() == idProducto && producto.getEstado()) {
		 	            return producto;
		 	        }
		 	    }

		 	    return null; 
	    }
	    
	    public void actualizarStock(int idProducto, int nuevoStock, int anteriorStock) {
	    	 try {
	 	 		int stockSuma = nuevoStock + anteriorStock;   
	 	 		productoDaoImpl.actualizarStock(idProducto, stockSuma);
	 	 	   } catch (Exception e) {
	 	 		e.printStackTrace();
	 	 	   }
	    }
	    
	    public void eliminarProducto(int idProducto) {
	 	   productoDaoImpl.eliminarProducto(idProducto);
	    }
	    
	    public Producto obtenerProductoPorNombre(String nombreProducto){
			Producto producto = productoDaoImpl.obtenerProductoPorNombre(nombreProducto);

			if(producto != null){
				int id = producto.getId();
				String descripcion = producto.getDescripcion();
				int idMarca = producto.getId_marca();
				double precio_venta = producto.getPrecio_venta();
				double precio_compra = producto.getPrecio_compra();
				int stock = producto.getStock();
				int idSubcategoria = producto.getId_subcategoria();
				boolean estado = producto.getEstado();
				
				producto.setId(id);
				producto.setDescripcion(descripcion);
				producto.setId_marca(idMarca);
				producto.setPrecio_venta(precio_venta);
				producto.setPrecio_compra(precio_compra);
				producto.setStock(stock);
				producto.setId_subcategoria(idSubcategoria);
				producto.setEstado(estado);			
				
				return producto;
			}

			else{
				return null;
			}
	   }	    
	    
	   public int obtenerIdProductoPorNombre(String nombreProducto){
			return productoDaoImpl.obtenerIdProductoPorNombre(nombreProducto);
	   }
	   
	   public String obtenerNombreProductoPorId(int idProducto) {
		   Producto producto = obtenerProductoPorId(idProducto);
		    
		    if (producto != null) {
		        return producto.getDescripcion();
		    } else {
		        return "No encontrado";
		    }
		}
	   
	   
	   public void actualizarStock(Producto producto) {
		   int idProducto = obtenerIdProductoPorNombre(producto.getDescripcion());
		   int cantidad = producto.getStock();
		   
		   productoDaoImpl.actualizarStock(idProducto, cantidad);
	   }
	   
	   public List<Producto> buscarProducto(String textoBusqueda) {
	        List<Producto> productosEncontrados = new ArrayList<>();

	        // Obtener la lista completa de productos
	        List<Producto> listaCompleta = listarProducto();

	        // Realizar la búsqueda por descripción en la lista
	        for (Producto producto : listaCompleta) {
	            if (producto.getDescripcion().toLowerCase().contains(textoBusqueda.toLowerCase())) {
	                productosEncontrados.add(producto);
	            }
	        }

	        return productosEncontrados;
	    }
	   
	   public List<Producto> listarProductoPorDescripcion(String descripcion) {
		    List<Producto> listaCompleta = listarProducto();
		    List<Producto> listaFiltrada = new ArrayList<>();

		    for (Producto producto : listaCompleta) {
		        if (producto.getEstado() && producto.getDescripcion().toLowerCase().contains(descripcion)) {
		            listaFiltrada.add(producto);
		        }
		    }
		    return listaFiltrada;
		}
	   
	   public List<Producto> listarProductoPorColumna(String columna, String descripcionBusqueda) {
		    try {
		        return productoDaoImpl.listarProductoPorColumna(columna, descripcionBusqueda);
		    } catch (Exception e) {
		        // Imprime información sobre la excepción para depuración
		        e.printStackTrace();

		        // Puedes lanzar una excepción personalizada, loggear el error o manejarlo de otra manera según tus necesidades
		        throw new RuntimeException("Error al listar productos por columna", e);
		    }
		}
	   
	   public List<Producto> buscarProductosPorDescripcion(String textoBuscar) {
		    return productoDaoImpl.buscarProductosPorDescripcion(textoBuscar);
		}
	   
	   /*FUNCIONES PARA ACTUALIZACION DE PRECIOS*/
	   public void actualizarPrecioCompraPorcentaje(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioCompraPorcentaje(numeroActualizar, marca);
	   }
	   
	   public void actualizarPrecioCompraSoles(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioCompraSoles(numeroActualizar, marca);
	   }
	   
	   public void actualizarPrecioVentaPorcentaje(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioVentaPorcentaje(numeroActualizar, marca);		   
	   }
	   
	   public void actualizarPrecioVentaSoles(double numeroActualizar, int marca) {
		   productoDaoImpl.actualizarPrecioVentaSoles(numeroActualizar, marca);
	   }
	   
	   public void darSalidaProducto(Producto producto) {
		   productoDaoImpl.darSalidaProducto(producto);
	   }
}	
