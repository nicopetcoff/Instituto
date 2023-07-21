package modelo;

import java.util.ArrayList;

import modelo.Enum.Dia;
import modelo.Enum.Turno;
import modelo.ToView.CursoToView;
import modelo.excepciones.NoDictaMateriaException;
import modelo.excepciones.ProfesorNoDisponibleException;

public class Curso {

	private Carrera carrera;
	private Materia materia;
	private ArrayList<Alumno> alumnos;
	private Profesor profesor;
	private Turno turno;
	private Dia dia;

	public Curso(Carrera carrera, Materia materia, Profesor profesor, Dia dia, Turno turno)
			throws ProfesorNoDisponibleException, NoDictaMateriaException {
		this.carrera = carrera;
		this.materia = materia;
		this.profesor = validarHorario(profesor);
		this.alumnos = new ArrayList<>();
		this.dia = dia;
		this.turno = turno;
	}

	private Profesor validarHorario(Profesor profesor2) throws ProfesorNoDisponibleException, NoDictaMateriaException {

		if (profesor2.validarHorario(this)) {
			return profesor2;
		}
		throw new ProfesorNoDisponibleException("No puede dar el curso");
	}

	public void agregarAlumno(Alumno a) {
		alumnos.add(a);
	}

	public Dia getDia() {
		return this.dia;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public Materia getMateria() {
		return materia;
	}

	public Carrera getCarrera() {
		return this.carrera;
	}

	public CursoToView toView() {
		return (new CursoToView(this.carrera, this.materia, this.profesor, this.turno, this.dia));
	}

	public ArrayList<Alumno> getAlumnos() {
		return this.alumnos;
	}

}
