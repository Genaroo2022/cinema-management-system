package ar.edu.ort.cines.classes.proyeccion;

public class Serie extends Proyeccion {
	private static final int DURACION_CAPITULOS = 20;
	private int cantCapitulos;
	
	
	public Serie(String nombre, String fechaEstreno, int cantCapitulos) {
		super(nombre, fechaEstreno);
		this.cantCapitulos = cantCapitulos;
	}


	@Override
	public int getDuracionPropia() {
		return this.cantCapitulos * DURACION_CAPITULOS;
	}
}


