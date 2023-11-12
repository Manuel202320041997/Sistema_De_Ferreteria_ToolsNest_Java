package View;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class frm_Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel titleBar;
    private JButton closeButton;  // Nuevo botón
    private Point mouseDownCompCoords = null;
    private int x;
    private int y;
    private JPasswordField passwordField;
    private JTextField textField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frm_Login frame = new frm_Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public frm_Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 463);
        setResizable(false);
        setUndecorated(true);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 52, 78));
        panel.setBounds(0, 28, 337, 435);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Ferretería ToolsNest");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(245, 245, 245));
        lblNewLabel.setBounds(10, 26, 317, 62);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 99, 317, 290);
        lblNewLabel_1.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/herramientas-de-ferreteria grande.png")));
        panel.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Líderes en Ferreterias en Todo el Perú y el Mundo");
        lblNewLabel_2.setForeground(new Color(245, 245, 245));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_2.setBounds(10, 410, 317, 14);
        panel.add(lblNewLabel_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 245, 245));
        panel_1.setBounds(333, 28, 417, 435);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_4 = new JLabel("DNI:");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(90, 215, 69, 30);
        panel_1.add(lblNewLabel_4);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(169, 279, 173, 30);
        panel_1.add(passwordField);
        
        textField = new JTextField();
        textField.setFocusTraversalPolicyProvider(true);
        textField.setBounds(169, 215, 173, 30);
        panel_1.add(textField);
        textField.setColumns(10);
        
        JLabel lblNewLabel_4_1 = new JLabel("CLAVE:");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4_1.setBounds(90, 282, 69, 30);
        panel_1.add(lblNewLabel_4_1);
        
        JButton btnNewButton = new JButton("Ingresar al Sistema");
        btnNewButton.setFocusPainted(false);
        btnNewButton.setForeground(new Color(245, 245, 245));
        btnNewButton.setBackground(new Color(40, 39, 61));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(86, 344, 256, 30);
        panel_1.add(btnNewButton);
        
        JLabel lblNewLabel_5 = new JLabel("");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setBounds(10, 46, 397, 133);
        lblNewLabel_5.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/usuarioiconoGrande.png")));
        panel_1.add(lblNewLabel_5);

        JPanel panelTitutlo = new JPanel();
        panelTitutlo.setBackground(new Color(40, 39, 61));
        panelTitutlo.setBounds(0, 0, 750, 28);
        contentPane.add(panelTitutlo);
        panelTitutlo.setLayout(null);

        JButton btnMinimizar = new JButton("");
        btnMinimizar.setFocusable(false);
        btnMinimizar.setFocusTraversalKeysEnabled(false);
        btnMinimizar.setFocusPainted(false);
        btnMinimizar.setBorder(null);
        btnMinimizar.setBackground(new Color(40, 39, 61));
        btnMinimizar.setBounds(29, 0, 32, 28);
        btnMinimizar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/borrar1.2.png")));
        panelTitutlo.add(btnMinimizar);

        JButton btnCerrar = new JButton("");
        btnCerrar.setFocusable(false);
        btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCerrar.setFocusTraversalKeysEnabled(false);
        btnCerrar.setFocusPainted(false);
        btnCerrar.setBorder(null);
        btnCerrar.setBounds(0, 0, 32, 28);
        btnCerrar.setBackground(new Color(40, 39, 61));
        btnCerrar.setIcon(new ImageIcon(frm_Login.class.getResource("/Img/cerrar1.1.png")));
        panelTitutlo.add(btnCerrar);

        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        btnMinimizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setExtendedState(JFrame.ICONIFIED);
            }
        });

        panelTitutlo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent arg0) {
                x = arg0.getX();
                y = arg0.getY();
            }
        });

        panelTitutlo.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                System.out.println("Coordenadas: (" + arg0.getX() + "," + arg0.getY() + ")");
                setLocation(getLocation().x + arg0.getX() - x, getLocation().y + arg0.getY() - y);
            }
        });
    }
}
