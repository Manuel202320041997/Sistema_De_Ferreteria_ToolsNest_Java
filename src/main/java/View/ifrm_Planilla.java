package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Controller.CargoController;
import Controller.ContratoController;
import Controller.EmpleadoController;
import Model.Reporte;
import Model.ReporteExcel;
import Controller.ReporteController;
import Model.Cargo;
import Model.Contrato;
import Model.Empleado;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class ifrm_Planilla extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ReporteController reportecontroller;
	private ContratoController contratocontroller;
	private EmpleadoController empleadocontroller;
	private CargoController cargocontroller;
	DefaultTableModel modelo;
	private JTable tblContrato;
	private JTextField txtId;
	private JTextField txtBuscar;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtDireccion;
	private JComboBox cboCargo;
	private JTextField txtSueldo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_Planilla frame = new ifrm_Planilla();
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
	public ifrm_Planilla() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		reportecontroller = new ReporteController();
		contratocontroller = new ContratoController();
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
		lblNewLabel.setBounds(10, 8, 260, 45);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por DNI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(30, 60, 105, 20);
		panel.add(lblNewLabel_1);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtBuscar.setBounds(133, 60, 86, 20);
		panel.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setBackground(new Color(204, 226, 178));
		btnBuscar.setBounds(229, 60, 37, 23);
		btnBuscar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/lupaicono.png")));
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_2 = new JLabel("DNI:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(30, 125, 30, 28);
		panel.add(lblNewLabel_2);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDni.setBounds(100, 125, 140, 24);
		panel.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOMBRE:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(30, 160, 55, 28);
		panel.add(lblNewLabel_2_1);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 160, 140, 24);
		panel.add(txtNombre);
		
		JLabel lblNewLabel_2_2 = new JLabel("CORREO:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_2.setBounds(30, 195, 50, 28);
		panel.add(lblNewLabel_2_2);
		
		txtCorreo = new JTextField();
		txtCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(100, 195, 140, 24);
		panel.add(txtCorreo);
		
		JLabel lblNewLabel_2_3 = new JLabel("DIRECCION:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(30, 230, 70, 28);
		panel.add(lblNewLabel_2_3);
		
		txtDireccion= new JTextField();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(100, 230, 140, 24);
		panel.add(txtDireccion);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_3.setBounds(30, 230, 70, 28);
		panel.add(lblNewLabel_2_3);
		
		
		JLabel lblNewLabel_2_5 = new JLabel("CARGO");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_5.setBounds(30, 265, 50, 28);
		panel.add(lblNewLabel_2_5);
		
		cboCargo = new JComboBox();
		cboCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCargo.setBounds(100, 265, 140, 24);
		panel.add(cboCargo);
		actualizarComboBoxCargo();
		
		JLabel lblNewLabel_2_6 = new JLabel("SUELDO:");
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_6.setBounds(30, 333, 50, 30);
		panel.add(lblNewLabel_2_6);
		
		txtSueldo = new JTextField();
		txtSueldo.setBounds(100, 333, 140, 24);
		txtSueldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSueldo.setColumns(10);
		panel.add(txtSueldo);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "Informacion de Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1.setBounds(15, 105, 250, 200);
		panel.add(lblNewLabel_3_1);
		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "Planilla", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1.setBounds(15, 310, 250, 67);
		panel.add(lblNewLabel_3_1_1);
		
		
		JButton btnAgregar = new JButton("Agregar ");
		btnAgregar.setForeground(new Color(255, 255, 255));
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregar.setBounds(30, 399, 220, 30);
		btnAgregar.setIcon(null);
		btnAgregar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		btnAgregar.setBackground(new Color(78, 156, 54));
		panel.add(btnAgregar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setForeground(new Color(255, 255, 255));
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiar.setBounds(30, 440, 220, 30);
		btnLimpiar.setIcon(null);
		btnLimpiar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/limpiaricono.png")));
		btnLimpiar.setBackground(new Color(252, 187, 33));
		panel.add(btnLimpiar);
		
		
		JButton btnExcel = new JButton("Excel");
		btnExcel.setForeground(new Color(255, 255, 255));
		btnExcel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcel.setBounds(30, 480, 105, 30);
		btnExcel.setIcon(null);
		btnExcel.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/excelicono.png")));
		btnExcel.setBackground(new Color(33, 114, 69));
		panel.add(btnExcel);
		
		JButton btnPDF = new JButton("PDF");
		btnPDF.setForeground(new Color(255, 255, 255));
		btnPDF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPDF.setBounds(145, 480, 105, 30);
		btnPDF.setIcon(null);
		btnPDF.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/pdficono.png")));
		btnPDF.setBackground(new Color(173, 8, 8));
		panel.add(btnPDF);
		
		txtId = new JTextField();
		txtId.setText("0");
		txtId.setVisible(false);
		txtId.setBounds(239, 86, 27, 20);
		panel.add(txtId);
		txtId.setColumns(10);

		modelo = new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			        "DNI", "Empleado", "Sueldo Mensual", "Gratificacion", "CTS", "Fecha de Registro"
			    }
			);
			tblContrato = new JTable(modelo);
			tblContrato.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
			tblContrato.getTableHeader().setOpaque(false);
			tblContrato.getTableHeader().setBackground(new Color(40, 39, 61));
			tblContrato.setSelectionBackground(new Color(241, 110, 79));
			tblContrato.getTableHeader().setForeground(new Color(255, 255, 255));
			tblContrato.setRowHeight(25);
			tblContrato.getColumnModel().getColumn(0).setPreferredWidth(50); // DNI
			tblContrato.getColumnModel().getColumn(0).setPreferredWidth(100); // DNI
			tblContrato.getColumnModel().getColumn(1).setPreferredWidth(20); // Sueldo Mensual
			tblContrato.getColumnModel().getColumn(2).setPreferredWidth(20); // Gratificacion
			tblContrato.getColumnModel().getColumn(3).setPreferredWidth(20); // cts
			tblContrato.getColumnModel().getColumn(4).setPreferredWidth(70); // Fecha Registro
			
			tblContrato.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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

			tblContrato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			tblContrato.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tblContrato.setIntercellSpacing(new Dimension(0, 0));
			tblContrato.setShowGrid(false);
			tblContrato.setShowHorizontalLines(true);
			tblContrato.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150)));
			tblContrato.setShowVerticalLines(true);
			tblContrato.setGridColor(new Color(200, 200, 200));

			mostrarTablaContrato();

		
		JScrollPane scrollPane = new JScrollPane(tblContrato);
		scrollPane.setBounds(10, 8, 928, 535);
		getContentPane().add(scrollPane);
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiar();
			}
		});
		
		btnAgregar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		        	int id = Integer.parseInt(txtId.getText());
		        	if(id <= 0) {
		        		agregarEmpleado();
		        	}
		        	else {
		        		editarSueldo();
		        	}
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		btnExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReporteController controller = new ReporteController();
	        	 List<Reporte> listarReporte = controller.listarReporte();
	        	 ReporteExcel.ReportePlanilla();

			}
		});
		
		btnPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ReporteController controller = new ReporteController();
	        	 List<Reporte> listarReporte = controller.listarReporte();
	        	 Reporte.ReportePLanilla();

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
		                cboCargo.setSelectedItem(nombreCargo);
		                
		                txtDni.setEditable(false);
		                txtNombre.setEditable(false);
		                txtCorreo.setEditable(false);
		                txtDireccion.setEditable(false);
		                //cboCargo.setEditable(false);
		                Contrato contrato = contratocontroller.obtenerContratoPorIdEmpleado(empleadoEncontrado.getId());
		                txtSueldo.setText(String.valueOf(contrato.getSueldo_mensual()));

		            } else {
		                // Manejar la situación donde no se encuentra el usuario
		                JOptionPane.showMessageDialog(ifrm_Planilla.this, "Empleado no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		            }

		        } catch (NumberFormatException ex) {
		            // Capturar excepción si el formato del DNI no es válido
		            JOptionPane.showMessageDialog(ifrm_Planilla.this, "DNI inválido", "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
	}
	

	protected void limpiar() {
		txtId.setText("0");
		txtBuscar.setText("");
		txtDni.setText("");
		txtNombre.setText("");		
		txtCorreo.setText("");
		txtDireccion.setText("");
		cboCargo.setSelectedIndex(0);
		txtSueldo.setText("");
		txtDni.setEditable(true);
        txtNombre.setEditable(true);
        txtCorreo.setEditable(true);
        txtDireccion.setEditable(true);
        //cboCargo.setEditable(true);
	}
	
	private void agregarEmpleado() {
		int dniEmpleado = Integer.parseInt(txtDni.getText());
		String nombreEmpleado = txtNombre.getText();
		String correo = txtCorreo.getText();
		String direccion = txtDireccion.getText();
		String cargo = (String) cboCargo.getSelectedItem();		
		int idCargo = cargocontroller.ObtenerIdCargoPorNombre(cargo);
		Double sueldoMensual = Double.parseDouble(txtSueldo.getText());
		
		Empleado empleado = new Empleado();
		empleado.setDni(dniEmpleado);
		empleado.setNombres(nombreEmpleado);
		empleado.setCorreo(correo);
		empleado.setDireccion(direccion);
		empleado.setId_cargo(idCargo);
		
		int idEmpleado = empleadocontroller.agregarEmpleado(empleado);
		
		Contrato contrato = new Contrato();
		
		contrato.setId_empleado(idEmpleado);
		contrato.setSueldo_mensual(sueldoMensual);
		
		contratocontroller.agregarPlanilla(contrato);
	    mostrarTablaContrato(); 
		JOptionPane.showMessageDialog(ifrm_Planilla.this, "Empleado Agregado con Éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	private void editarSueldo() {
		int idEmpleado = Integer.parseInt(txtId.getText());
		Double sueldoCambiar = Double.parseDouble(txtSueldo.getText());
		
		Contrato contrato = new Contrato();
		contrato.setId_empleado(idEmpleado);
		contrato.setSueldo_mensual(sueldoCambiar);
		contratocontroller.actualizarSueldo(contrato);
		
		mostrarTablaContrato();
		
		JOptionPane.showMessageDialog(ifrm_Planilla.this, "Sueldo Actualizado con Éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostrarTablaContrato() {
		modelo.setRowCount(0);
		
		try {
			List<Contrato> listaContrato = contratocontroller.listarContrato();
			
			for(Contrato contrato : listaContrato) {
				Empleado empleado = empleadocontroller.obtenerEmpleadoPorId(contrato.getId_empleado());
				Object[] fila = {
						empleado.getDni(),
						empleado.getNombres(),
						contrato.getSueldo_mensual(),
						contrato.getGratificacion(),
						contrato.getCts(),
						contrato.getFecha_registro()
				};
				modelo.addRow(fila);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
