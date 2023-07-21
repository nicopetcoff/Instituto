package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controlador.InstitutoController;
import modelo.CursoToView;

public class VistaListadoAlumnoProfesorCurso extends JFrame {
	
	InstitutoController controlador = new InstitutoController();

	public VistaListadoAlumnoProfesorCurso() {
		setSize(500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new BorderLayout());

		add(panel);

		Container cont1 = new Container();
		cont1.setLayout(new FlowLayout());
		
		JTable tablaCursos = new JTable();
		DefaultTableModel modeloTablaCursos = new DefaultTableModel();
		
		Object[] titulos = {"Carrera", "Materia", "Profesor", "Dia", "Turno"};
		
		modeloTablaCursos.setColumnIdentifiers(titulos);
		
		for(CursoToView cur : controlador.getCursosDisponibles()) {
			Object[] fila = new Object[5];
			fila[0] = cur.getCarrera();
			fila[1] = cur.getMateria();
			fila[2] = cur.getProfesor();
			fila[3] = cur.getDia();
			fila[4] = cur.getTurno();
			modeloTablaCursos.addRow(fila);
		}
		
		tablaCursos.setModel(modeloTablaCursos);
		
		JScrollPane scrollTable = new JScrollPane (tablaCursos);
		
		cont1.add(scrollTable);
		
		panel.add(cont1, BorderLayout.NORTH );
		
		
		

	}

}
