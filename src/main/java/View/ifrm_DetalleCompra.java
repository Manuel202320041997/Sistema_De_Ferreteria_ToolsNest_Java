package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Compra;
import Model.DetalleCompra;
import Model.DetalleVenta;
import Model.Proveedor;

import Controller.DetalleCompraController;
import Controller.ProductoController;
import Controller.CompraController;
import Controller.ProveedorController;
import Controller.MetodoPagoController;
import Controller.EmpleadoController;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.SwingConstants;

public class ifrm_DetalleCompra extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo;
	private JTable tblDetalleCompra;
	private CompraController compracontroller;
	private ProveedorController proveedorcontroller;
	private MetodoPagoController metodopagocontroller;
	private EmpleadoController empleadocontroller;
	private ProductoController productocontroller;
	private DetalleCompraController detallecompracontroller;
	private JDialog dialog;
	DefaultTableModel modelo2;
	private JTable tblDetalle;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_DetalleCompra frame = new ifrm_DetalleCompra();
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
	public ifrm_DetalleCompra() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);

		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		compracontroller = new CompraController();
		proveedorcontroller = new ProveedorController();
		metodopagocontroller = new MetodoPagoController();
		empleadocontroller = new EmpleadoController();
		productocontroller = new ProductoController();
		detallecompracontroller = new DetalleCompraController();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1264, 72);
		panel.setBackground(new Color(40,39,61));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDetalleDeCompra = new JLabel("Detalle de Compra");
		lblDetalleDeCompra.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetalleDeCompra.setForeground(Color.WHITE);
		lblDetalleDeCompra.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 33));
		lblDetalleDeCompra.setBounds(0, 11, 1264, 50);
		panel.add(lblDetalleDeCompra);
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	               "Fecha", "N° Compra", "Proveedor","Modo de Pago","Total","Empleado"
	            }
	        );
	
		tblDetalleCompra = new JTable(modelo);
		tblDetalleCompra.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblDetalleCompra.getTableHeader().setOpaque(false);
		tblDetalleCompra.getTableHeader().setBackground(new Color(40, 39, 61));
		tblDetalleCompra.setSelectionBackground(new Color(241, 110, 79));
		tblDetalleCompra.getTableHeader().setForeground(new Color(255, 255, 255));
		tblDetalleCompra.setRowHeight(25);
		tblDetalleCompra.setDefaultEditor(Object.class, null);
		tblDetalleCompra.setDefaultEditor(Object.class, null);
		tblDetalleCompra.getColumnModel().getColumn(0).setPreferredWidth(20); // fecha
		tblDetalleCompra.getColumnModel().getColumn(1).setPreferredWidth(30); // n° factura
		tblDetalleCompra.getColumnModel().getColumn(1).setPreferredWidth(50); // Cliente
		tblDetalleCompra.getColumnModel().getColumn(1).setPreferredWidth(30); // total
		tblDetalleCompra.getColumnModel().getColumn(1).setPreferredWidth(20); // modo pago
		tblDetalleCompra.getColumnModel().getColumn(1).setPreferredWidth(100); // empleado
				
		tblDetalleCompra.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		          //  ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		            c.setBackground(table.getBackground());
		            // Restaurar el color de texto predeterminado
		            c.setForeground(table.getForeground());
		        }

		        return c;
		    }
		});

		tblDetalleCompra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblDetalleCompra.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblDetalleCompra.setIntercellSpacing(new Dimension(0, 0));
		tblDetalleCompra.setShowGrid(false);
		tblDetalleCompra.setShowHorizontalLines(true);
		tblDetalleCompra.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblDetalleCompra.setShowVerticalLines(true);
		tblDetalleCompra.setGridColor(new Color(200, 200, 200));
		
		 mostrarTabla();
		 JScrollPane scrollPane = new JScrollPane(tblDetalleCompra);
		 scrollPane.setBounds(83, 102, 1102, 432);
		 getContentPane().add(scrollPane);
		 
		 tblDetalleCompra.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        if (e.getClickCount() == 2) {
			            int filaSeleccionada = tblDetalleCompra.getSelectedRow();
			            if (filaSeleccionada != -1) {
			                // Obtener la factura seleccionada
			                //Factura factura = obtenerFacturaDesdeLaFila(filaSeleccionada);
			            	Object columCompra = tblDetalleCompra.getValueAt(filaSeleccionada, 1);
			            	String numeroFactura = columCompra.toString();

			                // Aquí debes abrir una nueva vista con el detalle de la factura
			                // Puedes usar un JDialog, un JInternalFrame o cualquier otro contenedor
			                mostrarDetalleCompra(numeroFactura);
			            }
			        }
			    }
			});
		
		
	}
	
	private void mostrarTabla() {
		modelo.setRowCount(0);
		List<Compra> listarCompra = compracontroller.listarCompra();
		
		for(Compra compra : listarCompra) {
			Proveedor proveedor = proveedorcontroller.buscarProveeedorPorId(compra.getId_proveedor());
			String nombreProveedor = proveedor.getRazon_social();
			String modopago = metodopagocontroller.obtenerNombreMetodoPagoPorId(compra.getId_modo_pago());
			String nombreEmpleado = empleadocontroller.obtenerNombreEmpleadoPorId(compra.getId_empleado());
			
			Object[] fila = {
					compra.getFecha_compra(),
					compra.getNumero_compra(),
					nombreProveedor,
					modopago,
					compra.getTotal(),					
					nombreEmpleado
			};
			modelo.addRow(fila);
		}
		
	}
	
	private void mostrarDetalleCompra(String numeroCompra) {
		   dialog = new JDialog();
		    dialog.setTitle("Detalle de la Factura " + numeroCompra);
		    dialog.setSize(700, 480);
		    dialog.setLocationRelativeTo(null);
		    dialog.setResizable(false);

		    JPanel contentPanel = new JPanel();
		    contentPanel.setBackground(new Color(51, 52, 78));
		    dialog.add(contentPanel);

		    modelo2 = new DefaultTableModel(
		        new Object[][] {},
		        new String[] { "Producto", "Cantidad", "Precio de Compra" }
		    );

		    tblDetalle = new JTable(modelo2);
		    tblDetalle.setDefaultEditor(Object.class, null);
		    tblDetalle.getColumnModel().getColumn(0).setPreferredWidth(100); // Producto
		    tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(20); // Cantidad
		    tblDetalle.getColumnModel().getColumn(2).setPreferredWidth(20); // Precio

		    mostrarTablaDetalle(numeroCompra);

		    JScrollPane scrollPane = new JScrollPane(tblDetalle);
		    scrollPane.setBounds(37, 85, 680, 480);
		    contentPanel.add(scrollPane);

		    dialog.setVisible(true);
		
	}
	
	public void mostrarTablaDetalle(String numeroCompra) {
	    try {
	        if (modelo2 != null) {
	            modelo2.setRowCount(0);

	            List<DetalleCompra> listarDetalle = detallecompracontroller.listarDetalleCompraPorNumeroCompra(numeroCompra);

	            if (listarDetalle != null) {
	                for (DetalleCompra detallecompra : listarDetalle) {
	                    String nombreProducto = productocontroller.obtenerNombreProductoPorId(detallecompra.getId_producto());
	                    Object[] fila = {
	                        nombreProducto,
	                        detallecompra.getCantidad(),
	                        detallecompra.getPrecio_compra(),
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
