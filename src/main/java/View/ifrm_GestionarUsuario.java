package View;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.Reporte;
import Model.ReporteExcel;
import Model.Rol;
import Model.Usuario;
import Controller.UsuarioController;

import Controller.ReporteController;
import Controller.RolController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JComponent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ifrm_GestionarUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private UsuarioController usuariocontroller;
	
	private RolController rolcontroller;
	DefaultTableModel modelo;
	private JTable tblUsuario;
	private JTextField txtBuscar;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtClave;
	private JComboBox cboRol;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarUsuario frame = new ifrm_GestionarUsuario();
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
	public ifrm_GestionarUsuario() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		usuariocontroller = new UsuarioController();
		reportecontroller = new ReporteController();
		rolcontroller = new RolController();

		
		JPanel panel = new JPanel();
		panel.setBounds(974, 11, 280, 560);
		panel.setBackground(new Color(255, 255, 255)); // Cambiado el color de fondo

		Border bordeCompuesto = BorderFactory.createCompoundBorder(
		        BorderFactory.createLineBorder(new Color(100, 100, 100), 3), // Borde más grueso
		        BorderFactory.createEmptyBorder(15, 15, 15, 15)
		);
		Border bordeRedondeado = BorderFactory.createLineBorder(new Color(100, 100, 100), 3, true); // Borde más redondeado

		panel.setBorder(bordeCompuesto);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INGRESO DE DATOS ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 22, 260, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por DNI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(30, 84, 105, 20);
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
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 150, 77, 28);
		panel.add(lblNewLabel_2);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDni.setBounds(97, 149, 160, 29);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 202, 77, 28);
		panel.add(lblNewLabel_2_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(97, 202, 160, 28);
		panel.add(txtNombre);
		
		JLabel lblNewLabel_2_2 = new JLabel("CLAVE:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 260, 77, 28);
		panel.add(lblNewLabel_2_2);
		
		txtClave = new JTextField();
		txtClave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtClave.setColumns(10);
		txtClave.setBounds(97, 261, 160, 28);
		panel.add(txtClave);
		
		JLabel lblNewLabel_2_3 = new JLabel("ROL:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(10, 321, 77, 28);
		panel.add(lblNewLabel_2_3);
		
		cboRol = new JComboBox();
		cboRol.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboRol.setBounds(97, 323, 160, 29);
		actualizarComboBoxRol();
		panel.add(cboRol);
		
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
		txtId.setText("0");
		txtId.setVisible(false);
		txtId.setBounds(239, 116, 27, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
	

		

		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "DNI", "Nombre", "Clave", "Rol", "Estado"
	            }
	        );

		tblUsuario = new JTable(modelo);
	
		tblUsuario.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));    
		tblUsuario.getTableHeader().setOpaque(false);
		tblUsuario.getTableHeader().setBackground(new Color(40, 39, 61));
        tblUsuario.setSelectionBackground(new Color(241, 110, 79));
		tblUsuario.getTableHeader().setForeground(new Color(255, 255, 255));
		tblUsuario.setRowHeight(25);

		tblUsuario.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
		            
		         //   ((JComponent) c).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(245, 245, 245)));

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
		
		
		
		
		
		tblUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tblUsuario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tblUsuario.setIntercellSpacing(new Dimension(0, 0));
		tblUsuario.setShowGrid(false);
		tblUsuario.setShowHorizontalLines(true);
		tblUsuario.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
		tblUsuario.setShowVerticalLines(true);
		tblUsuario.setGridColor(new Color(200, 200, 200));
		
		
		
		
		tblUsuario.setDefaultEditor(Object.class, null);
		tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(70); // Nombre
		tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(100); // Correo
		tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblUsuario.getColumnModel().getColumn(4).setPreferredWidth(40);
		tblUsuario.getColumnModel().getColumn(5).setPreferredWidth(20);
		mostrarTabla();
	 // Crear un JScrollPane y agregar la JTable a él
		JScrollPane scrollPane = new JScrollPane(tblUsuario);
		scrollPane.setFocusable(false);
		scrollPane.setBounds(10, 11, 928, 560);
      //  scrollPane.setBorder(new LineBorder(new Color(241, 110, 79), 2));
		getContentPane().add(scrollPane);
	 
	 
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Usuario usuario = new Usuario();
		            String dniStr = txtDni.getText().trim();
		            
		            if (!dniStr.isEmpty() && dniStr.matches("\\d{1,8}")) {
		                usuario.setDni(Integer.parseInt(dniStr));

		                // Verificar si el DNI existe en la tabla empleados
		                boolean dniExisteEnEmpleados = usuariocontroller.verificarSiExisteDni(usuario.getDni());

		                if (dniExisteEnEmpleados) {
		                    // Continuar con la validación de nombre, clave, rol, etc.
		                    String nombre = txtNombre.getText().trim();
		                    if (!nombre.isEmpty() && !nombre.matches(".*\\d.*")) {
		                        usuario.setNombre(nombre);
		                    } else {
		                        throw new IllegalArgumentException("Nombre inválido. No debe contener números y debe estar lleno.");
		                    }

		                    String clave = txtClave.getText().trim();
		                    if (!clave.isEmpty()) {
		                        usuario.setClave(clave);
		                    } else {
		                        throw new IllegalArgumentException("Clave inválida. No debe estar vacía.");
		                    }

		                    String rolSeleccionado = (String) cboRol.getSelectedItem();
		                    int idRol = rolcontroller.ObtenerIdRolPorNombre(rolSeleccionado);
		                    if (idRol >= 0) {
		                        usuario.setId_rol(idRol);
		                    } else {
		                        throw new IllegalArgumentException("Rol no seleccionado");
		                    }

		                    // Obtener el valor del txtId (suponiendo que es un JTextField)
		                    String idStr = txtId.getText().trim();
		                    
		                    if (!idStr.isEmpty() && Integer.parseInt(idStr) > 0) {
		                        // Si txtId tiene un valor, asumimos que se desea editar
		                        usuario.setId(Integer.parseInt(idStr));
		                        
		                        // Llamar al método de editarUsuario en el controlador de usuarios
		                        usuariocontroller.editarUsuario(usuario);
		                        
		                        // Realizar otras operaciones necesarias para la edición

		                        // Actualizar la tabla y limpiar los campos
		                        mostrarTabla();
		                        limpiar();

		                        // Mostrar mensaje de éxito
		                        JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Usuario editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                    } else {
		                        // Si la verificación del DNI en empleados es exitosa, agregar el usuario
		                        usuariocontroller.agregarUsuario(usuario);

		                        // Realizar otras operaciones necesarias para la adición

		                        // Actualizar la tabla y limpiar los campos
		                        mostrarTabla();
		                        limpiar();

		                        // Mostrar mensaje de éxito
		                        JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Usuario agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                    }
		                } else {
		                    // Mostrar mensaje de error porque el DNI no existe en la tabla empleados
		                    JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Error: El DNI no está registrado como empleado.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } else {
		                throw new IllegalArgumentException("DNI inválido. Debe ser un número de hasta 8 dígitos.");
		            }

		        } catch (IllegalArgumentException ex) {
		            // Capturar excepciones relacionadas con validaciones
		            JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception e2) {
		            // Capturar otras excepciones no manejadas
		            e2.printStackTrace();
		        }
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
		            int dniUsuario = Integer.parseInt(txtBuscar.getText());
		            Usuario usuarioEncontrado = usuariocontroller.obtenerUsuarioPorDni(dniUsuario);

		            // Verificar si se encontró un usuario
		            if (usuarioEncontrado != null) {
		                String nombreRol = rolcontroller.obtenerNombreRolPorId(usuarioEncontrado.getId_rol());
		                		                
		                
		                // Establecer los valores en los campos
		                txtId.setText(String.valueOf(usuarioEncontrado.getId()));
		                txtDni.setText(String.valueOf(usuarioEncontrado.getDni()));
		                txtNombre.setText(usuarioEncontrado.getNombre());
		                txtClave.setText(usuarioEncontrado.getClave());

		                // Seleccionar el rol en el JComboBox
		                cboRol.setSelectedItem(nombreRol);
		            } else {
		                // Manejar la situación donde no se encuentra el usuario
		                JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Usuario no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		        } catch (NumberFormatException ex) {
		            // Capturar excepción si el formato del DNI no es válido
		            JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "DNI inválido", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
	        	 List<Reporte> listarReporte = reportecontroller.listarReporte();
	        	 ReporteExcel.reporte();

			}
		});
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				 
	        	 List<Reporte> listarReporte = reportecontroller.listarReporte();
	        	 Reporte.ReportesUsuario();

			}
		});
		
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int filaSeleccionada = tblUsuario.getSelectedRow();
				
				if(filaSeleccionada >= 0) {
					try {
						Object columnaId = tblUsuario.getValueAt(filaSeleccionada, 0);
						Object columnaEstado = tblUsuario.getValueAt(filaSeleccionada, 5);
						int idUsuario = Integer.parseInt(columnaId.toString());
						String estadoTexto = String.valueOf(columnaEstado);						
						
						int confirmacion = JOptionPane.showConfirmDialog(ifrm_GestionarUsuario.this, "¿Estás seguro de cambiar el estado a este Usuario?", "Confirmar Cambios", JOptionPane.YES_NO_OPTION);
						
						if(confirmacion == JOptionPane.YES_OPTION) {
							if(estadoTexto.equals("ACTIVO")) {
								usuariocontroller.cambiarEstadoInactivo(idUsuario);
								mostrarTabla();
							}
							else {
								usuariocontroller.cambiarEstadoEmpleadoaActivo(idUsuario);
								mostrarTabla();
							}
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Error de conversión: El valor no es un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(ifrm_GestionarUsuario.this, "Por favor, seleccione un Usuario para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}
			
		});
	}
	
	private void mostrarTabla() {
		modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
		List<Usuario> listarusuario = usuariocontroller.listarUsuario();
		
		 for (Usuario usuario : listarusuario) {	        
		        String nombreRol = rolcontroller.obtenerNombreRolPorId(usuario.getId_rol());
		        String estadoTexto = usuario.getEstado() ? "ACTIVO" : "INACTIVO";
		        
			 	Object[] fila = {
		        		
		        		usuario.getId(),
		        		usuario.getDni(),
		        		usuario.getNombre(),		        		
		        		usuario.getClave(),
		        		nombreRol,
		        		estadoTexto

		        };
		        modelo.addRow(fila);
		    }
	}
	
	private void limpiar() {
		txtId.setText("0");
		txtBuscar.setText("");
		txtDni.setText("");
		txtNombre.setText("");		
		txtClave.setText("");
		cboRol.setSelectedIndex(0);		
	}
	
	private void actualizarComboBoxRol() {
		List<Rol> listaRol = rolcontroller.listarRol();
		
		cboRol.removeAllItems();
		
		for(Rol rol : listaRol) {
			cboRol.addItem(rol.getDescripcion());
		}
	}
}
