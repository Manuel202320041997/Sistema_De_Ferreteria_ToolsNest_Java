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

import Model.DetalleCompra;
import Model.Empleado;
import Model.Marca;
import Model.Producto;
import Model.Proveedor;
import Model.Transportista;
import Model.Usuario;
import Model.SubCategoria;
import Model.Guia;
import Model.Guia_Detalle;
import Model.Guia_Ingreso;
import Model.Reporte;
import Model.ReporteExcel;

import Controller.ReporteController;
import Controller.EmpleadoController;
import Controller.GuiaController;
import Controller.GuiaDetalleController;
import Controller.GuiaIngresoController;
import Controller.ProveedorController;
import Controller.ProductoController;
import Controller.TransportistaController;
import Controller.MarcaController;
import Controller.SubCategoriaController;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class ifrm_Ingresos extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private EmpleadoController empleadocontroller;
	private ProveedorController proveedorcontroller;
	private ProductoController productocontroller;
	private TransportistaController transportistacontroller;
	private MarcaController marcacontroller;
	private SubCategoriaController subcategoriacontroller;
	private GuiaController guiacontroller;
	private GuiaDetalleController guiadetallecontroller;
	private GuiaIngresoController guiaingresocontroller;
	DefaultTableModel modelo;
	private JTable tblProducto;
	private JTextField txtObservacion;
	private JTextField textObservacion1;	
	private JComboBox cboProducto;
	private JComboBox cboProveedor;
	private JComboBox cboProveedor1;
	private JComboBox cboMarca;
	private JComboBox cboSubCategoria;
	private JComboBox cboTransporte;
	private JComboBox cboTransporte1;
    private JSpinner spinnerCantidad;	
    private JSpinner spinnerCantidad1;
    private JSpinner spinnerCompra;
    private JSpinner spinnerVenta;
    private JTextField txtProducto;
    private JTextField txtMotivo;
    private JTextField txtMotivo1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario usuarioValidado = new Usuario();
					ifrm_Ingresos frame = new ifrm_Ingresos(usuarioValidado);
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
	public ifrm_Ingresos(Usuario usuarioValidado) {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);	
		
		reportecontroller = new ReporteController();
		empleadocontroller = new EmpleadoController();
		proveedorcontroller = new ProveedorController();
		productocontroller = new ProductoController();
		transportistacontroller = new TransportistaController();
		marcacontroller = new MarcaController();
		subcategoriacontroller = new SubCategoriaController();
		guiacontroller = new GuiaController();
		guiadetallecontroller = new GuiaDetalleController();
		guiaingresocontroller = new GuiaIngresoController();				

		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "Descripcion", "Cantidad", "Precio Compra", "Precio Venta", "Marca", "SubCategoria"
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
		tblProducto.getColumnModel().getColumn(2).setPreferredWidth(20); // P.Compra
		tblProducto.getColumnModel().getColumn(3).setPreferredWidth(20); // P.Venta
		tblProducto.getColumnModel().getColumn(4).setPreferredWidth(20); // Marca
		tblProducto.getColumnModel().getColumn(5).setPreferredWidth(20); // SubCategoria

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
		          //  ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

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
		 scrollPane.setBounds(10, 11, 861, 574);
		 getContentPane().add(scrollPane);
		 
		 JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		 tabbedPane.setBounds(934, 11, 320, 560);
		 getContentPane().add(tabbedPane);
		 
		 JPanel panel = new JPanel();
		 tabbedPane.addTab("Actualizar Stock", null, panel, null);
		 panel.setLayout(null);
		 
		 JLabel lblNewLabel = new JLabel("INGRESO DE PRODUCTOS");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 lblNewLabel.setBounds(10, 5, 295, 41);
		 panel.add(lblNewLabel);
		 
		 JButton btnGuardar = new JButton("Agregar");
		 btnGuardar.setForeground(new Color(245, 245, 245));
		 btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnGuardar.setBackground(new Color(78, 156, 54));
		 btnGuardar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		 btnGuardar.setBounds(29, 415, 119, 29);
		 panel.add(btnGuardar);
		 
		 JButton btnLimpiar = new JButton("Limpiar");
		 btnLimpiar.setForeground(Color.BLACK);
		 btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnLimpiar.setBackground(new Color(252, 187, 33));
		 btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		 btnLimpiar.setBounds(29, 452, 260, 29);
		 panel.add(btnLimpiar);
		 
		 JButton btnEliminar = new JButton("Eliminar");
		 btnEliminar.setForeground(new Color(245, 245, 245));
		 btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnEliminar.setBackground(new Color(144, 8, 9));
		 btnEliminar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/eliminaricono.png")));
		 btnEliminar.setBounds(167, 415, 122, 29);
		 panel.add(btnEliminar);
		 
		 JButton btnActualizarStock = new JButton("Ingresar Productos");		
		 btnActualizarStock.setForeground(new Color(245, 245, 245));
		 btnActualizarStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnActualizarStock.setBackground(new Color(4, 51, 108));
		 btnActualizarStock.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/stockicono.png")));
		 btnActualizarStock.setBounds(29, 492, 260, 29);
		 panel.add(btnActualizarStock);
		 
		 String numeroGuia = guiacontroller.generarNumeroGuia();
		 JLabel lblGuia = new JLabel("N° Guía: "+numeroGuia);
		 lblGuia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblGuia.setBounds(29, 67, 110, 28);
		 panel.add(lblGuia);
		 
		 LocalDate fechaActual = LocalDate.now();
		 JLabel lblFecha = new JLabel("Fecha: "+fechaActual);
		 lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblFecha.setBounds(173, 67, 119, 28);
		 panel.add(lblFecha);
		 
		 JLabel lblNewLabel_2_3_1 = new JLabel("Proveedor:");
		 lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1.setBounds(29, 140, 100, 28);
		 panel.add(lblNewLabel_2_3_1);
		 
		 cboProveedor = new JComboBox();
		 cboProveedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboProveedor.setBounds(139, 140, 153, 29);
		 actualizarComboBoxProveedor();
		 panel.add(cboProveedor);
		 
		 JLabel lblNewLabel_2_3 = new JLabel("Producto:");
		 lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3.setBounds(29, 318, 100, 28);
		 panel.add(lblNewLabel_2_3);
		 
		 cboProducto = new JComboBox();
		 cboProducto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboProducto.setBounds(139, 318, 153, 29);
		 actualizarComboBoxProducto();
		 panel.add(cboProducto);
		 
		 spinnerCantidad = new JSpinner();
		 spinnerCantidad.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		 spinnerCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 spinnerCantidad.setBounds(139, 359, 153, 28);
		 panel.add(spinnerCantidad);
		 
		 JLabel lblNewLabel_2_2 = new JLabel("Cantidad:");
		 lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_2.setBounds(29, 357, 79, 28);
		 panel.add(lblNewLabel_2_2);
		 
		 JLabel lblNewLabel_2_3_1_1 = new JLabel("Chofer:");
		 lblNewLabel_2_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_1.setBounds(29, 247, 100, 28);
		 panel.add(lblNewLabel_2_3_1_1);
		 
		 cboTransporte = new JComboBox();
		 cboTransporte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 cboTransporte.setBounds(139, 247, 153, 29);
		 actualizarComboBoxChofer();
		 panel.add(cboTransporte);
		 
		 JLabel lblNewLabel_3_1 = new JLabel("");
		 lblNewLabel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DEL TRANSPORTISTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_1.setBounds(10, 227, 295, 59);
		 panel.add(lblNewLabel_3_1);
		 
		 JLabel lblNewLabel_3_1_1 = new JLabel("");
		 lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DEL PRODUCTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_1_1.setBounds(10, 297, 295, 107);
		 panel.add(lblNewLabel_3_1_1);
		 
		 JLabel lblNewLabel_2_3_1_2 = new JLabel("Observacion:");
		 lblNewLabel_2_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_2.setBounds(29, 100, 100, 28);
		 panel.add(lblNewLabel_2_3_1_2);
		 
		 txtObservacion = new JTextField();
		 txtObservacion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtObservacion.setColumns(10);
		 txtObservacion.setBounds(139, 100, 153, 29);
		 panel.add(txtObservacion);
		 
		 JLabel lblNewLabel_2_3_1_2_2 = new JLabel("Motivo:");
		 lblNewLabel_2_3_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_2_3_1_2_2.setBounds(29, 179, 100, 28);
		 panel.add(lblNewLabel_2_3_1_2_2);
		 
		 txtMotivo = new JTextField();
		 txtMotivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 txtMotivo.setColumns(10);
		 txtMotivo.setBounds(139, 179, 153, 29);
		 panel.add(txtMotivo);
		 
		 JLabel lblNewLabel_3 = new JLabel("");
		 lblNewLabel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS GENERALES DE GUIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3.setBounds(10, 49, 295, 167);
		 panel.add(lblNewLabel_3);
		 
		 JPanel panel_1 = new JPanel();
		 tabbedPane.addTab("Nuevos Productos", null, panel_1, null);
		 panel_1.setLayout(null);
		 
		 String numeroGuia1 = guiacontroller.generarNumeroGuia();
		 JLabel lblGuia_1 = new JLabel("N° Guía: "+numeroGuia1);
		 lblGuia_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblGuia_1.setBounds(29, 26, 110, 28);
		 panel_1.add(lblGuia_1);
		 
		 LocalDate fechaActual1 = LocalDate.now();
		 JLabel lblFecha_1 = new JLabel("Fecha: "+fechaActual1);
		 lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblFecha_1.setBounds(173, 26, 119, 28);
		 panel_1.add(lblFecha_1);
		 
		 textObservacion1 = new JTextField();
		 textObservacion1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 textObservacion1.setColumns(10);
		 textObservacion1.setBounds(139, 96, 153, 25);
		 panel_1.add(textObservacion1);
		 
		 JLabel lblNewLabel_2_3_1_2_1 = new JLabel("Observacion:");
		 lblNewLabel_2_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_1_2_1.setBounds(29, 95, 79, 28);
		 panel_1.add(lblNewLabel_2_3_1_2_1);
		 
		 JLabel lblNewLabel_2_3_1_3 = new JLabel("Proveedor:");
		 lblNewLabel_2_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_1_3.setBounds(29, 125, 100, 28);
		 panel_1.add(lblNewLabel_2_3_1_3);
		 
		 cboProveedor1 = new JComboBox();
		 cboProveedor1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 cboProveedor1.setBounds(139, 125, 153, 25);
		 actualizarComboBoxProveedor1();
		 panel_1.add(cboProveedor1);
		 
		 JLabel lblNewLabel_2_3_1_1_1 = new JLabel("Chofer:");
		 lblNewLabel_2_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_1_1_1.setBounds(29, 192, 100, 28);
		 panel_1.add(lblNewLabel_2_3_1_1_1);
		 
		 cboTransporte1 = new JComboBox();
		 cboTransporte1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 cboTransporte1.setBounds(139, 192, 153, 25);
		 actualizarComboBoxChofer1();
		 panel_1.add(cboTransporte1);
		 
		 JLabel lblNewLabel_3_1_2 = new JLabel("");
		 lblNewLabel_3_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DEL TRANSPORTISTA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_1_2.setBounds(10, 172, 295, 59);
		 panel_1.add(lblNewLabel_3_1_2);
		 
		 JLabel lblNewLabel_2_3_2 = new JLabel("Producto:");
		 lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_2.setBounds(29, 260, 100, 28);
		 panel_1.add(lblNewLabel_2_3_2);		 
		 
		 spinnerCantidad1 = new JSpinner();
		 spinnerCantidad1.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		 spinnerCantidad1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 spinnerCantidad1.setBounds(139, 290, 153, 25);
		 panel_1.add(spinnerCantidad1);
		 
		 JLabel lblNewLabel_2_2_1 = new JLabel("Cantidad:");
		 lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_2_1.setBounds(29, 290, 79, 28);
		 panel_1.add(lblNewLabel_2_2_1);
		 
		 JButton btnGuardar2 = new JButton("Agregar");		 		 
		 btnGuardar2.setForeground(new Color(245, 245, 245));
		 btnGuardar2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnGuardar2.setBackground(new Color(78, 156, 54));
		 btnGuardar2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		 btnGuardar2.setBounds(32, 452, 119, 29);
		 panel_1.add(btnGuardar2);
		 
		 JButton btnEliminar2 = new JButton("Eliminar");
		 btnEliminar2.setForeground(new Color(245, 245, 245));
		 btnEliminar2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnEliminar2.setBackground(new Color(144, 8, 9));
		 btnEliminar2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/eliminaricono.png")));
		 btnEliminar2.setBounds(170, 452, 122, 29);
		 panel_1.add(btnEliminar2);
		 
		 JButton btnRegistrarProducto = new JButton("Ingresar Nuevos Productos");
		 btnRegistrarProducto.setForeground(new Color(245, 245, 245));
		 btnRegistrarProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 btnRegistrarProducto.setBackground(new Color(4, 51, 108));
		 btnRegistrarProducto.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/stockicono.png")));
		 btnRegistrarProducto.setBounds(32, 492, 260, 29);
		 panel_1.add(btnRegistrarProducto);
		 
		 JLabel lblNewLabel_2_2_1_1 = new JLabel("P. Compra:");
		 lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_2_1_1.setBounds(29, 320, 79, 28);
		 panel_1.add(lblNewLabel_2_2_1_1);
		 
		 spinnerVenta = new JSpinner();
		 spinnerVenta.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		 spinnerVenta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 spinnerVenta.setBounds(139, 350, 153, 25);
		 panel_1.add(spinnerVenta);
		 
		 JLabel lblNewLabel_2_2_1_1_1 = new JLabel("P. Venta:");
		 lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_2_1_1_1.setBounds(29, 350, 79, 28);
		 panel_1.add(lblNewLabel_2_2_1_1_1);
		 
		 spinnerCompra = new JSpinner();
		 spinnerCompra.setModel(new SpinnerNumberModel(Double.valueOf(0), Double.valueOf(0), null, Double.valueOf(1)));
		 spinnerCompra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 spinnerCompra.setBounds(139, 320, 153, 25);
		 panel_1.add(spinnerCompra);
		 
		 JLabel lblNewLabel_2_3_2_1 = new JLabel("Marca:");
		 lblNewLabel_2_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_2_1.setBounds(29, 380, 100, 28);
		 panel_1.add(lblNewLabel_2_3_2_1);
		 
		 cboMarca = new JComboBox();
		 cboMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 cboMarca.setBounds(139, 380, 153, 25);
		 actualizarComboBoxMarca();
		 panel_1.add(cboMarca);
		 
		 JLabel lblNewLabel_2_3_2_1_1 = new JLabel("Sub Categoria:");
		 lblNewLabel_2_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_2_1_1.setBounds(31, 410, 100, 28);
		 panel_1.add(lblNewLabel_2_3_2_1_1);
		 
		 cboSubCategoria = new JComboBox();
		 cboSubCategoria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 cboSubCategoria.setBounds(139, 412, 153, 25);
		 actualizarComboBoxSubCategoria();
		 panel_1.add(cboSubCategoria);
		 
		 txtProducto = new JTextField();
		 txtProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 txtProducto.setColumns(10);
		 txtProducto.setBounds(139, 260, 153, 25);
		 panel_1.add(txtProducto);
		 
		 JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		 lblNewLabel_3_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DEL PRODUCTO", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_1_1_1.setBounds(10, 242, 295, 205);
		 panel_1.add(lblNewLabel_3_1_1_1);
		 
		 JLabel lblNewLabel_2_3_1_2_1_1 = new JLabel("Motivo");
		 lblNewLabel_2_3_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 lblNewLabel_2_3_1_2_1_1.setBounds(29, 65, 79, 28);
		 panel_1.add(lblNewLabel_2_3_1_2_1_1);
		 
		 txtMotivo1 = new JTextField();
		 txtMotivo1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 txtMotivo1.setColumns(10);
		 txtMotivo1.setBounds(139, 65, 153, 25);
		 panel_1.add(txtMotivo1);
		 
		 JLabel lblNewLabel_3_2 = new JLabel("");
		 lblNewLabel_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS GENERALES DE GUIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 lblNewLabel_3_2.setBounds(10, 11, 295, 150);
		 panel_1.add(lblNewLabel_3_2);
		 
		 btnLimpiar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		limpiar();
			 	}
			 });
		
		 btnGuardar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		Object valorspinner = spinnerCantidad.getValue();
					
					if(valorspinner instanceof Integer) {
						int cantidad = (int) valorspinner;
						
						if(cantidad > 0) {
							
							String nombreProducto = (String) cboProducto.getSelectedItem();							
							Producto productoInfo = productocontroller.obtenerProductoPorNombre(nombreProducto);
														
							double precioVenta = productoInfo.getPrecio_venta();
							double precioCompra = productoInfo.getPrecio_compra();
							String marca = marcacontroller.obtenerNombreMarcaPorId(productoInfo.getId_marca());							
							String subCategoria = subcategoriacontroller.obtenerNombreSubCategoriaPorId(productoInfo.getId_subcategoria());
							
								Object[] fila = {nombreProducto, cantidad, precioCompra, precioVenta, marca, subCategoria};
								modelo.addRow(fila);

								cboProducto.setSelectedIndex(0);
								spinnerCantidad.setValue(0);
						}
						else {
							JOptionPane.showMessageDialog(ifrm_Ingresos.this, "La cantidad debe ser mayor que cero.", "Aviso", JOptionPane.WARNING_MESSAGE);
						}
					}
			 	}
		});
		 
		 btnGuardar2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		 // Obtén los valores de los Spinners
			        Object valorCompra = spinnerCompra.getValue();
			        Object valorVenta = spinnerVenta.getValue();
			        Object cantidadProd = spinnerCantidad1.getValue();

			        // Verifica que los valores sean de tipo Double y mayores a cero
			        if (valorCompra instanceof Double && valorVenta instanceof Double && cantidadProd instanceof Integer) {
			            double precioCompra = (double) valorCompra;
			            double precioVenta = (double) valorVenta;
			            int cantidad = (int) cantidadProd;

			            if (precioCompra > 0 && precioVenta > 0 && cantidad > 0) {
			                String nombreProducto = txtProducto.getText();
			                String marca = (String) cboMarca.getSelectedItem();
			                String subCategoria = (String) cboSubCategoria.getSelectedItem();
			                // Agrega la fila solo si las condiciones se cumplen
			                Object[] fila = {nombreProducto, spinnerCantidad1.getValue(), precioCompra, precioVenta, marca, subCategoria};
			                modelo.addRow(fila);

			                // Limpia los componentes después de agregar la fila
			                txtProducto.setText("");
			                cboMarca.setSelectedIndex(0);
			                cboSubCategoria.setSelectedIndex(0);
			                spinnerCantidad1.setValue(0);
			                spinnerCompra.setValue(0);
			                spinnerVenta.setValue(0);
			                
			            } else {
			                JOptionPane.showMessageDialog(ifrm_Ingresos.this, "Los campos de cantidad, compra y venta deben ser mayores que cero.", "Aviso", JOptionPane.WARNING_MESSAGE);
			            }
			        } else {
			            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "Los valores de compra y venta deben ser de tipo numérico.", "Aviso", JOptionPane.WARNING_MESSAGE);
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
				            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
			 	}
			 });
		 
		 btnEliminar2.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		 int filaSeleccionada = tblProducto.getSelectedRow();

				        // Verifica que haya una fila seleccionada
				        if (filaSeleccionada != -1) {
				            // Elimina la fila del modelo de la tabla
				            modelo.removeRow(filaSeleccionada);
				        } else {
				            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
				        }
			 	}
			 });
		 
		 btnActualizarStock.addActionListener(new ActionListener() {
			    private List<Producto> productos = new ArrayList<>();
			    private List<Guia_Detalle> guiadetalles = new ArrayList<>();

			    public void actionPerformed(ActionEvent e) {
			        /* ACTUALIZACION DE STOCK */
			        int rowCount = modelo.getRowCount();
			        for (int i = 0; i < rowCount; i++) {
			            String nombreProducto = (String) modelo.getValueAt(i, 0);
			            int cantidad = (int) modelo.getValueAt(i, 1);

			            Producto producto = new Producto();
			            producto.setDescripcion(nombreProducto);
			            producto.setStock(cantidad);
			            productos.add(producto);
			        }

			        for (Producto producto : productos) {
			            productocontroller.actualizarStock(producto);
			        }
			        /* TERMINA ACTUALIZACION DE STOCK */

			        /* GENERAR GUIA DE INGRESO */
			        String motivo = txtMotivo.getText();
			        String observacion = txtObservacion.getText();

			        if (motivo.isEmpty() || observacion.isEmpty()) {
			            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "El campo Motivo y Observación no pueden estar vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			        } else {
			            String nombreProveedor = (String) cboProveedor.getSelectedItem();
			            int idProveedor = proveedorcontroller.obtenerIdProveedorPorNombre(nombreProveedor);
			            String nombreTransportista = (String) cboTransporte.getSelectedItem();
			            Transportista transportista = transportistacontroller.obtenerTransportistaPorNombre(nombreTransportista);
			            int idTransportista = transportista.getId();

			            /* DATOS GUIA Y GENERACION */
			            String numeroGuia = guiacontroller.generarNumeroGuia();
			            int dniUsuario = usuarioValidado.getDni();
			            Empleado empleado = new Empleado();
			            empleado = empleadocontroller.buscarEmpleadoPorDni(dniUsuario);
			            int idEmpleado = empleado.getId();

			            int idGuiaGenerada = guiacontroller.registrarGuia(numeroGuia, idEmpleado, motivo);
			            /* TERMINA GENERACION DE GUIA */

			            /* INICIA DETALLE DE GUIA */
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

			            /* INICIA GUIA INGRESOS */
			            Guia_Ingreso guiaingreso = new Guia_Ingreso();
			            guiaingreso.setId_guia(idGuiaGenerada);
			            guiaingreso.setId_proveedor(idProveedor);
			            guiaingreso.setId_transportista(idTransportista);
			            guiaingreso.setObservacion(observacion);

			            guiaingresocontroller.registrarGuiaIngreso(guiaingreso);
			            /* TERMINA GUIA INGRESOS */
			            Reporte.ReporteIngresos();
			            limpiar();
			            /* TERMIINA GENERAR GUIA DE INGRESO */
			            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "Stock y Guía de Ingresos : " + numeroGuia + " generadas con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
			        }
			 	}
		});
		 
		btnRegistrarProducto.addActionListener(new ActionListener() {
			private List<Producto> productos = new ArrayList<>();
		    private List<Guia_Detalle> guiadetalles = new ArrayList<>();
			public void actionPerformed(ActionEvent e) {
				int rowCount = modelo.getRowCount();
		 		for (int i = 0; i < rowCount; i++) {
	                String nombreProducto = (String) modelo.getValueAt(i, 0);		                
	                int cantidad = (int) modelo.getValueAt(i, 1);
	                double precio_compra = (double) modelo.getValueAt(i, 2);
	                double precio_venta = (double) modelo.getValueAt(i, 3);
	                String marca = (String) modelo.getValueAt(i, 4);
	                String subcategoria = (String) modelo.getValueAt(i, 5);
	                
	                int idmarca = marcacontroller.obtenerIdMarcaPorNombre(marca);
	                int idsubcategoria = subcategoriacontroller.obtenerIdSubCategoriaPorNombre(subcategoria);
	                System.out.println(idmarca);
	                
	                Producto producto = new Producto();
	                producto.setDescripcion(nombreProducto);
	                producto.setId_marca(idmarca);
	                producto.setPrecio_compra(precio_compra);
	                producto.setPrecio_venta(precio_venta);
	                producto.setStock(cantidad);
	                producto.setId_subcategoria(idsubcategoria);
	                productos.add(producto);
	            }
		 		
	            for (Producto producto: productos) {
	                productocontroller.agregarProducto(producto);
	            }
	            
	            /* GENERAR GUIA DE INGRESO */
		        String motivo = txtMotivo1.getText();
		        String observacion = textObservacion1.getText();

		        if (motivo.isEmpty() || observacion.isEmpty()) {
		            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "El campo Motivo y Observación no pueden estar vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
		        } else {
		            String nombreProveedor = (String) cboProveedor.getSelectedItem();
		            int idProveedor = proveedorcontroller.obtenerIdProveedorPorNombre(nombreProveedor);
		            String nombreTransportista = (String) cboTransporte.getSelectedItem();
		            Transportista transportista = transportistacontroller.obtenerTransportistaPorNombre(nombreTransportista);
		            int idTransportista = transportista.getId();

		            /* DATOS GUIA Y GENERACION */
		            String numeroGuia = guiacontroller.generarNumeroGuia();
		            int dniUsuario = usuarioValidado.getDni();
		            Empleado empleado = new Empleado();
		            empleado = empleadocontroller.buscarEmpleadoPorDni(dniUsuario);
		            int idEmpleado = empleado.getId();

		            int idGuiaGenerada = guiacontroller.registrarGuia(numeroGuia, idEmpleado, motivo);
		            /* TERMINA GENERACION DE GUIA */

		            /* INICIA DETALLE DE GUIA */
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

		            /* INICIA GUIA INGRESOS */
		            Guia_Ingreso guiaingreso = new Guia_Ingreso();
		            guiaingreso.setId_guia(idGuiaGenerada);
		            guiaingreso.setId_proveedor(idProveedor);
		            guiaingreso.setId_transportista(idTransportista);
		            guiaingreso.setObservacion(observacion);

		            guiaingresocontroller.registrarGuiaIngreso(guiaingreso);
		            /* TERMINA GUIA INGRESOS */
		            Reporte.ReporteIngresos();
		            limpiar();
		            /* TERMIINA GENERAR GUIA DE INGRESO */
		            JOptionPane.showMessageDialog(ifrm_Ingresos.this, "Stock y Guía de Ingresos : " + numeroGuia + " generadas con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
		        }
			}
		}); 
			 	
}
	
	private void actualizarComboBoxProveedor() {
		List<Proveedor> listaProveedor = proveedorcontroller.listaProveedorFiltarada();
		cboProveedor.removeAllItems();
		
		for(Proveedor proveedor : listaProveedor) {
			cboProveedor.addItem(proveedor.getRazon_social());
			
		}
	}
	
	private void actualizarComboBoxProveedor1() {
		List<Proveedor> listaProveedor = proveedorcontroller.listaProveedorFiltarada();
		cboProveedor1.removeAllItems();
		
		for(Proveedor proveedor : listaProveedor) {
			cboProveedor1.addItem(proveedor.getRazon_social());
			
		}
	}	
	
	private void actualizarComboBoxProducto() {
		List<Producto> listaProducto = productocontroller.listarProducto();
		cboProducto.removeAllItems();
		
		for(Producto producto : listaProducto) {
			cboProducto.addItem(producto.getDescripcion());
		}
 
	}
	
	private void actualizarComboBoxChofer() {
		List<Transportista> listaTransportista = transportistacontroller.listarTransportista();
		cboTransporte.removeAllItems();
		
		for(Transportista transportista : listaTransportista) {
			cboTransporte.addItem(transportista.getNombres());
		}
 
	}
	
	private void actualizarComboBoxChofer1() {
		List<Transportista> listaTransportista = transportistacontroller.listarTransportista();
		cboTransporte1.removeAllItems();
		
		for(Transportista transportista : listaTransportista) {
			cboTransporte1.addItem(transportista.getNombres());
		}
 
	}
	
	private void actualizarComboBoxMarca() {
		List<Marca> listaMarca = marcacontroller.listarMarca();
		cboMarca.removeAllItems();
		
		for(Marca marca : listaMarca) {
			cboMarca.addItem(marca.getDescripcion());
		}
 
	}
	
	private void actualizarComboBoxSubCategoria() {
		List<SubCategoria> listasubCategoria = subcategoriacontroller.listarCategoria();
		cboSubCategoria.removeAllItems();
		
		for(SubCategoria subcategoria : listasubCategoria) {
			cboSubCategoria.addItem(subcategoria.getDescripcion());
		}
 
	}
	
	private void limpiar() {
		txtMotivo.setText("");
		txtMotivo1.setText("");
        txtObservacion.setText("");
        textObservacion1.setText("");
        cboProveedor.setSelectedIndex(0);
        cboProveedor1.setSelectedIndex(0);
        cboTransporte.setSelectedIndex(0);
        cboTransporte1.setSelectedIndex(0);
        cboProducto.setSelectedIndex(0);
        txtProducto.setText("");        
        spinnerCantidad.setValue(0);
        spinnerCantidad1.setValue(0);
        spinnerCompra.setValue(0);
        spinnerVenta.setValue(0);
	}
}
