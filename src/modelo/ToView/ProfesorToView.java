package modelo.ToView;

public class ProfesorToView {

	private String nombre;
	private String apellido;
	private int legajo;

	public ProfesorToView(String nombre, String apellido, int legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getLegajo() {
		return legajo;
	}
	
	

}
