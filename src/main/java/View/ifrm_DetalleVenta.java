package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
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



import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

import Model.Cliente;
import Model.DetalleVenta;
import Model.Venta;
import Controller.ClienteController;
import Controller.DetalleVentaController;
import Controller.EmpleadoController;
import Controller.MetodoPagoController;
import Controller.VentaController;
import Controller.ProductoController;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class ifrm_DetalleVenta extends JInternalFrame {
	
	
	private static final long serialVersionUID = 1L;
	DefaultTableModel modelo;
	DefaultTableModel modelo2;
	private JTable tblDetalleVenta;
	private JTable tblDetalle;
	private JTable tblFactura;
	ArrayList<DetalleVenta> listarProducto = new ArrayList<>();
	private DetalleVentaController detalleVentaController;
	private VentaController ventaController;
	private ProductoController productoController;
	private ClienteController clientecontroller;
	private MetodoPagoController modopagocontroller;
	private EmpleadoController empleadocontroller;
	private JDialog dialog;
	private JTable table;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_DetalleVenta frame = new ifrm_DetalleVenta();
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
	public ifrm_DetalleVenta() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);	
	
		detalleVentaController = new DetalleVentaController();
		ventaController = new VentaController();
		productoController = new ProductoController();
		clientecontroller = new ClienteController();
		empleadocontroller = new EmpleadoController();
		modopagocontroller = new MetodoPagoController();	
		 
		 JPanel panel_1 = new JPanel();
		 panel_1.setLayout(null);
		 panel_1.setForeground(Color.WHITE);
		 panel_1.setBackground(new Color(40, 39, 61));
		 panel_1.setBounds(0, 0, 1264, 82);
		 getContentPane().add(panel_1);
		 
		 JLabel lblNewLabel = new JLabel("Detalle de Venta");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setBounds(10, 26, 1244, 35);
		 panel_1.add(lblNewLabel);
		 lblNewLabel.setForeground(new Color(255, 255, 255));
		 lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 33));
		 
		 JLabel lblNewLabel_2 = new JLabel("New label");
		 lblNewLabel_2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/tiempo.png")));
		 lblNewLabel_2.setBounds(10, 102, 63, 82);
		 getContentPane().add(lblNewLabel_2);
		 
		
			modelo = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		            	"Fecha Registro", "N° Factura", "Cliente","Total","Modo Pago","Empleado"
		            }
		        );
		
			tblFactura = new JTable(modelo);
			tblFactura.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
			tblFactura.getTableHeader().setOpaque(false);
			tblFactura.getTableHeader().setBackground(new Color(40, 39, 61));
			tblFactura.setSelectionBackground(new Color(241, 110, 79));
			tblFactura.getTableHeader().setForeground(new Color(255, 255, 255));
			tblFactura.setRowHeight(25);
			tblFactura.setDefaultEditor(Object.class, null);
			
			tblFactura.setDefaultEditor(Object.class, null);
			tblFactura.getColumnModel().getColumn(0).setPreferredWidth(20); // fecha
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // n° factura
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(70); // Cliente
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(20); // id cliente
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // telefono
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(30); // dni
			tblFactura.getColumnModel().getColumn(1).setPreferredWidth(20); // total
			
			tblFactura.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

			tblFactura.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tblFactura.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tblFactura.setIntercellSpacing(new Dimension(0, 0));
			tblFactura.setShowGrid(false);
			tblFactura.setShowHorizontalLines(true);
			tblFactura.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
			tblFactura.setShowVerticalLines(true);
			tblFactura.setGridColor(new Color(200, 200, 200));
			
			mostrarTabla();
			
			 JScrollPane scrollPane = new JScrollPane(tblFactura);
			 scrollPane.setBounds(83, 102, 1102, 448);
			 getContentPane().add(scrollPane);
			 
			 tblFactura.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseClicked(MouseEvent e) {
				        if (e.getClickCount() == 2) {
				            int filaSeleccionada = tblFactura.getSelectedRow();
				            if (filaSeleccionada != -1) {
				                // Obtener la factura seleccionada
				                //Factura factura = obtenerFacturaDesdeLaFila(filaSeleccionada);
				            	Object columFactura = tblFactura.getValueAt(filaSeleccionada, 1);
				            	String numeroFactura = columFactura.toString();

				                // Aquí debes abrir una nueva vista con el detalle de la factura
				                // Puedes usar un JDialog, un JInternalFrame o cualquier otro contenedor
				                mostrarDetalleFactura(numeroFactura);
				            }
				        }
				    }
				});
		}
		
		private void mostrarTabla() {
		    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos	   
		    List<Venta> listaVenta = ventaController.listarVentas();
		    
		    for (Venta venta : listaVenta) {		      
		    	Cliente cliente = clientecontroller.buscarClientePorId(venta.getId_cliente());
		    	String metodopago = modopagocontroller.obtenerNombreMetodoPagoPorId(venta.getId_modo_pago());
		    	String nombreEmpleado = empleadocontroller.obtenerNombreEmpleadoPorId(venta.getId_empleado());
		        Object[] fila2 = {
		        	venta.getFechaVenta(),
		            venta.getNumero_venta(),
		            cliente.getNombre(),
		            venta.getTotal(),
		            metodopago,
		            nombreEmpleado	            
		        };

		        modelo.addRow(fila2);
		    }
		}
		
		public void mostrarDetalleFactura(String numeroFactura) {
		    dialog = new JDialog();
		    dialog.setTitle("Detalle de la Factura " + numeroFactura);
		    dialog.setSize(700, 480);
		    dialog.setLocationRelativeTo(null);
		    dialog.setResizable(false);
		    
		    JPanel contentPanel = new JPanel();
		    contentPanel.setBackground(new Color(51, 52, 78));
		    dialog.add(contentPanel);
		    
		    modelo2 = new DefaultTableModel(
		            new Object[][] {},
		            new String[] {
		               "Producto","Cantidad","Precio Unitario"
		            }
		        );
		
			tblDetalle = new JTable(modelo2);
			tblDetalle.setDefaultEditor(Object.class, null);		
			tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(100); // Producto
			tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(20); // Cantidad
			tblDetalle.getColumnModel().getColumn(1).setPreferredWidth(20); // precio		
			
			mostrarTablaDetalle(numeroFactura);
			JScrollPane scrollPane = new JScrollPane(tblDetalle);
			scrollPane.setBounds(37, 85, 500, 290);
			contentPanel.add(scrollPane);
		
		    dialog.setVisible(true);
		}
		
		public void mostrarTablaDetalle(String numeroFactura) {
		    try {
				if(modelo2 != null) {
					modelo2.setRowCount(0);

				    List<DetalleVenta> listarDetalle = detalleVentaController.listarDetalleVentaPorNumeroFactura(numeroFactura);

				    if(listarDetalle != null) {
				    	for (DetalleVenta detalleVenta : listarDetalle) {
					        String nombreProducto = productoController.obtenerNombreProductoPorId(detalleVenta.getId_producto()); // Corregido aquí
					        Object[] fila = {
					                nombreProducto,
					                detalleVenta.getCantidad(),
					                detalleVenta.getPrecio_venta(),
					        };
					        modelo2.addRow(fila);
					    }
				    }
				    
				    else {
				    	System.err.println("Oliiiiiiiiiiiiiii");
				    }
				    
				}
			} catch (Exception e) {
				 e.printStackTrace();
			}
		}
}

