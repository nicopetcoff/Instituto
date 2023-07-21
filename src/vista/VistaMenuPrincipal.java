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
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
	}

}