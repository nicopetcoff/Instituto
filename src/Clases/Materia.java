package Clases;
import java.util.*;

/**
 * 
 */
public class Materia {
	
    private String codigo;
    private String descripcion;

    public Materia(String codigo, String descripcion) {
		
		this.codigo = codigo;
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Materia [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}


	public String getCodigo() {
		return codigo;
	}  
    

}