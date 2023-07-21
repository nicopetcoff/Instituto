package modelo.ToView;

import java.util.ArrayList;

import modelo.Materia;

public class CarreraToView {
	private String descripcion;
	private ArrayList<Materia> materiasCarrera;

	public CarreraToView(String descripcion, ArrayList<Materia> materiasCarrera) {

		this.descripcion = descripcion;
		this.materiasCarrera = new ArrayList<>();

	}

	@Override
	public String toString() {
		return "CarreraToView [descripcion=" + descripcion + ", materiasCarrera=" + materiasCarrera + "]";
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
