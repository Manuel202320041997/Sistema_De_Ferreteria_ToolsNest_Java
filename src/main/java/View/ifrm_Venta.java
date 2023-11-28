package View;

import java.awt.Color;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import View.frm_Inicio;

import Controller.CorreoController;
import Controller.ClienteController;
import Controller.DetalleVentaController;
import Controller.EmpleadoController;
import Controller.MetodoPagoController;
import Controller.NumeroEnTextoController;
import Controller.ProductoController;
import Controller.VentaController;
import Model.Reporte;
import Model.ReporteExcel;
import Controller.ReporteController;
import Model.Cliente;
import Model.DetalleCompra;
import Model.DetalleVenta;
import Model.Empleado;
import Model.MetodoPago;
import Model.Producto;
import Model.Usuario;
import Model.Venta;
import Model.Correo;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;




import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ifrm_Venta extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	DefaultTableModel modelo;
	private NumeroEnTextoController numeroentextocontroller;
	private VentaController facturaController;
	private ProductoController productoController;
	private ClienteController clienteController;
	private VentaController ventaController;
	private DetalleVentaController detalleVentaController;
	private EmpleadoController empleadocontroller;
	private MetodoPagoController metodopagocontroller;
	private CorreoController correocontroller;
	private ReporteController reportecontroller;
	private JTextField txtBuscar;
	private JTextField txtSubTotal;
	private JComboBox<String> cboCliente; 
	private JComboBox<String> cboProducto;
	private JComboBox cboMetodoPago;
	private JTextField txtDescuento;
	private JTextField txtIGV;
	private JTextField txtTotalTexto;
	private JTextField txtCambio;
	private JSpinner spinnerCantidad;
	private JSpinner spinnerEfectivo;	
	private JTable tblVenta;
	private JTable table;
	private JTable tbl_Venta;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario usuarioValidado = new Usuario();
					ifrm_Venta frame = new ifrm_Venta(usuarioValidado);
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
	public ifrm_Venta(Usuario usuarioValidado) {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);	
			
		reportecontroller = new ReporteController();
		correocontroller = new CorreoController();
		ventaController = new VentaController();
	    productoController = new ProductoController();
	    clienteController = new ClienteController();
	    detalleVentaController = new DetalleVentaController();
	    empleadocontroller = new EmpleadoController();
		metodopagocontroller = new MetodoPagoController();
		numeroentextocontroller = new NumeroEnTextoController();

	       // actualizarComboBoxClientes();
	       // actualizarComboBoxProductos();

	      ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(511, 32, 711, 505);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cliente:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(62, 201, 73, 25);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Producto:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(62, 274, 92, 25);
		panel.add(lblNewLabel_3);
		
		cboCliente = new JComboBox<String>();
		cboCliente.setBackground(new Color(255, 255, 255));
		cboCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DatosDelProducto();
				//registrarProducto();
				//CargarComboProducto();
			}
		});
		cboCliente.setBounds(157, 201, 186, 25);
		cboCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboCliente.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Cliente"}));
		actualizarComboBoxClientes();
		panel.add(cboCliente);
		
		
		cboProducto = new JComboBox<String>();
		cboProducto.setBackground(new Color(255, 255, 255));
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//CargarComboProducto();
			}
		});
		cboProducto.setBounds(157, 274, 186, 25);
		cboProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboProducto.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Producto"}));
		actualizarComboBoxProductos();
		panel.add(cboProducto);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(62, 310, 78, 25);
		panel.add(lblNewLabel_4);
		
		JSpinner spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinnerCantidad.setBounds(157, 310, 186, 25);
		panel.add(spinnerCantidad);
		
		JButton btnAgregar = new JButton("Registrar");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAgregar.setBackground(new Color(51, 52, 78));
		btnAgregar.setBounds(91, 357, 228, 41);
		btnAgregar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregar.png")));
		panel.add(btnAgregar);
		
		JLabel lblNewLabel_5 = new JLabel("Cliente ID:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(159, 129, 85, 13);
		panel.add(lblNewLabel_5);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(231, 126, 55, 19);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(51, 52, 78));
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/buscar.png")));
		btnBuscar.setBounds(296, 120, 47, 30);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_6 = new JLabel("SubTotal:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(451, 122, 70, 13);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Descuento:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(439, 158, 82, 13);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("iGV:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(476, 207, 45, 13);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Total:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(465, 257, 45, 13);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Efectivo:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(451, 306, 70, 13);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cambio:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(451, 353, 70, 13);
		panel.add(lblNewLabel_11);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setBounds(531, 121, 96, 19);
		panel.add(txtSubTotal);
		txtSubTotal.setColumns(10);
		
		txtDescuento = new JTextField();
		txtDescuento.setEditable(false);
		txtDescuento.setBounds(531, 157, 96, 19);
		panel.add(txtDescuento);
		txtDescuento.setColumns(10);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setBounds(530, 206, 96, 19);
		panel.add(txtIGV);
		txtIGV.setColumns(10);
		
		txtTotalTexto = new JTextField();
		txtTotalTexto.setEditable(false);
		txtTotalTexto.setBounds(531, 256, 96, 19);
		panel.add(txtTotalTexto);
		txtTotalTexto.setColumns(10);
		
		txtCambio = new JTextField();
		txtCambio.setEditable(false);
		txtCambio.setBounds(531, 352, 96, 19);
		panel.add(txtCambio);
		txtCambio.setColumns(10);
		
		JSpinner spinnerEfectivo = new JSpinner();
		spinnerEfectivo.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerEfectivo.setBounds(531, 305, 96, 20);
		panel.add(spinnerEfectivo);
		
		JButton btnNuevaVenta = new JButton("Venta");
		btnNuevaVenta.setForeground(new Color(255, 255, 255));
		btnNuevaVenta.setBackground(new Color(51, 52, 78));
		btnNuevaVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNuevaVenta.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/venta-factura.png")));
		btnNuevaVenta.setBounds(20, 443, 115, 51);
		panel.add(btnNuevaVenta);
		
		JButton btnCambio = new JButton("Cambio");
		btnCambio.setForeground(new Color(255, 255, 255));
		btnCambio.setBackground(new Color(51, 52, 78));
		btnCambio.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCambio.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/intercambiar.png")));
		btnCambio.setBounds(145, 443, 124, 51);
		panel.add(btnCambio);
		
		JButton btnRegistrarVenta = new JButton("Vender");
		btnRegistrarVenta.setForeground(new Color(255, 255, 255));
		btnRegistrarVenta.setBackground(new Color(51, 52, 78));
		btnRegistrarVenta.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRegistrarVenta.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/vender.png")));
		btnRegistrarVenta.setBounds(279, 443, 126, 51);
		panel.add(btnRegistrarVenta);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(40, 39, 61));
		panel_1.setBounds(0, 0, 711, 70);
		//getContentPane().setBackground(new Color(51, 52, 78));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(21, 0, 64, 64);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\logo.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Facturas");
		lblNewLabel_1.setBounds(315, 10, 138, 33);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		/*
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(166, 159, 124, 21);
		panel.add(cboCliente);
		
		JComboBox cboProducto = new JComboBox();
		cboProducto.setBounds(164, 215, 126, 21);
		panel.add(cboProducto);
		*/
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCalcular.setForeground(new Color(255, 255, 255));
		btnCalcular.setBounds(476, 408, 142, 29);
		btnCalcular.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/calculadora.png")));
		btnCalcular.setBackground(new Color(51, 52, 78));
		panel.add(btnCalcular);
		
		JLabel Calcular = new JLabel("");
		Calcular.setBorder(new LineBorder(new Color(0, 0, 0)));
		Calcular.setBounds(432, 101, 217, 354);
		panel.add(Calcular);
		
		txtTotal = new JTextField();
		txtTotal.setVisible(false);
		txtTotal.setBounds(652, 254, 49, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Metodo Pago:");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(62, 238, 92, 25);
		panel.add(lblNewLabel_3_1);
		
		cboMetodoPago = new JComboBox();
		cboMetodoPago.setFont(new Font("Tahoma", Font.BOLD, 14));
		cboMetodoPago.setBackground(Color.WHITE);
		cboMetodoPago.setBounds(157, 238, 186, 25);
		actualizarComboBoxMetodoPago();
		panel.add(cboMetodoPago);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_6_1_1.setBounds(31, 101, 324, 319);
		panel.add(lblNewLabel_6_1_1);
		 
			modelo = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		                "Nombre", "Cantidad", "P. Venta"
		            }
		        );

			tbl_Venta = new JTable(modelo);
			tbl_Venta.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
			tbl_Venta.getTableHeader().setOpaque(false);
			tbl_Venta.getTableHeader().setBackground(new Color(40, 39, 61));
			tbl_Venta.setSelectionBackground(new Color(241, 110, 79));
			tbl_Venta.getTableHeader().setForeground(new Color(255, 255, 255));
			tbl_Venta.setRowHeight(25);
			tbl_Venta.setDefaultEditor(Object.class, null);
			tbl_Venta.setDefaultEditor(Object.class, null);
			tbl_Venta.getColumnModel().getColumn(0).setPreferredWidth(50); // ID
			tbl_Venta.getColumnModel().getColumn(1).setPreferredWidth(30); // DNI
			tbl_Venta.getColumnModel().getColumn(2).setPreferredWidth(20); // Nombre

			 //mostrarTabla();
			tbl_Venta.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

			tbl_Venta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tbl_Venta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tbl_Venta.setIntercellSpacing(new Dimension(0, 0));
			tbl_Venta.setShowGrid(false);
			tbl_Venta.setShowHorizontalLines(true);
			tbl_Venta.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
			tbl_Venta.setShowVerticalLines(true);
			tbl_Venta.setGridColor(new Color(200, 200, 200));
			 JScrollPane scrollPane = new JScrollPane(tbl_Venta);
			 scrollPane.setBounds(22, 32, 459, 505);
			 getContentPane().add(scrollPane);
			/* 
			 tblCliente_1 = new JTable();
			 scrollPane.setColumnHeaderView(tblCliente_1);
			 */
			 tbl_Venta = new JTable();
			 tbl_Venta.setBounds(0, 0, 1, 1);
			 getContentPane().add(tbl_Venta);
		 
			 
			txtBuscar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtBuscar.setText("");
				}
			});
			 
			 btnAgregar.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				        Object spinnerValue = spinnerCantidad.getValue();

				        if (spinnerValue instanceof Integer) {
				            int cantidad = (int) spinnerValue;
				            if (cantidad > 0) {
				                String nombreProducto = (String) cboProducto.getSelectedItem();
				                Producto productoInfo = productoController.obtenerProductoPorNombre(nombreProducto);

				                if (productoInfo != null) {
				                    int stockProducto = productoInfo.getStock();
				                    double precioProducto = productoInfo.getPrecio_venta();

				                    if (stockProducto >= cantidad) {
				                        Object[] fila = {nombreProducto, cantidad, precioProducto};
				                        modelo.addRow(fila);
				                        spinnerCantidad.setValue(0);
				                    } else {
				                        JOptionPane.showMessageDialog(ifrm_Venta.this, "No contamos con el suficiente Stock para la Cantidad ingresada.", "Error", JOptionPane.ERROR_MESSAGE);
				                    }
				                } else {
				                    JOptionPane.showMessageDialog(ifrm_Venta.this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
				                }
				            } else {
				                JOptionPane.showMessageDialog(ifrm_Venta.this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
				            }
				        } else {
				            JOptionPane.showMessageDialog(ifrm_Venta.this, "Por favor, ingrese una cantidad válida en el Spinner.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
				    }
				});
		 
		 btnBuscar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        try {
			            int idCliente = Integer.parseInt(txtBuscar.getText());
			            Cliente clienteEncontrado = clienteController.buscarClientePorId(idCliente);

			            if (clienteEncontrado != null) {
			                // Limpia el ComboBox y agrega el nombre del cliente encontrado
			                cboCliente.removeAllItems();
			                cboCliente.addItem(clienteEncontrado.getNombre());
			            } else {
			                JOptionPane.showMessageDialog(ifrm_Venta.this, "Cliente no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			            }

			        } catch (Exception e2) {
			            e2.printStackTrace();
			        }
			    }
			});
		 
			btnCalcular.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String clienteSeleccionado = (String) cboCliente.getSelectedItem();
					
					List<DetalleVenta> detalleProductos = new ArrayList<>();
					
					for (int i = 0; i < modelo.getRowCount(); i++) {
					    String nombreProducto = (String) modelo.getValueAt(i, 0);
					    int idProducto = productoController.obtenerIdProductoPorNombre(nombreProducto);
					    int cantidad = (int) modelo.getValueAt(i, 1);
					    double Pre = (double) modelo.getValueAt(i, 2);					    

					    DetalleVenta detalle = new DetalleVenta(idProducto, cantidad, Pre);
					    detalleProductos.add(detalle);
					}			

			        // Realizar el cálculo y obtener los resultados
					 Map<String, Double> resultados = detalleVentaController.calcularVenta(clienteSeleccionado, detalleProductos);
					 double total = resultados.get("totalPagar");	
					 
					 String totalPagarTexto = numeroentextocontroller.convertirGrupoEnPalabras(total);

			        // Mostrar los resultados en los campos de texto
			        txtSubTotal.setText(String.valueOf(resultados.get("subTotal")));
			        txtDescuento.setText(String.valueOf(resultados.get("descuento")));
			        txtIGV.setText(String.valueOf(resultados.get("igv")));
			        txtTotal.setText(String.valueOf(total));
			        txtTotalTexto.setText(totalPagarTexto);
					
				}
			});
			
			btnCambio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					double efectivo = (double) spinnerEfectivo.getValue();
					double total = Double.parseDouble(txtTotal.getText());			            
			            
			            if (efectivo > 0) {  // Validar que la cantidad sea mayor que cero
			            	
			            	if(efectivo >= total) {
			            		
			            		double cambio = efectivo - total;
			            		System.out.println(cambio);
			            		cambio = Math.round(cambio * 100.0) / 100.0;
				            	txtCambio.setText(String.valueOf(cambio));
			            	}
			            	else {
			            		JOptionPane.showMessageDialog(ifrm_Venta.this, "El efectivo ingresado es menor al total a Pagar", "Error", JOptionPane.ERROR_MESSAGE);
			            	}			            	
			            }
			            else {
			            	JOptionPane.showMessageDialog(ifrm_Venta.this, "Ingresa efectivo del Cliente", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        }
				
			});
			
			btnRegistrarVenta.addActionListener(new ActionListener() {
			    private List<DetalleVenta> detallesVenta = new ArrayList<>();

			    public void actionPerformed(ActionEvent e) {
			    	 String nombreCliente = (String) cboCliente.getSelectedItem();
			         System.out.println("Nombre del Cliente: " + nombreCliente);

			         int idCliente = clienteController.obtenerIdClientePorNombre(nombreCliente);
			         System.out.println("ID del Cliente: " + idCliente);

			         String nombreModoPago = (String) cboMetodoPago.getSelectedItem();
			         System.out.println("Nombre del Modo de Pago: " + nombreModoPago);

			         Empleado empleado = empleadocontroller.buscarEmpleadoPorDni(usuarioValidado.getDni());

			         // Validar que el campo de texto txtTotal no esté vacío
			         String totalText = txtTotal.getText().trim();
			         if (totalText.isEmpty()) {
			             JOptionPane.showMessageDialog(ifrm_Venta.this, "Ingrese un monto total válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
			             return;
			         } else {
			             double total = Double.parseDouble(totalText);
			             System.out.println("Total: " + total);

			             int idModoPago = metodopagocontroller.obtenerIdMetodoPagoPorNombre(nombreModoPago);
			             System.out.println("ID del Modo de Pago: " + idModoPago);

			             int idEmpleado = empleado.getId();
			             System.out.println("ID del Empleado: " + idEmpleado);

			             if (total <= 0) {
			                 JOptionPane.showMessageDialog(ifrm_Venta.this, "No hay productos en la tabla", "Aviso", JOptionPane.WARNING_MESSAGE);
			                 return;
			             } else {
			                 String numeroVenta = ventaController.generarNumeroFactura();
			                 System.out.println("Número de Venta: " + numeroVenta);

			                 int idVenta = ventaController.registrarVenta(numeroVenta, idCliente, total, idModoPago, idEmpleado);
			                 System.out.println("ID de la Venta: " + idVenta);

			                 int rowCount = modelo.getRowCount();
			                 for (int i = 0; i < rowCount; i++) {
			                     int idProducto = productoController.obtenerIdProductoPorNombre((String) modelo.getValueAt(i, 0));
			                     double precioVenta = (double) modelo.getValueAt(i, 2);
			                     int cantidad = (int) modelo.getValueAt(i, 1);

			                     System.out.println("Detalles de Venta - Producto: " + idProducto + ", Precio: " + precioVenta + ", Cantidad: " + cantidad);

			                     DetalleVenta detalleVenta = new DetalleVenta();
			                     detalleVenta.setId_venta(idVenta);
			                     detalleVenta.setId_producto(idProducto);
			                     detalleVenta.setPrecio_venta(precioVenta);
			                     detalleVenta.setCantidad(cantidad);
			                     detallesVenta.add(detalleVenta);
			                 }

			                 for (DetalleVenta detalle : detallesVenta) {
			                     detalleVentaController.registrarDetalleVenta(detalle);
			                 }
			                 
			                 Reporte.ReporteVenta();
			                 
			                 limpiar();
			                 JOptionPane.showMessageDialog(ifrm_Venta.this, "Venta N° " + numeroVenta + " registrada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
			                 System.out.println(idCliente);
			                 Cliente cliente = clienteController.buscarClientePorId(idCliente);
			                 
			                 Correo correo = new Correo();
			                 
			                 correo.setCorreoRecibir(cliente.getCorreo());
			                 correo.setPara(cliente.getNombre());
			                 correocontroller.correo(correo);
			             }
			         }
			    }
			});
	
			
			btnNuevaVenta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiar();
				}
			});
	}
	
	private void actualizarComboBoxMetodoPago() {
		List<MetodoPago> listaMetodoPago = metodopagocontroller.listarMetodoPago();
		
		for(MetodoPago metodopago : listaMetodoPago) {
			cboMetodoPago.addItem(metodopago.getDescripcion());
		}
	}
	
	public void actualizarComboBoxProductos() {
        // Llama al controlador para obtener la lista de productos
        List<Producto> listaProductos = productoController.listarProducto();

        // Limpia el ComboBox
        cboProducto.removeAllItems();

        // Agrega los nombres de los productos al ComboBox
        for (Producto producto : listaProductos) {
           cboProducto.addItem(producto.getDescripcion());
        }
    }

	public void actualizarComboBoxClientes() {
        List<Cliente> listarCliente = clienteController.listarCliente();

        cboCliente.removeAllItems();

        for (Cliente cliente : listarCliente) {
            cboCliente.addItem(cliente.getNombre());
        }
    }

	    private void limpiar() {
	    	// Restablece los ComboBox
	        if (cboCliente != null && cboProducto != null) {
	            cboCliente.setSelectedIndex(0);
	            cboProducto.setSelectedIndex(0);
	        }

	        // Limpia los JTextField
	        if (txtSubTotal != null && txtDescuento != null && txtIGV != null && txtTotal != null && txtCambio != null && txtBuscar != null) {
	            txtSubTotal.setText("");
	            txtDescuento.setText("");
	            txtIGV.setText("");
	            txtTotalTexto.setText("");
	            txtTotal.setText("");
	            txtCambio.setText("");
	            txtBuscar.setText("");
	        }

	        // Limpia el JSpinner
	        if (spinnerCantidad != null && spinnerEfectivo != null) {
	            spinnerCantidad.setValue(0);
	            spinnerEfectivo.setValue(0.0);
	        }

	        // Limpia el modelo de la tabla
	        if (tblVenta != null) {
	            DefaultTableModel modelo = (DefaultTableModel) tblVenta.getModel();
	            modelo.setRowCount(0); // Elimina todas las filas de la tabla
	        }
	    }
	}