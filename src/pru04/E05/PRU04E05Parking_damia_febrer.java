package pru04.E05;

import java.util.HashMap;

public class PRU04E05Parking_damia_febrer {

	HashMap Mapa = new HashMap(105);
	private int places_no_discapacitats;
	private int places_discapacitats;

	public enum TipusPlacesParking {
		discapacitada,
		normal,
	}

	public PRU04E05Parking_damia_febrer(int places_no_discapacitats,int places_discapacitats) {
		this.places_no_discapacitats = places_no_discapacitats;
		this.places_discapacitats = places_discapacitats;
	}

	public void llegirMatricules(String path) throws Exception{
		/*Coger matriculas de un fichero*/
	}

	public int entraCotxe(String matricula) throws Exception{
		/*Añadir un coche al HASHMAP y quitar una plaza libre*/	
		try {
			if(places_no_discapacitats != 0) {
				Mapa.put(places_no_discapacitats --, matricula);
			}
		}
		catch(Exception e) {
		}
		return places_no_discapacitats;
	}

	public int entraCotxeDiscapacitat(String matricula) throws Exception{
		/*Añadir un coche discap. al HASHMAP y quitar una plaza libre*/
		try {
			int places;
			if(places_discapacitats != 0) {
				Mapa.put(places_discapacitats --, matricula);
			}
			if(places_discapacitats == 0 && places_no_discapacitats != 0) {
				Mapa.put(places_no_discapacitats --, matricula);
			}
			places = places_no_discapacitats + places_discapacitats;
		}
		catch(Exception e) {
			
		}
		return places;
	}

	public void surtCotxe(String matricula) throws Exception{
		/*Quitar un coche del HASHMAP y liberar la posicion*/
	}

	public void surtCotxeDiscapacitat(String matricula) throws Exception{
		/*Quitar un coche discap. del HASHMAP y liberar la posicion*/
	}

	public int getPlacesOcupades(TipusPlacesParking tipus) {
		/*Mostrar el numero de plazas ocupadas*/
	}

	public int getPlacesLliures(TipusPlacesParking tipus) {
		/*Mostrar el numero de plazas libres*/
	}

	public void guardarMatricules(String path) throws Exception{
		/*Esto tiene que guardar las matriculas que estan en el HASHMAP en un fichero. Excepciones de fichero no encontrado, etc*/
	}
}
