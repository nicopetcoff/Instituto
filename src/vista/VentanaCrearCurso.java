package vista;

import javax.swing.*;

public class VentanaCrearCurso extends JFrame{
	
	public VentanaCrearCurso() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		add(panel);
		
		// carrera, materia, profesor, dia, turno
		//int codigoCarrera, String codigoMateria, String descripcionMateria, int legajoProfesor
		
		JLabel codigoCarreraLabel = new JLabel("Ingrese codigo de la carrera: ");
		JTextField codigoCarreraField = new JTextField(10);
		
		
		
		pack();
	}

}
