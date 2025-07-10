package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;

public class Snake extends Carta {

	private int puntosDisminuidos;
	
	//Snake del metal gear solid
	
	/* Permite ver los puntos del rival durante un turno. Baja 8 puntos de tu contador*/

	public Snake() {
		super(0, 8, Habilidad.VER_PUNTOS_RIVAL, new Imagen(Recursos.SNAKE), false, 0, 0, 
				"Permite ver los puntos del rival durante un turno. Baja 8% puntos de tu contador");
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
