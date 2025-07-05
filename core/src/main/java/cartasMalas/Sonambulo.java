package cartasMalas;

import cartas.Carta;
import cartas.Habilidad;

public class Sonambulo extends Carta {

	//Carta de sonambulo (no tiene referencia)

/*Esta carta, al ser 
robada te obliga en los siguientes tres 
turnos a: jugar una carta aleatoria (que el juego decida). De no tener cartas para tirar, 
por cada turno que no se tire ninguna carta, su contador aumenta en 30 */
	
	public Sonambulo(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}

}
