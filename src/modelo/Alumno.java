package modelo;

import java.util.ArrayList;

import modelo.ToView.AlumnoToView;
import modelo.excepciones.NoPudoInscribirseException;

public class Alumno extends PersonaInstituto {

	private ArrayList<Curso> cursosInscripto;

	public Alumno(String nombre, String apellido, String documento) {
		super(nombre, apellido, documento);
		this.cursosInscripto = new ArrayList<>();
	}

	public void inscribirseEnCurso(Curso curso) throws NoPudoInscribirseException {
		if (puedeIncribirse(curso)) {
			cursosInscripto.add(curso);
			curso.agregarAlumno(this); // agrego el alumno al curso tambien
		}
		throw new NoPudoInscribirseException("No pudo iscribise");
	}

	private boolean puedeIncribirse(Curso curso) {

		for (Curso c : cursosInscripto) {
			if (!c.getDia().equals(curso.getDia()) || !c.getTurno().equals(curso.getTurno())) {
				return false;
			}

		}
		return true;
	}

	@Override
	public int getLegajo() {
		return this.legajo;
	}

	public AlumnoToView toView() {
		return (new AlumnoToView(this.nombre, this.apellido, this.documento, this.legajo));
	}

}
