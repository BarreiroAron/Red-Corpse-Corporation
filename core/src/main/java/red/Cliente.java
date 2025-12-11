 package red;

import java.util.ArrayList;

import Entidades.Entidad;

public class Cliente {

    private static int playerIndex;
    private static String nombreEntidad;
    private static String[] cartasIniciales;
    private static ArrayList<Entidad> jugadores = new ArrayList<Entidad>();
    private static ArrayList<String> idPersonajesJugadores = new ArrayList<String>();
    private static int turnoActual = 0;
    
    public static void setDatosInit(int index, String entidad, String[] cartas) {
        playerIndex = index;
        nombreEntidad = entidad;
        cartasIniciales = cartas;
    }

    public static void setTurnoActual(int turno) {
        turnoActual = turno;
        System.out.println("El turno actual cambio aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + turno);
        System.out.println("El turno del jugador es aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + playerIndex);
    }

    public static int getTurnoActual() {
        return turnoActual;
    }
    
    public static int getPlayerIndex() {
        return playerIndex;
    }

    public static String getNombreEntidad() {
        return nombreEntidad;
    }

    public static String[] getCartasIniciales() {
        return cartasIniciales;
    }

	public static void agregarJugador(Entidad jugador) {
		jugadores.add(jugador);
	}

	public static ArrayList<Entidad> getJugadores() {
		return jugadores;
	}

	public static ArrayList<String> getIdPersonajesJugadores() {
		return idPersonajesJugadores;
	}

	public static void setIdPersonajesJugadores(String idPersonajesJugadores) {
		Cliente.idPersonajesJugadores.add(idPersonajesJugadores);
	}
	
}

