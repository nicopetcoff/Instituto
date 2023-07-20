package modelo.ToView;

public class MateriaToView {
	
	private String codigo;
	private String descripcion;

	public MateriaToView(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "MateriaToView [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	

}
