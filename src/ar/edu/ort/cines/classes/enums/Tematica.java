package ar.edu.ort.cines.classes.enums;

public enum Tematica {
	HISTORICO(180),
	SALUD(90),
	POLITICO(75);
	
	private int duracion;
	
	private Tematica(int duracion) {
		this.duracion = duracion;
	}

	public int getDuracion() {
		return duracion;
	}	
}
