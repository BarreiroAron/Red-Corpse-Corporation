package jugadores;

public class Jugador {
	
	private String nombre;
	private int cartasEnLaMano;
	private int cartasEnElMazo;//cuidado el mazo es le mismo en jugador y enemigo, no es buena idea ponerlo en jugador
	
	public Jugador(String nombre, int cartasEnLaMano, int cartasEnElMazo) {
		this.nombre = nombre;
		this.cartasEnLaMano = cartasEnLaMano;
		this.cartasEnElMazo = cartasEnElMazo;
	}
	
	public void modificarPuntos(int puntos) {
		System.out.println("Se modificaron " + puntos + " Puntos");
	}
	
	public void robarCarta(boolean robar) {
		
	}
	
	public void bloquearRobo() {
		
	}
}
