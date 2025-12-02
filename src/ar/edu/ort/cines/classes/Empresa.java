package ar.edu.ort.cines.classes;

import ar.edu.ort.cines.classes.tdas.ListaCinesPorCapacidad;
import ar.edu.ort.cines.classes.tdas.ListaCinesPorIdentificador;

public class Empresa {
	private ListaCinesPorIdentificador cines;
	
	
	public Empresa() {
		this.cines = new ListaCinesPorIdentificador();
	}
	
	
	public Cine[] ofrecer(int cantidad) {
		Cine[] cines = new Cine[cantidad];
		ListaCinesPorCapacidad cinesOrdenados = ordenarCinesPorCapacidad();
		
		int index = 0;
		while(index < cinesOrdenados.size() && index < cantidad) {
			cines[index] = cinesOrdenados.get(index);
			index++;
		}
		
		return cines;
	}
	
	
	public Asiento[][] asientosDisponibles() {
		Asiento[][] resultado = new Asiento[this.cines.size()][Cine.CANT_SALAS];
		
		for(int i=0; i<this.cines.size(); i++) {
			Cine cine = this.cines.get(i);
			resultado[i] = cine.dameAsientosDisponibles();
		}
		
		return resultado;
	}
	
	
	public Cine mayorDuracion() {
		Cine cineMayor = null;
		
		for (Cine cine : cines) {
			if(cineMayor == null || cineMayor.tiempoProyeccion() > cine.tiempoProyeccion()) {
				cineMayor = cine;
			}
		}
		
		return cineMayor;
	}
	
	
	public void incorporar(Cine cine) {		
		if(!this.cines.exists(cine.identificate())) this.cines.add(cine);
	}
	
	
	public ListaCinesPorCapacidad ordenarCinesPorCapacidad() {
		ListaCinesPorCapacidad cinesOrdenados = new ListaCinesPorCapacidad();
		
		for (Cine cine : this.cines) {
			cinesOrdenados.add(cine);
		}
		
		return cinesOrdenados;
	}
}
