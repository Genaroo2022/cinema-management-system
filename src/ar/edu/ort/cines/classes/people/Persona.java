package ar.edu.ort.cines.classes.people;

import ar.edu.ort.cines.classes.Entrada;
import ar.edu.ort.cines.intefaces.Identificable;

public abstract class Persona implements Identificable<Long>{
	private String nombre;
	private int edad;
	private long dni;
	private Entrada entrada;
	private boolean prioritaria;

	@Override
	public Long identificate() {
		return getDni();
	}

	public int dameTuFila() {
		return this.entrada.getFila();
	}
	
	public int dameTuButaca() {
		return this.entrada.getButaca();
	}
	
	public boolean isPrioritaria() {
		return prioritaria;
	}

	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public long getDni() {
		return dni;
	}
}
