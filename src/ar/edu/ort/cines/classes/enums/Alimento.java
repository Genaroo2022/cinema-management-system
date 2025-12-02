package ar.edu.ort.cines.classes.enums;

public enum Alimento {
	POP_CORN("Estoy comiendo un enorme balde de pochoclos"),
	NACHOS("Estoy comiendo unos nachos bien mexicanos"),
	PANCHOS("Estoy comiendo un rico pancho");
	
	String mensaje;

	
	private Alimento(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
	public String mostrarMensaje() {
		return this.mensaje;
	}
}
