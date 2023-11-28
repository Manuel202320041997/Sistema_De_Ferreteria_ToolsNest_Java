package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Controller.ClienteController;
import Controller.MarcaController;
import Controller.ProductoController;
import Controller.ReporteController;
import Controller.SubCategoriaController;
import Model.Cliente;
import Model.Producto;
import Model.Reporte;
import Model.ReporteExcel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class ifrm_ListaInventario extends JInternalFrame {

	private ProductoController productocontroller;
	private MarcaController marcacontroller;
	private SubCategoriaController subcategoriacontroller;
	DefaultTableModel modelo;
	private static final long serialVersionUID = 1L;
	private JTable tblInventario;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_ListaInventario frame = new ifrm_ListaInventario();
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
	public ifrm_ListaInventario() {
		setBounds(0, 0, 1280, 635);
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

		
		tblInventario = new JTable();
		tblInventario.setBounds(26, 530, 1218, 0);
		getContentPane().add(tblInventario);
		
		JLabel lblNewLabel = new JLabel("Inventario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 1244, 37);
		getContentPane().add(lblNewLabel);
		
		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Descripcion", "Marca", "Precio Compra", "Precio Venta", "Stock","Sub Categoria"
	            }
	        );

		tblInventario = new JTable(modelo);
		tblInventario.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblInventario.getTableHeader().setOpaque(false);
		tblInventario.getTableHeader().setBackground(new Color(40, 39, 61));
		tblInventario.setSelectionBackground(new Color(241, 110, 79));
		tblInventario.getTableHeader().setForeground(new Color(255, 255, 255));
		tblInventario.setRowHeight(25);
		tblInventario.setDefaultEditor(Object.class, null);
		tblInventario.getColumnModel().getColumn(0).setPreferredWidth(10); // ID
		tblInventario.getColumnModel().getColumn(1).setPreferredWidth(180); // Descripcion
		tblInventario.getColumnModel().getColumn(2).setPreferredWidth(20); // Id Marca
		tblInventario.getColumnModel().getColumn(3).setPreferredWidth(20); // P. Compra
		tblInventario.getColumnModel().getColumn(4).setPreferredWidth(20); // P. Venta
		tblInventario.getColumnModel().getColumn(5).setPreferredWidth(20); // Stock
		tblInventario.getColumnModel().getColumn(6).setPreferredWidth(20); // Id SubCat
		
		tblInventario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

		tblInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblInventario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblInventario.setIntercellSpacing(new Dimension(0, 0));
		tblInventario.setShowGrid(false);
		tblInventario.setShowHorizontalLines(true);
		tblInventario.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblInventario.setShowVerticalLines(true);
		tblInventario.setGridColor(new Color(200, 200, 200));
		
		
		mostrarTabla();
		
		 JScrollPane scrollPane = new JScrollPane(tblInventario);
		 scrollPane.setBounds(10, 94, 1244, 470);
		 getContentPane().add(scrollPane);
		 
		 tblInventario = new JTable();
		 scrollPane.setColumnHeaderView(tblInventario);
		 
		 txtBuscar = new JTextField();
		 txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 txtBuscar.setBounds(943, 50, 135, 25);
		 getContentPane().add(txtBuscar);
		 txtBuscar.setColumns(10);
		
		 
		 JPanel panel = new JPanel();
		 panel.setVisible(false);
		 panel.setBounds(536, 55, 19, 10);
		 getContentPane().add(panel);
		 
		 JLabel lblNewLabel_1 = new JLabel("Buscar:");
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 lblNewLabel_1.setForeground(new Color(255, 255, 255));
		 lblNewLabel_1.setBounds(860, 48, 73, 25);
		 getContentPane().add(lblNewLabel_1);
		 
		 JButton btnBuscar = new JButton("");
		 btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/lupaicono.png")));
		 btnBuscar.setBounds(1088, 50, 44, 25);
		 btnBuscar.setBackground(new Color(204, 226, 178));
		 getContentPane().add(btnBuscar);
		 
		 JLabel lblNewLabel_2 = new JLabel("Filtrar Por:");
		 lblNewLabel_2.setForeground(new Color(255, 255, 255));
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 lblNewLabel_2.setBounds(36, 50, 96, 25);
		 getContentPane().add(lblNewLabel_2);
		 
		 JComboBox<String> cboFiltrar = new JComboBox<>();
		 cboFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 cboFiltrar.setBounds(155, 50, 135, 25);
		 cboFiltrar.addItem("ID");
		 cboFiltrar.addItem("Descripcion");
		 getContentPane().add(cboFiltrar);
		 
		 JButton btnLimpiar = new JButton("");
		 btnLimpiar.setBounds(1142, 50, 44, 25);
		 btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		 btnLimpiar.setBackground(new Color(252, 187, 33));
		 getContentPane().add(btnLimpiar);
		 
		 JButton btnExcel = new JButton("");
		 btnExcel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/excelicononegro.png")));
		 
		 btnExcel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnExcel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 ReporteController controller = new ReporteController();
			        	 List<Reporte> listarReporte = controller.listarReporte();
			        	 ReporteExcel.reporteinventario();

					}
				});
		 	}
		 });
		 btnExcel.setBackground(new Color(128, 255, 128));
		 btnExcel.setBounds(1196, 50, 44, 25);
		 getContentPane().add(btnExcel);
		
		 btnBuscar.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
			 if (cboFiltrar != null && txtBuscar != null) {
			        String columnaSeleccionada = cboFiltrar.getSelectedItem().toString();
			        String descripcionBusqueda = txtBuscar.getText().trim();

			        if (!descripcionBusqueda.isEmpty()) {
			            try {
			                filtrarTabla(columnaSeleccionada, descripcionBusqueda);
			            } catch (NumberFormatException ex) {
			                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico para la búsqueda por ID.", "Error", JOptionPane.ERROR_MESSAGE);
			            }
			        } else {
			            // Campo de búsqueda vacío, podrías mostrar un mensaje o realizar alguna acción
			        	JOptionPane.showMessageDialog(null, "Por favor, ingrese un elemento a buscar.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    } else {
			        // Mensaje de error o acción adecuada si cboFiltrar o txtBuscar es nulo
			        System.out.println("Error: JComboBox o JTextField es nulo");
			    }
			 }
		 });
		 
		 btnLimpiar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		mostrarTabla();
			 	}
			 });

	}
	
	
	
	private void mostrarTabla() {
	    modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
	    List<Producto> listarProducto = productocontroller.listarProducto();
	    
	    for (Producto producto : listarProducto) {
	    	String nombreMarca = marcacontroller.obtenerNombreMarcaPorId(producto.getId_marca());
	    	String nombreSubCategoria = subcategoriacontroller.obtenerNombreSubCategoriaPorId(producto.getId_subcategoria());
	        Object[] fila = {
	        		
	        		producto.getId(),
	        		producto.getDescripcion(),
	        		nombreMarca,
	        		producto.getPrecio_compra(),
	        		producto.getPrecio_venta(),
	        		producto.getStock(),
	        		nombreSubCategoria
	        		
	        };
	        modelo.addRow(fila);
	    }
	}
	
	//ESTO ES PARA EL TXTBUSCAR 
	
	  private void filtrarTabla(String columna, String descripcionBusqueda) {
	        // Utiliza la instancia correcta de tblInventario
	        List<Producto> listaFiltrada = productocontroller.listarProductoPorColumna(columna, descripcionBusqueda);

	        if (!listaFiltrada.isEmpty()) {
	            modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos

	            for (Producto producto : listaFiltrada) {
	            	String nombreMarca = marcacontroller.obtenerNombreMarcaPorId(producto.getId_marca());
	    	    	String nombreSubCategoria = subcategoriacontroller.obtenerNombreSubCategoriaPorId(producto.getId_subcategoria());
	    	        Object[] fila = {
	    	        		
	    	        		producto.getId(),
	    	        		producto.getDescripcion(),
	    	        		nombreMarca,
	    	        		producto.getPrecio_compra(),
	    	        		producto.getPrecio_venta(),
	    	        		producto.getStock(),
	    	        		nombreSubCategoria
	                };
	                modelo.addRow(fila);
	            }
	        } else {
	            if (columna.equalsIgnoreCase("DESCRIPCION")) {
	                // Si la búsqueda por descripción no devuelve resultados, mostrar un mensaje diferente
	                JOptionPane.showMessageDialog(null, "No se encontraron productos con la descripción proporcionada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	            } else if (columna.equalsIgnoreCase("ID")) {
	                // Si se está buscando por ID y ocurre un error de formato, mostrar un mensaje
	                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico para la búsqueda por ID.", "Error", JOptionPane.ERROR_MESSAGE);
	            } else {
	                // Mensaje predeterminado para otras columnas
	                JOptionPane.showMessageDialog(null, "No se encontraron productos con los criterios de búsqueda proporcionados", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	            }
	            mostrarTabla(); // Mostrar todos los productos si la búsqueda no devuelve resultados
	        }

	        limpiar(); // Limpia el campo de búsqueda después de mostrar los resultados
	    }

	private void buscarProducto() {
	    String textoBuscar = txtBuscar.getText().trim().toLowerCase();
	    
	    if (!textoBuscar.isEmpty()) {
	        List<Producto> listarProducto = productocontroller.listarProducto();

	        modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos

	        for (Producto producto : listarProducto) {
	            String id = String.valueOf(producto.getId()).toLowerCase();
	            String descripcion = producto.getDescripcion().toLowerCase();
	            String subcategoria = String.valueOf(producto.getId_subcategoria()).toLowerCase();

	            // Buscar coincidencias en id, descripcion y subcategoria
	            if (id.contains(textoBuscar) || descripcion.contains(textoBuscar) || subcategoria.contains(textoBuscar)) {
	                // Agregar la fila del producto encontrado
	                Object[] fila = {
	                        producto.getId(),
	                        producto.getDescripcion(),
	                        producto.getId_marca(),
	                        producto.getPrecio_compra(),
	                        producto.getPrecio_venta(),
	                        producto.getStock(),
	                        producto.getId_subcategoria()
	                };
	                modelo.addRow(fila);
	            }
	        }
	    } else {
	        // El campo de búsqueda está vacío, puedes mostrar un mensaje o realizar alguna acción
	        System.out.println("Ingrese un texto para buscar");
	    }
	   
	}
	private void limpiar() {
	    txtBuscar.setText(""); // Establece el texto del campo txtBuscar como vacío
	}
	
	private void buscarProductosPorDescripcion(String textoBuscar) {
		
		String textoBuscarLowerCase = textoBuscar.toLowerCase();
	//	String descripcionLowerCase = productocontroller.getDescripcion().toLowerCase();
	    List<Producto> productos = productocontroller.buscarProductosPorDescripcion(textoBuscar);

	    if (!productos.isEmpty()) {
	        modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
	        
	        for (Producto producto : productos) {	        	
	            Object[] fila = {
	                    producto.getId(),
	                    producto.getDescripcion(),
	                    producto.getId_marca(),
	                    producto.getPrecio_compra(),
	                    producto.getPrecio_venta(),
	                    producto.getStock(),
	                    producto.getId_subcategoria()
	            };
	            modelo.addRow(fila);
	        }
	    } else {
	        // Si no se encuentran productos, muestra un mensaje
	        JOptionPane.showMessageDialog(null, "No se encontraron productos con la descripción proporcionada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
	        mostrarTabla(); // Mostrar todos los productos si la búsqueda no devuelve resultados
	    }

	    limpiar(); // Limpia el campo de búsqueda después de mostrar los resultados
	}
	}
	


