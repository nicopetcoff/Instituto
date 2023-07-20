package modelo;

import java.util.ArrayList;

import modelo.ToView.MateriaToView;
import modelo.excepciones.NoExisteCarreraException;
import modelo.excepciones.NoExisteMateriaException;

public class Instituto {

	private static Instituto instance;
	private ArrayList<Carrera> carreras;
	private ArrayList<Materia> materias;
	private ArrayList<Curso> cursos;

	private Instituto() {
		this.carreras = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.cursos = new ArrayList<>();

	}

	public static Instituto getInstance() {
		if (instance == null) {
			instance = new Instituto();
		}

		return instance;
	}

	public void altaCarrera(String descripcion, ArrayList<Materia> materias1) {
		Carrera c = new Carrera(descripcion, materias1);
		carreras.add(c);
	}

	public void agregarMateriaNuevaACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException {
		Carrera c = tengoesaCarrera(codigoCarrera);
		if (c != null) {
			this.materias.add(c.agregarMateriaNueva(codigoMateria, descripcionMateria));
		} else {
			throw new NoExisteCarreraException("No existe la carreara");
		}
	}

	public void agregarMateriaExistenteACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException, NoExisteMateriaException {
		Carrera c = tengoesaCarrera(codigoCarrera);
		Materia m = tengoEsaMateria(codigoMateria, descripcionMateria);

		if (c != null) {
			if (m != null) {
				c.agregarMateria(m);
			} else {
				throw new NoExisteMateriaException("No exista la materia");
			}
		} else {
			throw new NoExisteCarreraException("No existe la carreara");
		}
	}
	
	public ArrayList<MateriaToView> getMateriasExistentes() {
		ArrayList<MateriaToView> materiasToView = new ArrayList<>();
		
		for (Materia m : materias) {
			materiasToView.add(m.ToView());
		}
		return materiasToView;				
	}
	
	public void altaCurso() {
		//Curso c = new Curso();
	}
	

	private Materia tengoEsaMateria(String codigoMateria, String descripcionMateria) {
		return null;
	}

	private Carrera tengoesaCarrera(int codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo() == codigo && c.getActivo()) {
				return c;
			}
		}
		return null;
	}	

}
