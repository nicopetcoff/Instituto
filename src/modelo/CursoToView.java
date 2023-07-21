package modelo;

import java.util.ArrayList;

import modelo.Enum.Dia;
import modelo.Enum.Turno;

public class CursoToView {

	private Carrera carrera;
	private Materia materia;
	private ArrayList<Alumno> alumnos;
	private Profesor profesor;
	private Turno turno;
	private Dia dia;

	public CursoToView(Carrera carrera, Materia materia, Profesor profesor, Turno turno, Dia dia) {
		this.carrera = carrera;
		this.materia = materia;
		this.profesor = profesor;
		this.turno = turno;
		this.dia = dia;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public Materia getMateria() {
		return materia;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public Turno getTurno() {
		return turno;
	}

	public Dia getDia() {
		return dia;
	}

}
