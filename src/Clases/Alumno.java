package Clases;
import java.util.*;

import ClaseAbstracta.*;

/**
 * 
 */
public class Alumno extends PersonaAcademica {
	
	private ArrayList<Curso> cursosInscripto;

    public Alumno(String nombre, String tipoDocumento, int nroDocumento, int lu) {
		super(nombre, tipoDocumento, nroDocumento, lu);
		this.cursosInscripto = new ArrayList<>();
    }

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento
				+ ", lu=" + lu + "]";
	}

	public void agregarCurso(Curso cur) {
		cursosInscripto.add(cur);		
	}     




}