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

/**
 * Esta es la clase que contiene la ventana principal de la aplicacion
 * @author Luis Diaz
 *
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Atributos
	ConexionDB bbdd;
    GestorRadar radar;
    GestorVehiculo gv;
    GestorPropietario gp;
    GestorSancion gs;
    private JTable table;
    Boolean parar;
	
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
    public VentanaPrincipal() {
    	// Inicializar variables
    	parar=false;
		// Crear Componentes
		JMenuBar menuBar = new JMenuBar();
		JMenu mnPanel = new JMenu("Panel de Control");
		JMenuItem mntmCerrar = new JMenuItem("Cerrar");
		JMenu mnSancion = new JMenu("Sancion");
		JMenuItem mntmCambiarPropietario = new JMenuItem("Cambiar Propietario");
		mntmCambiarPropietario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CambiarVehiculoPropietario c=new CambiarVehiculoPropietario(bbdd);
				c.setVisible(true);
			}
		});
		JMenuItem mntmPagarSancin = new JMenuItem("Pagar Sanción");
		mntmPagarSancin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PagarSancion p=new PagarSancion(bbdd);
				p.setVisible(true);
			}
		});
		JMenu mnVehiculos = new JMenu("Vehiculos");
		JButton btnIniciarRadar = new JButton("Iniciar Radar");
		table = new JTable();
		DefaultTableModel modelotabla=new DefaultTableModel();
		table.setModel(modelotabla);
		JButton btnPararRadar = new JButton("Parar Radar");
		
		// Ajustar Posicion
		table.setBounds(41, 139, 434, 240);
		
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
		
		// Añadirlos al panel
		table.setBackground(Color.WHITE);
		getContentPane().add(table);
		
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
				Radar[] radares=radar.iniciarRadares();
				Vehiculo[] vehiculos=gv.crearVehiculos(bbdd);
				while(!parar){
					System.out.println("Entrando");
					// Se crean las sanciones
					radar.GenerarSanciones(bbdd, radares, vehiculos, gs, gp, modelotabla);
					//limpiarDatosTabla(modelotabla);
				}
			}
		});
		
		// Crear la conexion con la base de datos
		
		
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
