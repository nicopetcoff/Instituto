package controlador;

import java.util.ArrayList;

import modelo.Instituto;
import modelo.Materia;
import modelo.ToView.AlumnoToView;
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

	public int altaCarrera(String nombre, String descripcion, ArrayList<Materia> materias) {
		return instituto.altaCarrera(nombre, descripcion, null);
	}

	public void agregarMateriaExistenteACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException, NoExisteMateriaException {
		instituto.agregarMateriaExistenteACarrera(codigoCarrera, codigoMateria, descripcionMateria);
	}
	
	public void crearMateriaNueva(String codigoMateria, String descripcionMateria) {
		instituto.crearMateriaNueva(codigoMateria, descripcionMateria);
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

	public int agregarProfesor(String nombre, String apellido, String dni) {
		return instituto.agregarProfesor(nombre, apellido, dni);
	}

	public void agregarMateriaAProfesor(int nroLegajo, String codigo, String descripcion)
			throws NoExisteProfesor, NoExisteMateriaException {
		instituto.agregarMateriaAProfesor(nroLegajo, codigo, descripcion);
	}

	public ArrayList<MateriaToView> getMateriaToView() {
		return instituto.getMateriasExistentes();
	}

	public void agregarAlumnoNuevo(String nombre, String apellido, String dni) {
		instituto.agregarAlumnoNuevo(nombre, apellido, dni);
	}

	public ArrayList<CursoToView> getCursosDisponibles() {

		return instituto.getCursosDisponibles();
	}

	public ArrayList<AlumnoToView> getAlumnosDelCurso(int codigoCarrera, String codigoMateria,
			String descripcionMateria)
			throws NoexisteCursoException, NoExisteMateriaException, NoExisteCarreraException {

		return instituto.getAlumnosDelCurso(codigoCarrera, codigoMateria, descripcionMateria);

	}

}
