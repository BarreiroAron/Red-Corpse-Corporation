package cartasMalas;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Sonambulo extends Carta {

	private int puntosDisminuidos;
	
	//Carta de sonambulo (no tiene referencia)

/*Esta carta, al ser 
robada te obliga en los siguientes tres 
turnos a: jugar una carta aleatoria (que el juego decida). De no tener cartas para tirar, 
por cada turno que no se tire ninguna carta, su contador aumenta en 30 */
	
	public Sonambulo() {
		super(0, 0, Habilidad.ROBAR_CARTA, new Imagen(Recursos.PECADO_CODICIA), false, 0, 0, "Esta carta, al ser robada te obliga en los siguientes tres turnos a: jugar una carta aleatoria (que el juego decida). "
				+ "De no tener cartas para tirar, por cada turno que no se tire ninguna carta, su contador aumenta en 30 \n"
				+ "	(En el turno sin poder tirar, no se puede robar del mazo)\n");
	};

	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
	
}
