package Main;
import Clases.*;
import Enum.*;
import Fachada.*;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Instituto i = new Instituto();
		
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		do{
			
			System.out.println("Bienvenido, seleccione la opcion deseada");
			System.out.println("1.\t Crear curso");
			System.out.println("2.\t Agregar Alumno al curso");
			
			opcion = sc.nextInt();
			
			switch(opcion) {
			
			case 1:
				System.out.println("Ha seleccionado la opcion 1");
				
				System.out.println("Elija el codigo de la carrera");
				i.mostrarCarrerasActivas();
				
				String codigoElejido= sc.next();
				
				Carrera c;
				
				c= i.soyEsaCarrera(codigoElejido);
				
				System.out.println("Elija la materia");
				
				c.verMaterias();
				
				String codigoElejido2= sc.next();
				
				Materia melejida = c.soyEsaMateria(codigoElejido2);
				
				System.out.println("Elija el profesor por su lu");
				
				i.mostrarCarrerasActivas();
				
				int lu= sc.nextInt();
				
				Profesor pe = i.soyElprofesor(lu);
				
				System.out.println("Diga el idCurso");
				String idCursoe = sc.next();
				
				i.crearCurso(idCursoe,melejida, pe, Dia.lunes, Turno.mañana);
				
				break;
				
			case 2:
				System.out.println("Ha seleccionado la opcion 2");
				System.out.println("Ingrese los datos del alumno");
				
				System.out.print("Nombre: \t");
				String nombre = sc.next();
				
				System.out.print("Tipo Documento: \t");
				String tipoDoc = sc.next();
				
				
				System.out.print("Tipo Nro documento: \t");
				int nroDoc = sc.nextInt();
				
				System.out.print("LU: \t");
				int lu1 = sc.nextInt();
				
				Alumno alum = new Alumno(nombre, tipoDoc, nroDoc, lu1);
				
				System.out.println("Elija curso");
				
				i.mostrarCursos();
				
				System.out.println("Elija el curso por su id");
				
				String iCurso= sc.next();
				
				Curso cur = i.soyEseCurso(iCurso);
				
				i.inscribirAlumno(cur, alum);
				
				alum.agregarCurso(cur);
				
				break;
				
			default:
				break;
			}
			
		}while(opcion!= 4);
		
		
		sc.close();	

	}

}
