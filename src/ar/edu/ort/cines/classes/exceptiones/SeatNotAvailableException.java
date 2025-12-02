package ar.edu.ort.cines.classes.exceptiones;

import ar.edu.ort.cines.classes.enums.Estado;

public class SeatNotAvailableException extends Exception {
	private static final long serialVersionUID = -2996785610626722046L; 
	private static final String MSG = "La persona no pudo ingresar ya que el asiento de la fila %d y butaca %d se encontraba %s";

	
	public SeatNotAvailableException(int fila, int butaca, Estado estado) {
		super(String.format(MSG, fila, butaca, estado));
	}
	
	
}
