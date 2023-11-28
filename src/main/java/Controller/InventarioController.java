package Controller;

import java.util.List;
import Dao.InventarioDao;
import DaoImpl.InventarioDaoImpl;
import Model.Inventario;

public class InventarioController {
    private InventarioDao inventarioDao = null;

    public InventarioController() {
        inventarioDao = new InventarioDaoImpl();
    }

    public List<Inventario> listarInventario() {
        List<Inventario> listaInventario = null;
        listaInventario = inventarioDao.listarInventario();
        return listaInventario;
    }

}