package Controller;

import java.util.ArrayList;
import java.util.List;
import DaoImpl.ReporteDaoImpl;
import Model.DetalleVenta;
import Model.Reporte;


public class ReporteController {
ArrayList<Reporte> listarReporte = new ArrayList<>();
private ReporteDaoImpl reporteDaoImpl = null;

    
    public ReporteController(){
        reporteDaoImpl = new ReporteDaoImpl();
    }
    
    public List<Reporte> listarReporte(){
    	List<Reporte> listarReporte = null;
    	listarReporte = reporteDaoImpl.listarReporte();
    	return listarReporte;
    }
    
	
}
	