package ar.edu.ort.cines.classes.proyeccion;

public abstract class Proyeccion {
	protected static final int DURACION_TRAILER = 10;
	protected String nombre;
	private String fechaEstreno;
	private int cantEspectadores;
	

	public Proyeccion(String nombre, String fechaEstreno) {
		this.nombre = nombre;
		this.fechaEstreno = fechaEstreno;
	}

	
	public boolean tieneNombre(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public int getDuracion() {
		return DURACION_TRAILER + getDuracionPropia();
	}
	
	protected abstract int getDuracionPropia();
	
	
	public int getCantEspectadores() {
		return this.cantEspectadores;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}
}
