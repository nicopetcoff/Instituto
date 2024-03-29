package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VistaMenuPrincipal extends JFrame {

	public VistaMenuPrincipal() {

		super("Menu Principal");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setSize(500, 400);

		JPanel panel = new JPanel(new BorderLayout());
		add(panel);

		JLabel titulo = new JLabel("Bienvenido al Instituto", SwingConstants.CENTER);

		panel.add(titulo, BorderLayout.NORTH);

		Container cont = new Container();
		cont.setLayout(new FlowLayout());
		panel.add(cont);

		JButton verListadoAlumnosYProfesorCurso = new JButton(
				"Imprimir listado de alumnos y profesor para un curso seleccionado");
		cont.add(verListadoAlumnosYProfesorCurso);

		verListadoAlumnosYProfesorCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VistaListadoAlumnoProfesorCurso vista = new VistaListadoAlumnoProfesorCurso();
				vista.setVisible(true);
			}
		});

		JButton agregarProfesor = new JButton("Agregar Profesor nuevo");
		cont.add(agregarProfesor);

		agregarProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VentanaAgregarProfesor ventana = new VentanaAgregarProfesor();
				ventana.setVisible(true);

			}
		});
		
		JButton crearMateria = new JButton("Crear Materia");
		cont.add(crearMateria);
		
		crearMateria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaCrearMateria ventana = new VentanaCrearMateria();
				ventana.setVisible (true);
			}
		});
		
		JButton asignarMateriaProfesor = new JButton("Asignar Materia a Profesor");
		cont.add(asignarMateriaProfesor);
		
		asignarMateriaProfesor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaAsignarMateriaProfesor ventana = new VentanaAsignarMateriaProfesor();
				ventana.setVisible(true);
				
			}
		});
		
		JButton crearCarrera = new JButton("Crear Carrera");
		cont.add(crearCarrera);
		
		crearCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaCrearCarrera ventana = new VentanaCrearCarrera();
				ventana.setVisible(true);
				
			}
		});
		
		JButton asignarMateriasCarrera = new JButton("Asignar materias a la carrera");
		cont.add(asignarMateriasCarrera);
		
		asignarMateriasCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaAsignarMateriasCarrera ventana= new VentanaAsignarMateriasCarrera();
				ventana.setVisible(true);
				
			}
		});
		
		JButton crearCurso = new JButton("Crear Curso");
		cont.add(crearCurso);
		crearCurso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				VentanaCrearCurso ventana = new VentanaCrearCurso();
				ventana.setVisible(true);
				
			}
		});
		
		JButton crearAlumno = new JButton("Crear Alumno");
		cont.add(crearAlumno);
		
		crearAlumno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaCrearAlumno ventana = new VentanaCrearAlumno();
				ventana.setVisible(true);
				
			}
		});
		
		JButton inscribirAlumnoEnCurso = new JButton("Inscribir Alumno en Curso");
		cont.add(inscribirAlumnoEnCurso);
		inscribirAlumnoEnCurso.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				VentanaInscribirAlumnoEnCurso ventana = new VentanaInscribirAlumnoEnCurso();
				ventana.setVisible(true);
				
			}
		});

		//pack();
	}

}
