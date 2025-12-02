package ar.edu.ort.cines.classes.people;

import ar.edu.ort.cines.classes.enums.Alimento;
import ar.edu.ort.cines.intefaces.Consumible;

public class VIP extends Espectador implements Consumible {
	private final int DOBLE = 2;
	
	
	@Override
	public void consumir(Alimento alimento) {
		System.out.println(alimento.mostrarMensaje());
	}
	
	@Override
	public int getPuntos() {
		return super.getPuntos() * DOBLE;
	}
}
