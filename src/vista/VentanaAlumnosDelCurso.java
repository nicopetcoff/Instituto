package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import modelo.ToView.AlumnoToView;

public class VentanaAlumnosDelCurso extends JFrame{
	
	public VentanaAlumnosDelCurso(ArrayList<AlumnoToView> arrayList) {		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel(new BorderLayout());		
		add(panel);
		
		JTable tablaAlumnos = new JTable();
		
		DefaultTableModel modeloTablaAlumnos = new DefaultTableModel();
		
		Object [] titulos = {"Nombre", "Apellido", "DNI", "Legajo"};
		
		modeloTablaAlumnos.setColumnIdentifiers(titulos);
		
		for(AlumnoToView alumno : arrayList) {
			
		}
		
		pack();
	}

}
