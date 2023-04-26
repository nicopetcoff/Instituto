package Clases;


import java.util.*;


public class Carrera {
	
    private String codigo;
    private String descripcion;
    private ArrayList<Materia> materias;
    private boolean activa;
    
	public Carrera(String codigo, String descripcion) {

		this.codigo = codigo;
		this.descripcion = descripcion;
		this.materias = new ArrayList<>();
		this.activa = true;
	}
	


	
	public String toString() {
		return "Carrera [codigo=" + codigo + ", descripcion=" + descripcion + ", materias=" + materias + ", activa="
				+ activa + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public ArrayList<Materia> getMaterias() {
		return materias;
	}
	
	public void agregarMaterias(Materia materia) {
		
		materias.add(materia);
		
	}
	
	public void verMaterias() {
		for(Materia m:materias)
			System.out.println(m);
	}
	
	public Materia soyEsaMateria(String codigo) {
		for(Materia m:materias){
			if (m.getCodigo().equals(codigo)) {
				return m;
			}
			

		}
		return null;
				}
	
	
    
    
    






}