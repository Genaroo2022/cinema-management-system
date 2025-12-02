package ar.edu.ort.cines.classes.proyeccion;

public class Pelicula extends Proyeccion{
	private int duracion;
	
	
	public Pelicula(String nombre, String fechaEstreno) {
		super(nombre, fechaEstreno);
	}
	
	
	public Pelicula(String nombre, String fechaEstreno, int duracion) {
		super(nombre, fechaEstreno);
		this.duracion = duracion;
	}


	@Override
	protected int getDuracionPropia() {
		return this.duracion;
	}
 }
