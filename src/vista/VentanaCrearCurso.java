package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;

import controlador.InstitutoController;
import modelo.ToView.CarreraToView;
import modelo.ToView.MateriaToView;
import modelo.ToView.ProfesorToView;
import modelo.excepciones.NoDictaMateriaException;
import modelo.excepciones.NoExisteCarreraException;
import modelo.excepciones.NoExisteDia;
import modelo.excepciones.NoExisteHorario;
import modelo.excepciones.NoExisteMateriaException;
import modelo.excepciones.NoExisteProfesor;
import modelo.excepciones.ProfesorNoDisponibleException;

public class VentanaCrearCurso extends JFrame{
	
	InstitutoController controlador = new InstitutoController();
	
	private int codigoCarrera, legajoProfesor;
	private String codigoMateria, descripcionMateria, dia, turno;
	
	public VentanaCrearCurso() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		add(mainPanel);
		
		CardLayout cardLayout = new CardLayout();		
		mainPanel.setLayout(cardLayout);
		
		JPanel panelCarrera = new JPanel(new BorderLayout());
		
		JTable tablaCarrera = new JTable();
		mainPanel.add(panelCarrera);
		
		DefaultTableModel modeloTablaCarreras = new DefaultTableModel();
		
		Object[] titulos = {"Nombre", "Codigo","Desscripcion"};
		
		modeloTablaCarreras.setColumnIdentifiers(titulos);
		
		for(CarreraToView carrera : controlador.getCarrerasExistentes()) {
			
			Object[] fila = new Object[3];
			fila[0] = carrera.getNombre();
			fila[1] = carrera.getCodigo();
			fila[2] = carrera.getDescripcion();
			modeloTablaCarreras.addRow(fila);
		}
		
		tablaCarrera.setModel(modeloTablaCarreras);
		
		JScrollPane scrollPane = new JScrollPane(tablaCarrera);
		
		panelCarrera.add(scrollPane, BorderLayout.CENTER);
		
		JButton seleccionarCarrera = new JButton("Seleccionar Carrera");
		panelCarrera.add(seleccionarCarrera, BorderLayout.SOUTH);
		
		JPanel panelMateria = new JPanel(new BorderLayout());
		mainPanel.add(panelMateria);
		
		seleccionarCarrera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int rowSelected = tablaCarrera.getSelectedRow();
				
				if(rowSelected >= 0) {
					codigoCarrera = (int) tablaCarrera.getValueAt(rowSelected, 1);			
					
				}
				cardLayout.next(mainPanel);
				
			}
		});
		
		//---------------------------------------------------------------------------
		
		JTable tablaMateria = new JTable();
		DefaultTableModel modeloTablaMaterias = new DefaultTableModel();
		
		Object[] titulos1 = {"Codigo", "Descripcion"};
		
		modeloTablaMaterias.setColumnIdentifiers(titulos1);
		
		for(MateriaToView materia : controlador.getMateriasExistentes()) {
			Object[] fila1 = new Object[2];
			fila1[0] = materia.getCodigo();
			fila1[1] = materia.getDescripcion();
			modeloTablaMaterias.addRow(fila1);
			
		}
		
		tablaMateria.setModel(modeloTablaMaterias);
		
		JScrollPane scrollPane1 = new JScrollPane(tablaMateria);
		
		panelMateria.add(scrollPane1, BorderLayout.CENTER);
		
		JButton seleccionarMateria = new JButton("Seleccionar Materia");
		panelMateria.add(seleccionarMateria, BorderLayout.SOUTH);
		
		JPanel panelProfesorDiaTurno = new JPanel(new BorderLayout());
		mainPanel.add(panelProfesorDiaTurno);
		
		seleccionarMateria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int rowSelected = tablaMateria.getSelectedRow();
				
				if(rowSelected >= 0) {
					codigoMateria = (String) tablaMateria.getValueAt(rowSelected, 0);
					descripcionMateria = (String) tablaMateria.getValueAt(rowSelected, 1);
				}
				
				cardLayout.next(mainPanel);
				
			}
		});
		
		//--------------------------------------------------------------------------------------------------------------
		
		JTable tablaProfesor = new JTable();
		DefaultTableModel modeloTablaProfesor = new DefaultTableModel();
		
		Object[] titulos2 = {"Nombre", "Apellido", "Legajo"};
		modeloTablaProfesor.setColumnIdentifiers(titulos2);
		
		for(ProfesorToView profesor : controlador.getProfesoresDisponibles()) {
			Object[] fila2 = new Object[3];
			fila2[0] = profesor.getNombre();
			fila2[1] = profesor.getApellido();
			fila2[2] = profesor.getLegajo();
			modeloTablaProfesor.addRow(fila2);
		}
		
		tablaProfesor.setModel(modeloTablaProfesor);
		
		JScrollPane scrollPane2 = new JScrollPane(tablaProfesor);
		
		panelProfesorDiaTurno.add(scrollPane2, BorderLayout.NORTH);
		
		Container cont = new Container();
		cont.setLayout(new GridLayout(2,2, 5,5));
		
		JLabel dialabel = new JLabel("Seleccione DIA: ");
		JComboBox comboDia = new JComboBox<String>();
		comboDia.addItem("LUNES");
		comboDia.addItem("MARTES");
		comboDia.addItem("MIERCOLES");
		comboDia.addItem("JUEVES");
		comboDia.addItem("VIERNES");
		
		JLabel turnoLabel = new JLabel("Seleccione Turno: ");
		JComboBox comboTurno = new JComboBox<String>();
		
		comboTurno.addItem("MAÑANA");
		comboTurno.addItem("TARDE");
		comboTurno.addItem("NOCHE");
		
		cont.add(dialabel);
		cont.add(comboDia);
		cont.add(turnoLabel);
		cont.add(comboTurno);
		
		panelProfesorDiaTurno.add(cont, BorderLayout.CENTER);
		
		JButton aceptar = new JButton("Aceptar");
		panelProfesorDiaTurno.add(aceptar, BorderLayout.SOUTH);
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int selectedRow = tablaProfesor.getSelectedRow();
				
				if(selectedRow >= 0) {
					legajoProfesor = (int) tablaProfesor.getValueAt(selectedRow, 2);
				}
				
				dia = (String) comboDia.getSelectedItem();
				turno = (String) comboTurno.getSelectedItem();
				
				try {
					controlador.altaCurso(codigoCarrera, codigoMateria, descripcionMateria, legajoProfesor, turno, dia);
					JOptionPane.showMessageDialog(null, "Se ha creado el curso", "Exito", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (ProfesorNoDisponibleException | NoDictaMateriaException | NoExisteCarreraException
						| NoExisteMateriaException | NoExisteProfesor | NoExisteHorario | NoExisteDia e1) {
					// TODO Auto-generated catch block
					
					JOptionPane.showMessageDialog(null, "No se ha creado el curso", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				dispose();
				
				
			}
		});		
		
		pack();
	}

}
