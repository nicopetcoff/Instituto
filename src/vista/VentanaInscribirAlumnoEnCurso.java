package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.InstitutoController;
import modelo.ToView.*;
import modelo.excepciones.NoExisteAlumnoException;
import modelo.excepciones.NoExisteCarreraException;
import modelo.excepciones.NoExisteMateriaException;
import modelo.excepciones.NoPudoInscribirseException;
import modelo.excepciones.NoexisteCursoException;

public class VentanaInscribirAlumnoEnCurso extends JFrame {

	InstitutoController controlador = new InstitutoController();

	public VentanaInscribirAlumnoEnCurso() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		add(mainPanel);
		
		JTable tablaCursos = new JTable();
		
		DefaultTableModel modeloTablaCursos = new DefaultTableModel();
		
		Object[] titulos = { "Carrera", "Materia", "Profesor", "Dia", "Turno" };

		modeloTablaCursos.setColumnIdentifiers(titulos);

		for (CursoToView cur : controlador.getCursosDisponibles()) {
			Object[] fila = new Object[5];
			fila[0] = cur.getCarrera();
			fila[1] = cur.getMateria();
			fila[2] = cur.getProfesor();
			fila[3] = cur.getDia();
			fila[4] = cur.getTurno();
			modeloTablaCursos.addRow(fila);
		}

		tablaCursos.setModel(modeloTablaCursos);

		JScrollPane scrollTable = new JScrollPane(tablaCursos);
		
		mainPanel.add(scrollTable, BorderLayout.NORTH);
		
		Container cont = new Container();
		cont.setLayout(new GridLayout(1,2, 5, 5));
		
		JLabel legajoLabel = new JLabel("Ingrese Legajo: ");
		JTextField legajoField = new JTextField(10);
		
		cont.add(legajoLabel);
		cont.add(legajoField);
		
		mainPanel.add(cont, BorderLayout.CENTER);
		
		JButton aceptar = new JButton("Aceptar");
		
		mainPanel.add(aceptar, BorderLayout.SOUTH);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				int selectedRow = tablaCursos.getSelectedRow();
				
				if(selectedRow >= 0) {
					CarreraToView carrera = (CarreraToView) tablaCursos.getValueAt(selectedRow, 0);
					MateriaToView materia = (MateriaToView) tablaCursos.getValueAt(selectedRow, 1);
					int legajoAlumno = Integer.parseInt(legajoField.getText());
					
					try {
						controlador.inscribirAlumnoEnCurso(legajoAlumno, carrera.getCodigo(), materia.getCodigo(), materia.getDescripcion());
						
						JOptionPane.showMessageDialog(null, "Se ha inscripto en el curso", "Exito", JOptionPane.INFORMATION_MESSAGE);
						
					} catch (NoExisteAlumnoException | NoExisteCarreraException | NoExisteMateriaException
							| NoPudoInscribirseException | NoexisteCursoException e1) {
						
						JOptionPane.showMessageDialog(null, "No se ha inscripto en el curso", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
					dispose();
					
				}
				
			}
		});
		
		pack();
	}

}
