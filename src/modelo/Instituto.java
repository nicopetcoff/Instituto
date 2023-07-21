package modelo;

import java.util.ArrayList;

import modelo.Enum.Dia;
import modelo.Enum.Turno;
import modelo.ToView.MateriaToView;
import modelo.excepciones.NoDictaMateriaException;
import modelo.excepciones.NoExisteAlumnoException;
import modelo.excepciones.NoExisteCarreraException;
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
		Carrera c = tengoEsaCarrera(codigoCarrera);
		if (c != null) {
			this.materias.add(c.agregarMateriaNueva(codigoMateria, descripcionMateria));
		} else {
			throw new NoExisteCarreraException("No existe la carreara");
		}
	}

	public void agregarMateriaExistenteACarrera(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoExisteCarreraException, NoExisteMateriaException {
		Carrera c = tengoEsaCarrera(codigoCarrera);
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

	public void altaCurso(int codigoCarrera, String codigoMateria, String descripcionMateria, int legajoProfesor,
			String turno, String dia) throws ProfesorNoDisponibleException, NoDictaMateriaException,
			NoExisteCarreraException, NoExisteMateriaException, NoExisteProfesor, NoExisteHorario, NoExisteDia {

		Carrera car = tengoEsaCarrera(codigoCarrera);
		Materia m = tengoEsaMateria(codigoMateria, descripcionMateria);
		Profesor p = tengoEseProfesor(legajoProfesor);
		Turno t = soyEseTurno(turno);
		Dia d = soyEseDia(dia);

		if (car != null) {
			if (m != null) {
				if (p != null) {
					if (t != null) {
						if (d != null) {

							Curso c = new Curso(car, m, p, d, t);

							cursos.add(c);

						} else {
							throw new NoExisteDia("No existe dia");
						}

					} else {
						throw new NoExisteHorario("No existe horario");
					}

				} else {
					throw new NoExisteProfesor("No existe el profesor");
				}

			} else {
				throw new NoExisteMateriaException("No existe la materia");
			}

		} else {
			throw new NoExisteCarreraException("No existe la carrera");
		}

	}

	public void agregarProfesor(String nombre, String apellido, String dni) {
		Profesor profesor = new Profesor(nombre, apellido, dni);
		profesores.add(profesor);
	}

	public void agregarAlumnoNuevo(String nombre, String apellido, String dni) {
		Alumno alumno = new Alumno(nombre, apellido, dni);
		alumnos.add(alumno);
	}

	public void inscribirAlumnoEnCurso(int legajoAlumno, int codigoCarrera, String codigoMateria,
			String descripcionMateria) throws NoExisteAlumnoException, NoExisteCarreraException,
			NoExisteMateriaException, NoPudoInscribirseException, NoexisteCursoException {

		Alumno a = tengoEseAlumno(legajoAlumno);
		Carrera car = tengoEsaCarrera(codigoCarrera);
		Materia m = tengoEsaMateria(codigoMateria, descripcionMateria);
		Curso cur = tengoEseCurso(car, m);

		if (a != null) {
			if (car != null) {
				if (m != null) {
					if (cur != null) {
						a.inscribirseEnCurso(cur);
					} else {
						throw new NoexisteCursoException("No existe el curso");
					}

				} else {
					throw new NoExisteMateriaException("No existe materia");
				}

			} else {
				throw new NoExisteCarreraException("No existe carrera");
			}

		} else {
			throw new NoExisteAlumnoException("No existe el alumno");
		}

	}

	public ArrayList<CursoToView> getCursosDisponibles() {

		ArrayList<CursoToView> cursosToView = new ArrayList<>();

		for (Curso c : cursos) {
			cursosToView.add(c.toView());
		}

		return cursosToView;
	}

	public ArrayList<AlumnoToView> alumnosDelCurso(int codigoCarrera, String codigoMateria, String descripcionMateria)
			throws NoexisteCursoException, NoExisteMateriaException, NoExisteCarreraException {

		Carrera car = tengoEsaCarrera(codigoCarrera);
		Materia m = tengoEsaMateria(codigoMateria, descripcionMateria);
		Curso cur = tengoEseCurso(car, m);

		ArrayList<AlumnoToView> alumnosToView = new ArrayList<>();

		if (car != null) {
			if (m != null) {
				if (cur != null) {

					for (Alumno a : cur.getAlumnos()) {
						alumnosToView.add(a.toView());
					}

					return alumnosToView;

				} else {
					throw new NoexisteCursoException("No existe el curso");
				}

			} else {
				throw new NoExisteMateriaException("No existe materia");
			}

		} else {
			throw new NoExisteCarreraException("No existe carrera");
		}

	}

	// -----------------------------------------------------------------------------------------------------------------------------------------------------

	private Curso tengoEseCurso(Carrera car, Materia m) {

		for (Curso cur : cursos) {
			if (cur.getMateria().equals(m) && cur.getCarrera().equals(car)) {
				return cur;
			}
		}
		return null;
	}

	private Alumno tengoEseAlumno(int legajoAlumno) {
		for (Alumno a : alumnos) {
			if (a.getLegajo() == legajoAlumno) {
				return a;
			}
		}
		return null;
	}

	private Dia soyEseDia(String dia) {

		Dia[] dias = Dia.values();

		for (Dia d : dias) {
			if (d.name().equals(dia)) {
				return d;
			}
		}

		return null;
	}

	private Turno soyEseTurno(String turno) {

		Turno[] turnos = Turno.values();

		for (Turno t : turnos) {
			if (t.name().equals(turno)) {
				return t;
			}
		}
		return null;
	}

	private Profesor tengoEseProfesor(int legajoProfesor) {

		for (Profesor p : profesores) {
			if (p.getLegajo() == legajoProfesor) {
				return p;
			}
		}
		return null;
	}

	private Materia tengoEsaMateria(String codigoMateria, String descripcionMateria) {
		for (Materia m : materias) {
			if (m.getCodigoMateria().equals(codigoMateria) && m.getDescripcion().equals(descripcionMateria)) {
				return m;
			}
		}
		return null;
	}

	private Carrera tengoEsaCarrera(int codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo() == codigo && c.getActivo()) {
				return c;
			}
		}
		return null;
	}

}
