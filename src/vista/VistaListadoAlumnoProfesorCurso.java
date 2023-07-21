package vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SpringLayout.Constraints;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controlador.InstitutoController;
import modelo.ToView.CursoToView;

public class VistaListadoAlumnoProfesorCurso extends JFrame {

    InstitutoController controlador = new InstitutoController();

    public VistaListadoAlumnoProfesorCurso() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        JPanel cont1 = new JPanel(new BorderLayout()); 
        panel.add(cont1, BorderLayout.CENTER);

        JTable tablaCursos = new JTable();
        DefaultTableModel modeloTablaCursos = new DefaultTableModel();

        Object[] titulos = {"Carrera", "Materia", "Profesor", "Dia", "Turno"};

        modeloTablaCursos.setColumnIdentifiers(titulos);

        for (CursoToView cur : controlador.getCursosDisponibles()) {
            Object[] fila = new Object[5];
            fila[0] = cur.getCarrera();
            fila[1] = cur.getMateria();
            fila[2] = cur.getProfesor();
            fila[3] = cur.getDia();
            fila[4] = cur.getTurno();
            modeloTablaCursos.addRow(fila);
        }

        tablaCursos.setModel(modeloTablaCursos);

        JScrollPane scrollTable = new JScrollPane(tablaCursos);
        cont1.add(scrollTable, BorderLayout.CENTER); 

        JButton tomarElejido = new JButton("Seleccionar uno");
        cont1.add(tomarElejido, BorderLayout.SOUTH); 

        tomarElejido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	int filaElejida = tablaCursos.getSelectedRow();
            	
            	//controlador.getAlumnosDelCurso();
            	
            	
            }
        });

        pack(); 
    }

}
