package modelo;

import java.util.ArrayList;

import modelo.excepciones.NoDictaMateriaException;

public class Profesor extends PersonaInstituto {

	private ArrayList<Curso> cursos;
	private ArrayList<Materia> materiasDictadas;

	public Profesor(String nombre, String apellido, String documento) {
		super(nombre, apellido, documento);
		this.cursos = new ArrayList<>();
		this.materiasDictadas = new ArrayList<>();
	}

	public boolean validarHorario(Curso curso) throws NoDictaMateriaException {
		for (Curso c : cursos) {
			if (c.getDia().equals(curso.getDia())) {
				return false;
			}
		}
		agregarCurso(curso); // quiere decir que pudo
		return true;
	}

	private void agregarCurso(Curso curso) throws NoDictaMateriaException {

		int contador = 0;

		for (Materia m : materiasDictadas) {
			if (curso.getMateria().equals(m)) {
				cursos.add(curso);
				contador++;
			}
		}

		if (contador == 0) {
			throw new NoDictaMateriaException("No dicta la materia");
		}
	}

	@Override
	public int getLegajo() {
		return this.legajo;
	}

}
