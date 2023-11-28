package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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

import Controller.EmpleadoController;
import Controller.CargoController;
import Model.Reporte;
import Model.ReporteExcel;
import Controller.ReporteController;
import Model.Empleado;
import Model.Usuario;
import Model.Cargo;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ifrm_GestionarEmpleado extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private EmpleadoController empleadocontroller;
	private CargoController cargocontroller;
	DefaultTableModel modelo;
	private JTable tblEmpleado;
	private JTextField txtId;
	private JTextField txtBuscar;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JComboBox cboCargo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_GestionarEmpleado frame = new ifrm_GestionarEmpleado();
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
	public ifrm_GestionarEmpleado() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		reportecontroller = new ReporteController();
		empleadocontroller = new EmpleadoController();
		cargocontroller = new CargoController();
		
		JPanel panel = new JPanel();
		panel.setBounds(974, 11, 280, 535);
		panel.setBackground(new Color(245,245,245));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INGRESO DE DATOS ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 22, 260, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por DNI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(30, 90, 105, 20);
		panel.add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBuscar.setBounds(133, 90, 86, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(204, 226, 178));
		btnBuscar.setBounds(229, 90, 37, 23);
		btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/lupaicono.png")));
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 140, 77, 28);
		panel.add(lblNewLabel_2);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDni.setBounds(105, 140, 160, 29);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(10, 180, 77, 28);
		panel.add(lblNewLabel_2_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(105, 180, 160, 28);
		panel.add(txtNombre);
		
		JLabel lblNewLabel_2_2 = new JLabel("CORREO:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(10, 220, 77, 28);
		panel.add(lblNewLabel_2_2);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(105, 220, 160, 28);
		panel.add(txtCorreo);
		
		JLabel lblNewLabel_2_3 = new JLabel("DIRECCION:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(10, 260, 95, 28);
		panel.add(lblNewLabel_2_3);
		
		txtDireccion= new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(105, 260, 160, 28);
		panel.add(txtDireccion);
		
		
		
		JLabel lblNewLabel_2_4 = new JLabel("CARGO");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(10, 300, 77, 28);
		panel.add(lblNewLabel_2_4);
		
		cboCargo = new JComboBox();
		cboCargo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cboCargo.setBounds(105, 300, 160, 29);
		actualizarComboBoxCargo();
		panel.add(cboCargo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setForeground(new Color(255, 255, 255));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificar.setBounds(30, 360, 219, 29);
		btnModificar.setIcon(null);
		btnModificar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		btnModificar.setBackground(new Color(78, 156, 54));
		panel.add(btnModificar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(30, 400, 219, 29);
		btnLimpiar.setIcon(null);
		btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		btnLimpiar.setBackground(new Color(252, 187, 33));
		panel.add(btnLimpiar);
		
		JButton btnCambiarEstado = new JButton("Cambar Estado");
		btnCambiarEstado.setForeground(new Color(255, 255, 255));
		btnCambiarEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCambiarEstado.setBounds(30, 440, 219, 29);
		btnCambiarEstado.setIcon(null);
		btnCambiarEstado.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/estadoicono.png")));
		btnCambiarEstado.setBackground(new Color(144, 8, 9));
		panel.add(btnCambiarEstado);
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setForeground(new Color(255, 255, 255));
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcel.setBounds(30, 480, 103, 29);
		btnExcel.setIcon(null);
		btnExcel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/excelicono.png")));
		btnExcel.setBackground(new Color(33, 114, 69));
		panel.add(btnExcel);
		
		JButton btnPDF = new JButton("PDF");
		btnPDF.setForeground(new Color(255, 255, 255));
		btnPDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPDF.setBounds(146, 480, 103, 29);
		btnPDF.setIcon(null);
		btnPDF.setBackground(new Color(173, 8, 8));
		btnPDF.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/pdficono.png")));
		panel.add(btnPDF);
		
		txtId = new JTextField();
		txtId.setText("0");
		txtId.setVisible(false);
		txtId.setBounds(239, 116, 27, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
	
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		

		modelo = new DefaultTableModel(
	            new Object[][] {},
	            new String[] {
	                "ID", "DNI", "Nombre", "Correo", "Dirección", "Cargo", "Estado"
	            }
	        );
		tblEmpleado = new JTable(modelo);
		tblEmpleado.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tblEmpleado.getTableHeader().setOpaque(false);
		tblEmpleado.getTableHeader().setBackground(new Color(40, 39, 61));
		tblEmpleado.setSelectionBackground(new Color(241, 110, 79));
		tblEmpleado.getTableHeader().setForeground(new Color(255, 255, 255));
		tblEmpleado.setRowHeight(25);
		tblEmpleado.getColumnModel().getColumn(0).setPreferredWidth(20); // ID
		tblEmpleado.getColumnModel().getColumn(1).setPreferredWidth(70); // Nombre
		tblEmpleado.getColumnModel().getColumn(2).setPreferredWidth(100); // Correo
		tblEmpleado.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblEmpleado.getColumnModel().getColumn(4).setPreferredWidth(40);
		tblEmpleado.getColumnModel().getColumn(5).setPreferredWidth(20);
		tblEmpleado.getColumnModel().getColumn(6).setPreferredWidth(20);
		

tblEmpleado.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

	tblEmpleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	tblEmpleado.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	tblEmpleado.setIntercellSpacing(new Dimension(0, 0));
	tblEmpleado.setShowGrid(false);
	tblEmpleado.setShowHorizontalLines(true);
	tblEmpleado.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
	tblEmpleado.setShowVerticalLines(true);
	tblEmpleado.setGridColor(new Color(200, 200, 200));
		
		mostrarTabla();
		
		JScrollPane scrollPane = new JScrollPane(tblEmpleado);
		scrollPane.setBounds(10, 11, 928, 535);
		getContentPane().add(scrollPane);

		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});		
		
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            	Empleado empleado = new Empleado();
		            String dniStr = txtDni.getText().trim();
		            
		            if (!dniStr.isEmpty() && dniStr.matches("\\d{1,8}")) {
		            	empleado.setDni(Integer.parseInt(dniStr));

		                 
		                    // Continuar con la validación de nombre, clave, rol, etc.
		                    String nombre = txtNombre.getText().trim();
		                    if (!nombre.isEmpty()) {
		                        empleado.setNombres(nombre);
		                    } else {
		                        throw new IllegalArgumentException("El campo no debe estar vacío.");
		                    }

		                    String correo = txtCorreo.getText().trim();
		                    if (!correo.isEmpty()) {
		                        empleado.setCorreo(correo);
		                    } else {
		                        throw new IllegalArgumentException("El campo no debe estar vacío.");
		                    }
		                    
		                    String direccion = txtDireccion.getText().trim();
		                    if (!direccion.isEmpty()) {
		                        empleado.setDireccion(direccion);
		                    } else {
		                        throw new IllegalArgumentException("El campo no debe estar vacío.");
		                    }

		                    String rolSeleccionado = (String) cboCargo.getSelectedItem();
		                    int idCargo = cargocontroller.ObtenerIdCargoPorNombre(rolSeleccionado);
		                    if (idCargo >= 0) {
		                        empleado.setId_cargo(idCargo);
		                    } else {
		                        throw new IllegalArgumentException("Cargo no seleccionado");
		                    }

		                    // Obtener el valor del txtId (suponiendo que es un JTextField)
		                    String idStr = txtId.getText().trim();
		                    

		                    if (!idStr.isEmpty() && Integer.parseInt(idStr) > 0) {
		                    	
		                    	empleado.setId(Integer.parseInt(idStr));
		                        
		                    	empleadocontroller.modificarEmpleado(empleado);
		                    	mostrarTabla();
		                        limpiar();
		                        
		                        // Mostrar mensaje de éxito
		                        JOptionPane.showMessageDialog(ifrm_GestionarEmpleado.this, "Empleado editado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		                    } 
		                } 
		            else {
		                throw new IllegalArgumentException("DNI inválido. Debe ser un número de hasta 8 dígitos.");
		            }

		        } catch (IllegalArgumentException ex) {
		            // Capturar excepciones relacionadas con validaciones
		            JOptionPane.showMessageDialog(ifrm_GestionarEmpleado.this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        } catch (Exception e2) {
		            // Capturar otras excepciones no manejadas
		            e2.printStackTrace();
		        }
			}
		});
		
		btnCambiarEstado.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        int filaSeleccionada = tblEmpleado.getSelectedRow();

		        if (filaSeleccionada >= 0) {
		            try {
		                Object columnaId = tblEmpleado.getValueAt(filaSeleccionada, 0);
		                Object columnaEstado = tblEmpleado.getValueAt(filaSeleccionada, 6);
		                int idEmpleado = Integer.parseInt(columnaId.toString());
		                String Estadotext = String.valueOf(columnaEstado);

		                System.out.println("ID de empleado seleccionado: " + idEmpleado);
		                System.out.println("Estado actual: " + Estadotext);

		                int confirmacion = JOptionPane.showConfirmDialog(
		                        ifrm_GestionarEmpleado.this,
		                        "¿Estás seguro de cambiar el Estado?",
		                        "Confirmar Cambio",
		                        JOptionPane.YES_NO_OPTION
		                );

		                if (confirmacion == JOptionPane.YES_OPTION) {
		                    System.out.println("Confirmación para cambiar el estado recibida.");

		                    if (Estadotext.equals("ACTIVO")) {
		                        System.out.println("Cambiando estado a INACTIVO...");
		                        empleadocontroller.cambiarEstadoEmpleadoaInactivo(idEmpleado);
		                        mostrarTabla();
		                        System.out.println("Estado cambiado a INACTIVO.");
		                    } else {
		                        System.out.println("Cambiando estado a ACTIVO...");
		                        empleadocontroller.cambiarEstadoEmpleadoaActivo(idEmpleado);
		                        mostrarTabla();
		                        System.out.println("Estado cambiado a ACTIVO.");
		                    }
		                }
		            } catch (Exception e) {
		                JOptionPane.showMessageDialog(
		                        ifrm_GestionarEmpleado.this,
		                        "Error de conversión: El valor no es un número entero válido.",
		                        "Error",
		                        JOptionPane.ERROR_MESSAGE
		                );
		                e.printStackTrace(); // Imprime la traza de la excepción
		            }
		        } else {
		            JOptionPane.showMessageDialog(
		                    ifrm_GestionarEmpleado.this,
		                    "Por favor, seleccione un Empleado para cambiar Estado",
		                    "Advertencia",
		                    JOptionPane.WARNING_MESSAGE
		            );
		        }
		    }
		});
		
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReporteController controller = new ReporteController();
	        	 List<Reporte> listarReporte = controller.listarReporte();
	        	 ReporteExcel.reporteempleado();

			}
		});
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReporteController controller = new ReporteController();
	        	 List<Reporte> listarReporte = controller.listarReporte();
	        	 Reporte.ReporteEmpleado();

			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
		            int dniEmpleado = Integer.parseInt(txtBuscar.getText());
		            Empleado  empleadoEncontrado = empleadocontroller.buscarEmpleadoPorDni(dniEmpleado);

		            // Verificar si se encontró un usuario
		            if (empleadoEncontrado != null) {
		                String nombreCargo = cargocontroller.obtenerNombreCargoPorId(empleadoEncontrado.getId_cargo());

		                // Establecer los valores en los campos
		                txtId.setText(String.valueOf(empleadoEncontrado.getId()));
		                txtDni.setText(String.valueOf(empleadoEncontrado.getDni()));
		                txtNombre.setText(empleadoEncontrado.getNombres());
		                txtCorreo.setText(empleadoEncontrado.getCorreo());
		                txtDireccion.setText(empleadoEncontrado.getDireccion());
		                
		                // Seleccionar el rol en el JComboBox
		                cboCargo.setSelectedItem(nombreCargo);
		            } else {
		                // Manejar la situación donde no se encuentra el usuario
		                JOptionPane.showMessageDialog(ifrm_GestionarEmpleado.this, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		        } catch (NumberFormatException ex) {
		            // Capturar excepción si el formato del DNI no es válido
		            JOptionPane.showMessageDialog(ifrm_GestionarEmpleado.this, "DNI inválido", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
	}
	public void limpiar() {
		txtId.setText("0");
		txtBuscar.setText("");
		txtDni.setText("");
		txtNombre.setText("");		
		txtCorreo.setText("");
		txtDireccion.setText("");
		cboCargo.setSelectedIndex(0);	
	}

	private void mostrarTabla() {
		modelo.setRowCount(0); // Limpiar la tabla antes de agregar datos
		List<Empleado> listarempleado = empleadocontroller.listarEmpleados();
		
		 for (Empleado empleado : listarempleado) {	        
		        String nombreCargo = cargocontroller.obtenerNombreCargoPorId(empleado.getId_cargo());
		        String estadoTexto = empleado.getEstado() ? "ACTIVO" : "INACTIVO";
			 	Object[] fila = {
		        		
		        		empleado.getId(),
		        		empleado.getDni(),
		        		empleado.getNombres(),		        		
		        		empleado.getCorreo(),
		        		empleado.getDireccion(),
		        		nombreCargo,
		        		estadoTexto

		        };
		        modelo.addRow(fila);
		    }
	}

	private void actualizarComboBoxCargo() {
		List<Cargo> listaCargo = cargocontroller.listarCargo();
		
		cboCargo.removeAllItems();
		
		for(Cargo cargo : listaCargo) {
			cboCargo.addItem(cargo.getDescripcion());
		}
	}
}
