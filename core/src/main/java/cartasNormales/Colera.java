package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class Colera extends Carta {

	//Colera (esta es una carta sin referencia
	
	/*
Al jugar esta carta, te ves obligado
 en los siguientes 3 turnos a solo robar del mazo. 
 Si en las 3 robadas no sale ninguna carta mala: Tus puntos se reducen en 20.*/

	public Colera(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}

}
