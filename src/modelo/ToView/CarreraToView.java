package modelo.ToView;

import java.util.ArrayList;

import modelo.Materia;

public class CarreraToView {
	
	private String nombre;
	private int codigoCarrera;
	private String descripcion;
	private ArrayList<Materia> materiasCarrera;

	public CarreraToView(String nombre ,int codigoCarrera, String descripcion, ArrayList<Materia> materiasCarrera) {
		
		this.nombre = nombre;
		this.codigoCarrera = codigoCarrera;
		this.descripcion = descripcion;
		this.materiasCarrera = new ArrayList<>();

	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public int getCodigo() {
		return this.codigoCarrera;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public ArrayList<MateriaToView> getMateriasCarrera() {

		ArrayList<MateriaToView> mToView = new ArrayList<>();

		for (Materia m : materiasCarrera) {
			mToView.add(m.ToView());
		}
		return mToView;
	}

}
