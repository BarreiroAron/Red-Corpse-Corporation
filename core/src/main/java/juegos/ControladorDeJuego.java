package juegos;

import Entidades.Entidad;

public interface ControladorDeJuego {
		void siguienteJugador();
		void modificarPuntos(Entidad objetivo, int puntos, boolean esPorcentual);
		void marcarReinicio();
	    void cambiarDireccion();
	    void robarCarta(Entidad jugador);
	    void mostrarCartasSiguientes(int cantidad);
}
