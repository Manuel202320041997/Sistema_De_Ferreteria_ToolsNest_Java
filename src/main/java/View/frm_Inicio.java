package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.EmpresaController;

import java.awt.Color;

import Model.Empresa;
import Model.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JDesktopPane;

public class frm_Inicio extends JFrame {
	private EmpresaController empresacontroller;
	private JLabel lblLogoInicio;
	private Usuario usuarioValidado;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JDesktopPane desktopPanePrincipal;
	private int x;
	private int y;
	private JMenu menuUsuario;
	private JMenu menuCompras;
	private JMenu menuVentas;
	private JMenu menuAlmacen;
	private JMenu menuRRHH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	            	Usuario usuarioValido = new Usuario(/* parámetros necesarios */);

	                frm_Inicio frame = new frm_Inicio(usuarioValido);
	                System.out.println("Valor de idrolUsuario antes de llamar a configurarPorRolUsuario: " + usuarioValido.getId_rol());
	                //frame.configurarPorRolUsuario(usuarioValido.getId_rol());
	                System.out.println("Después de llamar a configurarPorRolUsuario");
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
	public frm_Inicio(Usuario usuarioValidado) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setResizable(false);
        setUndecorated(true);
		contentPane = new JPanel();		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		empresacontroller = new EmpresaController();
		
		this.usuarioValidado = usuarioValidado;
		String nombreUsuario = usuarioValidado.getNombre();		
		int idRolUsuario = usuarioValidado.getId_rol();		
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBackground(new Color(40, 39, 61));
		panelTitulo.setBounds(0, 0, 1302, 28);
		contentPane.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JButton btnMinimizar = new JButton("");
		btnMinimizar.setFocusable(false);
		btnMinimizar.setFocusTraversalKeysEnabled(false);
		btnMinimizar.setFocusPainted(false);
		btnMinimizar.setBorder(null);
		btnMinimizar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/borrar1.2.png")));
		btnMinimizar.setBackground(new Color(40, 39, 61));
		btnMinimizar.setBounds(29, 0, 32, 28);
		panelTitulo.add(btnMinimizar);
		
		JButton btnCerrar = new JButton("");
		btnCerrar.setFocusable(false);
		btnCerrar.setFocusTraversalKeysEnabled(false);
		btnCerrar.setFocusPainted(false);
		btnCerrar.setBorder(null);
		btnCerrar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/cerrar1.1.png")));
		btnCerrar.setBackground(new Color(40, 39, 61));
		btnCerrar.setBounds(0, 0, 32, 28);
		panelTitulo.add(btnCerrar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 109, 1280, 22);
		contentPane.add(menuBar);
		
		menuUsuario = new JMenu("Usuario");
		menuUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuUsuario);
		
		JMenuItem submenuGestionUsuario = new JMenuItem("Gestionar Usuario");
		submenuGestionUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuUsuario.add(submenuGestionUsuario);
		
		menuCompras = new JMenu("Compras");
		menuCompras.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuCompras);
		
		JMenuItem submenuProveedores = new JMenuItem("Proveedores");
		submenuProveedores.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuProveedores);
		
		JMenuItem submenuPreciosActualizados = new JMenuItem("Precios Actualizados");
		submenuPreciosActualizados.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuPreciosActualizados);
		
		JMenuItem submenuOrdenCompra = new JMenuItem("Ordenes de Compra");
		submenuOrdenCompra.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuOrdenCompra);
		
		JMenuItem submenuCotizaciones = new JMenuItem("Cotizaciones");
		submenuCotizaciones.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuCotizaciones);
		
		JMenuItem submenuDetalleCompra = new JMenuItem("Detalle de Compra");
		submenuDetalleCompra.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuCompras.add(submenuDetalleCompra);
		
		menuVentas = new JMenu("Ventas");
		menuVentas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuVentas);
		
		JMenuItem submenuClientes = new JMenuItem("Clientes");
		submenuClientes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuVentas.add(submenuClientes);
		
		JMenuItem submenuDetalleVenta = new JMenuItem("Detalle de Venta");
		submenuDetalleVenta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuVentas.add(submenuDetalleVenta);
		
		JMenuItem submenuFacturas = new JMenuItem("Facturas");
		submenuFacturas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuVentas.add(submenuFacturas);
		
		menuAlmacen = new JMenu("Almacen");
		menuAlmacen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuAlmacen);
		
		JMenuItem submenuInventario = new JMenuItem("Inventario");
		submenuInventario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuInventario);
		
		JMenuItem submenuIngresos = new JMenuItem("Ingresos");
		submenuIngresos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuIngresos);
		
		JMenuItem submenuSalidas = new JMenuItem("Salidas");
		submenuSalidas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuSalidas);
		
		JMenuItem submenuGuiaRemision = new JMenuItem("Guias de Remisión");
		submenuGuiaRemision.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuGuiaRemision);
		
		JMenuItem submenuHistorial = new JMenuItem("Historial");
		submenuHistorial.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuHistorial);
		
		JMenuItem submenuOtros = new JMenuItem("Gestionar Otros");
		submenuOtros.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAlmacen.add(submenuOtros);
		
		menuRRHH = new JMenu("R.R.H.H.");
		menuRRHH.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuRRHH);
		
		JMenuItem submenuPlanilla = new JMenuItem("Planilla");
		submenuPlanilla.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuRRHH.add(submenuPlanilla);
		
		JMenuItem submenuGestionEmpleados = new JMenuItem("Gestión de Empleados");
		submenuGestionEmpleados.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuRRHH.add(submenuGestionEmpleados);
		
		JMenu menuAcercaDe = new JMenu("Acerca De");
		menuAcercaDe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(menuAcercaDe);
		
		JMenuItem submenuCapacitacion = new JMenuItem("Empresa y Capacitación");
		submenuCapacitacion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAcercaDe.add(submenuCapacitacion);
		
		configurarMenuPorRolUsuario(idRolUsuario);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 28, 1280, 81);
		panel.setBackground(new Color(51, 52, 78));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblLogoInicio = new JLabel("");
		lblLogoInicio.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogoInicio.setBounds(0, 0, 119, 81);
		actualizarIconoInicio();
		panel.add(lblLogoInicio);
		
		Empresa empresa = empresacontroller.obtenerEmpresa();
		JLabel lblNewLabel_1 = new JLabel("Sistema de Ferretría " + empresa.getRazon_social());
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(new Color(245, 245, 245));
		lblNewLabel_1.setBounds(114, 11, 923, 58);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usuario: " + nombreUsuario);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_2.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/usuarioicono.png")));
		lblNewLabel_2.setForeground(new Color(245, 245, 245));
		lblNewLabel_2.setBounds(1047, 11, 223, 52);
		panel.add(lblNewLabel_2);
		
		Image backgroundImage = new ImageIcon("/Escritorio/fondoTitulo.jpg").getImage();
		desktopPanePrincipal = new JDesktopPane();
		desktopPanePrincipal.setBackground(new Color(51, 52, 78));		
		desktopPanePrincipal.setBounds(0, 131, 1302, 589);
		contentPane.add(desktopPanePrincipal);
				
        panelTitulo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                x = arg0.getX();
                y = arg0.getY();
            }
        });
        
        panelTitulo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                System.out.println("Coordenadas: (" + arg0.getX() + "," + arg0.getY() + ")");
                setLocation(getLocation().x + arg0.getX() - x, getLocation().y + arg0.getY() - y);
            }
        });
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnMinimizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setExtendedState(JFrame.ICONIFIED);
			}
		});
		
		/*EVENTOS PARA ABRIR INTERNAL FRAMES*/
		submenuGestionUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarInternalFrames();
				ifrm_GestionarUsuario ifrm_gestionarusuario = new ifrm_GestionarUsuario();
				ifrm_gestionarusuario.setVisible(true);
				desktopPanePrincipal.add(ifrm_gestionarusuario);
			}
		});
		
		submenuProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_GestionProveedores ifrm_gestionarproveedores = new ifrm_GestionProveedores();
				ifrm_gestionarproveedores.setVisible(true);
				desktopPanePrincipal.add(ifrm_gestionarproveedores);			}
		});
		
		submenuPreciosActualizados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_PreciosActualizados ifrm_preciosactualizados = new ifrm_PreciosActualizados();
				ifrm_preciosactualizados.setVisible(true);
				desktopPanePrincipal.add(ifrm_preciosactualizados);
			}
		});
		
		submenuOrdenCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_OrdenesCompra ifrm_ordenescompra = new ifrm_OrdenesCompra(usuarioValidado);
				ifrm_ordenescompra.setVisible(true);
				desktopPanePrincipal.add(ifrm_ordenescompra);
			}
		});
		
		submenuClientes.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {   
	    		 cerrarInternalFrames();
	    		ifrm_GestionarCliente ifrm_gestionarcliente =  new ifrm_GestionarCliente();
	        		desktopPanePrincipal.add(ifrm_gestionarcliente);
	        		ifrm_gestionarcliente.setVisible(true);
	        	}
	    	
	    });
		
		submenuFacturas.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        cerrarInternalFrames();
    	        try {
    	            ifrm_Venta ifrm_ventas = new ifrm_Venta(usuarioValidado);
    	            desktopPanePrincipal.add(ifrm_ventas);
    	            ifrm_ventas.setVisible(true);
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	        }
    	    }
    	});
		
    	submenuDetalleVenta.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	        cerrarInternalFrames();
    	        try {
    	            ifrm_DetalleVenta ifrm_detalleventas = new ifrm_DetalleVenta();
    	            desktopPanePrincipal.add(ifrm_detalleventas);
    	            ifrm_detalleventas.setVisible(true);
    	        } catch (Exception ex) {
    	            ex.printStackTrace();
    	        }
    	    }
    	});
    	
    	submenuInventario.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			cerrarInternalFrames();
    			ifrm_ListaInventario frm_listainventario = new ifrm_ListaInventario();
    			frm_listainventario.setVisible(true);
    			desktopPanePrincipal.add(frm_listainventario);
    		}
    	});
    	
		submenuCotizaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_Cotizaciones ifrm_cotizaciones = new ifrm_Cotizaciones();
				ifrm_cotizaciones.setVisible(true);
				desktopPanePrincipal.add(ifrm_cotizaciones);
			}
		});
		
		submenuDetalleCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarInternalFrames();
				ifrm_DetalleCompra ifrm_detallecompra = new ifrm_DetalleCompra();
				ifrm_detallecompra.setVisible(true);
				desktopPanePrincipal.add(ifrm_detallecompra);
			}
		});
		
		submenuIngresos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarInternalFrames();
				ifrm_Ingresos ifrm_ingresos = new ifrm_Ingresos(usuarioValidado);
				ifrm_ingresos.setVisible(true);
				desktopPanePrincipal.add(ifrm_ingresos);
			}
		});
		
		submenuGestionEmpleados.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
				cerrarInternalFrames();
				ifrm_GestionarEmpleado ifrm_gestionarempleado = new ifrm_GestionarEmpleado();
				desktopPanePrincipal.add(ifrm_gestionarempleado);
				ifrm_gestionarempleado.setVisible(true);
			}
    	});
		
		submenuSalidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_Salida ifrm_salida = new ifrm_Salida(usuarioValidado);
				desktopPanePrincipal.add(ifrm_salida);
				ifrm_salida.setVisible(true);
			}			
		});
		
		submenuGuiaRemision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_Remision ifrm_remision = new ifrm_Remision(usuarioValidado);
				desktopPanePrincipal.add(ifrm_remision);
				ifrm_remision.setVisible(true);
			}			
		});
		
		submenuHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_Historial ifrm_historial = new ifrm_Historial();
				desktopPanePrincipal.add(ifrm_historial);
				ifrm_historial.setVisible(true);
			}
		});
		
		submenuOtros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_Otros ifrm_otros = new ifrm_Otros();
				desktopPanePrincipal.add(ifrm_otros);
				ifrm_otros.setVisible(true);
			}
		});
		
		submenuPlanilla.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_Planilla ifrm_planilla = new ifrm_Planilla();
				desktopPanePrincipal.add(ifrm_planilla);
				ifrm_planilla.setVisible(true);
			}
		});
		
		submenuCapacitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarInternalFrames();
				ifrm_AcercaDe ifrm_acercade = new ifrm_AcercaDe();
				desktopPanePrincipal.add(ifrm_acercade);
				ifrm_acercade.setVisible(true);
			}
		});
		

	}
	
	private void configurarMenuPorRolUsuario(int idrolUsuario) {
	    System.out.println("ID de Rol del Usuario: " + idrolUsuario); // Agrega esta línea para imprimir el valor
	    if (idrolUsuario == 2) {
	        menuUsuario.setVisible(false);	       
	        menuRRHH.setVisible(false);
	        // También puedes ocultar otros elementos relacionados con los menús si es necesario
	    }
	}
	
	// Método para cerrar todos los InternalFrames
	private void cerrarInternalFrames() {
	    JInternalFrame[] frames = desktopPanePrincipal.getAllFrames();
	    for (JInternalFrame frame : frames) {
	        frame.dispose();
	    }
	}	
	
	public void actualizarIconoInicio() {
		Empresa empresa = empresacontroller.obtenerEmpresa();
		ImageIcon iconoInicio = new ImageIcon(empresa.getLogo_inicio());
		lblLogoInicio.setIcon(iconoInicio);		
	}
}
