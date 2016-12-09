/**
 * 
 */
package com.radardgt.iteracion6.integracion.presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.radardgt.iteracion6.integracion.dominio.GestorPropietario;
import com.radardgt.iteracion6.integracion.dominio.GestorRadar;
import com.radardgt.iteracion6.integracion.dominio.GestorSancion;
import com.radardgt.iteracion6.integracion.dominio.GestorVehiculo;
import com.radardgt.iteracion6.integracion.dominio.Radar;
import com.radardgt.iteracion6.integracion.dominio.Vehiculo;
import com.radardgt.iteracion6.integracion.persistencia.ConexionDB;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

/**
 * Esta es la clase que contiene la ventana principal de la aplicacion
 * @author Luis Diaz
 *
 */
public class JF_VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos
	static ConexionDB bbdd;
    GestorRadar radar;
    GestorVehiculo gv;
    GestorPropietario gp;
    GestorSancion gs;
    Boolean parar;
    
    // Forms
    JF_CambiarVehiculoPropietario cambiarPropietario;
    JF_PagarSancion pagarSancion;
    private JTable table;
	
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JF_VentanaPrincipal frame = new JF_VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    /**
     * Constructor de la ventana
     */
    public JF_VentanaPrincipal() {
    	setResizable(false);
    	setBounds(200,100,500,500);
    	// Inicializar variables
    	parar=false;
		// Crear Componentes
		JMenuBar menuBar = new JMenuBar();
		JMenu mnPanel = new JMenu("Panel de Control");
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		JMenu mnSancion = new JMenu("Sancion");
		JMenuItem mntmCambiarPropietario = new JMenuItem("Cambiar Propietario");
		mntmCambiarPropietario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cambiarPropietario=JF_CambiarVehiculoPropietario.getInstance();
				cambiarPropietario.setVisible(true);
			}
		});
		mntmCambiarPropietario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cambiarPropietario=JF_CambiarVehiculoPropietario.getInstance();
				cambiarPropietario.setVisible(true);
			}
		});
		JMenuItem mntmPagarSancin = new JMenuItem("Pagar Sanción");
		mntmPagarSancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pagarSancion=JF_PagarSancion.getInstance();
				pagarSancion.setVisible(true);
			}
		});
		JMenu mnVehiculos = new JMenu("Vehiculos");
		JButton btnIniciarRadar = new JButton("Iniciar Radar");
		DefaultTableModel modelotabla=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"MATRICULA", "VELOCIDAD", "PROPIETARIO"
				});
		JButton btnPararRadar = new JButton("Parar Radar");
		
		// Crar barra de menu
		setJMenuBar(menuBar);
		
		// Añadirlos al menu
		menuBar.add(mnPanel);
		mnPanel.add(mntmCerrar);
		mnVehiculos.add(mntmCambiarPropietario);
		mnSancion.add(mntmPagarSancin);
		menuBar.add(mnVehiculos);
		menuBar.add(mnSancion);
		getContentPane().setLayout(null);
		
		// Objetos
		radar=new GestorRadar();
		gv=new GestorVehiculo();
		gp=new GestorPropietario();
		gs=new GestorSancion();
		crearConexionconBBDD();
		
		btnIniciarRadar.setBounds(61, 28, 110, 61);
		getContentPane().add(btnIniciarRadar);
		
		
		btnPararRadar.setBounds(333, 32, 110, 53);
		getContentPane().add(btnPararRadar);
		
		table = new JTable();
		table.setBounds(46, 132, 400, 295);
		table.setModel(modelotabla);
		
		getContentPane().add(table);
		
		// Eventos
		mntmCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		btnPararRadar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				parar=true;
			}
		});
		
		btnIniciarRadar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				limpiarDatosTabla(modelotabla);
				Radar[] radares=radar.iniciarRadares();
				Vehiculo[] vehiculos=gv.crearVehiculos(bbdd);
				//for(int i=0; i<14000;i++){
					System.out.println("Entrando");
					// Se crean las sanciones
					radar.GenerarSanciones(bbdd, radares, vehiculos, gs, gp, modelotabla);
					
				//}
			}
		});
		
		// Crear la conexion con la base de datos
		
		
	}
    public static ConexionDB getConexion(){
    	return bbdd;
    }
	private void crearConexionconBBDD() {
		// TODO Auto-generated method stub
		bbdd=new ConexionDB("Oracle","localhost","oradev","LUIS","3907");
	}
	
    /**
     * Borra todas los datos de un DefaultTableModel
     * @param dtm Tabla
     */
    public static void limpiarDatosTabla(DefaultTableModel dtm){
       
        for(int i=0;i<dtm.getColumnCount();i++){
            for(int j=0;j<dtm.getRowCount();j++){
                dtm.setValueAt("", i, j);
            }
        }
    }
}
