package ar.edu.ort.cines.classes.people;

import ar.edu.ort.cines.intefaces.Puntuable;

public class Espectador extends Persona implements Puntuable{
	private int puntos;

	public int getPuntos() {
		return puntos;
	}
}
