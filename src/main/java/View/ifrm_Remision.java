package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.DetalleVenta;
import Model.Empleado;
import Model.Guia;
import Model.Guia_Detalle;
import Model.Producto;
import Model.Transportista;
import Model.Usuario;
import Model.Guia_Ingreso;
import Model.Guia_Remision;
import Model.Guia_Salida;
import Model.Reporte;
import Model.ReporteExcel;
import Controller.ReporteController;
import Controller.EmpleadoController;
import Controller.GuiaController;
import Controller.GuiaDetalleController;
import Controller.TransportistaController;
import Controller.GuiaSalidaController;
import Controller.ProductoController;
import Controller.GuiaIngresoController;
import Controller.GuiaRemisionController;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ifrm_Remision extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private GuiaController guiacontroller;
	private TransportistaController transportistacontroller;
	private GuiaIngresoController guiaingresocontroller;
	private GuiaSalidaController guiasalidacontroller;
	private GuiaDetalleController guiadetallecontroller;
	private ProductoController productocontroller;
	private EmpleadoController empleadocontroller;
	private GuiaRemisionController guiaremisioncontroller;
	DefaultTableModel modelo;
	private JTable tblProducto;
	private JTextField txtMotivo;
	private JTextField txtInicio;
	private JTextField txtLlegada;
	private JTextField txtModeloVehiculo;
	private JComboBox cboTransportista;
	private JRadioButton rbSalida;
	private JRadioButton rbIngreso;
	private JComboBox cboGuia;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario usuarioValidado = new Usuario();
					ifrm_Remision frame = new ifrm_Remision(usuarioValidado);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ifrm_Remision(Usuario usuarioValidado) {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);	
		
		reportecontroller = new ReporteController();
		guiacontroller = new GuiaController();
		guiaingresocontroller = new GuiaIngresoController();
		guiasalidacontroller = new GuiaSalidaController();
		guiaremisioncontroller = new GuiaRemisionController();
		transportistacontroller = new TransportistaController();
		guiadetallecontroller = new GuiaDetalleController();
		productocontroller = new ProductoController();
		empleadocontroller = new EmpleadoController();
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Descripcion", "Cantidad"
	            }
	        );
		
		
		

		tblProducto = new JTable(modelo);
		tblProducto.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblProducto.getTableHeader().setOpaque(false);
		tblProducto.getTableHeader().setBackground(new Color(40, 39, 61));
		tblProducto.setSelectionBackground(new Color(241, 110, 79));
		tblProducto.getTableHeader().setForeground(new Color(255, 255, 255));
		tblProducto.setRowHeight(25);
		tblProducto.setDefaultEditor(Object.class, null);
		tblProducto.setDefaultEditor(Object.class, null);
		tblProducto.getColumnModel().getColumn(0).setPreferredWidth(150);// Descripcion
		tblProducto.getColumnModel().getColumn(1).setPreferredWidth(20); // Cantidad
		 getContentPane().setLayout(null);

		 tblProducto.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			    @Override
			    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

			        // Obtener la fuente actual y establecer solo el estilo negrita
			        Font currentFont = c.getFont();
			        Font newFont = new Font(currentFont.getName(), Font.BOLD, currentFont.getSize());
			        c.setFont(newFont);

			        // Verificar si la fila está seleccionada
			        if (isSelected) {

			            // Cambiar el color de fondo de la fila seleccionada (puedes ajustar el color según tus preferencias)
			            c.setBackground(new Color(65, 65, 65));

			            // Poner el texto en blanco para que sea visible sobre el fondo oscuro
			            c.setForeground(Color.WHITE);
			        } else {
			            // Restaurar el estilo predeterminado si la fila no está seleccionada
			           // ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

			            c.setBackground(table.getBackground());
			            // Restaurar el color de texto predeterminado
			            c.setForeground(table.getForeground());
			        }

			        return c;
			    }
			});

			tblProducto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tblProducto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tblProducto.setIntercellSpacing(new Dimension(0, 0));
			tblProducto.setShowGrid(false);
			tblProducto.setShowHorizontalLines(true);
			tblProducto.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
			tblProducto.setShowVerticalLines(true);
			tblProducto.setGridColor(new Color(200, 200, 200));

		 
		 //mostrarTabla();
		 JScrollPane scrollPane = new JScrollPane(tblProducto);
		 scrollPane.setBounds(35, 103, 562, 427);
		 getContentPane().add(scrollPane);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setBackground(new Color(40, 39, 61));
		 panel_1.setBounds(35, 55, 562, 42);
		 getContentPane().add(panel_1);
		 
		 JLabel lblNewLabel = new JLabel("Filtrar por:");
		 lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel.setBounds(10, 11, 80, 20);
		 panel_1.add(lblNewLabel);
		 
		 cboGuia = new JComboBox();
		 cboGuia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboGuia.setModel(new DefaultComboBoxModel(new String[] {"Guias"}));
		 //comboBox.setBackground(new Color(40, 39, 61));
		 cboGuia.setBounds(100, 12, 94, 19);
		 panel_1.add(cboGuia);
		 
		 rbIngreso = new JRadioButton("Ingreso");
		 rbIngreso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 rbIngreso.setBounds(200, 8, 80, 23);
		 rbIngreso.setForeground(new Color(240, 240, 240));
		 rbIngreso.setBackground(new Color(40, 39, 61));
		 panel_1.add(rbIngreso);
		 
		 rbSalida = new JRadioButton("Salida");
		 rbSalida.setForeground(UIManager.getColor("Button.background"));
		 rbSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 rbSalida.setBackground(new Color(40, 39, 61));
		 rbSalida.setBounds(293, 8, 80, 23);
		 panel_1.add(rbSalida);

		 
		 JPanel panel = new JPanel();
		 panel.setBounds(652, 140, 562, 339);
		 getContentPane().add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel("GUIAS DE REMISION");
		 lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		 lblNewLabel_1.setBounds(10, 0, 549, 44);
		 panel.add(lblNewLabel_1);
		 
		 String numeroGuia = guiacontroller.generarNumeroGuia();
		 JLabel lblGuia = new JLabel("N° Guía: "+numeroGuia);
		 lblGuia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblGuia.setBounds(32, 56, 129, 28);
		 panel.add(lblGuia);
		 
		 String nombreUsuario = usuarioValidado.getNombre();
		 JLabel lblEmpleado = new JLabel("Empleado: "+nombreUsuario);
		 lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblEmpleado.setBounds(205, 56, 153, 28);
		 panel.add(lblEmpleado);
		 
		 LocalDate fechaActual = LocalDate.now();
		 JLabel lblFecha = new JLabel("Fecha: "+fechaActual);
		 lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblFecha.setBounds(390, 56, 129, 28);
		 panel.add(lblFecha);
		 
		 JLabel lblNewLabel_2_3_1_2_2 = new JLabel("Motivo:");
		 lblNewLabel_2_3_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_2_2.setBounds(32, 95, 81, 28);
		 panel.add(lblNewLabel_2_3_1_2_2);
		 
		 txtMotivo = new JTextField();
		 txtMotivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtMotivo.setColumns(10);
		 txtMotivo.setBounds(123, 95, 396, 29);
		 panel.add(txtMotivo);
		 
		 JLabel lblNewLabel_3 = new JLabel("");
		 lblNewLabel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS GENERALES DE GUIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3.setBounds(20, 40, 521, 97);
		 panel.add(lblNewLabel_3);
		 
		 JLabel lblNewLabel_2_3_1_2_2_1 = new JLabel("Punto Inicio:");
		 lblNewLabel_2_3_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_2_3_1_2_2_1.setBounds(32, 160, 85, 28);
		 panel.add(lblNewLabel_2_3_1_2_2_1);
		 
		 txtInicio = new JTextField();
		 txtInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtInicio.setColumns(10);
		 txtInicio.setBounds(123, 160, 142, 29);
		 panel.add(txtInicio);
		 
		 txtLlegada = new JTextField();
		 txtLlegada.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtLlegada.setColumns(10);
		 txtLlegada.setBounds(390, 160, 142, 29);
		 panel.add(txtLlegada);
		 
		 JLabel lblNewLabel_2_3_1_2_2_1_1 = new JLabel("Punto LLegada:");
		 lblNewLabel_2_3_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_2_3_1_2_2_1_1.setBounds(275, 160, 102, 28);
		 panel.add(lblNewLabel_2_3_1_2_2_1_1);
		 
		 JLabel lblNewLabel_2_3 = new JLabel("Transportista:");
		 lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_2_3.setBounds(32, 201, 95, 28);
		 panel.add(lblNewLabel_2_3);
		 
		 cboTransportista = new JComboBox();
		 cboTransportista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboTransportista.setBounds(123, 200, 142, 29);
		 actualizarComboBoxTransportista();	
		 panel.add(cboTransportista);
		 
		 JLabel lblNewLabel_2_3_1_2_2_1_1_1 = new JLabel("Modelo Vehiculo:");
		 lblNewLabel_2_3_1_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 lblNewLabel_2_3_1_2_2_1_1_1.setBounds(275, 200, 102, 28);
		 panel.add(lblNewLabel_2_3_1_2_2_1_1_1);
		 
		 txtModeloVehiculo = new JTextField();
		 txtModeloVehiculo.setEditable(false);
		 txtModeloVehiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtModeloVehiculo.setColumns(10);
		 txtModeloVehiculo.setBounds(390, 200, 142, 29);
		 panel.add(txtModeloVehiculo);
		 
		 JLabel lblNewLabel_3_1 = new JLabel("");
		 lblNewLabel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DETALLES DEL TRANSPORTE:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_1.setBounds(20, 141, 521, 103);
		 panel.add(lblNewLabel_3_1);
		 
		 JButton btnLimpiar = new JButton("Limpiar");
		 btnLimpiar.setForeground(Color.BLACK);
		 btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnLimpiar.setBackground(new Color(252, 187, 33));
		 btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		 btnLimpiar.setBounds(293, 255, 248, 29);
		 panel.add(btnLimpiar);
		 
		 JButton btnEliminar = new JButton("Eliminar Producto");
		 btnEliminar.setForeground(new Color(245, 245, 245));
		 btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnEliminar.setBackground(new Color(144, 8, 9));
		 btnEliminar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/eliminaricono.png")));
		 btnEliminar.setBounds(20, 255, 248, 29);
		 panel.add(btnEliminar);
		 
		 JButton btnGenerarGuiaRemision = new JButton("Generar Guia de Remision");
		 btnGenerarGuiaRemision.setForeground(new Color(245, 245, 245));
		 btnGenerarGuiaRemision.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnGenerarGuiaRemision.setBackground(new Color(4, 51, 108));
		 btnGenerarGuiaRemision.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/remisionicono.png")));
		 btnGenerarGuiaRemision.setBounds(20, 295, 521, 29);
		 panel.add(btnGenerarGuiaRemision);
		 
		 rbIngreso.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		if(rbIngreso.isSelected()) {
			 			rbSalida.setSelected(false);
			 			actualizarComboBoxIngreso();
					}
			 		else {
			 			 limpiarrbGuia();
			 		}
			 	}
			 });
		 
		 rbSalida.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		if(rbSalida.isSelected()) {
			 			rbIngreso.setSelected(false);
			 			actualizarComboBoxSalida();
					}
			 		else {
			 			 limpiarrbGuia();
			 		}
			 	}
			 });
		 
		 cboTransportista.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		String nombreTransportista = (String) cboTransportista.getSelectedItem();
					Transportista transportista = transportistacontroller.obtenerTransportistaPorNombre(nombreTransportista);
					String nombreVehiculo = transportista.getModelo_vehiculo();
					
					txtModeloVehiculo.setText(nombreVehiculo);					
			 	}
			 });
		 
		 cboGuia.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		
			 		if (modelo != null) {
			            modelo.setRowCount(0);
			            
			            String numeroGuia = (String) cboGuia.getSelectedItem();			            
			            //Guia_Detalle guiadetalle = new Guia_Detalle();
			            List<Guia_Detalle> listarDetalleGuia = guiadetallecontroller.listarDetalleGuiaPorNumeroGuia(numeroGuia);
			            
			            if(listarDetalleGuia != null && !listarDetalleGuia.isEmpty()) {
			            	
			            	for(Guia_Detalle guiadetalle : listarDetalleGuia ) {
			            		String nombreProducto = productocontroller.obtenerNombreProductoPorId(guiadetalle.getId_producto());
			            		Object[] fila  = {
			            				nombreProducto,
			            				guiadetalle.getCantidad()
			            		};
			            		modelo.addRow(fila);	
			            	}
			            	
			            }
			 		}
			 	}
			 });
		 
		 btnLimpiar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		limpiar();
			 	}
			 });
		 
		 btnEliminar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		int filaSeleccionada = tblProducto.getSelectedRow();

			        // Verifica que haya una fila seleccionada
			        if (filaSeleccionada != -1) {
			            // Elimina la fila del modelo de la tabla
			            modelo.removeRow(filaSeleccionada);
			        } else {
			            JOptionPane.showMessageDialog(ifrm_Remision.this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			 	}
			 });
		 
		 btnGenerarGuiaRemision.addActionListener(new ActionListener() {
			 private List<Guia_Detalle> guiadetalles = new ArrayList<>();
			 	public void actionPerformed(ActionEvent e) {
			 		try {
						/*LOGICA PARA REGISTRO DE GUIA REMISION*/
			 			String motivo = txtMotivo.getText();
			 			String inicio = txtInicio.getText();
			 			String llegada = txtLlegada.getText();
			 			String transportistaTexto = (String) cboTransportista.getSelectedItem();
			 			
			 			Transportista transportista = transportistacontroller.obtenerTransportistaPorNombre(transportistaTexto);
			 			
			 			if(motivo.isEmpty() || inicio.isEmpty() || llegada.isEmpty()) {
			 				JOptionPane.showMessageDialog(ifrm_Remision.this, "El campo Motivo y Punto de Inicio, y Punto de Llegada no pueden estar vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			 				
			 			}
			 			else {
			 				Empleado empleado = empleadocontroller.buscarEmpleadoPorDni(usuarioValidado.getDni());
			 				int idEmpleado = empleado.getId();
			 				/*GENERACION DE GUIA*/
			 				String numeroGuia = guiacontroller.generarNumeroGuia();
			 				
			 				int idGuiaGenerada = guiacontroller.registrarGuia(numeroGuia, idEmpleado, motivo);
			 				/*TERMINA GENERACIÓN DE GUIA*/
			 				
			 				/*INICIA DETALLE GUIA*/
							 int rowcount = modelo.getRowCount();
					            for (int i = 0; i < rowcount; i++) {
					                String nombreProductoTabla = (String) modelo.getValueAt(i, 0);
					                int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProductoTabla);
					                int cantidadTabla = (int) modelo.getValueAt(i, 1);

					                Guia_Detalle guiadetalle = new Guia_Detalle();
					                guiadetalle.setId_guia(idGuiaGenerada);
					                guiadetalle.setId_producto(idProducto);
					                guiadetalle.setCantidad(cantidadTabla);
					                guiadetalles.add(guiadetalle);
					            }

					            for (Guia_Detalle guiadetalle : guiadetalles) {
					                guiadetallecontroller.registrarDetalleGuia(guiadetalle);
					            }
					         /* TERMINA DETALLE GUIA */
			 				
					         /*INICIA GUIA REMISION*/
					            Guia_Remision guiaremision = new Guia_Remision();
					            guiaremision.setId_guia(idGuiaGenerada);
					            guiaremision.setPunto_partida(inicio);
					            guiaremision.setPunto_llegada(llegada);
					            guiaremision.setId_transportista(transportista.getId());
					            
					            System.out.println("guiaremision: " + guiaremision);
					            System.out.println("guiaremisioncontroller: " + guiaremisioncontroller);
					            guiaremisioncontroller.registrarGuiaRemision(guiaremision);
					         /*TERMINA GUIA REMISION*/
					            Reporte.ReporteRemision();
					            limpiar();
					            JOptionPane.showMessageDialog(ifrm_Remision.this, "Ajuste de Inventario y Guía de Salida : " + numeroGuia + " generadas con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
					            
			 			}
			 			
					} catch (Exception e2) {
						e2.printStackTrace();
					}
			 	}
			 });
	}
	
	private void actualizarComboBoxTransportista() {
		List<Transportista> listaTransportista = transportistacontroller.listarTransportista();
		cboTransportista.removeAllItems();
		
		for(Transportista transportista : listaTransportista) {
			cboTransportista.addItem(transportista.getNombres());
		} 
	}
	
	private void actualizarComboBoxIngreso() {
		List<Guia_Ingreso> listaGuiaingreso = guiaingresocontroller.listarGuiaIngreso();
		cboGuia.removeAllItems();
		
		for(Guia_Ingreso guiaingreso : listaGuiaingreso) {
			Guia guia = guiacontroller.obtenerGuiaPorId(guiaingreso.getId_guia());			
			cboGuia.addItem(guia.getNumero_guia());
		} 
	}
	
	private void actualizarComboBoxSalida() {
		List<Guia_Salida> listaGuiasalida = guiasalidacontroller.listarGuiaSalida();
		cboGuia.removeAllItems();
		
		for(Guia_Salida guisalida : listaGuiasalida) {
			Guia guia = guiacontroller.obtenerGuiaPorId(guisalida.getId_guia());			
			cboGuia.addItem(guia.getNumero_guia());
		} 
	}
	
	private void limpiarrbGuia() {
		if(!rbIngreso.isSelected() && !rbSalida.isSelected()) {
			cboGuia.removeAllItems();
		}
	}
	
	private void limpiar() {
		txtModeloVehiculo.setText("");
		txtMotivo.setText("");
		txtInicio.setText("");
		txtLlegada.setText("");
		cboGuia.removeAllItems();
		cboTransportista.setSelectedIndex(0);
		
	}
}
