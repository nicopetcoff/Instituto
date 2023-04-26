package Clases;
import java.util.*;

import Enum.*;

/**
 * 
 */
public class Curso {
	
	private String idCurso;
    private Materia materia;
    private Profesor profesor;
    private Dia dia;
    private Turno turno;
    private ArrayList<Alumno> alumnosInscriptos;
    
	public Curso(String idCurso, Materia materia, Profesor profesor, Dia dia, Turno turno) {
		this.idCurso= idCurso;
		this.materia = materia;
		this.profesor = profesor;
		this.dia = dia;
		this.turno = turno;
		this.alumnosInscriptos= new ArrayList<>();
		
	}

	@Override
	public String toString() {
		return "Curso [materia=" + materia + ", profesor=" + profesor + ", dia=" + dia + ", turno=" + turno + "]";
	}

	public String getIdCurso() {
		return idCurso;
	}
	
	public void agregarAlumno(Alumno n) {
		alumnosInscriptos.add(n);
	}
	
	public void AlumnosEnCurso() {
		for(Alumno a: alumnosInscriptos)
			System.out.println(a);
	}
	
}