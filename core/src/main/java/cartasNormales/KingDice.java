package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;
import cartas.TipoDeCarta;

public class KingDice extends Carta {

	private int puntosDisminuidos;
	
	//King dice del Cuphead
	
	/*Al jugar esta carta, todo el mazo es barajado y mezclado 
	 * (las cartas con efectos negativos son puestas nuevamente en el mazo). 
	 * Tu contador pierde 7 puntos y tu rival gana 4 puntos.
	 */

	public KingDice() {
		super(4, 7, Habilidad.ROBAR_CARTA, new Imagen(Recursos.KING_DICE), true, 0, 0, 
				"Al jugar esta carta, todo el mazo es barajado y mezclado"
				+ " (las cartas con efectos negativos son puestas nuevamente en el mazo)."
				+ " Tu contador pierde 7% de sus puntos y el de tu rival gana 4% de sus puntos.",TipoDeCarta.NORMAL);
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}