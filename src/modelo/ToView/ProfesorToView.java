package modelo.ToView;

public class ProfesorToView {
	
	private String nombre;
	private String apellido;
	
	public ProfesorToView(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return nombre + " " +apellido;
	} 
	
	

}
