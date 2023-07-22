package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import controlador.InstitutoController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import modelo.ToView.MateriaToView;
import modelo.excepciones.NoExisteCarreraException;
import modelo.excepciones.NoExisteMateriaException;
import modelo.excepciones.NoExisteProfesor;

public class VentanaAsignarMateriasCarrera extends JFrame {

	InstitutoController controlador = new InstitutoController();

	public VentanaAsignarMateriasCarrera() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
		add(panel);

		Container cont = new Container();
		cont.setLayout(new GridLayout(1, 2));

		JTable tablaMaterias = new JTable();

		DefaultTableModel modeloTablaMaterias = new DefaultTableModel();

		Object[] titulos = { "Codigo", "Descripcion" };

		modeloTablaMaterias.setColumnIdentifiers(titulos);

		for (MateriaToView materia : controlador.getMateriasExistentes()) {
			Object[] fila = new Object[2];
			fila[0] = materia.getCodigo();
			fila[1] = materia.getDescripcion();
			modeloTablaMaterias.addRow(fila);
		}

		tablaMaterias.setModel(modeloTablaMaterias);

		JScrollPane scrollPanel = new JScrollPane(tablaMaterias);

		panel.add(scrollPanel);

		JLabel codigoCarreraLabel = new JLabel("Ingrese codigo Carrera: ");
		JTextField codigoCarreraField = new JTextField(10);

		cont.add(codigoCarreraField);
		cont.add(codigoCarreraField);
		panel.add(cont);

		JButton aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int codigoCarrera = Integer.parseInt(codigoCarreraField.getText());

				int rowSelected = tablaMaterias.getSelectedRow();

				if (rowSelected >= 0) {

					String codigoMateria = (String) tablaMaterias.getValueAt(rowSelected, 0);
					String descripcionMateria = (String) tablaMaterias.getValueAt(rowSelected, 1);

					try {
						controlador.agregarMateriaExistenteACarrera(codigoCarrera, codigoMateria, descripcionMateria);
						JOptionPane.showMessageDialog(null, "Se ha asginado la materia");
					} catch (NoExisteCarreraException | NoExisteMateriaException e1) {
						// TODO Auto-generated catch block
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
