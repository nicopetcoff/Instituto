package vista;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.ToView.AlumnoToView;

public class VentanaAlumnosDelCurso extends JFrame {

	public VentanaAlumnosDelCurso(ArrayList<AlumnoToView> arrayList) {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel(new BorderLayout());
		add(panel);

		JTable tablaAlumnos = new JTable();

		DefaultTableModel modeloTablaAlumnos = new DefaultTableModel();

		Object[] titulos = { "Nombre", "Apellido", "DNI", "Legajo" };

		modeloTablaAlumnos.setColumnIdentifiers(titulos);

		for (AlumnoToView alumno : arrayList) {
			Object[] fila = new Object[4];
			fila[0] = alumno.getNombre();
			fila[1] = alumno.getApellido();
			fila[2] = alumno.getDni();
			fila[3] = alumno.getLegajo();
			modeloTablaAlumnos.addRow(fila);
		}

		tablaAlumnos.setModel(modeloTablaAlumnos);

		JScrollPane scrollTable = new JScrollPane(tablaAlumnos);

		panel.add(scrollTable, BorderLayout.CENTER);

		pack();
	}

}
