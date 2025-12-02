package ar.edu.ort.cines.classes.tdas;

import ar.edu.ort.cines.classes.Cine;
import ar.edu.ort.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaCinesPorIdentificador extends ListaOrdenadaNodos<String, Cine> {

	@Override
	public int compare(Cine cine1, Cine cine2) {
		return cine1.identificate().compareTo(cine2.identificate());
	}

	@Override
	public int compareByKey(String identificador, Cine cine) {
		return identificador.compareTo(cine.identificate());
	}

}
