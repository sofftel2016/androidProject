package com.radardgt.iteracion6.integracion.presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.radardgt.iteracion6.integracion.persistencia.ConexionDB;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CambiarVehiculoPropietario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -40034147737167158L;
	
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtPropietario;
	private JTextField txtNombre;
	private JTextField txtN_DNI;
	private JTextField txtN_Nombre;


	/**
	 * Create the frame.
	 */
	public CambiarVehiculoPropietario(ConexionDB bbdd) {
		setTitle("Cambiar Propietario Vehículo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscarVehiculo = new JButton("Buscar Vehiculo");
		btnBuscarVehiculo.setBounds(290, 45, 132, 56);
		contentPane.add(btnBuscarVehiculo);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(101, 29, 144, 22);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(26, 33, 65, 14);
		contentPane.add(lblMatricula);
		
		JButton btnBuscarNuevoPropietario = new JButton("Buscar Nuevo Propietario");
		btnBuscarNuevoPropietario.setHorizontalAlignment(SwingConstants.LEADING);
		btnBuscarNuevoPropietario.setBounds(279, 178, 158, 29);
		contentPane.add(btnBuscarNuevoPropietario);
		
		txtPropietario = new JTextField();
		txtPropietario.setEditable(false);
		txtPropietario.setBounds(101, 62, 144, 23);
		contentPane.add(txtPropietario);
		txtPropietario.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(95, 285, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
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
