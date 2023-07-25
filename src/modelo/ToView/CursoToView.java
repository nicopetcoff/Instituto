package modelo.ToView;

import java.util.ArrayList;

import modelo.Alumno;
import modelo.Carrera;
import modelo.Materia;
import modelo.Profesor;
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

	@Override
	public String toString() {
		return "CursoToView [carrera=" + carrera + ", materia=" + materia + ", alumnos=" + alumnos + ", profesor="
				+ profesor + ", turno=" + turno + ", dia=" + dia + "]";
	}

	public CarreraToView getCarrera() {
		return carrera.toView();
	}

	public MateriaToView getMateria() {
		return materia.ToView();
	}

	public ProfesorToView getProfesor() {
		return profesor.toView();
	}

	public Turno getTurno() {
		return turno;
	}

	public Dia getDia() {
		return dia;
	}

}
