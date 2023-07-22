package vista;

import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controlador.InstitutoController;
import modelo.ToView.MateriaToView;
import modelo.excepciones.NoExisteMateriaException;
import modelo.excepciones.NoExisteProfesor;

public class VentanaAsignarMateriaProfesor extends JFrame{
	
	InstitutoController controlador = new InstitutoController();

	public VentanaAsignarMateriaProfesor() {
		super("Ventana Asignar Materia Profesor");
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel(new GridLayout(3,1, 5, 5));
		add(panel);
		
		Container cont = new Container();
		cont.setLayout(new GridLayout(1,2));
		
		
		JTable tablaMaterias = new JTable();
		
		DefaultTableModel modeloTablaMaterias = new DefaultTableModel();
		
		Object[] titulos = {"Codigo", "Descripcion"};
		
		modeloTablaMaterias.setColumnIdentifiers(titulos);
		
		for(MateriaToView materia : controlador.getMateriasExistentes()) {
			Object[] fila = new Object[2];
			fila[0] = materia.getCodigo();
			fila[1] = materia.getDescripcion();
			modeloTablaMaterias.addRow(fila);			
		}
		
		tablaMaterias.setModel(modeloTablaMaterias);
		
		JScrollPane scrollTable = new JScrollPane(tablaMaterias);
		
		panel.add(scrollTable);
		
		
		JLabel legajoLabel = new JLabel("Ingrese nro Legajo");
		
		JTextField legajoField = new JTextField(10);
		
		
		cont.add(legajoLabel);
		cont.add(legajoField);
		panel.add(cont);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int nroLegajoProfesor = Integer.parseInt(legajoField.getText());
				
				int rowSelected = tablaMaterias.getSelectedRow();
				
				if(rowSelected >= 0) {
					
					String codigo = (String) tablaMaterias.getValueAt(rowSelected, 0);
					String descripcion = (String) tablaMaterias.getValueAt(rowSelected, 1);
					
					try {
						controlador.agregarMateriaAProfesor(nroLegajoProfesor, codigo, descripcion);
						JOptionPane.showMessageDialog(null, "Se ha asignado la materia seleccionada");
					} catch (NoExisteProfesor | NoExisteMateriaException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "No se ha podido completar", "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
					
					dispose();
					
				}
				
				
				
			}
		});
		
		panel.add(aceptar);
		
		
		pack();
		
	}
	
	

}
