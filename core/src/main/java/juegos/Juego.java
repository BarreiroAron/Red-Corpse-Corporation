package juegos;

import java.util.ArrayList;
import java.util.Collections;

import Entidades.Entidad;
import cartas.Carta;
import cartasEspeciales.IMHERE;
import cartasEspeciales.Inanicion;
import cartasMalas.PecadoDeLaCodicia;
import cartasMalas.Sonambulo;
import cartasNormales.CambioDeRonda;
import cartasNormales.Chester;
import cartasNormales.Colera;
import cartasNormales.Company;
import cartasNormales.Estrenimiento;
import cartasNormales.HambreContenida;
import cartasNormales.KingDice;
import cartasNormales.Mimico;
import cartasNormales.NotToday;
import cartasNormales.OjoQueTodoLoVe;
import cartasNormales.Redento;
import cartasNormales.Saltamontes;
import cartasNormales.Snake;
import cartasNormales.ThanksForPlaying;

public class Juego implements ControladorDeJuego, TiempoListener {
	
	private int direccionRonda = 1;
	private int turno;
	private int cantidadCartasMazo;
	
	private ArrayList<Carta> mazo;
	private ArrayList<Carta> mesa = new ArrayList<>();;
	private ArrayList<Entidad> jugadores;
	
	private int indiceMesa=0;
	private int indiceMazo=0;
	private int indiceJugadorActual=0;
	private int tiempo =2;
	private int rondas=0;
	
	
	private boolean debeReiniciar= false;
	
	public Juego( ArrayList<Entidad> Jugadores){
		this.jugadores= Jugadores;
		iniciarMazo();
		repartirCartas();
		HiloTiempoPartida hiloDeTiempo = new HiloTiempoPartida(this);
		hiloDeTiempo.setMinutos(tiempo);
		hiloDeTiempo.start();
	}


	private void iniciarMazo() {
		System.out.println("Se creo mazo");
		mazo = new ArrayList<>();
		
		// Cartas normales
		mazo.add(new CambioDeRonda());
		mazo.add(new Chester());
		mazo.add(new Colera());
		mazo.add(new Company());
		mazo.add(new Estrenimiento());
		mazo.add(new HambreContenida());
		mazo.add(new KingDice());
		mazo.add(new Mimico());
		mazo.add(new NotToday());
		mazo.add(new OjoQueTodoLoVe());
		mazo.add(new Redento());
		mazo.add(new Saltamontes());
		mazo.add(new Snake());
		mazo.add(new ThanksForPlaying());
		

		// Cartas malas
		mazo.add(new PecadoDeLaCodicia());
		mazo.add(new Sonambulo());

		// Cartas especiales
		mazo.add(new IMHERE());
		mazo.add(new Inanicion());
		
		cantidadCartasMazo = mazo.size();
		
	    Collections.shuffle(mazo);
	}
	
	public void actualizar(){
		actualizarReiniciarPartida();
	}
	
	public void jugarCarta(Carta carta, Entidad jugador) {
		Entidad enemigo = carta.getEnemigoDeterminado(jugadores,jugador);
		jugador.modificarPuntos(carta.getPuntosDisminuidos(), carta.getPorcentual());
		enemigo.modificarPuntos(carta.getPuntosAumentadosRival(), carta.getPorcentual());
	    carta.getHabilidad().ejecutar(carta, jugador, enemigo, this);
	}
	
	private void repartirCartas() {
		System.out.println("Se reparten cartas");
		for (Entidad jugador : jugadores) {
	        for (int i = 0; i < 3; i++) {
	            if (!mazo.isEmpty()) {
	                Carta carta = mazo.remove(0);
	                jugador.agregarCarta(carta); 
	            }
	        }
	    }
		
	}
	
	public void robarCartaMazo(Entidad jugador) {
		Carta carta = mazo.remove(0);
		jugador.agregarCarta(carta);
	}
	

	public void marcarReinicio() {
	    debeReiniciar = true;
	}

	public void actualizarReiniciarPartida() {
	    if (debeReiniciar) {
	        reiniciarPartida();
	        debeReiniciar = false;
	    }
	}

	
	public void reiniciarPartida() {
		for(Entidad jugador : jugadores) {
			jugador.getMano().clear();
		}
		mesa.clear();
		iniciarMazo();
		repartirCartas();
		
		System.out.println("Partida reiniciada por Company");
	}

	
	public Entidad getJugadorActual() {
		return jugadores.get(indiceJugadorActual);
	}
	
	public void agregarCartaMesa(Carta  carta) {
		mesa.add(carta);
		aumentarIndiceMesa();
	}
	
	public void sumarRonda() {
		this.rondas++;
		System.out.println("Se sumo una ronda");
		siguienteJugador();
	}
	
	public void siguienteJugador() {
	    int cantidadJugadores = jugadores.size();
	    indiceJugadorActual = (indiceJugadorActual + direccionRonda + cantidadJugadores) % cantidadJugadores;
	}
	
	public void invertirOrden() {
	    direccionRonda *= -1;
	}
	
	private int getIndiceJugador() {
		return indiceJugadorActual;
	}
	
	private void setIndiceJugador(int cambioDeIndice) {
		this.indiceJugadorActual = cambioDeIndice;
	}

	public Entidad getJugador(int indice) {
		return jugadores.get(indice);
	}
	
	public ArrayList<Entidad> getJugadores() {
		return jugadores;
	}
	
	public ArrayList<Carta> getMesa() {
		return mesa;
	}
	
	public int getIndiceMesa() {
		return indiceMesa;
	}
	
	public void aumentarIndiceMesa() {
		indiceMesa++;
	}

	public int getDireccionRonda() {
		return direccionRonda;
	}

	public int getCantidadCartasMazo() {
		return cantidadCartasMazo;
	}

	public void setCantidadCartasMazo(int cantidadCartasMazo) {
		this.cantidadCartasMazo = cantidadCartasMazo;
	}

	@Override
	public void cambiarDireccion() {
		invertirOrden();
	}

	@Override
	public void robarCarta(Entidad jugador) {
		robarCartaMazo(jugador);
	}
	
	@Override
    public void modificarPuntos(Entidad objetivo, int puntos, boolean esPorcentual) {
        objetivo.modificarPuntos(puntos, esPorcentual);
    }


	@Override
    public void onProgresoActualizado(float nuevoProgreso) {
    }

    @Override
    public void onTiempoFinalizado() {
        // Acá podrías decidir reiniciar el hilo o pasar a otro estado del juego
    }


}