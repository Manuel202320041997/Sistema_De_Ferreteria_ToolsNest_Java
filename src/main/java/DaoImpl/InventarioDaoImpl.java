package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Dao.Conexion;
import Dao.InventarioDao;
import Model.Inventario;

public class InventarioDaoImpl implements InventarioDao {
    
    private PreparedStatement statement = null;
    private Connection conexion;
    
    public InventarioDaoImpl(){
        this.conexion = Conexion.obtenerConexion();
    }
    
    public List<Inventario> listarInventario() {
        List<Inventario> listaInventario = new ArrayList<>();
        
        try {
            String consulta = "SELECT * FROM producto";
            statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String descripcion = resultSet.getString("descripcion");
                int idMarca = resultSet.getInt("id_marca");
                double precioCompra = resultSet.getDouble("precio_compra");
                double precioVenta = resultSet.getDouble("precio_venta");
                int stock = resultSet.getInt("stock");
                int idSubcategoria = resultSet.getInt("id_subcategoria");
                
                Inventario producto = new Inventario();
                producto.setId(id);
                producto.setDescripcion(descripcion);
                producto.setIdMarca(idMarca);
                producto.setPrecioCompra(precioCompra);
                producto.setPrecioVenta(precioVenta);
                producto.setStock(stock);
                producto.setIdSubcategoria(idSubcategoria);
                
                listaInventario.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return listaInventario;
    }

    public void agregarProducto(Inventario producto) {
        // Implementa la lógica para agregar un producto a la base de datos
    }

    public void eliminarProducto(int idProducto) {
        // Implementa la lógica para eliminar un producto de la base de datos
    }

    public void editarProducto(int idProducto) {
        // Implementa la lógica para editar un producto en la base de datos
    }

    public Inventario buscarProductoPorId(int idProducto) {
        // Implementa la lógica para buscar un producto por su ID en la base de datos
        return null;
    }
}