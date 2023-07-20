package modelo;

import java.util.ArrayList;

import modelo.Enum.Dia;
import modelo.Enum.Turno;

public class Curso {

	private Carrera carrera;
	private Materia materia;
	private ArrayList<Alumno> alumnos;
	private Profesor profesor;
	private Turno turno;
	private Dia dia;
	
	
	public Curso(Carrera carrera, Materia materia, Profesor profesor) {
		this.carrera = carrera;
		this.materia = materia;
		this.profesor = validarHorario(profesor);
		this.alumnos = new ArrayList<>();
	}


	private Profesor validarHorario(Profesor profesor2) {
		
		if (profesor2.validarHorario(this)) {
			return profesor2;
		}
		
		return null;
	}


	public Dia getDia() {
		return this.dia;
	}


	public Turno getTurno() {
		return this.turno;
	}
	

}
