package modelo;

public class AlumnoToView {

	private String nombre;
	private String apellido;
	private String dni;
	private int legajo;

	public AlumnoToView(String nombre, String apellido, String dni, int legajo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}

	public int getLegajo() {
		return legajo;
	}

}
