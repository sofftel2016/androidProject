package com.radardgt.iteracion6.integracion.presentacion;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.radardgt.iteracion6.integracion.persistencia.ConexionDB;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.SystemColor;

public class JF_PagarSancion extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2720595042665147092L;
	private JPanel contentPane;
	private JTable table;
	ConexionDB conexion;
	public static JF_PagarSancion instance=null;

	public static JF_PagarSancion getInstance(){
        createInstance();
        return instance;
    }
    
    private synchronized static void createInstance(){
        if (instance == null) {
            instance = new JF_PagarSancion();  
        }
    }
	/**
	 * Create the frame.
	 */
	public JF_PagarSancion() {
		conexion=JF_VentanaPrincipal.getConexion();
		setTitle("Pagar Sanción");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 450, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBackground(SystemColor.text);
		table.setBounds(31, 33, 375, 213);
		contentPane.add(table);
		
		JButton btnPagar = new JButton("Pagar");
		
		btnPagar.setBounds(63, 269, 89, 23);
		contentPane.add(btnPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnSalir.setBounds(286, 269, 89, 23);
		contentPane.add(btnSalir);
		DefaultTableModel tabla=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Puntos_Sanción", "Importe_Sancion", "DNI_Conductor", "Nombre", "Matricula_Vehiculo"
				});
		table.setModel(tabla);
		conexion.ejecutarConsulta("Select * from SANCIONES");
		//rellenaTablaBD(conexion.getResultSet(),tabla);
		
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Prueba para las sanciones");
				System.out.println(table.getSelectedRow());
			}
		});
	}
	
    /**
     * Rellena una tabla desde BD
     * @param resultSet Resultset con la consulta, debe ser correcta
     * @param tabla Tabla
     */
    public void rellenaTablaBD(ResultSet resultSet, DefaultTableModel tabla){
        try {
            ResultSetMetaData metadatos = resultSet.getMetaData();
            
            tabla.setColumnCount(metadatos.getColumnCount());
            
            int numeroColumnas=tabla.getColumnCount();
            
            Object[] etiquetas = new Object[numeroColumnas];

            // Se obtiene cada una de las etiquetas para cada columna
            for (int i = 0; i < numeroColumnas; i++)
            {
               // Nuevamente, para ResultSetMetaData la primera columna es la 1. 
               etiquetas[i] = metadatos.getColumnLabel(i + 1); 
            }
            
            tabla.setColumnIdentifiers(etiquetas);
            
                // Para cada registro de resultado en la consulta 
                while (resultSet.next())
                {
                    // Se crea y rellena la fila para el modelo de la tabla.
                    Object[] datosFila = new Object[tabla.getColumnCount()];
                    for (int i = 0; i < tabla.getColumnCount(); i++)
                        datosFila[i] = resultSet.getObject(i + 1);
                    tabla.addRow(datosFila);
                    
                }
                resultSet.close();
            } catch (SQLException ex) {
            	ex.printStackTrace();
        }
    }
}
