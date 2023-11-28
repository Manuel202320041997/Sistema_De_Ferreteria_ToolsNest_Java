package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import Model.Cliente;
import Model.DetalleVenta;
import Model.Empleado;
import Model.Guia;
import Model.Producto;
import Model.Usuario;
import Model.Venta;
import Model.Guia_Salida;
import Model.Guia_Detalle;
import Model.Reporte;
import Model.ReporteExcel;
import Controller.ReporteController;
import Controller.GuiaDetalleController;
import Controller.GuiaSalidaController;
import Controller.DetalleVentaController;
import Controller.ProductoController;
import Controller.GuiaController;
import Controller.ClienteController;
import Controller.VentaController;
import Controller.EmpleadoController;


import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;


public class ifrm_Salida extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private DetalleVentaController detalleventacontroller;
	private ProductoController productocontroller;
	private GuiaController guiacontroller;
	private GuiaSalidaController guiasalidacontroller;	
	private ClienteController clientecontroller;
	private VentaController ventacontroller;
	private EmpleadoController empleadocontroller;
	private GuiaDetalleController guiadetallecontroller;
	DefaultTableModel modelo;
	private JTable tblProducto;
	private JTextField txtMotivo;
	private JTextField txtVenta;
	private JTextField txtCantidad;
	private JComboBox cboProducto;
	private JComboBox cboCliente;
	private JComboBox cboVenta;
	private JSpinner spinnerCantidad;
	private JRadioButton rbCliente;
	private JRadioButton rbInterno;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario usuarioValidado = new Usuario();
					ifrm_Salida frame = new ifrm_Salida(usuarioValidado);
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
	public ifrm_Salida(Usuario usuarioValidado) {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);	
		
		guiasalidacontroller = new GuiaSalidaController();
		reportecontroller = new ReporteController();
		guiadetallecontroller = new GuiaDetalleController();
		empleadocontroller = new EmpleadoController();
		detalleventacontroller = new DetalleVentaController();
		productocontroller = new ProductoController();
		guiacontroller = new GuiaController();
		clientecontroller = new ClienteController();
		ventacontroller = new VentaController();
		
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
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(657, 118, 562, 375);
		 getContentPane().add(panel);
		 panel.setLayout(null);
		 
		 JLabel lblNewLabel_1 = new JLabel("SALIDA DE PRODUCTOS");
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		 lblNewLabel_1.setBounds(10, 0, 542, 44);
		 panel.add(lblNewLabel_1);
		 
		 String numeroGuia = guiacontroller.generarNumeroGuia();
		 JLabel lblGuia = new JLabel("N° Guía: "+numeroGuia);
		 lblGuia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblGuia.setBounds(32, 71, 129, 28);
		 panel.add(lblGuia);
		 
		 LocalDate fechaActual = LocalDate.now();
		 JLabel lblFecha = new JLabel("Fecha: "+fechaActual);
		 lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblFecha.setBounds(390, 71, 129, 28);
		 panel.add(lblFecha);
		 
		 JLabel lblNewLabel_2_3_1_2_2 = new JLabel("Motivo:");
		 lblNewLabel_2_3_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_2_2.setBounds(32, 127, 61, 28);
		 panel.add(lblNewLabel_2_3_1_2_2);
		 
		 txtMotivo = new JTextField();
		 txtMotivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtMotivo.setColumns(10);
		 txtMotivo.setBounds(89, 127, 95, 29);
		 panel.add(txtMotivo);
		 
		 String nombreUsuario = usuarioValidado.getNombre();
		 JLabel lblEmpleado = new JLabel("Empleado: "+nombreUsuario);
		 lblEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblEmpleado.setBounds(203, 71, 153, 28);
		 panel.add(lblEmpleado);
		 
		 JLabel lblNewLabel_2_2 = new JLabel("Cantidad:");
		 lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_2.setBounds(32, 240, 79, 28);
		 panel.add(lblNewLabel_2_2);
		 
		 JLabel lblNewLabel_2_3 = new JLabel("Producto:");
		 lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3.setBounds(32, 201, 79, 28);
		 panel.add(lblNewLabel_2_3);
		 
		 cboProducto = new JComboBox();
		 cboProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboProducto.setBounds(120, 199, 153, 29);
		 actualizarComboBoxProducto();
		 panel.add(cboProducto);
		 
		 spinnerCantidad = new JSpinner();
		 spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		 spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 spinnerCantidad.setBounds(120, 240, 153, 28);
		 panel.add(spinnerCantidad);
		 
		 txtVenta = new JTextField();
		 txtVenta.setEditable(false);
		 txtVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtVenta.setColumns(10);
		 txtVenta.setBounds(383, 201, 136, 29);
		 panel.add(txtVenta);
		 
		 JLabel lblNewLabel_2_3_1_2_2_1 = new JLabel("P. Venta:");
		 lblNewLabel_2_3_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_2_2_1.setBounds(315, 200, 61, 28);
		 panel.add(lblNewLabel_2_3_1_2_2_1);
		 
		 txtCantidad = new JTextField();
		 txtCantidad.setEditable(false);
		 txtCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtCantidad.setColumns(10);
		 txtCantidad.setBounds(383, 241, 136, 29);
		 panel.add(txtCantidad);
		 
		 JLabel lblNewLabel_2_3_1_2_2_1_1 = new JLabel("Cantidad:");
		 lblNewLabel_2_3_1_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_2_2_1_1.setBounds(315, 240, 61, 28);
		 panel.add(lblNewLabel_2_3_1_2_2_1_1);
		 
		 JLabel lblNewLabel_3_1 = new JLabel("");
		 lblNewLabel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DE PRODUCTO:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_1.setBounds(20, 178, 521, 104);
		 panel.add(lblNewLabel_3_1);
		 
		 JButton btnEliminar = new JButton("Eliminar Producto");
		 btnEliminar.setForeground(new Color(245, 245, 245));
		 btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnEliminar.setBackground(new Color(144, 8, 9));
		 btnEliminar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/eliminaricono.png")));
		 btnEliminar.setBounds(20, 333, 248, 29);
		 panel.add(btnEliminar);
		 
		 JButton btnAgregarProducto = new JButton("Agregar Producto");		
		 btnAgregarProducto.setForeground(new Color(245,245,245));
		 btnAgregarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnAgregarProducto.setBackground(new Color(78, 156, 54));
		 btnAgregarProducto.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		 btnAgregarProducto.setBounds(20, 293, 248, 29);
		 panel.add(btnAgregarProducto);
		 
		 JButton btnGuiaSalida = new JButton("Dar Salida");
		 btnGuiaSalida.setForeground(new Color(245, 245, 245));
		 btnGuiaSalida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnGuiaSalida.setBackground(new Color(4, 51, 108));
		 btnGuiaSalida.setBounds(293, 333, 248, 29);
		 btnGuiaSalida.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/salidaicono.png")));
		 panel.add(btnGuiaSalida);
		 
		 JButton btnLimpiar = new JButton("Limpiar");
		 btnLimpiar.setForeground(Color.BLACK);
		 btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnLimpiar.setBackground(new Color(252, 187, 33));
		 btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		 btnLimpiar.setBounds(293, 293, 248, 29);
		 panel.add(btnLimpiar);
		 
		 rbCliente = new JRadioButton("Cliente");
		 rbCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 rbCliente.setBounds(198, 127, 71, 29);
		 panel.add(rbCliente);
		 
		 rbInterno = new JRadioButton("Uso Interno");
		 rbInterno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 rbInterno.setBounds(275, 127, 97, 29);
		 panel.add(rbInterno);
		 
		 cboCliente = new JComboBox();
		 cboCliente.setVisible(false);
		 cboCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboCliente.setBounds(390, 125, 129, 29);
		 actualizarComboBoxCliente();
		 panel.add(cboCliente);
		 
		 JLabel lblNewLabel_3_2 = new JLabel("");
		 lblNewLabel_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DESTINATARIO:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_2.setBounds(190, 111, 192, 50);
		 panel.add(lblNewLabel_3_2);
		 
		 JLabel lblNewLabel_3 = new JLabel("");
		 lblNewLabel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS GENERALES DE GUIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3.setBounds(20, 55, 521, 115);
		 panel.add(lblNewLabel_3);
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setBounds(35, 50, 562, 42);
		 panel_1.setBackground(new Color(40, 39, 61));
		 getContentPane().add(panel_1);
		 panel_1.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("Buscar N° Venta:");
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel.setForeground(new Color(240,240,240));
		 lblNewLabel.setBounds(10, 11, 121, 20);
		 panel_1.add(lblNewLabel);
		 
		 cboVenta = new JComboBox();
		 cboVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboVenta.setBounds(141, 12, 171, 19);
		 actualizarComboBoxSalida();
		 panel_1.add(cboVenta);
		 
		 cboVenta.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		if (modelo != null) {
			            modelo.setRowCount(0);
			            String numeroVenta = (String) cboVenta.getSelectedItem();
			            
			            Venta venta = new Venta();
			            venta = ventacontroller.obtenerVentaPorNumeroVenta(numeroVenta);
			            List<DetalleVenta> listarDetalleVenta = detalleventacontroller.listarDetalleVentaPorNumeroFactura(numeroVenta);
			            
			            if (listarDetalleVenta != null && !listarDetalleVenta.isEmpty()) {
			                for (DetalleVenta detalleventa : listarDetalleVenta) {
			                    String nombreProducto = productocontroller.obtenerNombreProductoPorId(detalleventa.getId_producto());
			                    Object[] fila = {
			                            nombreProducto,
			                            detalleventa.getCantidad()
			                    };
			                    modelo.addRow(fila);
			                }
			                
			                rbCliente.setSelected(true);
			                rbInterno.setSelected(false);
			                cboCliente.setVisible(true);
			                Cliente cliente = clientecontroller.buscarClientePorId(venta.getId_cliente());
			                String nombreCliente = cliente.getNombre();
			                cboCliente.setSelectedItem(nombreCliente);
			            } else {
			                // Mostrar JOptionPane indicando que el número de venta no existe.
			                JOptionPane.showMessageDialog(null, "El número de venta no existe", "Número no encontrado", JOptionPane.WARNING_MESSAGE);
			            }
			        }
			 	}
			 });
		 
		 rbCliente.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		if(rbCliente.isSelected()) {
						rbInterno.setSelected(false);
						cboCliente.setVisible(true);
					}
			 	}
			 });
		 
		 rbInterno.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		if(rbInterno.isSelected()) {
						rbCliente.setSelected(false);
						cboCliente.setVisible(false);
					}
			 	}
			 });
		 
		 cboProducto.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
					String nombreProducto = (String) cboProducto.getSelectedItem();
					int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProducto);
					Producto producto = new Producto();
					producto = productocontroller.obtenerProductoPorId(idProducto);
					
					txtVenta.setText(String.valueOf(producto.getPrecio_venta()));
					txtCantidad.setText(String.valueOf(producto.getStock()));
			 	}
			 });
		 
		 btnLimpiar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		limpiar();
			 	}
			 });
		 
		 btnAgregarProducto.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		Object valorspinner = spinnerCantidad.getValue();
					
					if(valorspinner instanceof Integer) {
						int cantidad = (int) valorspinner;
						
						if(cantidad > 0) {
							
							String nombreProducto = (String) cboProducto.getSelectedItem();
							//int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProducto);
							Producto productoInfo = productocontroller.obtenerProductoPorNombre(nombreProducto);
							
							int stockProducto = productoInfo.getStock();
							
							if(stockProducto >= cantidad) {
								Object[] fila = {nombreProducto, cantidad};
								modelo.addRow(fila);
								
								cboProducto.setSelectedIndex(0);
								txtVenta.setText("");
								txtCantidad.setText("");
								spinnerCantidad.setValue(0);

							}
							
							else {
								JOptionPane.showMessageDialog(ifrm_Salida.this, "No tenemos suficiente Stock para la cantidad necesitada.", "Error", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						
						else {						
							JOptionPane.showMessageDialog(ifrm_Salida.this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);						
						}
						
					}
					
					else {
						JOptionPane.showMessageDialog(ifrm_Salida.this, "Por favor, ingrese una cantidad válida en el Spinner.", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
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
			            JOptionPane.showMessageDialog(ifrm_Salida.this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			 	}
			 });
		 
		 btnGuiaSalida.addActionListener(new ActionListener() {
			 private List<Producto> productos = new ArrayList<>();
			 private List<Guia_Detalle> guiadetalles = new ArrayList<>();
			 
			 public void actionPerformed(ActionEvent e) {
			 		
				 try {
					 /*LOGICA PARA DAR SALIDA A PRODUCTOS*/
					 int rowCount = modelo.getRowCount();
					 for(int i = 0; i < rowCount ; i++) {
				          String nombreProducto = (String) modelo.getValueAt(i, 0);
				          int cantidad = (int) modelo.getValueAt(i, 1);
				          
				          int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProducto);
				          Producto producto = new Producto();
				          producto.setId(idProducto);
				          producto.setStock(cantidad);
				          productos.add(producto);
					 }
					 for(Producto producto : productos) {
						 productocontroller.darSalidaProducto(producto);
					 }
					 /*TERMINA LOGICA DE SALIDA DE PRODUCTOS*/
					 
					 /*LOGICA DE REGISTRO DE GUIA SALIDA*/
					 String motivo = txtMotivo.getText();
					 String destinatario;
					 if(motivo.isEmpty()) {
						 JOptionPane.showMessageDialog(ifrm_Salida.this, "El campo Motivo y Observación no pueden estar vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
					 }				 
					 else {
						 if(rbCliente.isSelected()) {
							 String nombreCliente = (String) cboCliente.getSelectedItem();
							 destinatario = nombreCliente;
							 Empleado empleado = empleadocontroller.buscarEmpleadoPorDni(usuarioValidado.getDni());
							 						 
							 /*GENERACION DE GUIA*/
							 String numeroGuia = guiacontroller.generarNumeroGuia();
							 int idEmpleado = empleado.getId();
							 
							 int idGuiaGenerada = guiacontroller.registrarGuia(numeroGuia, idEmpleado, motivo);
							 
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
					            
							 /*INICIA GUIA SALIDA*/
					            Guia_Salida guiasalida = new Guia_Salida();
					            guiasalida.setId_guia(idGuiaGenerada);
					            guiasalida.setDestinatario(destinatario);
					            guiasalidacontroller.registrarGuiaSalida(guiasalida);
					         /*TERMINA GUIA SALIDA*/
					            
					            Reporte.ReporteSalida();
					            limpiar();
					            JOptionPane.showMessageDialog(ifrm_Salida.this, "Ajuste de Inventario y Guía de Salida : " + numeroGuia + " generadas con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
						 }
						 else {
							 destinatario = "Uso Interno";						 
							 Empleado empleado = empleadocontroller.buscarEmpleadoPorDni(usuarioValidado.getDni());
	 						 
							 /*GENERACION DE GUIA*/
							 String numeroGuia = guiacontroller.generarNumeroGuia();
							 int idEmpleado = empleado.getId();
							 
							 int idGuiaGenerada = guiacontroller.registrarGuia(numeroGuia, idEmpleado, motivo);
							 
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
					            
							 /*INICIA GUIA SALIDA*/
					            Guia_Salida guiasalida = new Guia_Salida();
					            guiasalida.setId_guia(idGuiaGenerada);
					            guiasalida.setDestinatario(destinatario);
					            guiasalidacontroller.registrarGuiaSalida(guiasalida);
					         /*TERMINA GUIA SALIDA*/
					            limpiar();
					            JOptionPane.showMessageDialog(ifrm_Salida.this, "Ajuste de Inventario y Guía de Salida : " + numeroGuia + " generadas con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
						 }
						 
					 }
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				 
			 	}
			 });
	}
	private void actualizarComboBoxProducto() {
		List<Producto> listaProducto = productocontroller.listarProducto();
		cboProducto.removeAllItems();
		
		for(Producto producto : listaProducto) {
			cboProducto.addItem(producto.getDescripcion());
		} 
	}
	
	private void actualizarComboBoxCliente() {
		List<Cliente> listaCliente = clientecontroller.listarCliente();
		cboCliente.removeAllItems();
		
		for(Cliente cliente : listaCliente) {
			cboCliente.addItem(cliente.getNombre());
		} 
	}
	
	private void actualizarComboBoxSalida() {
		List<Venta> listaVenta = ventacontroller.listarVentas();
		cboVenta.removeAllItems();
		
		for(Venta venta : listaVenta) {						
			cboVenta.addItem(venta.getNumero_venta());
		} 
	}
		
	private void limpiar(){
		txtMotivo.setText("");
		cboProducto.setSelectedIndex(0);
		spinnerCantidad.setValue(0);
		txtVenta.setText("");
		txtCantidad.setText("");
		rbCliente.setSelected(false);
		rbInterno.setSelected(false);
		cboCliente.setVisible(false);
	}
}
