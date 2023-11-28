package Dao;

import java.util.List;
import Model.Inventario;

public interface InventarioDao {
    List<Inventario> listarInventario();

    void agregarProducto(Inventario producto);

    void eliminarProducto(int idProducto);

    void editarProducto(int idProducto);

    Inventario buscarProductoPorId(int idProducto);
}