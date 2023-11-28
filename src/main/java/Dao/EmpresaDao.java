package Dao;

import Model.Empresa;

public interface EmpresaDao {
	public Empresa obtenerEmpresa();
	
	public void editarEmpresa(Empresa empresa);
	
	public void cambiarLogoInicio(int idEmpresa, String rutaLogo);
	
	public void cambiarLogoLogin(int idEmpresa, String rutaLogo);
}
