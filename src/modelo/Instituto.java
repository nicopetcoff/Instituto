package modelo;

import java.util.ArrayList;

import modelo.Enum.Dia;
import modelo.Enum.Turno;
import modelo.ToView.AlumnoToView;
import modelo.ToView.CarreraToView;
import modelo.ToView.CursoToView;
import modelo.ToView.MateriaToView;
import modelo.ToView.ProfesorToView;
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

public class Instituto {

	private static Instituto instance;
	
	private ArrayList<Carrera> carreras;
	private ArrayList<Materia> materias;
	private ArrayList<Curso> cursos;
	private ArrayList<Alumno> alumnos;
	private ArrayList<Profesor> profesores;

	private Instituto() {
		this.carreras = new ArrayList<>();
		this.materias = new ArrayList<>();
		this.cursos = new ArrayList<>();
		this.profesores = new ArrayList<>();
		this.alumnos = new ArrayList<>();

	}

	// ----------------------------------------------------------------------------------------------------------------------

	public static Instituto getInstance() {
		if (instance == null) {
			instance = new Instituto();
		}

		return instance;
	}

	public int altaCarrera(String nombre,String descripcion, ArrayList<Materia> materias1) {
		Carrera c = new Carrera(nombre,descripcion, materias1);
		carreras.add(c);
		
		return c.getCodigo();
	}
	
	public ArrayList<CarreraToView> getCarrerasExistenes() {

		ArrayList<CarreraToView> carrerasToView = new ArrayList<>();
		
		for(Carrera carrera : carreras) {
			carrerasToView.add(carrera.toView());
		}
		
		return carrerasToView;
	}
	
	
	public void agregarMateriaExistenteACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException, NoExisteMateriaException {
		Carrera c = buscarCarrera(codigoCarrera);
		Materia m = buscarMateria(codigoMateria, descripcionMateria);

		c.agregarMateria(m);
	}

	public void crearMateriaNueva(String codigoMateria, String descripcionMateria) {
		Materia materia = new Materia(codigoMateria, descripcionMateria);
		this.materias.add(materia);
	}

	public ArrayList<MateriaToView> getMateriasExistentes() {
		ArrayList<MateriaToView> materiasToView = new ArrayList<>();

		for (Materia m : materias) {
			materiasToView.add(m.ToView());
		}
		return materiasToView;
	}

	public void altaCurso(int codigoCarrera, String codigoMateria, String descripcionMateria, int legajoProfesor,
			String turno1, String dia1) throws ProfesorNoDisponibleException, NoDictaMateriaException,
			NoExisteCarreraException, NoExisteMateriaException, NoExisteProfesor, NoExisteHorario, NoExisteDia {

		Carrera cerrera = buscarCarrera(codigoCarrera);
		Materia materia = buscarMateria(codigoMateria, descripcionMateria);
		Profesor profesor = buscarProfesor(legajoProfesor);
		Turno turno = buscarTurno(turno1);
		Dia dia = buscarDia(dia1);

		Curso c = new Curso(cerrera, materia, profesor, dia, turno);

		cursos.add(c);

	}

	public int agregarProfesor(String nombre, String apellido, String dni) {
		Profesor profesor = new Profesor(nombre, apellido, dni);
		profesores.add(profesor);
		int nroLegajoProfesor = profesor.getLegajo();
		return nroLegajoProfesor;
	}
	
	public ArrayList<ProfesorToView> getProfesoresDisponibles(){
		ArrayList<ProfesorToView> profesoresToView = new ArrayList<>();
		
		for(Profesor profesor : profesores) {
			profesoresToView.add(profesor.toView());
		}
		
		return profesoresToView;
	}

	public void agregarMateriaAProfesor(int nroLegajo, String codigoMateria, String descripcionMateria)
			throws NoExisteProfesor, NoExisteMateriaException {
		Profesor profesor = buscarProfesor(nroLegajo);
		Materia materia = buscarMateria(codigoMateria, descripcionMateria);

		profesor.agregarMateria(materia);

	}

	public int agregarAlumnoNuevo(String nombre, String apellido, String dni) {
		Alumno alumno = new Alumno(nombre, apellido, dni);
		alumnos.add(alumno);
		
		return alumno.getLegajo();
	}

	public void inscribirAlumnoEnCurso(int legajoAlumno, int codigoCarrera, String codigoMateria,
			String descripcionMateria) throws NoExisteAlumnoException, NoExisteCarreraException,
			NoExisteMateriaException, NoPudoInscribirseException, NoexisteCursoException {

		Alumno a = buscarAlumno(legajoAlumno);
		Carrera car = buscarCarrera(codigoCarrera);
		Materia m = buscarMateria(codigoMateria, descripcionMateria);
		Curso cur = buscarCurso(car, m);

		a.inscribirseEnCurso(cur);

	}

	public ArrayList<CursoToView> getCursosDisponibles() {

		ArrayList<CursoToView> cursosToView = new ArrayList<>();

		for (Curso c : cursos) {
			cursosToView.add(c.toView());
		}

		return cursosToView;
	}

	public ArrayList<AlumnoToView> getAlumnosDelCurso(int codigoCarrera, String codigoMateria,
			String descripcionMateria)
			throws NoexisteCursoException, NoExisteMateriaException, NoExisteCarreraException {

		Carrera car = buscarCarrera(codigoCarrera);
		Materia m = buscarMateria(codigoMateria, descripcionMateria);
		Curso cur = buscarCurso(car, m);

		ArrayList<AlumnoToView> alumnosToView = new ArrayList<>();

		for (Alumno a : cur.getAlumnos()) {
			alumnosToView.add(a.toView());
		}

		return alumnosToView;

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	private Curso buscarCurso(Carrera car, Materia m) throws NoexisteCursoException {

		for (Curso cur : cursos) {
			if (cur.getMateria().equals(m) && cur.getCarrera().equals(car)) {
				return cur;
			}
		}
		throw new NoexisteCursoException("No existe el curso");
	}

	private Alumno buscarAlumno(int legajoAlumno) throws NoExisteAlumnoException {
		for (Alumno a : alumnos) {
			if (a.getLegajo() == legajoAlumno) {
				return a;
			}
		}
		throw new NoExisteAlumnoException("No existe el Alumno");
	}

	private Dia buscarDia(String dia) throws NoExisteDia {

		Dia[] dias = Dia.values();

		for (Dia d : dias) {
			if (d.name().equals(dia)) {
				return d;
			}
		}

		throw new NoExisteDia("No existe el dia");
	}

	private Turno buscarTurno(String turno) throws NoExisteHorario {

		Turno[] turnos = Turno.values();

		for (Turno t : turnos) {
			if (t.name().equals(turno)) {
				return t;
			}
		}
		throw new NoExisteHorario("No existe el turno");
	}

	private Profesor buscarProfesor(int legajoProfesor) throws NoExisteProfesor {

		for (Profesor p : profesores) {
			if (p.getLegajo() == legajoProfesor) {
				return p;
			}
		}
		throw new NoExisteProfesor("No existe el Profesor");
	}

	private Materia buscarMateria(String codigoMateria, String descripcionMateria) throws NoExisteMateriaException {
		for (Materia m : materias) {
			if (m.getCodigoMateria().equals(codigoMateria) && m.getDescripcion().equals(descripcionMateria)) {
				return m;
			}
		}
		throw new NoExisteMateriaException("No existe la materia");
	}
	

	private Carrera buscarCarrera(int codigo) throws NoExisteCarreraException {
		for (Carrera c : carreras) {
			if (c.getCodigo() == codigo && c.getActivo()) {
				return c;
			}
		}
		throw new NoExisteCarreraException("No existe la carrera");
	}

	

}
