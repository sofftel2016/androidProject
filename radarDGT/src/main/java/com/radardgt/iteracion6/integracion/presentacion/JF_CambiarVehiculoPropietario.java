package com.radardgt.iteracion6.integracion.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.radardgt.iteracion6.integracion.dominio.GestorPropietario;
import com.radardgt.iteracion6.integracion.dominio.GestorVehiculo;
import com.radardgt.iteracion6.integracion.dominio.Propietario;
import com.radardgt.iteracion6.integracion.dominio.Vehiculo;
import com.radardgt.iteracion6.integracion.persistencia.ConexionDB;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JF_CambiarVehiculoPropietario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -40034147737167158L;
	public static JF_CambiarVehiculoPropietario instance=null;
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtPropietario;
	private JTextField txtNombre;
	private JTextField txtN_DNI;
	private ConexionDB bbdd;
	JButton btnBuscarNuevoPropietario;
	private JTextField txtN_Nombre;
	GestorPropietario gp;
	Propietario p,pnuevo;
	Vehiculo v;
	GestorVehiculo gv;

	public static JF_CambiarVehiculoPropietario getInstance(){
        createInstance();
        return instance;
    }
    
    private synchronized static void createInstance(){
        if (instance == null) {
            instance = new JF_CambiarVehiculoPropietario();  
        }
    }

	/**
	 * Create the frame.
	 */
	public JF_CambiarVehiculoPropietario() {
		bbdd=JF_VentanaPrincipal.getConexion(); // Obtener la conexion a la bbdd
		setTitle("Cambiar Propietario Vehículo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 482, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gv=new GestorVehiculo();
				if(txtMatricula.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Introduce la matricula del coche","Error en el Campo",JOptionPane.ERROR_MESSAGE);
				}else{
					v=gv.obtenerVehiculo(txtMatricula.getText(), bbdd);	
					gp=new GestorPropietario();
				    p=gp.DevolverPropietario(v, bbdd);
					txtPropietario.setText(p.getDni());
					txtNombre.setText(p.getNombre());
					btnBuscarNuevoPropietario.setEnabled(true);
				}
				
				
			}
		});
		btnBuscarVehiculo.setBounds(290, 45, 132, 56);
		contentPane.add(btnBuscarVehiculo);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(101, 29, 144, 22);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(26, 33, 65, 14);
		contentPane.add(lblMatricula);
		
		btnBuscarNuevoPropietario = new JButton("Buscar Nuevo Propietario");
		btnBuscarNuevoPropietario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pnuevo=gp.buscarPropietario(txtN_DNI.getText(),bbdd);
				txtN_Nombre.setText(pnuevo.getNombre());
			}
		});
		btnBuscarNuevoPropietario.setEnabled(false);
		btnBuscarNuevoPropietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnBuscarNuevoPropietario.setHorizontalAlignment(SwingConstants.LEADING);
		btnBuscarNuevoPropietario.setBounds(279, 178, 158, 47);
		contentPane.add(btnBuscarNuevoPropietario);
		
		txtPropietario = new JTextField();
		txtPropietario.setEditable(false);
		txtPropietario.setBounds(101, 62, 144, 23);
		contentPane.add(txtPropietario);
		txtPropietario.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				gv.cambiarPropietario(pnuevo, v, bbdd);
				JOptionPane.showMessageDialog(null,"Cambio Realizado Correctamente","Cambios", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAceptar.setBounds(95, 285, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(275, 285, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(26, 66, 65, 14);
		contentPane.add(lblDni);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(101, 102, 144, 23);
		contentPane.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(26, 106, 65, 14);
		contentPane.add(lblNombre);
		
		JLabel label = new JLabel("DNI:");
		label.setBounds(36, 171, 65, 14);
		contentPane.add(label);
		
		txtN_DNI = new JTextField();
		txtN_DNI.setColumns(10);
		txtN_DNI.setBounds(101, 167, 144, 23);
		contentPane.add(txtN_DNI);
		
		JLabel label_1 = new JLabel("Nombre:");
		label_1.setBounds(36, 211, 65, 14);
		contentPane.add(label_1);
		
		txtN_Nombre = new JTextField();
		txtN_Nombre.setEditable(false);
		txtN_Nombre.setColumns(10);
		txtN_Nombre.setBounds(101, 207, 144, 23);
		contentPane.add(txtN_Nombre);
	}
}
