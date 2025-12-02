package ar.edu.ort.cines.classes.tdas;

import ar.edu.ort.cines.classes.Cine;
import ar.edu.ort.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaCinesPorCapacidad extends ListaOrdenadaNodos<Integer, Cine> {

	@Override
	public int compare(Cine cine1, Cine cine2) {
		return cine2.getCapacidad() - cine1.getCapacidad();
	}

	@Override
	public int compareByKey(Integer capacidad, Cine cine) {
		return cine.getCapacidad() - capacidad;
	}

}
