package ClaseAbstracta;

import java.util.*;

/**
 * 
 */
public abstract class PersonaAcademica {

    protected String nombre;
    protected String tipoDocumento;
    protected int nroDocumento;
    protected int lu;
    
	public PersonaAcademica(String nombre, String tipoDocumento, int nroDocumento, int lu) {
		this.nombre = nombre;
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.lu = lu;
	}

    



}