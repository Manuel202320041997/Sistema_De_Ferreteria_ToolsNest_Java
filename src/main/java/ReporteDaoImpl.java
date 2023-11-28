package DaoImpl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.DetalleVentaController;

import Dao.Conexion;
import Model.Reporte;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.lowagie.text.pdf.PdfTable;

public class ReporteDaoImpl {
	
	public List<Reporte> listarReporte() {
		// TODO Auto-generated method stub
		
		return null;
	}
	

	public void ReportesClientes() {

		
		Document documento = new Document();
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportesClientes.pdf"));
			Image header = Image.getInstance("src/main/resources/Img/header1.jpg");
			header.scaleToFit(650,1000);
			header.setAlignment(Chunk.ALIGN_CENTER);
				
			//Formato Text
			
			Paragraph parrafo = new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.add("Reporte generado por \nLosQuistes\n\n");
			parrafo.setFont(FontFactory.getFont("Arial Black", 28, Font.BOLD,BaseColor.DARK_GRAY));
			parrafo.add("Reporte de Clientes \n\n");
			
			documento.open();
			
			documento.add(header);
			documento.add(parrafo);
			
			PdfPTable tabla = new PdfPTable(5);
			
			tabla.addCell("NR");
			tabla.addCell("DNI");
			tabla.addCell("Nombre");
			tabla.addCell("Correo");
			tabla.addCell("Telefono");
			
			try {
				Connection cn = Conexion.obtenerConexion();
				PreparedStatement pst = cn.prepareStatement(
			"SELECT id, nombre AS nombres, dni, correo, telefono FROM cliente"
						);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					do {
						tabla.addCell(rs.getString(1));
						tabla.addCell(rs.getString(2));
						tabla.addCell(rs.getString(3));
						tabla.addCell(rs.getString(4));
						tabla.addCell(rs.getString(5));
						
						
					} while (rs.next());
					documento.add(tabla);

				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error en " + e);
			}
			//documento.close();
			
			JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
			//documento.close();
			
		} catch (DocumentException | IOException e) {
			// TODO: handle exception
			System.out.println("Error en: " +e);
		}
		//documento.close();
	}
	
public void ReportesProductos() {

		
		Document documento = new Document();
		try {
			String ruta = System.getProperty("user.home");
			PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportesProductos.pdf"));
			Image header = Image.getInstance("src/main/resources/Img/header1.jpg");
			header.scaleToFit(650,1000);
			header.setAlignment(Chunk.ALIGN_CENTER);
				
			//Formato Text
			
			Paragraph parrafo = new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.add("Reporte generado por \nLosQuistes\n\n");
			parrafo.setFont(FontFactory.getFont("Arial Black", 28, Font.BOLD,BaseColor.DARK_GRAY));
			parrafo.add("Reporte de Productos \n\n");
			
			documento.open();
			
			documento.add(header);
			documento.add(parrafo);
			
			PdfPTable tabla = new PdfPTable(5);
			
			tabla.addCell("NR");
			tabla.addCell("DNI");
			tabla.addCell("Nombre");
			tabla.addCell("Correo");
			tabla.addCell("Telefono");
			
			try {
				Connection cn = Conexion.obtenerConexion();
				PreparedStatement pst = cn.prepareStatement(
			"SELECT id, nombre AS nombres, dni, correo, telefono FROM cliente"
						);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
					do {
						tabla.addCell(rs.getString(1));
						tabla.addCell(rs.getString(2));
						tabla.addCell(rs.getString(3));
						tabla.addCell(rs.getString(4));
						tabla.addCell(rs.getString(5));
						
						
					} while (rs.next());
					documento.add(tabla);
					
					JOptionPane.showMessageDialog(null, "Reporte creado exitosamente");
					
				}
				
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error en " + e);
			}
			documento.close();
			
		} catch (DocumentException | IOException e) {
			// TODO: handle exception
			System.out.println("Error en: " +e);
		}
		//documento.close();
	}
	
	
	
	}

