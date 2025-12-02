package ar.edu.ort.cines.classes.people;

import ar.edu.ort.cines.classes.enums.Alimento;
import ar.edu.ort.cines.intefaces.Consumible;

public class Empleado extends Persona implements Consumible{
	private float antiguedad;
	private float salario;
	
	
	@Override
	public void consumir(Alimento alimento) {
		System.out.println(alimento.mostrarMensaje());
	}


	public float getAntiguedad() {
		return antiguedad;
	}


	public float getSalario() {
		return salario;
	}
	
	
	
}
