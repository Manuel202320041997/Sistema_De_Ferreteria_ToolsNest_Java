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

// import com.itextpdf.awt.geom.Dimension;

import Model.Reporte;
import Model.ReporteExcel;
import Model.Producto;
import Model.Cotizacion;
import Controller.NumeroEnTextoController;
import Controller.ProductoController;
import Controller.ReporteController;
import Controller.ReporteCotizacionController;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.time.LocalDate;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;

public class ifrm_Cotizaciones extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private ProductoController productocontroller;
	private NumeroEnTextoController numeroentextocontroller;
	private ReporteCotizacionController reportecotizacioncontroller;
	DefaultTableModel modelo;
	private JTable tblProductos;
	private JTextField txtPrecio;
	private JTextField txtTotalTexto;
	private JTextField txtIGV;
	private JTextField txtSubTotal;
	private JComboBox cboProducto;
	private JButton btnEliminar;
	private JSpinner spinnerCantidad;
	private JTextField txtTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_Cotizaciones frame = new ifrm_Cotizaciones();
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
	public ifrm_Cotizaciones() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		productocontroller = new ProductoController();
		numeroentextocontroller = new NumeroEnTextoController();
		reportecontroller = new ReporteController();
		reportecotizacioncontroller = new ReporteCotizacionController();

		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	            		"ID", "Nombre", "Precio Unitario", "Cantidad"
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
		          //  ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
		JScrollPane scrollPane = new JScrollPane(tblProductos);
		scrollPane.setBounds(10, 11, 928, 560);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(948, 11, 306, 560);
		panel.setBackground(new Color(245,245,245));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("COTIZACIONES");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_10.setBounds(0, 11, 306, 40);
		panel.add(lblNewLabel_10);
		
		cboProducto = new JComboBox();
		actualizarComboBoxProducto();
		cboProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboProducto.setBounds(128, 124, 147, 22);
		panel.add(cboProducto);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerCantidad.setBounds(128, 159, 147, 22);
		panel.add(spinnerCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(128, 192, 147, 22);
		panel.add(txtPrecio);
		
		JLabel lblNewLabel_4_2 = new JLabel("P. Unitario:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(24, 194, 94, 20);
		panel.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cantidad:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(24, 157, 94, 22);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Producto:");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1.setBounds(24, 124, 94, 20);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DETALLES DE PRODUCTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1.setBounds(10, 102, 286, 130);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Total:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(24, 335, 94, 20);
		panel.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("SubTotal:");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1_1_1.setBounds(24, 265, 94, 20);
		panel.add(lblNewLabel_4_1_1_1);
		
		txtTotalTexto = new JTextField();
		txtTotalTexto.setEditable(false);
		txtTotalTexto.setColumns(10);
		txtTotalTexto.setBounds(128, 335, 147, 22);
		panel.add(txtTotalTexto);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("IGV:");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1_1.setBounds(24, 298, 94, 22);
		panel.add(lblNewLabel_2_1_1);
		
		txtIGV = new JTextField();
		txtIGV.setEditable(false);
		txtIGV.setColumns(10);
		txtIGV.setBounds(128, 301, 147, 22);
		panel.add(txtIGV);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(128, 267, 147, 22);
		panel.add(txtSubTotal);		
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "CALCULOS DE COTIZACION", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1_1.setBounds(10, 243, 286, 130);
		panel.add(lblNewLabel_3_1_1_1);
		
		LocalDate fechaActual = LocalDate.now();		
		JLabel lblNewLabel = new JLabel("Fecha Cotización:"+ fechaActual);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(115, 77, 181, 14);
		panel.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular Cotización");
		btnCalcular.setForeground(new Color(245, 245, 245));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcular.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/calculadoraicono.png")));		
		btnCalcular.setBackground(new Color(4, 51, 108));
		btnCalcular.setBounds(50, 480, 219, 29);
		panel.add(btnCalcular);
		
		JButton btnGenerarDocumento = new JButton("Generar Documento");
		btnGenerarDocumento.setForeground(new Color(245, 245, 245));
		btnGenerarDocumento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarDocumento.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/pdficono.png")));
		btnGenerarDocumento.setBackground(new Color(173, 8, 8));
		btnGenerarDocumento.setBounds(50, 520, 219, 29);
		panel.add(btnGenerarDocumento);
		
		JButton btnAgregar = new JButton("Agregar a la Tabla");
		btnAgregar.setForeground(new Color(245, 245, 245));
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		btnAgregar.setBackground(new Color(78, 156, 54));
		btnAgregar.setBounds(50, 400, 219, 29);
		panel.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar Producto");
		btnEliminar.setForeground(new Color(245, 245, 245));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/eliminaricono.png")));
		btnEliminar.setBackground(new Color(144, 8, 9));
		btnEliminar.setBounds(50, 440, 219, 29);
		panel.add(btnEliminar);
		
		txtTotal = new JTextField();
		txtTotal.setVisible(false);
		txtTotal.setBounds(128, 369, 86, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		cboProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreProducto = (String) cboProducto.getSelectedItem();
				int idProducto = productocontroller.obtenerIdProductoPorNombre(nombreProducto);
				Producto producto = new Producto();
				producto = productocontroller.obtenerProductoPorId(idProducto);
				
				txtPrecio.setText(String.valueOf(producto.getPrecio_compra()));
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
						Producto productoInfo = productocontroller.obtenerProductoPorNombre(nombreProducto);
						
						int stockProducto = productoInfo.getStock();
						double precioCompra = productoInfo.getPrecio_compra();
						
						if(stockProducto >= cantidad) {
							Object[] fila = {idProducto, nombreProducto, precioCompra, cantidad};
							modelo.addRow(fila);
							
							//spinnerCantidad.setValue(0);
							limpiar();
						}
						
						else {
							JOptionPane.showMessageDialog(ifrm_Cotizaciones.this, "No tenemos suficiente Stock para la cantidad necesitada.", "Error", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
					else {						
						JOptionPane.showMessageDialog(ifrm_Cotizaciones.this, "La cantidad debe ser mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);						
					}
					
				}
				
				else {
					JOptionPane.showMessageDialog(ifrm_Cotizaciones.this, "Por favor, ingrese una cantidad válida en el Spinner.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int filaSeleccionada = tblProductos.getSelectedRow();

			        // Verifica que haya una fila seleccionada
			        if (filaSeleccionada != -1) {
			            // Elimina la fila del modelo de la tabla
			            modelo.removeRow(filaSeleccionada);
			        } else {
			            JOptionPane.showMessageDialog(ifrm_Cotizaciones.this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			}
		});
		
		btnCalcular.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {				
					BigDecimal subtotal = BigDecimal.ZERO;

			        for (int i = 0; i < modelo.getRowCount(); i++) {
			            int cantidad = (int) modelo.getValueAt(i, 3);
			            BigDecimal preciounitario = new BigDecimal(modelo.getValueAt(i, 2).toString());

			            subtotal = subtotal.add(preciounitario.multiply(BigDecimal.valueOf(cantidad)));
			        }

			        BigDecimal igv = subtotal.multiply(new BigDecimal("0.18"));
			        BigDecimal total = subtotal.add(igv);

			        subtotal = subtotal.setScale(2, RoundingMode.HALF_UP);
			        igv = igv.setScale(2, RoundingMode.HALF_UP);
			        total = total.setScale(2, RoundingMode.HALF_UP);

			        try {
			            String totalTexto = numeroentextocontroller.convertirGrupoEnPalabras(total.doubleValue());
			            txtSubTotal.setText(String.valueOf(subtotal));
			            txtIGV.setText(String.valueOf(igv));
			            txtTotal.setText(String.valueOf(total));
			            txtTotalTexto.setText(totalTexto);
			        } catch (Exception ex) {
			            // Manejo de excepciones, por ejemplo, mostrar un mensaje de error
			            JOptionPane.showMessageDialog(ifrm_Cotizaciones.this, "Error al convertir el total a palabras.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
				}
		});
		
		btnGenerarDocumento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
	        	 List<Reporte> listarReporte = reportecontroller.listarReporte();
	        	 Reporte.ReporteCotizaciones();

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
	
	private void limpiar() {
		
		txtTotalTexto.setText("");	
		txtTotal.setText("");
		txtSubTotal.setText("");
		txtIGV.setText("");
		cboProducto.setSelectedIndex(0);	
		spinnerCantidad.setValue(0);
	}
}
