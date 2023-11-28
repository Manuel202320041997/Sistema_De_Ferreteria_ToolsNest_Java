package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javafx.scene.Group;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import Controller.EmpresaController;
import Controller.VideosController;
import Model.Empresa;
import Model.Videos;
import Model.Usuario;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;

public class ifrm_AcercaDe extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    //private frm_Inicio frm_inicio;
    private EmpresaController empresacontroller;
    private VideosController videoscontroller;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtRazon_Social;
    private JTextField txtRuc;
    private JLabel lblLogoLogin;
    private JLabel lblLogoInicio;
    private JButton btnLogoLogin;
    private JButton btnLogoInicio; 
    private JTextField txtId;
    private MediaPlayer mediaPlayer;
    private JPanel panelDerecho;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ifrm_AcercaDe frame = new ifrm_AcercaDe();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ifrm_AcercaDe() {
    	this.repaint();
        setBounds(0, 0, 1280, 589);
        setClosable(true);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        getContentPane().setBackground(new Color(51, 52, 78));
        getContentPane().setLayout(null);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        //frm_inicio = new frm_Inicio(null);
        empresacontroller = new EmpresaController();
        videoscontroller = new VideosController();
        
        JPanel panel = new JPanel();
        panel.setBounds(132, 11, 994, 537);
        getContentPane().add(panel);
        panel.setLayout(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(1000, 1000));
        contentPanel.setLayout(null);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBounds(0, 0, 994, 537);
        scrollPane.add(contentPanel);
        panel.add(scrollPane);
        
        JLabel lblNewLabel = new JLabel("Información de la Empresa");
        lblNewLabel.setBounds(10, 11, 275, 67);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        contentPanel.add(lblNewLabel);
        
        lblLogoLogin = new JLabel("");
        lblLogoLogin.setBounds(23, 102, 262, 264);
        //lblLogoLogin.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/herramientas-de-ferreteria grande.png")));
        contentPanel.add(lblLogoLogin);
        
        lblLogoInicio = new JLabel("");
        lblLogoInicio.setBounds(304, 286, 64, 67);
        //lblLogoInicio.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/herramientas-de-ferreteria-icono2.png")));
        contentPanel.add(lblLogoInicio);
        
        txtDireccion = new JTextField();
        txtDireccion.setEditable(false);
        txtDireccion.setBounds(510, 371, 183, 29);
        txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtDireccion.setColumns(10);
        contentPanel.add(txtDireccion);
        
        JLabel lblNewLabel_2 = new JLabel("Direccion:");
        lblNewLabel_2.setBounds(410, 371, 101, 28);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_2);
        
        JLabel lblNewLabel_2_1 = new JLabel("Telefono:");
        lblNewLabel_2_1.setBounds(410, 331, 101, 28);
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_2_1);
        
        txtTelefono = new JTextField();
        txtTelefono.setEditable(false);
        txtTelefono.setBounds(510, 331, 183, 29);
        txtTelefono.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtTelefono.setColumns(10);
        contentPanel.add(txtTelefono);
        
        JLabel lblNewLabel_2_2 = new JLabel("Razon Social:");
        lblNewLabel_2_2.setBounds(410, 286, 101, 28);
        lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_2_2);
        
        txtRazon_Social = new JTextField();
        txtRazon_Social.setEditable(false);
        txtRazon_Social.setBounds(510, 291, 183, 29);
        txtRazon_Social.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtRazon_Social.setColumns(10);
        contentPanel.add(txtRazon_Social);
        
        JLabel lblNewLabel_2_3 = new JLabel("RUC");
        lblNewLabel_2_3.setBounds(410, 251, 101, 28);
        lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        contentPanel.add(lblNewLabel_2_3);
        
        txtRuc = new JTextField();
        txtRuc.setEditable(false);
        txtRuc.setBounds(510, 251, 183, 29);
        txtRuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtRuc.setColumns(10);
        contentPanel.add(txtRuc);
        
        JButton btnGuardar = new JButton("Guardar Cambios");
        btnGuardar.setBounds(730, 371, 219, 29);
        btnGuardar.setForeground(new Color(245, 245, 245));
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnGuardar.setBackground(new Color(78, 156, 54));
        contentPanel.add(btnGuardar);
        
        JLabel lblNewLabel_4_1 = new JLabel("");
        lblNewLabel_4_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "DATOS  DE LA EMPRESA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        lblNewLabel_4_1.setBounds(395, 226, 310, 191);
        contentPanel.add(lblNewLabel_4_1);
        
        btnLogoLogin = new JButton("Cambiar Logo Login");
        btnLogoLogin.setVisible(false);
        btnLogoLogin.setBounds(21, 377, 152, 23);
        contentPanel.add(btnLogoLogin);
        
        btnLogoInicio = new JButton("Cambiar Logo Inicio"); 
        btnLogoInicio.setVisible(false);
        btnLogoInicio.setBounds(216, 377, 152, 23);
        contentPanel.add(btnLogoInicio);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "IMAGENES UTILIZADAS DE LA EMPRESA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        lblNewLabel_4.setBounds(10, 82, 380, 335);
        contentPanel.add(lblNewLabel_4);
        
        JRadioButton rbEdicion = new JRadioButton("Activar Edicion de Datos");
        rbEdicion.setFont(new Font("Tahoma", Font.PLAIN, 15));
        rbEdicion.setBounds(730, 334, 219, 23);
        contentPanel.add(rbEdicion);
        
        txtId = new JTextField();
        txtId.setVisible(false);
        txtId.setBounds(703, 257, 47, 20);
        contentPanel.add(txtId);
        txtId.setColumns(10);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(0, 0, 0));
        separator.setBounds(22, 497, 927, 14);
        contentPanel.add(separator);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("");
        lblNewLabel_4_1_1.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "ACCIONES A REALIZAR", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
        lblNewLabel_4_1_1.setBounds(715, 305, 250, 112);
        contentPanel.add(lblNewLabel_4_1_1);
        
        JLabel lblNewLabel_3 = new JLabel("Capacitación");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel_3.setBounds(10, 501, 275, 67);
        contentPanel.add(lblNewLabel_3);

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setPreferredSize(new Dimension(0, 1000));
        panel.add(scrollBar);

        
        JLabel lblBanner = new JLabel();
        lblBanner.setBounds(398, 11, 567, 204);
        ImageIcon icon = new ImageIcon(frm_Login.class.getResource("/Img/BannerToolsNest.png"));
        Image image = icon.getImage().getScaledInstance(lblBanner.getWidth(), lblBanner.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);
        lblBanner.setIcon(scaledIcon);
        contentPanel.add(lblBanner);
        
   /*     JLabel lblNewLabel_7 = new JLabel("Prueba fondo");
        lblNewLabel_7.setBorder(new TitledBorder(null, "prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ImageIcon icon2 = new ImageIcon(frm_Login.class.getResource("/Img/BannerToolsNest.png"));
        Image image2 = icon2.getImage().getScaledInstance(lblNewLabel_7.getWidth(), lblNewLabel_7.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
        lblNewLabel_7.setIcon(scaledIcon2);  // Cambiado de lblBanner a lblNewLabel_7
        lblNewLabel_7.setBounds(0, 490, 1000, 600);
        contentPanel.add(lblNewLabel_7);*/
        
        JSplitPane splitPane = new JSplitPane();
        splitPane.setBounds(50,590,900,400);        
        contentPanel.add(splitPane);

        JPanel panelBotones = new JPanel();
        panelBotones.setPreferredSize(new java.awt.Dimension(200, 100));
        splitPane.setLeftComponent(panelBotones);
        panelBotones.setLayout(new GridLayout(5, 1, 0, 10));
        panelBotones.revalidate();
        panelBotones.repaint();
        
        panelDerecho = new JPanel();
        splitPane.setRightComponent(panelDerecho);
        panelDerecho.setLayout(new FlowLayout());
        panelDerecho.revalidate();
        panelDerecho.repaint();
        
        JButton btnModulo1 = new JButton("Modulo Usuario");
        btnModulo1.setBounds(10, 10, 200, 30);
        panelBotones.add(btnModulo1);
        
        JButton btnModulo2 = new JButton("Modulo Compras");
        btnModulo2.setBounds(10, 50, 200, 30);
        panelBotones.add(btnModulo2);
        
        JButton btnModulo3 = new JButton("Modulo Ventas");
        btnModulo3.setBounds(10, 90, 200, 30);
        panelBotones.add(btnModulo3);
        
        
        JButton btnModulo4 = new JButton("Modulo Almacén");
        btnModulo4.setBounds(10, 130, 200, 30);
        panelBotones.add(btnModulo4);
        
        JButton btnModulo5 = new JButton("Modulo R.R.H.H.");
        btnModulo5.setBounds(10, 170, 200, 30);
        panelBotones.add(btnModulo5);       
        
        panelBotones.setComponentZOrder(btnModulo1, 0);
        panelBotones.setComponentZOrder(btnModulo2, 1);
        panelBotones.setComponentZOrder(btnModulo3, 2);
        panelBotones.setComponentZOrder(btnModulo4, 3);
        panelBotones.setComponentZOrder(btnModulo5, 4);
        
        

        mostrarDatos();
        
        btnLogoLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Imagen a Seleccionar");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    String rutaArchivo = archivoSeleccionado.getAbsolutePath();

                    // Obtener el ID del usuario
                    int idUsuario = Integer.parseInt(txtId.getText());
                    
                    System.out.println(rutaArchivo);
                    // Actualizar la imagen en la base de datos
                    empresacontroller.cambiarLogoLogin(idUsuario, rutaArchivo);

                    // Actualizar la vista con la nueva imagen
                    mostrarDatos();
                    JOptionPane.showMessageDialog(ifrm_AcercaDe.this, "La imagen ha sido actualizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
        	}
        });
        
        btnLogoInicio.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Imagen a Seleccionar");
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = fileChooser.getSelectedFile();
                    String rutaArchivo = archivoSeleccionado.getAbsolutePath();

                    // Obtener el ID del usuario
                    int idUsuario = Integer.parseInt(txtId.getText());
                    
                    System.out.println(rutaArchivo);
                    // Actualizar la imagen en la base de datos
                    empresacontroller.cambiarLogoInicio(idUsuario, rutaArchivo);
                    
                    //frm_inicio.actualizarIconoInicio();
                	
                    // Actualizar la vista con la nueva imagen
                    mostrarDatos();
                    JOptionPane.showMessageDialog(ifrm_AcercaDe.this, "La imagen ha sido actualizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
        	}
        });
        
        btnModulo1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Videos> videos = videoscontroller.obtenerVideos(Integer.parseInt(txtId.getText()));

                if (!videos.isEmpty()) {
                    String urlVideo = videos.get(6).getUrl(); // Obtener la URL del primer video
                    
                    detenerReproduccion();
                    
                    // Ahora, puedes llamar a tu método reproducirVideo con la URL y el panelDerecho
                    reproducirVideo(urlVideo, panelDerecho);
                } else {
                    System.out.println("No se encontraron videos para reproducir.");
                }
        	}
        });
        
        btnModulo2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Videos> videos = videoscontroller.obtenerVideos(Integer.parseInt(txtId.getText()));

                if (!videos.isEmpty()) {
                    String urlVideo = videos.get(7).getUrl(); // Obtener la URL del primer video
                    
                    detenerReproduccion();
                    // Ahora, puedes llamar a tu método reproducirVideo con la URL y el panelDerecho
                    reproducirVideo(urlVideo, panelDerecho);
                } else {
                    System.out.println("No se encontraron videos para reproducir.");
                }
        	}
        });
        
        btnModulo3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Videos> videos = videoscontroller.obtenerVideos(Integer.parseInt(txtId.getText()));

                if (!videos.isEmpty()) {
                    String urlVideo = videos.get(8).getUrl(); // Obtener la URL del primer video
                    
                    detenerReproduccion();
                    // Ahora, puedes llamar a tu método reproducirVideo con la URL y el panelDerecho
                    reproducirVideo(urlVideo, panelDerecho);
                } else {
                    System.out.println("No se encontraron videos para reproducir.");
                }
        	}
        });
        
        btnModulo4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Videos> videos = videoscontroller.obtenerVideos(Integer.parseInt(txtId.getText()));

                if (!videos.isEmpty()) {
                    String urlVideo = videos.get(9).getUrl(); // Obtener la URL del primer video
                    
                    detenerReproduccion();
                    // Ahora, puedes llamar a tu método reproducirVideo con la URL y el panelDerecho
                    reproducirVideo(urlVideo, panelDerecho);
                } else {
                    System.out.println("No se encontraron videos para reproducir.");
                }
        	}
        });
        
        btnModulo5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		List<Videos> videos = videoscontroller.obtenerVideos(Integer.parseInt(txtId.getText()));

                if (!videos.isEmpty()) {
                    String urlVideo = videos.get(10).getUrl(); // Obtener la URL del primer video
                    
                    detenerReproduccion();
                    // Ahora, puedes llamar a tu método reproducirVideo con la URL y el panelDerecho
                    reproducirVideo(urlVideo, panelDerecho);
                } else {
                    System.out.println("No se encontraron videos para reproducir.");
                }
        	}
        });
                
        
        rbEdicion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		if(rbEdicion.isSelected()) {
        			habilidarDatos();
        		}
        		else {
        			inahibilitarDatos();
        		}
        	}
        });
        
        btnGuardar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Empresa empresa = new Empresa();
        		int idEmpresa = Integer.parseInt(txtId.getText());
        		String razonsocial = txtRazon_Social.getText();
        		String direccion = txtDireccion.getText();
        		String telefono = txtTelefono.getText();
        		
        		if(razonsocial.isEmpty() || direccion.isEmpty() || telefono.isEmpty()) {
        			JOptionPane.showMessageDialog(ifrm_AcercaDe.this, "NINGÚN CAMPO DEBE ESTAR VACÍO", "Advertencia", JOptionPane.WARNING_MESSAGE);
        		}
        		else {
        			empresa.setRazon_social(razonsocial);
        			empresa.setDireccion(direccion);
        			empresa.setTelefono(telefono);
        			empresa.setId(idEmpresa);
        			
        			empresacontroller.editarEmpresa(empresa);
        			mostrarDatos();
        			inahibilitarDatos();
        			rbEdicion.setSelected(false);
        			
        			int respuesta = JOptionPane.showConfirmDialog(ifrm_AcercaDe.this, "¿Desea reiniciar la aplicación para aplicar los cambios?", "Reinicio Necesario", JOptionPane.YES_NO_OPTION);
                    
                    if (respuesta == JOptionPane.YES_OPTION) {
                        System.exit(0);
                    }
        			
        		}
        		
        	}
        });
    }
    
    private void mostrarDatos() {
    	Empresa empresa = empresacontroller.obtenerEmpresa();  	

        try {
            ImageIcon iconoLogin = new ImageIcon(empresa.getLogo_login());
            ImageIcon iconoInicio = new ImageIcon(empresa.getLogo_inicio());
            lblLogoLogin.setIcon(iconoLogin);
            lblLogoInicio.setIcon(iconoInicio);
        } catch (Exception e) {
            e.printStackTrace();
            lblLogoLogin.setText("Error al cargar la imagen");
        }
        txtId.setText(String.valueOf(empresa.getId()));
        txtRuc.setText(empresa.getRuc());
        txtRazon_Social.setText(empresa.getRazon_social());
        txtTelefono.setText(empresa.getTelefono());
        txtDireccion.setText(empresa.getDireccion());
   }
    private void inahibilitarDatos() {
		txtDireccion.setEditable(false);
		txtRazon_Social.setEditable(false);
		txtTelefono.setEditable(false);
		btnLogoLogin.setVisible(false);
		btnLogoInicio.setVisible(false);
    }
    
    private void habilidarDatos() {
    	txtDireccion.setEditable(true);
		txtRazon_Social.setEditable(true);
		txtTelefono.setEditable(true);
		btnLogoLogin.setVisible(true);
		btnLogoInicio.setVisible(true);
    }
    
    private void reproducirVideo(String url, JPanel panel) {
        // Iniciar la plataforma JavaFX
        new JFXPanel();

        // Imprimir la ruta del archivo
        System.out.println("Ruta del archivo: " + url);

        // Codificar la URL para manejar espacios y otros caracteres especiales
        try {
            url = URLEncoder.encode(url, StandardCharsets.UTF_8.toString()).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // Reemplazar las barras invertidas con barras normales
        url = url.replace("\\", "/");

        // Crear el reproductor de medios
        Media media = new Media("file:///" + url);
        mediaPlayer = new MediaPlayer(media);

        // Crear el componente de JavaFX para mostrar el reproductor
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(panelDerecho.getWidth());
        mediaView.setFitHeight(panelDerecho.getHeight());

        // Crear el grupo fuera del hilo de JavaFX
        Group group = new Group(mediaView);
        
        // Utilizar Platform.runLater para trabajar con componentes de JavaFX
        Platform.runLater(() -> {
            Scene scene = new Scene(group, 640, 480);
            JFXPanel fxPanel = new JFXPanel();
            fxPanel.setScene(scene);

            // Limpiar el panel y agregar el componente de JavaFX
            panel.removeAll();
            panel.add(fxPanel);
            panel.revalidate();
            panel.repaint();

            // Iniciar la reproducción
            mediaPlayer.play();
        });
    }
    
    private void detenerReproduccion() {
        if (mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.stop();
        }
    }
    
    private boolean esImagen(File archivo) {
        try {
            ImageIO.read(archivo);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private Image redimensionarImagen(Image imagen, int ancho, int alto) {
        return imagen.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    }
  }