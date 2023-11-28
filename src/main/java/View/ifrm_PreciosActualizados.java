package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JTree;
import java.awt.Label;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import Controller.ProductoController;
import Controller.SubCategoriaController;
import Controller.MarcaController;
import Model.Marca;
import Model.Producto;
import Model.Rol;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ifrm_PreciosActualizados extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ProductoController productocontroller;
	private MarcaController marcacontroller;
	private SubCategoriaController subcategoriacontroller;
	DefaultTableModel modelo;
	private JTable tblProductos;
	private JComboBox cboMarca;
	private JRadioButton rbVenta;
	private JRadioButton rbCompra;
	private JRadioButton rbPorcentaje;
	private JRadioButton rbSoles;
	private JSpinner spinnerVariacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_PreciosActualizados frame = new ifrm_PreciosActualizados();
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
	public ifrm_PreciosActualizados() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		marcacontroller = new MarcaController();
		productocontroller = new ProductoController();
		subcategoriacontroller = new SubCategoriaController();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(964, 97, 290, 382);
		getContentPane().add(panel);		
		panel.setLayout(null);
		
		JLabel lblActualizacinDePrecios = new JLabel("Actualización de Precios");
		lblActualizacinDePrecios.setBounds(10, 11, 270, 26);
		lblActualizacinDePrecios.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizacinDePrecios.setFont(new Font("Tahoma", Font.PLAIN, 21));
		panel.add(lblActualizacinDePrecios);
		
		cboMarca = new JComboBox();
		cboMarca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboMarca.setBackground(new Color(255, 255, 255));
		cboMarca.setBounds(101, 85, 166, 26);
		actualizarComboBoxRol();
		panel.add(cboMarca);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(25, 82, 66, 28);
		panel.add(lblNewLabel_2);
		
		rbCompra = new JRadioButton("Compra");
		rbCompra.setBackground(new Color(245, 245, 245));
		rbCompra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbCompra.setBounds(47, 176, 84, 23);
		panel.add(rbCompra);
		
		rbVenta = new JRadioButton("Venta");
		rbVenta.setBackground(new Color(245, 245, 245));
		rbVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbVenta.setBounds(169, 176, 84, 23);
		panel.add(rbVenta);
		
		rbPorcentaje = new JRadioButton("%");
		rbPorcentaje.setBackground(new Color(245, 245, 245));
		rbPorcentaje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbPorcentaje.setBounds(153, 248, 48, 23);
		panel.add(rbPorcentaje);
		
		rbSoles = new JRadioButton("S/.");
		rbSoles.setBackground(new Color(245, 245, 245));
		rbSoles.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbSoles.setBounds(205, 248, 48, 23);
		panel.add(rbSoles);
		
		spinnerVariacion = new JSpinner();
		spinnerVariacion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		spinnerVariacion.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		spinnerVariacion.setBounds(42, 248, 89, 23);
		panel.add(spinnerVariacion);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(new Color(245, 245, 245));
		btnActualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnActualizar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		btnActualizar.setBackground(new Color(78, 156, 54));
		btnActualizar.setBounds(34, 311, 219, 29);
		panel.add(btnActualizar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(0, 0, 0));
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		btnLimpiar.setBackground(new Color(252, 187, 33));
		btnLimpiar.setBounds(34, 343, 219, 29);
		panel.add(btnLimpiar);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "ACTUALIZAR PRECIO DE:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3.setBounds(25, 153, 242, 62);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tipo:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1.setBounds(141, 235, 119, 40);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "VARIACI\u00D3N:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(25, 226, 242, 62);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(10, 130, 270, 170);
		panel.add(lblNewLabel_1);
		
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Descripcion", "Marca", "Precio Compra", "Precio Venta", "SubCategoria"
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
		tblProductos.getColumnModel().getColumn(1).setPreferredWidth(100); // Nombre
		tblProductos.getColumnModel().getColumn(2).setPreferredWidth(60); // Correo
		tblProductos.getColumnModel().getColumn(3).setPreferredWidth(20);
		tblProductos.getColumnModel().getColumn(4).setPreferredWidth(20);
		tblProductos.getColumnModel().getColumn(2).setPreferredWidth(60);
		
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
		           // ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
		
		mostrarTabla();
	 // Crear un JScrollPane y agregar la JTable a él
		JScrollPane scrollPane = new JScrollPane(tblProductos);
		scrollPane.setBounds(10, 11, 928, 560);
		getContentPane().add(scrollPane);
		
		rbCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbCompra.isSelected()) {
					rbVenta.setSelected(false);
				}
			}
		});
		
		rbVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rbVenta.isSelected()) {
					rbCompra.setSelected(false);
				}
			}
		});
		
		rbPorcentaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbPorcentaje.isSelected()) {
					rbSoles.setSelected(false);
				}
			}
		});
		
		rbSoles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rbSoles.isSelected()) {
					rbPorcentaje.setSelected(false);
				}
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double numeroActualizar = (double) spinnerVariacion.getValue();
				String marca = String.valueOf(cboMarca.getSelectedItem());
				int  idMarca = marcacontroller.obtenerIdMarcaPorNombre(marca);
				
				if(numeroActualizar > 0.0) {
					if(rbCompra.isSelected() && rbPorcentaje.isSelected()) {
						productocontroller.actualizarPrecioCompraPorcentaje(numeroActualizar, idMarca);
						mostrarTabla();
						JOptionPane.showMessageDialog(ifrm_PreciosActualizados.this, "Precios de Compra de la marca " + marca + " actualizadas exitosamente. Aumentadas en un " + numeroActualizar + "%", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						limpiar();
					}
					else if(rbCompra.isSelected() && rbSoles.isSelected()) {
						productocontroller.actualizarPrecioCompraSoles(numeroActualizar, idMarca);
						mostrarTabla();
						JOptionPane.showMessageDialog(ifrm_PreciosActualizados.this, "Precios de Compra de la marca " + marca + " actualizadas exitosamente. Aumentadas en S/." + numeroActualizar, "Éxito", JOptionPane.INFORMATION_MESSAGE);
						limpiar();
					}
					else if(rbVenta.isSelected() && rbPorcentaje.isSelected()) {
						productocontroller.actualizarPrecioVentaPorcentaje(numeroActualizar, idMarca);
						mostrarTabla();
						JOptionPane.showMessageDialog(ifrm_PreciosActualizados.this, "Precios de Venta de la marca " + marca + " actualizadas exitosamente. Aumentadas en un " + numeroActualizar + "%", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						limpiar();
					}
					else if(rbVenta.isSelected() && rbSoles.isSelected()) {
						productocontroller.actualizarPrecioVentaSoles(numeroActualizar, idMarca);
						mostrarTabla();
						JOptionPane.showMessageDialog(ifrm_PreciosActualizados.this, "Precios de Venta de la marca " + marca + " actualizadas exitosamente. Aumentadas en S/." + numeroActualizar , "Éxito", JOptionPane.INFORMATION_MESSAGE);						//JOptionPane.showMessageDialog(ifrm_PreciosActualizados.this, "Actualizarás Ventas con soles", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						limpiar();
					}
				}
				else {
					JOptionPane.showMessageDialog(ifrm_PreciosActualizados.this, "Tienes que colocar un valor mayor a Cero en la Variación", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
	
	private void mostrarTabla() {
			modelo.setRowCount(0);
			List<Producto> listaProductos = productocontroller.listarProducto();
			
			for(Producto producto : listaProductos) {				
				String nombreSubCategoria = subcategoriacontroller.obtenerNombreSubCategoriaPorId(producto.getId_subcategoria());
				String nombreMarca = marcacontroller.obtenerNombreMarcaPorId(producto.getId_marca()); 
				Object[] fila = {
					producto.getId(),
					producto.getDescripcion(),
					nombreMarca,
					producto.getPrecio_compra(),
					producto.getPrecio_venta(),
					nombreSubCategoria
				};
				modelo.addRow(fila);
			}
	}
	
	private void actualizarComboBoxRol() {
		List<Marca> listaMarca = marcacontroller.listarMarca();
		
		cboMarca.removeAllItems();
		
		for(Marca marca : listaMarca) {
			cboMarca.addItem(marca.getDescripcion());
		}
	}
	
	private void limpiar() {
		cboMarca.setSelectedIndex(0);
		rbCompra.setSelected(false);
		rbVenta.setSelected(false);
		rbPorcentaje.setSelected(false);
		rbSoles.setSelected(false);
		spinnerVariacion.setValue(0.0);
	}
}
