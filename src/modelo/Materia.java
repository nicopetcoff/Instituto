package modelo;

import modelo.ToView.MateriaToView;

public class Materia {

	private String codigo;
	private String descripcion;

	public Materia(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public MateriaToView ToView() {
		return (new MateriaToView(this.codigo, this.descripcion));
	}

	public String getCodigoMateria() {
		return this.codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}
