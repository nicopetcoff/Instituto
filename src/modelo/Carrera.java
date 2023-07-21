package modelo;

import java.util.ArrayList;

import modelo.ToView.CarreraToView;
import modelo.ToView.MateriaToView;

public class Carrera {

	private int codigo;
	private static int codigoSiguiente = 1;
	private String descripcion;
	private ArrayList<Materia> materiasCarrera;
	private boolean activa;

	public Carrera(String descripcion, ArrayList<Materia> materiasCarrera) {
		this.codigo = codigoSiguiente;
		codigoSiguiente++;
		this.descripcion = descripcion;
		this.materiasCarrera = new ArrayList<>();
		this.activa = true;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public boolean getActivo() {
		return this.activa;
	}

	public Materia agregarMateriaNueva(String codigoMateria, String descripcionMateria) {
		Materia m = new Materia(codigoMateria, descripcionMateria);
		this.materiasCarrera.add(new Materia(codigoMateria, descripcionMateria));
		return m;
	}

	public void agregarMateria(Materia m) {
		this.materiasCarrera.add(m);
	}

	public ArrayList<MateriaToView> getMateriasCarrera() {
		ArrayList<MateriaToView> materiasToView = new ArrayList<>();

		for (Materia m : materiasCarrera) {
			materiasToView.add(m.ToView());
		}

		return materiasToView;
	}

	public CarreraToView carreraToView() {

		return (new CarreraToView(this.descripcion, this.materiasCarrera));

	}

	public String getNombre() {
		return this.descripcion;
	}

}
