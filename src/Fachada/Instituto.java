package Fachada;


import java.util.ArrayList;

import Clases.*;
import Enum.Dia;
import Enum.Turno;

public class Instituto {
	
    private ArrayList<Carrera> carreras;
    private ArrayList<Profesor> profesores;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Curso> cursos;

    public Instituto() {
        carreras = new ArrayList<>();
        profesores = new ArrayList<>();
        alumnos = new ArrayList<>();
        cursos = new ArrayList<>();
       
        // Agrego carreras y materias
        Carrera c1 = new Carrera("c1", "ingenieria");
        Carrera c2 = new Carrera("c2", "fisica");
        carreras.add(c1);
        carreras.add(c2);       

        c1.agregarMaterias(new Materia("m1","matematica"));
        c1.agregarMaterias(new Materia("m2", "filosfia"));
        
        c2.agregarMaterias(new Materia("m1","matematica"));
        c2.agregarMaterias(new Materia("m2", "lengua"));
        
        //Agrego profesores
        
        Profesor p1 = new Profesor("carlos","dni", 1234, 1);
        Profesor p2 = new Profesor("pedro","dni", 56789, 2);
        
        profesores.add(p1);
        profesores.add(p2);
        
        
    }
	
	public void crearCurso(String idCurso,Materia materia, Profesor profesor, Dia dia, Turno turno){
		
		Curso c = new Curso(idCurso,materia, profesor, dia, turno);
		
		cursos.add(c);		
	}
	
	
	public void mostrarCarrerasActivas() {
		
		for(Carrera c: carreras) {
			System.out.println(c);
		}
		
	}
	
	public void mostrarProfesores() {
		for(Profesor f:profesores)
			System.out.println(f);
	}
	
	public Profesor soyElprofesor(int lu) {
		
		for(Profesor f:profesores)
			if (f.getLu()== lu) {
				return f;
			}
			
		return null;
		
	}
	
	public void mostrarCursos() {
		for (Curso c : cursos)
			System.out.println(c);
	}
	
	public Curso soyEseCurso(String idCurso) {
		for(Curso c: cursos) {
			if (c.getIdCurso().equals(idCurso)) {
				return c;
			}
		}
		return null;
		
	}

    public void inscribirAlumno(Curso cur, Alumno alumno) {
        cur.agregarAlumno(alumno);
    }
    


	public Carrera soyEsaCarrera(String codigoElejido) {
		for(Carrera c: carreras) {
			if(c.getCodigo().equals(codigoElejido))
				return c;
		}
		return null;
	}
	

}
