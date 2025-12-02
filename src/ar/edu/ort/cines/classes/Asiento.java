package ar.edu.ort.cines.classes;

import ar.edu.ort.cines.classes.enums.Estado;

public class Asiento {
	private final String ERR_FILA = "El valor de la fila es un número inválido";
	private final String ERR_BUTACA = "El valor de la butaca es un número inválido";
	private final int MIN_VALOR_FILA = 1;
	private final int MAX_VALOR_FILA = 25;
	private final int MIN_VALOR_BUTACA = 1;
	private final int MAX_VALOR_BUTACA = 18;
	private int fila;
	private int butaca;
	private boolean soporte;
	private Estado estado;
	
	
	public Asiento(int fila, int butaca, boolean soporte, Estado estado) throws IllegalArgumentException{
		setFila(fila);	
		setButaca(butaca);
		this.soporte = soporte;
		this.estado = estado;
	}
	
	
	public boolean estaDisponible() {
		return Estado.DISPONIBLE.equals(this.estado);
	}
	
	
	public void ocupar() {
		this.estado = Estado.OCUPADO;
	}


	public int getFila() {
		return fila;
	}


	public int getButaca() {
		return butaca;
	}

	
	
	private void setFila(int fila) {
		if(fila < MIN_VALOR_FILA || fila > MAX_VALOR_FILA) {
			throw new IllegalArgumentException(ERR_FILA);
		}
		
		this.fila = fila;
	}


	private void setButaca(int butaca) {
		if(butaca < MIN_VALOR_BUTACA || butaca > MAX_VALOR_BUTACA) {
			throw new IllegalArgumentException(ERR_BUTACA);
		}
		
		this.butaca = butaca;
	}


	
	
	public Estado getEstado() {
		return estado;
	}


	public boolean tieneSoporte() {
		return soporte;
	}
}
