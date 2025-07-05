package cartasNormales;

import cartas.Carta;
import cartas.Habilidad;

public class ThanksForPlaying extends Carta {

	//Carta de fresa ThanksForPlaying del Celeste
	/*Tus puntos se reducen en 15.*/
	
	private int puntosDisminuidos;


	public ThanksForPlaying(int puntosAumentadosRival, int puntosDisminuidos, boolean robarCarta, Habilidad habilidad,
			String texturaCarta, String texturaCartaEspalda) {
		super(puntosAumentadosRival, puntosDisminuidos, robarCarta, habilidad, texturaCarta, texturaCartaEspalda);
	}

	@Override
	public void setPuntosDisminuidos(int puntosDisminuidos) {
		this.puntosDisminuidos = puntosDisminuidos;
	}
}
