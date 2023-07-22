package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.InstitutoController;

public class VentanaCrearMateria extends JFrame{
	
	InstitutoController controlador = new InstitutoController();
	
	public VentanaCrearMateria() {
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
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
