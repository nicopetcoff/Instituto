package modelo;

public abstract class PersonaInstituto {
	protected String nombre;
	protected String apellido;
	protected String documento;
	protected int legajo;
	protected static int legajoSiguiente = 1;
	
	public PersonaInstituto(String nombre, String apellido, String documento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.legajo = legajoSiguiente;
		legajoSiguiente++;
	}
	
	

}
