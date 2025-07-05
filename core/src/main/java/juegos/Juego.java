package juegos;

public class Juego {
	
	private int direccionRonda;
	private int cantidadCartasMazo;
	private String texturaMesa;
	private String texturaCartasRival;
	private String texturaCartasJugador;
	private String texturaCartel;
	private String texturaPuntos;
	
	public Juego(int direccionRonda, int cantidadCartasMazo, String texturaMesa, String texturaCartasRival, String texturaCartasJugador, String texturaCartel, String texturaPuntos) {
		this.direccionRonda = direccionRonda;
		this.cantidadCartasMazo = cantidadCartasMazo;
		this.texturaMesa = texturaMesa;
		this.texturaCartasJugador = texturaCartasJugador;
		this.texturaCartasRival = texturaCartasRival;
		this.texturaCartel = texturaCartel;
		this.texturaPuntos = texturaPuntos;
	}

	public int getDireccionRonda() {
		return direccionRonda;
	}

	public void setDireccionRonda(int direccionRonda) {
		this.direccionRonda = direccionRonda;
	}

	public int getCantidadCartasMazo() {
		return cantidadCartasMazo;
	}

	public void setCantidadCartasMazo(int cantidadCartasMazo) {
		this.cantidadCartasMazo = cantidadCartasMazo;
	}
}
