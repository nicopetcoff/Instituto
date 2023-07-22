package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.InstitutoController;

public class VentanaAgregarProfesor extends JFrame {

	InstitutoController controlador = new InstitutoController();

	public VentanaAgregarProfesor() {
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

				int nroLegajoProfesor = controlador.agregarProfesor(nombre, apellido, dni);

				JOptionPane.showMessageDialog(null, "Se ha registrago profesor con Legajo N°: " + nroLegajoProfesor, "",
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
