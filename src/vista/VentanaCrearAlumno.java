package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.InstitutoController;

public class VentanaCrearAlumno extends JFrame{
	
	InstitutoController controlador = new InstitutoController();
	
	public VentanaCrearAlumno() {
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		

		JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
		add(panel);

		JLabel nombreLabel = new JLabel("Ingrese nombre: ");
		JTextField nombreField = new JTextField(10);

		JLabel apellidoLabel = new JLabel("Ingrese apellido: ");
		JTextField apellidoField = new JTextField(10);

		JLabel dniLabel = new JLabel("Ingrese su DNI: ");
		JTextField dniField = new JTextField(10);

		JButton aceptar = new JButton("Aceptar");
		

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String nombre = nombreField.getText();
				String apellido = apellidoField.getText();
				String dni = dniField.getText();

				int nroLegajoAlumno = controlador.crearAlumno(nombre, apellido, dni);

				JOptionPane.showMessageDialog(null, "Se ha registrado Alumno con Legajo N°: " + nroLegajoAlumno, "",
						JOptionPane.INFORMATION_MESSAGE);
				dispose();

			}
		});		
		

		panel.add(nombreLabel);
		panel.add(nombreField);
		panel.add(apellidoLabel);
		panel.add(apellidoField);
		panel.add(dniLabel);
		panel.add(dniField);
		panel.add(aceptar);
		
		pack();
		
	}
}
