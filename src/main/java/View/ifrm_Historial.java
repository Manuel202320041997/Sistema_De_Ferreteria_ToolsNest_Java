package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controller.EmpleadoController;
import Controller.GuiaController;
import Controller.GuiaDetalleController;
import Controller.GuiaIngresoController;
import Controller.GuiaRemisionController;
import Controller.GuiaSalidaController;
import Controller.ProductoController;
import Controller.ProveedorController;
import Controller.TransportistaController;
import Model.DetalleCompra;
import Model.Guia;
import Model.Guia_Detalle;
import Model.Guia_Ingreso;
import Model.Guia_Remision;
import Model.Guia_Salida;
import Model.Proveedor;
import Model.Transportista;
import Model.Usuario;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ifrm_Historial extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel modeloIngresos;
	DefaultTableModel modeloSalida;
	DefaultTableModel modeloRemision;
	private JDialog dialog;
	DefaultTableModel modelo2;
	private JTable tblIngresos;
	private JTable tblSalida;
	private JTable tblRemision;
	private JTable tblDetalle;
	private GuiaIngresoController guiaingresocontroller;
	private GuiaSalidaController guiasalidacontroller;
	private GuiaRemisionController guiaremisioncontroller;
	private ProveedorController proveedorcontroller;
	private TransportistaController transportistacontroller;
	private EmpleadoController empleadocontroller;
	private GuiaController guiacontroller;
	private GuiaDetalleController guiadetallecontroller;
	private ProductoController productocontroller;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_Historial frame = new ifrm_Historial();
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
	public ifrm_Historial() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		guiaingresocontroller = new GuiaIngresoController();
		guiasalidacontroller = new GuiaSalidaController();
		guiaremisioncontroller = new GuiaRemisionController();
		guiacontroller = new GuiaController();
		proveedorcontroller = new ProveedorController();
		transportistacontroller = new TransportistaController();
		empleadocontroller = new EmpleadoController();
		guiadetallecontroller = new GuiaDetalleController();
		productocontroller = new ProductoController();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(21, 23, 1221, 514);
		getContentPane().add(tabbedPane);
		
		/**********INGRESOS*********/
		
		JPanel panelIngresos = new JPanel();
		tabbedPane.addTab("Ingresos", null, panelIngresos, null);
		

		modeloIngresos = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Fecha Registro", "N° Guia", "Proveedor", "Transportista", "Observacion", "Motivo", "Empleado"
	            }
	        );

		tblIngresos = new JTable(modeloIngresos);
		
		tblIngresos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblIngresos.getTableHeader().setOpaque(false);
		tblIngresos.getTableHeader().setBackground(new Color(40, 39, 61));
		tblIngresos.setSelectionBackground(new Color(241, 110, 79));
		tblIngresos.getTableHeader().setForeground(new Color(255, 255, 255));
		tblIngresos.setRowHeight(25);
		tblIngresos.setDefaultEditor(Object.class, null);
		
		tblIngresos.setDefaultEditor(Object.class, null);
		tblIngresos.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblIngresos.getColumnModel().getColumn(1).setPreferredWidth(20);
		tblIngresos.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblIngresos.getColumnModel().getColumn(3).setPreferredWidth(100);// Descripcion
		tblIngresos.getColumnModel().getColumn(4).setPreferredWidth(150); // Cantidad
		tblIngresos.getColumnModel().getColumn(5).setPreferredWidth(100);
		tblIngresos.getColumnModel().getColumn(6).setPreferredWidth(100);
		panelIngresos.setLayout(null);
		
		tblIngresos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		            //((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		            c.setBackground(table.getBackground());
		            // Restaurar el color de texto predeterminado
		            c.setForeground(table.getForeground());
		        }

		        return c;
		    }
		});

		tblIngresos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblIngresos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblIngresos.setIntercellSpacing(new Dimension(0, 0));
		tblIngresos.setShowGrid(false);
		tblIngresos.setShowHorizontalLines(true);
		tblIngresos.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblIngresos.setShowVerticalLines(true);
		tblIngresos.setGridColor(new Color(200, 200, 200));
		

		 mostrarTablaIngreso();
		 JScrollPane scrollPaneIngreso = new JScrollPane(tblIngresos);
		 scrollPaneIngreso.setBounds(0, 0, 1216, 486);
		 panelIngresos.add(scrollPaneIngreso);
		 
		 tblIngresos.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) {
			            int filaSeleccionada = tblIngresos.getSelectedRow();
			            if (filaSeleccionada != -1) {
			                // Obtener la factura seleccionada
			                //Factura factura = obtenerFacturaDesdeLaFila(filaSeleccionada);
			            	Object columGuia = tblIngresos.getValueAt(filaSeleccionada, 1);
			            	String numeroGuia = columGuia.toString();

			                // Aquí debes abrir una nueva vista con el detalle de la factura
			                // Puedes usar un JDialog, un JInternalFrame o cualquier otro contenedor
			            	mostrarDetalleGuia(numeroGuia);
			            }
			        }
			    }
			});

		
		 /**********SALIDAS*********/
		JPanel panelSalidas = new JPanel();
		tabbedPane.addTab("Salidas", null, panelSalidas, null);
		
		modeloSalida = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Fecha Registro", "N° Guia", "Destinatario", "Motivo", "Empleado"
	            }
	        );

		tblSalida = new JTable(modeloSalida);
		tblSalida.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblSalida.getTableHeader().setOpaque(false);
		tblSalida.getTableHeader().setBackground(new Color(40, 39, 61));
		tblSalida.setSelectionBackground(new Color(241, 110, 79));
		tblSalida.getTableHeader().setForeground(new Color(255, 255, 255));
		tblSalida.setRowHeight(25);
		tblSalida.setDefaultEditor(Object.class, null);
		
		tblSalida.setDefaultEditor(Object.class, null);
		tblSalida.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblSalida.getColumnModel().getColumn(1).setPreferredWidth(20);
		tblSalida.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblSalida.getColumnModel().getColumn(3).setPreferredWidth(150);// Descripcion
		tblSalida.getColumnModel().getColumn(4).setPreferredWidth(100); // Cantidad
		
		
		panelSalidas.setLayout(null);
		
		tblSalida.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

		tblSalida.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblSalida.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblSalida.setIntercellSpacing(new Dimension(0, 0));
		tblSalida.setShowGrid(false);
		tblSalida.setShowHorizontalLines(true);
		tblSalida.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblSalida.setShowVerticalLines(true);
		tblSalida.setGridColor(new Color(200, 200, 200));
		

		 mostrarTablaSalida();
		 JScrollPane scrollPaneSalida = new JScrollPane(tblSalida);
		 scrollPaneSalida.setBounds(0, 0, 1216, 486);
		 panelSalidas.add(scrollPaneSalida);
		 
		 tblSalida.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) {
			            int filaSeleccionada = tblSalida.getSelectedRow();
			            if (filaSeleccionada != -1) {
			                // Obtener la factura seleccionada
			                //Factura factura = obtenerFacturaDesdeLaFila(filaSeleccionada);
			            	Object columGuia = tblSalida.getValueAt(filaSeleccionada, 1);
			            	String numeroGuia = columGuia.toString();

			                // Aquí debes abrir una nueva vista con el detalle de la factura
			                // Puedes usar un JDialog, un JInternalFrame o cualquier otro contenedor
			            	mostrarDetalleGuia(numeroGuia);
			            }
			        }
			    }
			});

		 /**********REMISION*********/
		JPanel panelRemision = new JPanel();
		tabbedPane.addTab("Remision", null, panelRemision, null);
		
		modeloRemision = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Fecha Registro", "N° Guia", "Punto Partida", "Punto Llegada", "Motivo", "Empleado"
	            }
	        );

		tblRemision = new JTable(modeloRemision);
		tblRemision.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblRemision.getTableHeader().setOpaque(false);
		tblRemision.getTableHeader().setBackground(new Color(40, 39, 61));
		tblRemision.setSelectionBackground(new Color(241, 110, 79));
		tblRemision.getTableHeader().setForeground(new Color(255, 255, 255));
		tblRemision.setRowHeight(25);
		tblRemision.setDefaultEditor(Object.class, null);

		tblRemision.setDefaultEditor(Object.class, null);
		tblRemision.getColumnModel().getColumn(0).setPreferredWidth(20);
		tblRemision.getColumnModel().getColumn(1).setPreferredWidth(20);
		tblRemision.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblRemision.getColumnModel().getColumn(3).setPreferredWidth(150);// Descripcion
		tblRemision.getColumnModel().getColumn(4).setPreferredWidth(100); // Cantidad
		tblRemision.getColumnModel().getColumn(5).setPreferredWidth(100);
		panelRemision.setLayout(null);
		
		tblRemision.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

		tblRemision.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblRemision.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblRemision.setIntercellSpacing(new Dimension(0, 0));
		tblRemision.setShowGrid(false);
		tblRemision.setShowHorizontalLines(true);
		tblRemision.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblRemision.setShowVerticalLines(true);
		tblRemision.setGridColor(new Color(200, 200, 200));

		 mostrarTablaRemision();
		 JScrollPane scrollPaneRemision = new JScrollPane(tblRemision);
		 scrollPaneRemision.setBounds(0, 0, 1216, 486);
		 panelRemision.add(scrollPaneRemision);
		 
		 tblRemision.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) {
			            int filaSeleccionada = tblRemision.getSelectedRow();
			            if (filaSeleccionada != -1) {
			                // Obtener la factura seleccionada
			                //Factura factura = obtenerFacturaDesdeLaFila(filaSeleccionada);
			            	Object columGuia = tblRemision.getValueAt(filaSeleccionada, 1);
			            	String numeroGuia = columGuia.toString();

			                // Aquí debes abrir una nueva vista con el detalle de la factura
			                // Puedes usar un JDialog, un JInternalFrame o cualquier otro contenedor
			            	mostrarDetalleGuia(numeroGuia);
			            }
			        }
			    }
			});

	}
	
	private void mostrarTablaIngreso() {
		modeloIngresos.setRowCount(0); // Limpiar la tabla antes de agregar datos
		List<Guia_Ingreso> listaringreso = guiaingresocontroller.listarGuiaIngreso();
		
		 for (Guia_Ingreso guiaingreso : listaringreso) {
			  Proveedor proveedor = proveedorcontroller.buscarProveeedorPorId(guiaingreso.getId_proveedor());
			  Guia guia = guiacontroller.obtenerGuiaPorId(guiaingreso.getId_guia());
			  Transportista transportista = transportistacontroller.obtenerTransportistaPorId(guiaingreso.getId_transportista());
			  String nombreEmpleado = empleadocontroller.obtenerNombreEmpleadoPorId(guia.getId_empleado());
			 
			 	Object[] fila = {
		        		
		        		guiaingreso.getFecha_registro(),
		        		guia.getNumero_guia(),
		        		proveedor.getRazon_social(),      		
		        		transportista.getNombres(),
		        		guiaingreso.getObservacion(),
		        		guia.getMotivo(),
		        		nombreEmpleado

		        };
		        modeloIngresos.addRow(fila);
		    }
	}
	
	private void mostrarTablaSalida() {
		modeloSalida.setRowCount(0); // Limpiar la tabla antes de agregar datos
		List<Guia_Salida> listarSalida = guiasalidacontroller.listarGuiaSalida();
		
		 for (Guia_Salida guiasalida : listarSalida) {		 
			  Guia guia = guiacontroller.obtenerGuiaPorId(guiasalida.getId_guia());			  
			  String nombreEmpleado = empleadocontroller.obtenerNombreEmpleadoPorId(guia.getId_empleado());
			 
			 	Object[] fila = {
		        		
			 			guiasalida.getFecha_registro(),
		        		guia.getNumero_guia(),
		        		guiasalida.getDestinatario(),
		        		guia.getMotivo(),
		        		nombreEmpleado

		        };
			 	modeloSalida.addRow(fila);
		    
		    }
	}
	
	private void mostrarTablaRemision() {
		modeloRemision.setRowCount(0); // Limpiar la tabla antes de agregar datos
		List<Guia_Remision> listarRemision = guiaremisioncontroller.listarGuiaRemision();
		
		 for (Guia_Remision guiaremision : listarRemision) {		 
			  Guia guia = guiacontroller.obtenerGuiaPorId(guiaremision.getId_guia());			  
			  String nombreEmpleado = empleadocontroller.obtenerNombreEmpleadoPorId(guia.getId_empleado());
			 
			 	Object[] fila = {
		        		
			 			guiaremision.getFecha_registro(),
		        		guia.getNumero_guia(),
		        		guiaremision.getPunto_partida(),
		        		guiaremision.getPunto_llegada(),
		        		guia.getMotivo(),
		        		nombreEmpleado

		        };
			 	modeloRemision.addRow(fila);
		    
		    }
	}
	
	private void mostrarDetalleGuia(String numeroGuia) {
		   	dialog = new JDialog();
		    dialog.setTitle("Detalle de la Guia " + numeroGuia);
		    dialog.setSize(700, 480);
		    dialog.setLocationRelativeTo(null);
		    dialog.setResizable(false);

		    JPanel contentPanel = new JPanel();
		    contentPanel.setBackground(new Color(51, 52, 78));
		    dialog.add(contentPanel);

		    modelo2 = new DefaultTableModel(
		        new Object[][] {},
		        new String[] { "Producto", "Cantidad"}
		    );

		    tblDetalle = new JTable(modelo2);
		    tblDetalle.setDefaultEditor(Object.class, null);
		    tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(100); // Producto
		    tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(20); // Cantidad

		    mostrarTablaDetalle(numeroGuia);

		    JScrollPane scrollPane = new JScrollPane(tblDetalle);
		    scrollPane.setBounds(37, 85, 680, 480);
		    contentPanel.add(scrollPane);

		    dialog.setVisible(true);
		
	}
	
	public void mostrarTablaDetalle(String numeroGuia) {
	    try {
	        if (modelo2 != null) {
	            modelo2.setRowCount(0);

	            List<Guia_Detalle> listarDetalle = guiadetallecontroller.listarDetalleGuiaPorNumeroGuia(numeroGuia);

	            if (listarDetalle != null) {
	                for (Guia_Detalle detalleguia : listarDetalle) {
	                    String nombreProducto = productocontroller.obtenerNombreProductoPorId(detalleguia.getId_producto());
	                    Object[] fila = {
	                        nombreProducto,
	                        detalleguia.getCantidad(),

	                    };
	                    modelo2.addRow(fila);
	                }
	            }
	        } else {
	            System.err.println("Hola");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Manejar la excepción de manera apropiada
	    }
	    
	}
}
