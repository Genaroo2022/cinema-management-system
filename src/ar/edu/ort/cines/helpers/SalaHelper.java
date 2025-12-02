package ar.edu.ort.cines.helpers;

import java.util.Random;

import ar.edu.ort.cines.classes.Sala;
import ar.edu.ort.cines.classes.enums.Funcion;

public class SalaHelper {
	private static final Random random = new Random(System.currentTimeMillis());
	
	public static Sala crearSala() {
		int capacidad = random.nextInt(100);

		Sala sala = new Sala("sala_" + System.currentTimeMillis(), capacidad);
		sala.planificarProyeccion(ProyeccionHelper.createProyeccion(ProyeccionHelper.PELICULA), obtenerFuncion());
		sala.planificarProyeccion(ProyeccionHelper.createProyeccion(ProyeccionHelper.SERIE), obtenerFuncion());
		sala.planificarProyeccion(ProyeccionHelper.createProyeccion(ProyeccionHelper.DOCUMENTAL), obtenerFuncion());
		sala.planificarProyeccion(ProyeccionHelper.createProyeccion(ProyeccionHelper.PELICULA), obtenerFuncion());
		
		return sala;
	}
	
	
	public static Sala crearSala(int capacity) {
		int proyecciones = random.nextInt(10);

		Sala sala = new Sala("sala_" + System.currentTimeMillis(), capacity);
		for(int i = 0; i < proyecciones; i++) {
			sala.planificarProyeccion(ProyeccionHelper.createProyeccion(obtenerTipoProyeccion()), obtenerFuncion());			
		}
		
		return sala;
	}

	
	private static String obtenerTipoProyeccion() {
		String[] tipos = new String[] {ProyeccionHelper.PELICULA, ProyeccionHelper.SERIE, ProyeccionHelper.DOCUMENTAL};
		int index = random.nextInt(tipos.length);
		
		return tipos[index];
	}
	
	private static Funcion obtenerFuncion() {
		int index = random.nextInt(Funcion.values().length);
		
		return Funcion.values()[index];
	}
}
