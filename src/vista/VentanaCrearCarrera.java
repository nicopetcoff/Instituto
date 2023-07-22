package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.InstitutoController;

public class VentanaCrearCarrera extends JFrame{
	
	InstitutoController controlador = new InstitutoController();
	
	public VentanaCrearCarrera() {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel nombreLabel = new JLabel("Nombre de la carrera:");
        JTextField nombreTextField = new JTextField();

        JLabel descripcionLabel = new JLabel("Descripción de la carrera:");
        JTextArea descripcionTextArea = new JTextArea();

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String nombre = nombreTextField.getText();
	                String descripcion = descripcionTextArea.getText();

	                //
	                controlador.altaCarrera(nombre, descripcion, null);
				
			}
		});
        panel.add(nombreLabel);
        panel.add(nombreTextField);
        panel.add(descripcionLabel);
        panel.add(new JScrollPane(descripcionTextArea));
        panel.add(btnEnviar);

        add(panel);
        
        pack();
	}

}
