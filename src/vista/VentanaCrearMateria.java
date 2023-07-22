package vista;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.InstitutoController;

public class VentanaCrearMateria extends JFrame{
	
	InstitutoController controlador = new InstitutoController();
	
	public VentanaCrearMateria() {
		setLocationRelativeTo(null);
		JPanel panel = new JPanel(new GridLayout(3,2,10,10));
		add(panel);
		
		JLabel codigoMateriaLabel = new JLabel("Ingrese codigo: ");
		JTextField codigoMateriaField = new JTextField(10);

		JLabel descripcionLabel = new JLabel("Ingrese descripcion: ");
		JTextField descipcionField = new JTextField(10);


		JButton aceptar = new JButton("Aceptar");

		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String codigo = codigoMateriaField.getText();
				String descripcion = descipcionField.getText();
				
				
				controlador.crearMateriaNueva(codigo, descripcion);
				
				JOptionPane.showMessageDialog(null, "Se ha creador la materia");

				dispose();
			}
		});

		panel.add(codigoMateriaLabel);
		panel.add(codigoMateriaField);
		panel.add(descripcionLabel);
		panel.add(descipcionField);
		panel.add(aceptar);
		
		pack();
		
	}
	
}
