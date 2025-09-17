package cartasNormales;

import Utiles.Recursos;
import cartas.Carta;
import cartas.Habilidad;
import cartas.Imagen;
import cartas.TipoDeCarta;

public class CambioDeRonda extends Carta {

	//Cartas de cambio de ronda del UNO!
	//Cambia el ciruclo de la ronda
	
	private int puntosDisminuidos;
	
	public CambioDeRonda() {
		super(0, 6, Habilidad.CAMBIO_DIRECCION, new Imagen(Recursos.CAMBIO_DE_RONDA), false, 0, 0, "Esta carta cambia la dirección de la ronda. Reduce en 6% tus puntos",TipoDeCarta.NORMAL);
	}
	
	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
