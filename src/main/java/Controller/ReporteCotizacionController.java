package Controller;

import java.util.HashMap;
import java.util.Map;

import Model.Cotizacion;
import Model.Empresa;
import Model.Producto;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ReporteCotizacionController {
	
	private EmpresaController empresacontroller = null;
	
	public ReporteCotizacionController() {
		empresacontroller = new EmpresaController();
	}
	
	public void generarReporteCotizacion(Cotizacion cotizacion, Producto producto) {
		
		Empresa empresa = empresacontroller.obtenerEmpresa();
		
		Map<String, Object> parametros = new HashMap<>();
		
		
		parametros.put("cotizacion", cotizacion);
		parametros.put("producto", producto);
		parametros.put("empresa", empresa);
		
		String rutaInformeJRXML = "D:\\Java Projects\\ProyectoFerreteria\\src\\main\\java\\View\\Reportes\\ReporteCotizacion.jrxml";
		String rutaInformeJasper = "D:\\Java Projects\\ProyectoFerreteria\\src\\main\\java\\\\View\\\\Reportes\\ReporteCotizacion.jasper";
		
		try {
			JasperCompileManager.compileReportToFile(rutaInformeJRXML, rutaInformeJasper);
			JasperPrint informe = JasperFillManager.fillReport(rutaInformeJasper, parametros, new JREmptyDataSource());
			
			JasperViewer viewer = new JasperViewer(informe, false);
			viewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
			viewer.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
