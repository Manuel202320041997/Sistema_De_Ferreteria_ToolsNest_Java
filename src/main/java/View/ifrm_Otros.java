package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controller.CategoriaController;
import Controller.MarcaController;
import Controller.SubCategoriaController;
import Controller.TransportistaController;
import Model.Categoria;
import Model.Marca;
import Model.SubCategoria;
import Model.Transportista;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ifrm_Otros extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private CategoriaController categoriacontroller;
	private SubCategoriaController subcategoriacontroller;
	private MarcaController marcacontroller;
	private TransportistaController transportistacontroller;
	private JTextField txtDniTransportista;
	private JTextField txtNombreTransportista;
	private JTextField txtBreveteTransportista;
	private JTextField txtPlacaTransportista;
	private JTextField txtModeloTransportista;
	private JTextField txtSubCategoria;
	private JTextField txtCategoria;
	private JTextField txtMarca;
	private JComboBox cboCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ifrm_Otros frame = new ifrm_Otros();
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
	public ifrm_Otros() {
		setBounds(0, 0, 1280, 589);
		setClosable(true); //cerrar frame
		setIconifiable(false); // minimizar frame
		setMaximizable(false);
		setResizable(false);
		getContentPane().setBackground(new Color(51, 52, 78));
		getContentPane().setLayout(null);
		
		categoriacontroller = new CategoriaController();
		subcategoriacontroller = new SubCategoriaController();
		marcacontroller = new MarcaController();
		transportistacontroller = new TransportistaController();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(395, 150, 515, 289);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Transportista", null, panel, null);
		panel.setLayout(null);
		
		txtDniTransportista = new JTextField();
		txtDniTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDniTransportista.setBounds(105, 30, 135, 27);
		panel.add(txtDniTransportista);
		txtDniTransportista.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 35, 46, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNombres = new JLabel("NOMBRES:");
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombres.setBounds(26, 73, 72, 27);
		panel.add(lblNombres);
		
		txtNombreTransportista = new JTextField();
		txtNombreTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombreTransportista.setColumns(10);
		txtNombreTransportista.setBounds(105, 70, 135, 27);
		panel.add(txtNombreTransportista);
		
		JLabel lblBrevete = new JLabel("BREVETE:");
		lblBrevete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBrevete.setBounds(26, 110, 72, 27);
		panel.add(lblBrevete);
		
		txtBreveteTransportista = new JTextField();
		txtBreveteTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBreveteTransportista.setColumns(10);
		txtBreveteTransportista.setBounds(105, 110, 135, 27);
		panel.add(txtBreveteTransportista);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DEL CONDUCTOR:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1.setBounds(10, 11, 252, 138);
		panel.add(lblNewLabel_3_1_1);
		
		txtPlacaTransportista = new JTextField();
		txtPlacaTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPlacaTransportista.setColumns(10);
		txtPlacaTransportista.setBounds(107, 216, 135, 27);
		panel.add(txtPlacaTransportista);
		
		JLabel lblPlaca = new JLabel("PLACA:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlaca.setBounds(28, 216, 72, 27);
		panel.add(lblPlaca);
		
		JLabel lblModelo = new JLabel("MODELO:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(28, 179, 72, 27);
		panel.add(lblModelo);
		
		txtModeloTransportista = new JTextField();
		txtModeloTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtModeloTransportista.setColumns(10);
		txtModeloTransportista.setBounds(107, 176, 135, 27);
		panel.add(txtModeloTransportista);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DEL VEHICULO:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1_1.setBounds(10, 160, 252, 97);
		panel.add(lblNewLabel_3_1_1_1);
		
		JButton btnAgregarTransportista = new JButton("Agregar");
		btnAgregarTransportista.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregarTransportista.setForeground(new Color(245, 245, 245));
		btnAgregarTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarTransportista.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/agregaricono.png")));
		btnAgregarTransportista.setBackground(new Color(78, 156, 54));
		btnAgregarTransportista.setBounds(272, 110, 228, 37);
		panel.add(btnAgregarTransportista);
		
		JButton btnLimpiarTransportista = new JButton("Limpiar");
		btnLimpiarTransportista.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLimpiarTransportista.setForeground(new Color(245, 245, 245));		
		btnLimpiarTransportista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarTransportista.setBackground(new Color(252, 187, 33));
		btnLimpiarTransportista.setBounds(272, 153, 228, 37);
		panel.add(btnLimpiarTransportista);
		
		JLabel lblNewLabel_1 = new JLabel("Registro Transportista");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(272, 11, 228, 37);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Sub Categoria", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblSubCategoria = new JLabel("Sub Categoria:");
		lblSubCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubCategoria.setBounds(127, 83, 98, 27);
		panel_1.add(lblSubCategoria);
		
		txtSubCategoria = new JTextField();
		txtSubCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSubCategoria.setColumns(10);
		txtSubCategoria.setBounds(235, 85, 135, 27);
		panel_1.add(txtSubCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria.setBounds(127, 121, 72, 27);
		panel_1.add(lblCategoria);
		
		cboCategoria = new JComboBox();
		cboCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboCategoria.setBounds(235, 123, 135, 27);
		actualizarComboBoxCategoria();
		panel_1.add(cboCategoria);
		
		JLabel lblNewLabel_1_1 = new JLabel("Registro Sub Categoria");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(10, 11, 490, 37);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("");
		lblNewLabel_3_1_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DE LA SUBCATEGORIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1_2.setBounds(111, 59, 276, 104);
		panel_1.add(lblNewLabel_3_1_1_2);
		
		JButton btnAgregarSubCategoria = new JButton("Agregar");
		btnAgregarSubCategoria.setForeground(new Color(245, 245, 245));
		btnAgregarSubCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarSubCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregarSubCategoria.setBackground(new Color(78, 156, 54));
		btnAgregarSubCategoria.setBounds(135, 178, 228, 29);
		panel_1.add(btnAgregarSubCategoria);
		
		JButton btnLimpiarSubCategoria = new JButton("Limpiar");
		btnLimpiarSubCategoria.setForeground(new Color(245, 245, 245));
		btnLimpiarSubCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarSubCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLimpiarSubCategoria.setBackground(new Color(252, 187, 33));
		btnLimpiarSubCategoria.setBounds(135, 221, 228, 29);
		panel_1.add(btnLimpiarSubCategoria);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Categoria", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Registro Categoria");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1_1.setBounds(10, 11, 490, 37);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblCategoria_1 = new JLabel("Categoria:");
		lblCategoria_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria_1.setBounds(126, 100, 98, 27);
		panel_2.add(lblCategoria_1);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(234, 102, 135, 27);
		panel_2.add(txtCategoria);
		
		JButton btnAgregarCategoria = new JButton("Agregar");
		btnAgregarCategoria.setForeground(new Color(245, 245, 245));
		btnAgregarCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregarCategoria.setBackground(new Color(78, 156, 54));
		btnAgregarCategoria.setBounds(135, 178, 228, 29);
		panel_2.add(btnAgregarCategoria);
		
		JButton btnLimpiarCategoria = new JButton("Limpiar");
		btnLimpiarCategoria.setForeground(new Color(245, 245, 245));
		btnLimpiarCategoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarCategoria.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLimpiarCategoria.setBackground(new Color(252, 187, 33));
		btnLimpiarCategoria.setBounds(135, 221, 228, 29);
		panel_2.add(btnLimpiarCategoria);
		
		JLabel lblNewLabel_3_1_1_2_1 = new JLabel("");
		lblNewLabel_3_1_1_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DE LA CATEGORIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1_2_1.setBounds(110, 76, 276, 73);
		panel_2.add(lblNewLabel_3_1_1_2_1);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Marca", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Registro Marca");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1_1_1.setBounds(10, 11, 490, 37);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		JLabel lblCategoria_1_1 = new JLabel("Marca:");
		lblCategoria_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCategoria_1_1.setBounds(126, 100, 98, 27);
		panel_3.add(lblCategoria_1_1);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMarca.setColumns(10);
		txtMarca.setBounds(234, 102, 135, 27);
		panel_3.add(txtMarca);
		
		JButton btnAgregarMarca = new JButton("Agregar");
		btnAgregarMarca.setForeground(new Color(245, 245, 245));
		btnAgregarMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAgregarMarca.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnAgregarMarca.setBackground(new Color(78, 156, 54));
		btnAgregarMarca.setBounds(135, 178, 228, 29);
		panel_3.add(btnAgregarMarca);
		
		JButton btnLimpiarMarca = new JButton("Limpiar");
		btnLimpiarMarca.setForeground(new Color(245, 245, 245));
		btnLimpiarMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpiarMarca.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLimpiarMarca.setBackground(new Color(252, 187, 33));
		btnLimpiarMarca.setBounds(135, 221, 228, 29);
		panel_3.add(btnLimpiarMarca);
		
		JLabel lblNewLabel_3_1_1_2_1_1 = new JLabel("");
		lblNewLabel_3_1_1_2_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(160, 160, 160)), "DATOS DE LA CATEGORIA:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblNewLabel_3_1_1_2_1_1.setBounds(110, 76, 276, 73);
		panel_3.add(lblNewLabel_3_1_1_2_1_1);
		
		((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
		
		btnAgregarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreCategoria = txtCategoria.getText();
				if(!nombreCategoria.isEmpty()) {
					Categoria categoria = new Categoria();
					categoria.setDescripcion(nombreCategoria);
					categoriacontroller.registrarCategoria(categoria);
					JOptionPane.showMessageDialog(ifrm_Otros.this, "La Categoria ha sido registrada exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(ifrm_Otros.this, "El campo Categoria no debe estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnAgregarSubCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nombreSubCategoria = txtSubCategoria.getText();
				if(!nombreSubCategoria.isEmpty()) {
					String nombreCategoria = (String) cboCategoria.getSelectedItem();
					int idCategoria = categoriacontroller.obtenerIdCategoriaPorNombre(nombreCategoria);
					
					SubCategoria subcategoria = new SubCategoria();
					subcategoria.setDescripcion(nombreSubCategoria);
					subcategoria.setId_categoria(idCategoria);
					subcategoriacontroller.registrarSubCategoria(subcategoria);
					JOptionPane.showMessageDialog(ifrm_Otros.this, "La Sub Categoria ha sido registrada exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(ifrm_Otros.this, "El campo Sub Categoria no debe estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnAgregarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String marcanombre = txtMarca.getText();
				if(!marcanombre.isEmpty()) {
					Marca marca = new Marca();
					marca.setDescripcion(marcanombre);
					marcacontroller.registrarMarca(marca);
					JOptionPane.showMessageDialog(ifrm_Otros.this, "La Marca ha sido registrada exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(ifrm_Otros.this, "El campo Marca no debe estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnAgregarTransportista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dniTransportista = Integer.parseInt(txtDniTransportista.getText());
				String nombreTransportista = txtNombreTransportista.getText();
				String modeloVehiculo = txtModeloTransportista.getText();
				String placaVehiculo = txtPlacaTransportista.getText();
				String brevete = txtBreveteTransportista.getText();
				
				if(dniTransportista != 0 || !nombreTransportista.isEmpty() || modeloVehiculo.isEmpty() || placaVehiculo.isEmpty() || brevete.isEmpty()) {
					Transportista transportista = new Transportista();
					transportista.setDni(dniTransportista);
					transportista.setNombres(nombreTransportista);
					transportista.setModelo_vehiculo(modeloVehiculo);
					transportista.setPlaca_vehiculo(placaVehiculo);
					transportista.setBrevete(brevete);
					
					transportistacontroller.registrarTransportista(transportista);
					JOptionPane.showMessageDialog(ifrm_Otros.this, "El Transportista ha sido registrada exitosamente", "Exito", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(ifrm_Otros.this, "Ningún campo debe estar vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

	}
	private void actualizarComboBoxCategoria() {
		List<Categoria> listaCategoria = categoriacontroller.listarCategoria();
		cboCategoria.removeAllItems();
		
		for(Categoria categoria : listaCategoria) {
			cboCategoria.addItem(categoria.getDescripcion());
		}
 
	}
	
}
