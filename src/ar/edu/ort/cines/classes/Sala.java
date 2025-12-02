package ar.edu.ort.cines.classes;

import ar.edu.ort.cines.classes.enums.Alimento;
import ar.edu.ort.cines.classes.enums.Funcion;
import ar.edu.ort.cines.classes.exceptiones.SeatNotAvailableException;
import ar.edu.ort.cines.classes.people.Persona;
import ar.edu.ort.cines.classes.proyeccion.Proyeccion;
import ar.edu.ort.cines.intefaces.Consumible;
import ar.edu.ort.cines.intefaces.Identificable;
import ar.edu.ort.cines.intefaces.Puntuable;
import ar.edu.ort.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tdas.interfaces.Cola;
import ar.edu.ort.tdas.interfaces.Pila;

public class Sala implements Identificable<String>{
	private final int CANT_FILAS = 25;
	private final int CANT_BUTACAS = 18;
	private String nombre;
	private int capacidad;
	private Proyeccion[] proyecciones;
	private Asiento[][] asientos;
	private Cola<Persona> personas;
	private Alimento alimento;
	private Pila<Proyeccion> historial;
	
	
	public Sala(int capacidad) {
		this("dummy", capacidad);
	}
	
	
	public Sala(String nombre, int capacidad) {
		this.nombre = null;
		this.capacidad = capacidad;
		this.proyecciones = new Proyeccion[Funcion.values().length];
		this.asientos = new Asiento[CANT_FILAS][CANT_BUTACAS];
		this.personas = new ColaNodos<Persona>();
		this.historial = new PilaNodos<Proyeccion>();
		inicializarAsientos();			
	}

	
	public void eliminarHistoria(String nombreProyeccion) {
		Pila<Proyeccion> pilaAux = new PilaNodos<Proyeccion>();
		boolean encontrada = false;
		Proyeccion proyeccion;
		
		while(!this.historial.isEmpty() && !encontrada) {
			proyeccion = this.historial.pop();
			if(proyeccion.tieneNombre(nombreProyeccion)) {
				encontrada = true;
			} else {
				pilaAux.push(proyeccion);
			}
		}
		
		while(!pilaAux.isEmpty()) this.historial.push(pilaAux.pop());
	}
	
	
	public Cola<Persona> ingresoPrioritario() {
		final Persona CENT = null;
		Cola<Persona> personasPrioritarias = new ColaNodos<Persona>();
		Persona persona;
		
		this.personas.add(CENT);
		persona = this.personas.remove();
		while(persona != CENT) {
			if(persona.isPrioritaria()) {
				personasPrioritarias.add(persona);
			} else {
				this.personas.add(persona);
			}
			
			persona = this.personas.remove();
		}
		
		return personasPrioritarias;
	}
	
	
	public void abrirSala() {
		final Persona CENT = null;
		Persona persona;
		
		this.personas.add(CENT);
		persona = this.personas.remove();
		while(persona != CENT) {
			try {
				
				permitirIngreso(persona);
				
			} catch (SeatNotAvailableException e) {
				
				this.personas.add(persona);
				System.out.println(e.getMessage());
			
			}
			
			persona = this.personas.remove();
		}
	}
	
	
	public Asiento dameAsientoDisponible() {
		Asiento asiento = null;
		int index = 0;
		
		while(index < CANT_FILAS && asiento == null) {
			asiento = buscarAsientoDisponible(this.asientos[index]);
			index++;
		}
		
		return asiento;
	}
	

	public void permitirIngreso(Persona persona) throws SeatNotAvailableException  {
		int fila = persona.dameTuFila() - 1;
		int butaca = persona.dameTuButaca() - 1;

		if(this.asientos[fila][butaca].estaDisponible()) {
			this.asientos[fila][butaca].ocupar();
		} else throw new SeatNotAvailableException(persona.dameTuFila(), persona.dameTuButaca(), this.asientos[fila][butaca].getEstado());
	}
	
	
	public int tiempoProyeccion() {
		int duracionTotal = 0;
		
		for (Proyeccion proyeccion : proyecciones) {
			if(proyeccion != null)	duracionTotal += proyeccion.getDuracion();
		}
		
		return duracionTotal;
	}

	
	public void habilitarConsumo() {
		final Persona CENT = null;
		Persona persona;
		
		this.personas.add(CENT);
		persona = this.personas.remove();
		while(persona != CENT) {
			if(persona instanceof Consumible) {
				Consumible c = (Consumible) persona;
				c.consumir(this.alimento);
			}
			
			persona = this.personas.remove();
		}
	}
	
	
	public int obtenerPuntaje() {
		int puntaje = 0;
		
		final Persona CENT = null;
		Persona persona;
		
		this.personas.add(CENT);
		persona = this.personas.remove();
		while(persona != CENT) {
			if(persona instanceof Puntuable) {
				Puntuable puntuable = (Puntuable) persona;
				puntaje += puntuable.getPuntos();
			}
			
			persona = this.personas.remove();
		}
		
		return puntaje;
	}
	
	
	public void planificarProyeccion(Proyeccion proyeccion, Funcion funcion) {
		if(!tenesProyeccion(funcion)) this.proyecciones[funcion.ordinal()] = proyeccion;
	}
	
	
	public boolean tenesProyeccion(Funcion funcion) {
		return this.proyecciones[funcion.ordinal()] != null;
	}
	
	
	/**
	 * ESTE METODO SOLO FUE PARA EXPLICAR EXCEPCIONES!!
	 * NO ES NECESARIO HACER ESTO
	 */
	private void inicializarAsientos() {
		//this.asientos[0][0] = new Asiento(-1, 0, false, Estado.DISPONIBLE);			
	}

	
	/**
	 * Busca un asiento disponible en una fila determinada
	 * @param fila
	 * @return
	 */
	private Asiento buscarAsientoDisponible(Asiento[] fila) {
		Asiento asiento = null;
		int index = 0;
		
		while(index < CANT_BUTACAS && asiento == null) {
			asiento = fila[index].estaDisponible() ? fila[index] : null;
			index++;
		}
		
		return asiento;
	}
	
	
	@Override
	public String identificate() {
		return getNombre();
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getCapacidad() {
		return capacidad;
	}
}
