package ar.edu.ort.cines.classes.tdas;

import ar.edu.ort.cines.classes.Sala;
import ar.edu.ort.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaSalasPorCapacidad extends ListaOrdenadaNodos<Integer, Sala> {

	@Override
	public int compare(Sala sala1, Sala sala2) {
		return -1 * (sala1.getCapacidad() - sala2.getCapacidad());
	}

	@Override
	public int compareByKey(Integer capacidad, Sala sala) {
		return -1 * (capacidad - sala.getCapacidad());
	}
	
}
