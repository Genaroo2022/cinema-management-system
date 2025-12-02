package ar.edu.ort.cines;

import ar.edu.ort.cines.classes.Cine;
import ar.edu.ort.cines.classes.Empresa;

public class Main {

	public static void main(String[] args) {				
		Empresa cinemark = new Empresa();
	
		try {
			
			Cine cine1 = new Cine("Palermo");
			cinemark.incorporar(cine1);

		}catch(IllegalArgumentException ex) {
			
		}
		
		
		try {
			
			Cine cine2 = new Cine("Abasto");			
			cinemark.incorporar(cine2);
			
		}catch(IllegalArgumentException ex) {
			
			System.out.println("No se pudo crear el cine. EL motivo fue: " + ex.getMessage());
		
		}

		try {
			
			Cine cine3 = new Cine("Puerto Madero");
			cinemark.incorporar(cine3);
			
		}catch(IllegalArgumentException ex) {
			
			System.out.println("No se pudo crear el cine. EL motivo fue: " + ex.getMessage());
		
		}
		
		
		System.out.println("El cine con mayor duración fue: " + cinemark.mayorDuracion());
	}
}
