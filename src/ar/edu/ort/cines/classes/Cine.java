package ar.edu.ort.cines.classes;

import ar.edu.ort.cines.classes.enums.Funcion;
import ar.edu.ort.cines.helpers.SalaHelper;
import ar.edu.ort.cines.intefaces.Identificable;

public class Cine implements Identificable<String>{
	public static final int CANT_SALAS = 8;
	private String id;
	private Sala[] salas;
	private int capacidadSalaEspera;
	
	
	public Cine(String id) {
		this.id = id;
		this.salas = new Sala[CANT_SALAS];
		inicializarSalas();
	}
	
	
	public void inicializarSalas() {
		for(int i=0; i < CANT_SALAS; i++) {
			this.salas[i] = SalaHelper.crearSala();			
		}
	}
	
	
	public Asiento[] dameAsientosDisponibles() {
		Asiento[] asientos = new Asiento[CANT_SALAS];
		
		for(int i =0 ; i < CANT_SALAS; i++) {
			asientos[i] = this.salas[i].dameAsientoDisponible();
		}
		
		return asientos;
	}
	
	public int tiempoProyeccion() {
		int duracionTotal = 0;

		for (Sala sala : salas) {
			duracionTotal += sala.tiempoProyeccion();
		}
		
		return duracionTotal;
	}
	
	
	public int calcularPuntaje(String idSala) {
		int puntos = 0;
		int index = 0;
		boolean encontrada = false;
		
		while(!encontrada && index < this.salas.length) {
			Sala sala = this.salas[index];
			
			if(sala.identificate().equals(idSala)) {
				puntos = sala.obtenerPuntaje();
				encontrada = true;
			} else {
				index++;
			}
		}
		
		return puntos;
	}
	
	
	public int getCapacidad() {
		return this.capacidadSalaEspera + sumatoriaCapacidadSalas();
	}
	
	
	public int[] proyeccionesPorFunciones() {
		int[] cantidades = new int[Funcion.values().length];
		
		
		for(int i = 0; i < CANT_SALAS; i++) {
			completarCantidadesParaSala(cantidades, this.salas[i]);
		}
		
		
		return cantidades;
	}
	
	
	
	private void completarCantidadesParaSala(int[] cantidades, Sala sala) {
		
		for (Funcion funcion : Funcion.values()) {
			if(sala.tenesProyeccion(funcion)) cantidades[funcion.ordinal()]++;				
		}
		
	}
	
	
	private int sumatoriaCapacidadSalas() {
		int total = 0;
		for (Sala sala : salas) {
			total += sala.getCapacidad();
		}
		
		return total;
	}
	
	
	@Override
	public String identificate() {
		return getId();
	}

	@Override
	public String toString() {
		return String.format("Cine con ID=%s", identificate());
	}
	
	
	public String getId() {
		return id;
	}
}
