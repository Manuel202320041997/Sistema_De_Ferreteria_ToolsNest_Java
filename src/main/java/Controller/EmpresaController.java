package Controller;

import Dao.EmpresaDao;
import DaoImpl.CategoriaDaoImpl;
import DaoImpl.EmpresaDaoImpl;
import Model.Empresa;

public class EmpresaController {
	private EmpresaDao empresadao = null;
	
	public EmpresaController() {
		empresadao = new EmpresaDaoImpl();
	}
	
	public Empresa obtenerEmpresa() {		
		try {
	        Empresa empresa = empresadao.obtenerEmpresa();
	        
	        if (empresa != null) {
	            return empresa;
	        } else {
	            System.err.println("EMPRESA NO ENCONTRADA" + empresa.getId());
	            return null;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public void editarEmpresa(Empresa empresa) {
		empresadao.editarEmpresa(empresa);
	}
	
	public void cambiarLogoInicio(int idEmpresa, String rutaLogo) {
		if(idEmpresa != 0 || !rutaLogo.isEmpty()) {
			empresadao.cambiarLogoInicio(idEmpresa, rutaLogo);
		}
		else {
			System.err.println("ALGUN CAMPO ESTÁ VACÍO");
		}		
	}
	
	public void cambiarLogoLogin(int idEmpresa, String rutaLogo) {
		if(idEmpresa != 0 || !rutaLogo.isEmpty()) {
			empresadao.cambiarLogoLogin(idEmpresa, rutaLogo);
		}
		else {
			System.err.println("ALGUN CAMPO ESTÁ VACÍO");
		}
	}
}
