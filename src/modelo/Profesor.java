package modelo;

import java.util.ArrayList;

public class Profesor extends PersonaInstituto{
	
	private ArrayList<Curso> cursos;
	private ArrayList <Materia> materias;
	
	public Profesor(String nombre, String apellido, String documento, ArrayList<Curso> cursos, ArrayList<Materia> materias) {
		super(nombre, apellido, documento);
		this.cursos = new ArrayList<>();
		this.materias = new ArrayList<>();
	}

	public boolean validarHorario(Curso curso) {
		for(Curso c : cursos) {
			if (c.getDia().equals(curso.getDia()) ) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	

}
