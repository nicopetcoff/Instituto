package Clases;
import java.util.*;

import ClaseAbstracta.*;

/**
 * 
 */
public class Profesor extends PersonaAcademica {
    
	private ArrayList<Materia> materiasQueDicta;


 
	
	public Profesor(String nombre, String tipoDocumento, int nroDocumento, int lu) {
		super(nombre, tipoDocumento, nroDocumento, lu);		
	}



	public String toString() {
		return "Profesor [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombre=" + nombre
				+ ", lu=" + lu + "]";
	}



	public int getLu() {
		return lu;
	}
	
	





}