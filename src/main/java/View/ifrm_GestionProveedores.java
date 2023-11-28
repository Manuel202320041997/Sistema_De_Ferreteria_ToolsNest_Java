package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
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

import Controller.ProveedorController;
import Controller.ReporteController;
import Model.Proveedor;
import Model.Reporte;
import Model.ReporteExcel;
import Model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class ifrm_GestionProveedores extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ProveedorController proveedorcontroller;
	private ReporteController reportecontroller;
	DefaultTableModel modelo;
	private JTable tblProveedores;
	private JTextField txtBuscar;
	private JTextField txtRazonSocial;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionProveedores frame = new ifrm_GestionProveedores();
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
	public ifrm_GestionProveedores() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);		
		
		proveedorcontroller = new ProveedorController();
		reportecontroller = new ReporteController();
		
		JPanel panel = new JPanel();
		panel.setBounds(974, 11, 280, 560);
		panel.setBackground(new Color(245,245,245));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INGRESO DE DATOS ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 22, 260, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por ID:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(46, 84, 89, 20);
		panel.add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBuscar.setBounds(133, 85, 86, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(204, 226, 178));
		btnBuscar.setBounds(229, 84, 37, 23);
		btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/lupaicono.png")));
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("Razón Social:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 150, 103, 28);
		panel.add(lblNewLabel_2);
		
		txtRazonSocial = new JTextField();
		txtRazonSocial.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtRazonSocial.setBounds(107, 149, 150, 29);
		panel.add(txtRazonSocial);
		txtRazonSocial.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Telefono:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 202, 77, 28);
		panel.add(lblNewLabel_2_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(107, 202, 150, 28);
		panel.add(txtTelefono);
		
		JLabel lblNewLabel_2_2 = new JLabel("Dirrección:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 260, 77, 28);
		panel.add(lblNewLabel_2_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(107, 261, 150, 28);
		panel.add(txtDireccion);
		
		JLabel lblNewLabel_2_3 = new JLabel("Correo:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(10, 321, 77, 28);
		panel.add(lblNewLabel_2_3);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(107, 323, 150, 29);		
		panel.add(txtCorreo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(new Color(245, 245, 245));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(30, 380, 219, 29);
		btnGuardar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		btnGuardar.setBackground(new Color(78, 156, 54));
		panel.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(0, 0, 0));
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(30, 417, 219, 29);
		btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		btnLimpiar.setBackground(new Color(252, 187, 33));
		panel.add(btnLimpiar);
		
		JButton btnEliminar = new JButton("Cambiar Estado");
		btnEliminar.setForeground(new Color(245, 245, 245));
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBounds(30, 457, 219, 29);
		btnEliminar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/estadoicono.png")));
		btnEliminar.setBackground(new Color(144, 8, 9));
		panel.add(btnEliminar);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setForeground(new Color(245, 245, 245));
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcel.setBounds(30, 497, 103, 29);
		btnExcel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/excelicono.png")));
		btnExcel.setBackground(new Color(33, 114, 69));
		panel.add(btnExcel);
		
		JButton btnPDF = new JButton("PDF");
		btnPDF.setForeground(new Color(245, 245, 245));
		btnPDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPDF.setBounds(146, 497, 103, 29);
		btnPDF.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/pdficono.png")));
		btnPDF.setBackground(new Color(173, 8, 8));
		panel.add(btnPDF);
		
		txtId = new JTextField();
		txtId.setVisible(false);
		txtId.setText("0");
		txtId.setBounds(239, 116, 27, 20);
		panel.add(txtId);
		txtId.setColumns(10);	

		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "Razón Social", "Telefono", "Direccion", "Correo", "Estado"
	            }
	        );

		tblProveedores = new JTable(modelo);
		tblProveedores.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblProveedores.getTableHeader().setOpaque(false);
		tblProveedores.getTableHeader().setBackground(new Color(40, 39, 61));
		tblProveedores.setSelectionBackground(new Color(241, 110, 79));
		tblProveedores.getTableHeader().setForeground(new Color(255, 255, 255));
		tblProveedores.setRowHeight(25);

		
		tblProveedores.setDefaultEditor(Object.class, null);
		tblProveedores.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblProveedores.getColumnModel().getColumn(1).setPreferredWidth(100); // Nombre
		tblProveedores.getColumnModel().getColumn(2).setPreferredWidth(40); // Correo
		tblProveedores.getColumnModel().getColumn(3).setPreferredWidth(150);
		tblProveedores.getColumnModel().getColumn(4).setPreferredWidth(100);
		tblProveedores.getColumnModel().getColumn(5).setPreferredWidth(20);
		
		
		tblProveedores.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		            ((JComponent) c).setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		            c.setBackground(table.getBackground());
		            // Restaurar el color de texto predeterminado
		            c.setForeground(table.getForeground());
		        }

		        return c;
		    }
		});

		tblProveedores.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblProveedores.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblProveedores.setIntercellSpacing(new Dimension(0, 0));
		tblProveedores.setShowGrid(false);
		tblProveedores.setShowHorizontalLines(true);
		tblProveedores.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblProveedores.setShowVerticalLines(true);
		tblProveedores.setGridColor(new Color(200, 200, 200));
		
		
		
		mostrarTabla();
	 // Crear un JScrollPane y agregar la JTable a él
		JScrollPane scrollPane = new JScrollPane(tblProveedores);
		scrollPane.setBounds(10, 11, 928, 560);
		getContentPane().add(scrollPane);
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		
		txtBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtBuscar.setText("");
			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int idProveedor = Integer.parseInt(txtBuscar.getText());
					Proveedor proveedorEncontrado = proveedorcontroller.buscarProveeedorPorId(idProveedor);
					
					if(proveedorEncontrado != null) {
						txtId.setText(String.valueOf(proveedorEncontrado.getId()));
						txtRazonSocial.setText(proveedorEncontrado.getRazon_social());
						txtTelefono.setText(proveedorEncontrado.getTelefono());
						txtDireccion.setText(proveedorEncontrado.getDireccion());
						txtCorreo.setText(proveedorEncontrado.getCorreo());
					}					
					else {
						JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Proveedor No Encontrado", "Aviso", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "ID Invalido", "Aviso", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String telefono = txtTelefono.getText();
					
					if(!telefono.isEmpty() && telefono.matches("\\d{9}")) {			
							Proveedor proveedor = new Proveedor();
							
							String razon_social = txtRazonSocial.getText().trim();							
							String direccion = txtDireccion.getText().trim();
							String correo = txtCorreo.getText().trim();
							
							if(!razon_social.isEmpty() && !direccion.isEmpty() && !correo.isEmpty()) {
								proveedor.setRazon_social(razon_social);
								proveedor.setTelefono(telefono);
								proveedor.setDireccion(direccion);
								proveedor.setCorreo(correo);
								
								String id = txtId.getText().trim();
								
								if(!id.isEmpty() && Integer.parseInt(id) > 0) {
									proveedor.setId(Integer.parseInt(id));
									
									proveedorcontroller.editarProveedor(proveedor);
									mostrarTabla();
									limpiar();
									JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Proveedor editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								}
								else {
									proveedorcontroller.agregarProveedor(proveedor);
									mostrarTabla();
									limpiar();
									JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Proveedor agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								}								
							}
							else {
								JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Ningún campo debe estar vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
							}
						}
					else {
						JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Campo Telefono no puede ser vacío o tener un numero mayor a 9 digitos.", "Aviso", JOptionPane.WARNING_MESSAGE);
					}

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
	        	 List<Reporte> listarReporte = reportecontroller.listarReporte();
	        	 ReporteExcel.reporteproveedor();

			}
		});
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
	        	 List<Reporte> listarReporte = reportecontroller.listarReporte();
	        	 Reporte.ReportesProveedores();

			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int filaSeleccionada = tblProveedores.getSelectedRow();
				
				if(filaSeleccionada >= 0) {
					try {
						Object columnaId = tblProveedores.getValueAt(filaSeleccionada, 0);
						Object columnaEstado = tblProveedores.getValueAt(filaSeleccionada, 5);
						int idProveedor = Integer.parseInt(columnaId.toString());
						String estadoTexto = String.valueOf(columnaEstado);
						
						int confirmacion = JOptionPane.showConfirmDialog(ifrm_GestionProveedores.this, "¿Estás seguro de cambiar Estado de este Proveedor?", "Confirmar Cambios", JOptionPane.YES_NO_OPTION);
						
						if(confirmacion == JOptionPane.YES_OPTION) {
							if(estadoTexto.equals("ACTIVO")) {
								proveedorcontroller.cambiarEstadoEmpleadoaInactivo(idProveedor);
								mostrarTabla();
							}
							else {
								proveedorcontroller.cambiarEstadoEmpleadoaActivo(idProveedor);
								mostrarTabla();
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Error de conversión: El valor no es un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(ifrm_GestionProveedores.this, "Por favor, seleccione un Proveedor para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
			
		});
		

	}
	
	private void mostrarTabla() {
		modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
		List<Proveedor> listarProveedor = proveedorcontroller.listarProveedor();
		
		 for (Proveedor proveedor : listarProveedor) {
			 String estadoTexto = proveedor.getEstado() ? "ACTIVO" : "INACTIVO";
			 	Object[] fila = {
		        		
		        		proveedor.getId(),
		        		proveedor.getRazon_social(),
		        		proveedor.getTelefono(),		        		
		        		proveedor.getDireccion(),
		        		proveedor.getCorreo(),
		        		estadoTexto

		        };
		        modelo.addRow(fila);
		    }
	}
	
	private void limpiar() {
		txtId.setText("0");
		txtBuscar.setText("");
		txtRazonSocial.setText("");
		txtTelefono.setText("");		
		txtDireccion.setText("");
		txtCorreo.setText("");
	}

}
