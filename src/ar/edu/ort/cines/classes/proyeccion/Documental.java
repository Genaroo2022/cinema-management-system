package ar.edu.ort.cines.classes.proyeccion;

import ar.edu.ort.cines.classes.enums.Tematica;

public class Documental extends Proyeccion {	
	private Tematica tematica;
	
	
	
	public Documental(String nombre, String fechaEstreno, Tematica tematica) {
		super(nombre, fechaEstreno);
		this.tematica = tematica;
	}

	
	@Override
	public int getDuracionPropia() {
		return this.tematica.getDuracion();
	}
}
