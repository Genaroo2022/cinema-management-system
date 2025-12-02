package ar.edu.ort.cines.helpers;

import java.util.Random;

import ar.edu.ort.cines.classes.enums.Tematica;
import ar.edu.ort.cines.classes.proyeccion.Documental;
import ar.edu.ort.cines.classes.proyeccion.Pelicula;
import ar.edu.ort.cines.classes.proyeccion.Proyeccion;
import ar.edu.ort.cines.classes.proyeccion.Serie;

public class ProyeccionHelper {
	public static final String PELICULA = "P";
	public static final String SERIE = "S";
	public static final String DOCUMENTAL = "D";
	private static final Random random = new Random(System.currentTimeMillis());
	
	
	public static Proyeccion createProyeccion(String tipo) {
		Proyeccion p = null;
		
		switch (tipo) {
		case PELICULA:
			p = crearPelicula();
			break;
		case SERIE:
			p = crearSerie();
			break;
		case DOCUMENTAL:
			p = crearDocumental();
			break;

		default:
			break;
		}
	
		return p;
	}
	
	
	private static final Pelicula crearPelicula() {
		int duracion = random.nextInt(210);
		
		return new Pelicula("pelicula_" + System.currentTimeMillis(), "05/07/1999", duracion);
	}
	
	private static final Serie crearSerie() {
		int cantCapitulos = random.nextInt(150);
		
		return new Serie("serie_" + System.currentTimeMillis(), "10/11/2005", cantCapitulos);
	}
	
	private static final Documental crearDocumental() {
		return new Documental("documental_", "10/11/2014", Tematica.SALUD);
	}
}

