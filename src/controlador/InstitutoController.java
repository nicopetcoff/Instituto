package controlador;

import java.util.ArrayList;

import modelo.Curso;
import modelo.Instituto;
import modelo.Materia;
import modelo.ToView.CursoToView;
import modelo.ToView.MateriaToView;
import modelo.excepciones.NoDictaMateriaException;
import modelo.excepciones.NoExisteAlumnoException;
import modelo.excepciones.NoExisteCarreraException;
import modelo.excepciones.NoExisteDia;
import modelo.excepciones.NoExisteHorario;
import modelo.excepciones.NoExisteMateriaException;
import modelo.excepciones.NoExisteProfesor;
import modelo.excepciones.NoPudoInscribirseException;
import modelo.excepciones.NoexisteCursoException;
import modelo.excepciones.ProfesorNoDisponibleException;

public class InstitutoController {

	private Instituto instituto;

	public InstitutoController() {
		instituto = Instituto.getInstance();
	}

	public void altaCarrera(String descripcion, ArrayList<Materia> materias) {
		instituto.altaCarrera(descripcion, materias);
	}

	public void agregarMateriaNuevaACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException {
		instituto.agregarMateriaNuevaACarrera(codigoCarrera, codigoMateria, descripcionMateria);
	}

	public void agregarMateriaExistenteACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException, NoExisteMateriaException {
		instituto.agregarMateriaExistenteACarrera(codigoCarrera, codigoMateria, descripcionMateria);
	}

	public ArrayList<MateriaToView> getMateriasExistentes() {
		return instituto.getMateriasExistentes();
	}

	public void altaCurso(int codigoCarrera, String codigoMateria, String descripcionMateria, int legajoProfesor,
			String turno, String dia) throws ProfesorNoDisponibleException, NoDictaMateriaException,
			NoExisteCarreraException, NoExisteMateriaException, NoExisteProfesor, NoExisteHorario, NoExisteDia {
		instituto.altaCurso(codigoCarrera, codigoMateria, descripcionMateria, legajoProfesor, turno, dia);
	}

	public void inscribirAlumnoEnCurso(int legajoAlumno, int codigoCarrera, String codigoMateria,
			String descripcionMateria) throws NoExisteAlumnoException, NoExisteCarreraException,
			NoExisteMateriaException, NoPudoInscribirseException, NoexisteCursoException {
		instituto.inscribirAlumnoEnCurso(legajoAlumno, codigoCarrera, codigoMateria, descripcionMateria);
	}

	public void agregarProfesor(String nombre, String apellido, String dni) {
		instituto.agregarProfesor(nombre, apellido, dni);
	}

	public void agregarAlumnoNuevo(String nombre, String apellido, String dni) {
		instituto.agregarAlumnoNuevo(nombre, apellido, dni);
	}
	
	public ArrayList<CursoToView> getCursosDisponibles() {

		return instituto.getCursosDisponibles(); 
	}

}
