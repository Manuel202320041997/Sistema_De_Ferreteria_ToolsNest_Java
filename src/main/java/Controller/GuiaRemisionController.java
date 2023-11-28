package Controller;

import java.util.ArrayList;
import java.util.List;

import Dao.Guia_RemisionDao;
import DaoImpl.GuiaRemisionDaoImpl;
import Model.Guia_Remision;

public class GuiaRemisionController {
    private Guia_RemisionDao guiaremisiondao = null;
    private GuiaController guiacontroller = null;

    public GuiaRemisionController() {
        guiaremisiondao = new GuiaRemisionDaoImpl();
        guiacontroller = new GuiaController();
    }

    public List<Guia_Remision> listarGuiaRemision() {
        List<Guia_Remision> listarGuiaRemision = null;
        listarGuiaRemision = guiaremisiondao.listarGuiaRemision();
        return listarGuiaRemision;
    }

    public List<Guia_Remision> listarGuiaRemisionPorNumeroGuiaRemision(String numeroGuiaRemision) {
        List<Guia_Remision> listarGuiaRemision = new ArrayList<>();

        try {
            int idGuia = guiacontroller.obtenerIdGuiaPorNumeroGuia(numeroGuiaRemision);

            if (idGuia > 0) {
                listarGuiaRemision = guiaremisiondao.listarGuiaRemisionPorIdGuia(idGuia);
            } else {
                throw new IllegalArgumentException("No se encontró la remisión correspondiente al número " + numeroGuiaRemision);
            }
        } catch (IllegalArgumentException e) {
            // Manejar la excepción según tus necesidades (imprimir un mensaje o lanzar otra excepción más específica)
            e.printStackTrace();
        } catch (Exception e) {
            // Manejar otras excepciones si es necesario
            e.printStackTrace();
        }

        return listarGuiaRemision;
    }

    public void registrarGuiaRemision(Guia_Remision guiaremision) {
        // No es necesario crear una nueva instancia, puedes usar directamente guiaremision
        guiaremisiondao.agregarGuiaRemision(guiaremision);
    }
}

