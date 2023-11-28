package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Reporte;
import Model.ReporteExcel;
import Model.MetodoPago;
import Model.Producto;
import Model.Proveedor;
import Model.Usuario;
import Model.DetalleCompra;
import Model.Empleado;

import Controller.MetodoPagoController;
import Controller.NumeroEnTextoController;
import Controller.ProveedorController;
import Controller.ReporteController;
import Controller.UsuarioController;
import Controller.ProductoController;
import Controller.EmpleadoController;
import Controller.CompraController;
import Controller.DetalleCompraController;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

public class ifrm_OrdenesCompra extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private UsuarioController usuariocontroller;
	private MetodoPagoController metodopagocontroller;
	private ProveedorController proveedorcontroller;
	private ProductoController productocontroller;
	private EmpleadoController empleadocontroller;
	private CompraController compracontroller;
	private DetalleCompraController detallecompracontroller;
	private NumeroEnTextoController numeroentextocontroller;
	DefaultTableModel modelo;
	private JTable tblProductos;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JTextField txtPrecio;
	private JTextField txtTotalTexto;
	private JComboBox cboMetodoPago;
	private JComboBox cboProducto;
	private JComboBox cboRazonSocial;
	private JSpinner spinnerCantidad;
	private JTextField txtTotal;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario usuarioValidado = new Usuario();
					ifrm_OrdenesCompra frame = new ifrm_OrdenesCompra(usuarioValidado);
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
	public ifrm_OrdenesCompra(Usuario usuarioValidado) {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		reportecontroller = new ReporteController();
		metodopagocontroller = new MetodoPagoController();
		proveedorcontroller = new ProveedorController();
		productocontroller = new ProductoController();
		empleadocontroller = new EmpleadoController();
		compracontroller = new CompraController();
		detallecompracontroller = new DetalleCompraController();
		numeroentextocontroller = new NumeroEnTextoController();
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 340, 560);
		panel.setBackground(new Color(245,245,245));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		cboRazonSocial = new JComboBox();
		cboRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboRazonSocial.setBounds(128, 223, 176, 22);
		actualizarComboBoxProveedor();
		panel.add(cboRazonSocial);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(24, 256, 85, 22);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefono: ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(24, 286, 85, 20);
		panel.add(lblNewLabel_4);
		
		String numeroCompratexto = compracontroller.generarNumeroOrdenCompra();
		JLabel lblOrdenCompra = new JLabel("N° Orden: "+numeroCompratexto);
		lblOrdenCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOrdenCompra.setBounds(29, 78, 134, 17);
		panel.add(lblOrdenCompra);
		
		JLabel lblNewLabel_7 = new JLabel("Metodo de Pago:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(24, 121, 119, 14);
		panel.add(lblNewLabel_7);
		
		cboMetodoPago = new JComboBox();
		cboMetodoPago.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboMetodoPago.setBounds(153, 117, 156, 22);
		actualizarComboBoxMetodoPago();
		panel.add(cboMetodoPago);
		
		LocalDate fechaActual = LocalDate.now();
		JLabel lblFecha = new JLabel("Fecha: "+fechaActual);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFecha.setBounds(193, 78, 134, 14);
		panel.add(lblFecha);
		
		JLabel lblNewLabel_10 = new JLabel("ORDENES DE COMPRA");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_10.setBounds(10, 11, 324, 40);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Razón Social:");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(24, 223, 95, 20);
		panel.add(lblNewLabel_4_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(128, 286, 176, 22);
		panel.add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setEditable(false);
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(128, 256, 176, 22);
		panel.add(txtCorreo);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DETALLES DE PROVEEDOR:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(10, 192, 317, 130);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Producto:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(24, 355, 95, 20);
		panel.add(lblNewLabel_4_1_1);
		
		cboProducto = new JComboBox();
		cboProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboProducto.setBounds(128, 355, 176, 22);
		actualizarComboBoxProducto();
		panel.add(cboProducto);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(24, 388, 85, 22);
		panel.add(lblNewLabel_2_1);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerCantidad.setBounds(128, 390, 176, 22);
		panel.add(spinnerCantidad);
		
		JLabel lblNewLabel_4_2 = new JLabel("P. Unitario:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(24, 425, 85, 20);
		panel.add(lblNewLabel_4_2);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(128, 425, 176, 22);
		panel.add(txtPrecio);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DETALLES DE PRODUCTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1.setBounds(10, 333, 317, 130);
		panel.add(lblNewLabel_3_1_1);
		
		JButton btnCalcular = new JButton("Calcular Total");
		btnCalcular.setForeground(new Color(245, 245, 245));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcular.setBackground(new Color(78, 156, 54));
		btnCalcular.setBounds(10, 520, 152, 29);
		panel.add(btnCalcular);
		
		JLabel lblNewLabel_3_3 = new JLabel("Total a Pagar:");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(24, 146, 85, 22);
		panel.add(lblNewLabel_3_3);
		
		txtTotalTexto = new JTextField();
		txtTotalTexto.setEditable(false);
		txtTotalTexto.setColumns(10);
		txtTotalTexto.setBounds(153, 146, 156, 22);
		panel.add(txtTotalTexto);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DETALLE DE ORDEN DE COMPRA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_2.setBounds(10, 54, 317, 127);
		panel.add(lblNewLabel_3_2);
		
		JButton btnAgregar = new JButton("Agregar Producto");
		btnAgregar.setForeground(new Color(245, 245, 245));
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setBackground(new Color(4, 51, 108));
		btnAgregar.setBounds(10, 480, 152, 29);
		panel.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.setForeground(new Color(245, 245, 245));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));		
		btnEliminar.setBackground(new Color(144, 8, 9));
		btnEliminar.setBounds(175, 480, 152, 29);
		panel.add(btnEliminar);
		
		JButton btnRegistrarComprar = new JButton("Generar Compra");
		btnRegistrarComprar.setForeground(new Color(245, 245, 245));
		btnRegistrarComprar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrarComprar.setBackground(new Color(252, 187, 33));
		btnRegistrarComprar.setBounds(175, 520, 152, 29);
		panel.add(btnRegistrarComprar);
		
		txtTotal = new JTextField();
		txtTotal.setVisible(false);
		txtTotal.setBounds(62, 171, 86, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		/*String nombre = usuarioValidado.getNombre();
		JLabel lblUsuario = new JLabel(nombre);
		lblUsuario.setBounds(0, 11, 134, 17);
		panel.add(lblUsuario);*/
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Nombre", "Precio Compra", "Cantidad"
	            }
	        );

		tblProductos = new JTable(modelo);
		
		tblProductos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblProductos.getTableHeader().setOpaque(false);
		tblProductos.getTableHeader().setBackground(new Color(40, 39, 61));
		tblProductos.setSelectionBackground(new Color(241, 110, 79));
		tblProductos.getTableHeader().setForeground(new Color(255, 255, 255));
		tblProductos.setRowHeight(25);
		tblProductos.setDefaultEditor(Object.class, null);
		tblProductos.setDefaultEditor(Object.class, null);
		tblProductos.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblProductos.getColumnModel().getColumn(1).setPreferredWidth(150); // Nombre
		tblProductos.getColumnModel().getColumn(2).setPreferredWidth(20); // Correo
		tblProductos.getColumnModel().getColumn(3).setPreferredWidth(20);
		
		
		tblProductos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		         //   ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		            c.setBackground(table.getBackground());
		            // Restaurar el color de texto predeterminado
		            c.setForeground(table.getForeground());
		        }

		        return c;
		    }
		});

		tblProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblProductos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblProductos.setIntercellSpacing(new Dimension(0, 0));
		tblProductos.setShowGrid(false);
		tblProductos.setShowHorizontalLines(true);
		tblProductos.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblProductos.setShowVerticalLines(true);
		tblProductos.setGridColor(new Color(200, 200, 200));
		
		//mostrarTabla();
	 // Crear un JScrollPane y agregar la JTable a él
		JScrollPane scrollPane2 = new JScrollPane(tblProductos);
		scrollPane2.setBounds(412, 11, 842, 620);
		getContentPane().add(scrollPane2);
		
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreProducto = (String) cboProducto.getSelectedItem();
				int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProducto);
				Producto producto = new Producto();
				producto = productocontroller.obtenerProductoPorId(idProducto);
				
				txtPrecio.setText(String.valueOf(producto.getPrecio_compra()));
			}
		});
		
		cboRazonSocial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreProveedor = (String) cboRazonSocial.getSelectedItem();
				int idProveedor = proveedorcontroller.obtenerIdProveedorPorNombre(nombreProveedor);
				Proveedor proveedor = new Proveedor();
				proveedor = proveedorcontroller.buscarProveeedorPorId(idProveedor);
				
				txtCorreo.setText(proveedor.getCorreo());
				txtTelefono.setText(proveedor.getTelefono());
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object valorspinner = spinnerCantidad.getValue();
				
				if(valorspinner instanceof Integer) {
					int cantidad = (int) valorspinner;
					
					if(cantidad > 0) {						
						String nombreProducto = (String) cboProducto.getSelectedItem();
						int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProducto);
						Producto productoinfo = productocontroller.obtenerProductoPorNombre(nombreProducto);
						
						int stockProducto = productoinfo.getStock();
						double precioCompra = productoinfo.getPrecio_compra();
						
						if(stockProducto >= cantidad) {
							Object[] fila = {idProducto,nombreProducto, precioCompra, cantidad};
							modelo.addRow(fila);
							
							spinnerCantidad.setValue(0);
						}
						else {
							JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "No tenemos suficiente Stock para la cantidad necesitada.", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
					}					
				}
				else {
					JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "Por favor, ingrese una cantidad válida en el Spinner.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 // Obtiene la fila seleccionada
		        int filaSeleccionada = tblProductos.getSelectedRow();

		        // Verifica que haya una fila seleccionada
		        if (filaSeleccionada != -1) {
		            // Elimina la fila del modelo de la tabla
		            modelo.removeRow(filaSeleccionada);
		        } else {
		            JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			  
				BigDecimal total = BigDecimal.ZERO;

			    for (int i = 0; i < modelo.getRowCount(); i++) {
			        int cantidad = (int) modelo.getValueAt(i, 3);
			        BigDecimal precioUnitario = new BigDecimal(modelo.getValueAt(i, 2).toString());

			        total = total.add(precioUnitario.multiply(BigDecimal.valueOf(cantidad)));
			    }

			    total = total.setScale(2, RoundingMode.HALF_UP);

			    try {
			        System.out.println("Total antes de convertir a palabras: " + total);
			        String totalTexto = numeroentextocontroller.convertirGrupoEnPalabras(total.doubleValue());
			        System.out.println("Total después de convertir a palabras: " + totalTexto);
			        txtTotal.setText(String.valueOf(total));
			        txtTotalTexto.setText(totalTexto);
			    } catch (Exception ex) {
			        ex.printStackTrace();  // Imprimir la traza de la excepción para ver detalles en la consola
			        JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "Error al convertir el total a palabras.", "Error", JOptionPane.ERROR_MESSAGE);
			    }
			}
		});
		
		btnRegistrarComprar.addActionListener(new ActionListener() {
			private List<DetalleCompra> detallesCompra = new ArrayList<>();
			public void actionPerformed(ActionEvent e) {
				String nombreProveedor = (String) cboRazonSocial.getSelectedItem();
		        String nombremodoPago = (String) cboMetodoPago.getSelectedItem();
		        int dniUsuario = usuarioValidado.getDni();
		        Empleado empleado = new Empleado();
		        empleado = empleadocontroller.buscarEmpleadoPorDni(dniUsuario);

		        int idProveedor = proveedorcontroller.obtenerIdProveedorPorNombre(nombreProveedor);

		        // Validar que el campo de texto txtTotal no esté vacío
		        String totalText = txtTotal.getText().trim();
		        if (totalText.isEmpty()) {
		            JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "Ingrese un monto total válido.", "Aviso", JOptionPane.WARNING_MESSAGE);
		            return;
		        }

		        double total = Double.parseDouble(totalText);
		        int idModoPago = metodopagocontroller.obtenerIdMetodoPagoPorNombre(nombremodoPago);
		        int idEmpleado = empleado.getId();

		        if (total <= 0) {
		            JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "NO HAY PRODUCTOS EN LA ORDEN PARA COMPRAR", "Aviso", JOptionPane.WARNING_MESSAGE);
		            return;
		        } else {
		            String numeroCompra = compracontroller.generarNumeroOrdenCompra();
		            int idCompra = compracontroller.registrarVenta(numeroCompra, idProveedor, total, idModoPago, idEmpleado);

		            int rowCount = modelo.getRowCount();
		            for (int i = 0; i < rowCount; i++) {
		                int idProducto = (int) modelo.getValueAt(i, 0);
		                double precio_compra = (double) modelo.getValueAt(i, 2);
		                int cantidad = (int) modelo.getValueAt(i, 3);

		                DetalleCompra detallecompra = new DetalleCompra();
		                detallecompra.setId_compra(idCompra);
		                detallecompra.setId_producto(idProducto);
		                detallecompra.setPrecio_compra(precio_compra);
		                detallecompra.setCantidad(cantidad);
		                detallesCompra.add(detallecompra);
		            }

		            for (DetalleCompra detalle : detallesCompra) {
		                detallecompracontroller.registrarDetalleCompra(detalle);
		            }
		            Reporte.ReporteCompra();		            
		            limpiar();
		            JOptionPane.showMessageDialog(ifrm_OrdenesCompra.this, "Orden de Compra N° " + numeroCompra + " registrada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		});

	}
	
	private void actualizarComboBoxMetodoPago() {
		List<MetodoPago> listaMetodoPago = metodopagocontroller.listarMetodoPago();
		cboMetodoPago.removeAllItems();
		
		for(MetodoPago metodopago : listaMetodoPago) {
			cboMetodoPago.addItem(metodopago.getDescripcion());
		}
	}
	
	private void actualizarComboBoxProveedor() {
		List<Proveedor> listaProveedor = proveedorcontroller.listaProveedorFiltarada();
		cboRazonSocial.removeAllItems();
		
		for(Proveedor proveedor : listaProveedor) {
			cboRazonSocial.addItem(proveedor.getRazon_social());
		}
	}
	
	private void actualizarComboBoxProducto() {
		List<Producto> listaProducto = productocontroller.listarProducto();
		cboProducto.removeAllItems();
		
		for(Producto producto : listaProducto) {
			cboProducto.addItem(producto.getDescripcion());
		}
 
	}
	
	private void limpiar() {
		txtTotalTexto.setText("");
		txtTotal.setText("");
		txtCorreo.setText("");
		txtPrecio.setText("");
		txtTelefono.setText("");
		cboMetodoPago.setSelectedIndex(0);
		cboProducto.setSelectedIndex(0);
		cboRazonSocial.setSelectedIndex(0);
		spinnerCantidad.setValue(0);
	}
}
