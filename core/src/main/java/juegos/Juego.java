package juegos;

import java.util.ArrayList;
import java.util.Collections;

import Entidades.Entidad;
import cartas.Carta;
import cartas.TipoDeCarta;
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
import sonidos.SonidoAmbiental;
import sonidos.SonidoManager;

public class Juego implements ControladorDeJuego, TiempoListener {
	
	private int direccionRonda = 1;
	private int cantidadCartasMazo;
	
	private ArrayList<Carta> mazo;
	private ArrayList<Carta> mesa = new ArrayList<>();;
	private ArrayList<Entidad> jugadores;
	
	private int indiceMesa=0;
	private int indiceJugadorActual=0;
	private float tiempo =0.5f;
	private int rondas=0;
	
	Entidad jugadorPerdedor=null;
	
	HiloTiempoPartida hiloDeTiempo;
	
	private boolean debeReiniciar= false;
	
	private boolean partidaFinalizada= false;
	
	private boolean cartasDisponiblesMazo= true;

	public final ArrayList<HabilidadActiva> habilidadesActivas = new ArrayList<>();
	
	private ArrayList<Carta> cartasMostradas = new ArrayList<>();
	
	public Juego( ArrayList<Entidad> Jugadores){
		this.jugadores= Jugadores;
		iniciarMazo();
		repartirCartas();
		this.hiloDeTiempo = new HiloTiempoPartida(this);
		this.hiloDeTiempo.setMinutos(tiempo);
		this.hiloDeTiempo.start();
		SonidoAmbiental VentiladorHilo = new SonidoAmbiental();
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
				//mazo.add(new IMHERE());
				mazo.add(new Inanicion());
		
		cantidadCartasMazo = mazo.size();
		
	    Collections.shuffle(mazo);
	}
	
	public void actualizar(){
		actualizarReiniciarPartida();
		actualizarJugadorPerdedor();
		comprobarPartidaTerminada();
		actualizarCartasDisponiblesMazo();
	}
	
	public void activarBloqueoRobar(Entidad objetivo, int turnos, String descripcion) {
	    habilidadesActivas.add(HabilidadActiva.bloqueoRobarA(objetivo, turnos, descripcion));
	}
	public void activarBloqueoRobarGlobal(int turnos, String descripcion) {
	    habilidadesActivas.add(HabilidadActiva.bloqueoRobarGlobal(turnos, descripcion));
	}
	
	public void activarJugarCartaAleatorea(Entidad objetivo,int turnos, String descripcion) {
	    habilidadesActivas.add(HabilidadActiva.jugarCartaAleatorea(objetivo,turnos, descripcion));
	}
	
	private boolean estaBloqueadoRobar(Entidad jugador) {
	    for (HabilidadActiva ha : habilidadesActivas) {
	        if (ha.getTipo() == HabilidadActiva.Tipo.BLOQUEAR_ROBAR && ha.getTurnosRestantes() > 0) {
	            if (ha.isGlobal()) return true;
	            if (ha.getObjetivo() == jugador) return true;
	        }
	    }
	    return false;
	}
	
	public void activarVerCartas() {
	    habilidadesActivas.add(HabilidadActiva.verSiguientesCartas(2, "habilidad de bill de ver cartas"));
	}

	//bloquea a todos excepto a el tirador
	public void activarBloqueoRobarATodosExcepto(Entidad caster, int turnos, String descripcion) {
	    for (Entidad e : jugadores) {
	        if (e != caster) {
	            activarBloqueoRobar(e, turnos, descripcion);
	        }
	    }
	}
	
	private void tickHabilidadesActivasPara(Entidad jugadorQueTermino) {
	    for (int i = habilidadesActivas.size() - 1; i >= 0; i--) {
	        HabilidadActiva ha = habilidadesActivas.get(i);
	        if (ha.getObjetivo() == jugadorQueTermino) {
	            if (ha.tick()) habilidadesActivas.remove(i);
	        }
	    }
	}
	
	private void tickHabilidadesActivasMixto(Entidad jugadorQueTermino) {
	    for (int i = habilidadesActivas.size() - 1; i >= 0; i--) {
	        HabilidadActiva ha = habilidadesActivas.get(i);
	        boolean debeTickear = ha.isGlobal() || ha.getObjetivo() == jugadorQueTermino;
	        if (debeTickear && ha.tick()) habilidadesActivas.remove(i);
	    }
	}
	
	private void actualizarCartasDisponiblesMazo() {
		if(!cartasDisponiblesMazo) {
			rebarajearMesa();
		}
	}


	private void comprobarPartidaTerminada() {
		
		if(jugadores.size()==1) {
			partidaFinalizada=true;
		}
	}


	private void actualizarJugadorPerdedor() {
		 if (jugadorPerdedor != null) {
		        System.out.println("Jugador eliminado: " + jugadorPerdedor.getNombre());
		        eliminarYReacomodarJugador(jugadorPerdedor);
		        jugadorPerdedor = null;
		    }
	}
	
	private void eliminarYReacomodarJugador(Entidad jugadorAEliminar) {
	    if (jugadores.isEmpty()) return;
	    int indexEliminado = jugadores.indexOf(jugadorAEliminar);
	    if (indexEliminado == -1) return;

	    //Se agregan las cartas de la mano para no perderlas
	    mazo.addAll(jugadores.get(indexEliminado).getMano());
	    //Elimina el juagodor
	    jugadores.remove(indexEliminado);

	    if (jugadores.isEmpty()) {
	        indiceJugadorActual = 0;
	        return;
	    }

	    if (indexEliminado < indiceJugadorActual) {
	        indiceJugadorActual--;
	    } else if (indexEliminado == indiceJugadorActual) {
	    	
	        if (indiceJugadorActual >= jugadores.size()) {
	            indiceJugadorActual = 0;
	        }
	    }

	    if (indiceJugadorActual >= jugadores.size()) {
	        indiceJugadorActual = jugadores.size() - 1;
	    }
	    
	    if(jugadores.size()>1){
	    	hiloDeTiempo = new HiloTiempoPartida(this);
	        hiloDeTiempo.setMinutos(tiempo);
	        hiloDeTiempo.start();
	    }
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
		robarCartaMazo(jugador, false);
	}
	
	public void robarCartaMazo(Entidad jugador, boolean ignorarBloqueosDeRobo) {
	    if (!ignorarBloqueosDeRobo && estaBloqueadoRobar(jugador)) {
	        System.out.println("Bloqueado: " + jugador.getNombre() + " no puede robar del mazo.");
	        return;
	    }
	    if (mazo.size() == 0) {
	        cartasDisponiblesMazo = false;
	        actualizarCartasDisponiblesMazo();
	        return;
	    }

	    // --- se roba carta del mazo ---
	    Carta carta = mazo.remove(0);
	    /*
	    //sonambulo no funciona aun
	    if (carta instanceof Sonambulo) {
	        // activamos efecto Sonámbulo 3 turnos
	        habilidadesActivas.add(HabilidadActiva.sonambulo(jugador, 3,
	                "Debe jugar cartas aleatorias por 3 turnos (Sonámbulo)"));
	        System.out.println(jugador.getNombre() + " robó SONÁMBULO → activado efecto por 3 turnos");
	        // si NO querés que quede en la mano, no agregarla al jugador
	        // si querés que quede, entonces:
	        jugador.agregarCarta(carta);
	        return;
	    } */

	    //pecado de la codicia
	    if (carta instanceof PecadoDeLaCodicia) {
	        for (int i = 0; i < 4 && !jugador.getMano().isEmpty(); i++) {
	            Carta removida = jugador.getMano().remove(0);
	            System.out.println("Se destruyó carta por Pecado de la Codicia: " + removida.getDescripcion());
	        }
	        jugador.agregarCarta(carta);
	        return;
	    }
	    jugador.agregarCarta(carta);
	}


	private void rebarajearMesa(){
		mazo.addAll(mesa);
		mesa.clear();
		cartasDisponiblesMazo=true;
	}
	
	public void mezclarMazo() {
		Collections.shuffle(mazo);
		System.out.println("se mezcla mazo");
	}
	
	public ArrayList<Carta> getListaPorTipoCartas(TipoDeCarta tipo, ArrayList<Carta> ListaCartas1) {
		
		ArrayList<Carta> cartas = new ArrayList();
		
		for(int i=0; i<ListaCartas1.size(); i++ ) {
			if(ListaCartas1.get(i).getTipo()== tipo) {
				System.out.println("se agrego la carta  = " + ListaCartas1.get(i).getDescripcion());
				cartas.add(ListaCartas1.get(i));
			}
		}
		
		return cartas;
	}
	
	public void pasarCartas(ArrayList<Carta> ListaCartas1 , ArrayList<Carta> LiscaCartas2) {
		
		for(int i=0;i<ListaCartas1.size();i++) {
			LiscaCartas2.add(ListaCartas1.get(i));
		}
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

	public void eliminarPorListaCartas(ArrayList<Carta> ListaCartas1 , ArrayList<Carta> LiscaCartas2) {
		boolean encontrado= false;
		for(int i=0;i<ListaCartas1.size();i++) {
			int n=0;
			while(n<LiscaCartas2.size()|| encontrado) {
				if(LiscaCartas2.get(n).getTipo()==ListaCartas1.get(i).getTipo()) {
					System.out.println("carta eliminada = " + LiscaCartas2.get(n).getDescripcion());
					LiscaCartas2.remove(n);
				}
				n++;
			}
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
		 Entidad saliente = jugadores.get(indiceJugadorActual);
		 tickHabilidadesActivasMixto(saliente); //baja un tick a cada habilidad 

	    int cantidadJugadores = jugadores.size();
	    indiceJugadorActual = (indiceJugadorActual + direccionRonda + cantidadJugadores) % cantidadJugadores;
	}
	
	public void invertirOrden() {
	    direccionRonda *= -1;
	}
	
	public void aumentarIndiceMesa() {
		indiceMesa++;
	}

	
	@Override
	public void mostrarCartasSiguientes(int cantidad) {
	    ArrayList<Carta> cartasMostradas = new ArrayList<>();
	    for (int i = 0; i < cantidad && i < mazo.size(); i++) {
	        cartasMostradas.add(mazo.get(i));
	    }
	    setCartasMostradas(cartasMostradas);

	    System.out.println("Mostrando próximas " + cantidad + " cartas:");
	    for (Carta c : cartasMostradas) {
	        System.out.println("- " + c.getClass().getSimpleName());
	    }
	}

	private void asignarJugadorPerdedor() {
	    if (jugadores.isEmpty()) return;

	    Entidad perdedor = jugadores.get(0);
	    int mayorPuntaje = perdedor.getPuntos();

	    for (Entidad jugador : jugadores) {
	        if (jugador.getPuntos() > mayorPuntaje) {
	            perdedor = jugador;
	            mayorPuntaje = jugador.getPuntos();
	        }
	    }

	    jugadorPerdedor = perdedor;

	    if (hiloDeTiempo != null) {
	        hiloDeTiempo.terminar();
	    }
	}

	
	public Entidad getJugadorActual() {
	    if (jugadores.isEmpty()) return null;

	    if (indiceJugadorActual >= jugadores.size()) {
	        indiceJugadorActual = 0;
	    }

	    return jugadores.get(indiceJugadorActual);
	}

	
	private int getIndiceJugador() {
		return indiceJugadorActual;
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
	
	public int getDireccionRonda() {
		return direccionRonda;
	}

	public int getCantidadCartasMazo() {
		return cantidadCartasMazo;
	}
	
	public ArrayList<Carta> getCartasMostradas() {
		return cartasMostradas;
	}

	public ArrayList<Carta> getMazo() {
	    return mazo;
	}
	
	public void setCantidadCartasMazo(int cantidadCartasMazo) {
		this.cantidadCartasMazo = cantidadCartasMazo;
	}

	
	public void setCartasMostradas(ArrayList<Carta> cartasMostradas) {
	    this.cartasMostradas = cartasMostradas;
	}
	
	private void setIndiceJugador(int cambioDeIndice) {
		this.indiceJugadorActual = cambioDeIndice;
	}
	
	public boolean isPartidaFinalizada() {
		return partidaFinalizada;
	}
	
	@Override
	public void cambiarDireccion() {
		invertirOrden();
	}

	@Override
	public void robarCarta(Entidad jugador) {
		robarCartaMazo(jugador);
	}
	
	public float getProgresoTiempo() {
	    if (hiloDeTiempo == null) return 0f;
	    return hiloDeTiempo.getProgreso(); // ← accede al hilo real
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
    		asignarJugadorPerdedor();
    }


	public void activarVerPuntos() {
		habilidadesActivas.add(HabilidadActiva.verPuntos());
	}
	
	public boolean isHabilidadActiva(HabilidadActiva.Tipo tipo) {
	    for (HabilidadActiva ha : habilidadesActivas) {
	        if (ha.getTipo() == tipo) return true;
	    }
	    return false;
	}
	
	public boolean isHabilidadActivaEnJugador(HabilidadActiva.Tipo tipo,Entidad jugador) {
		for (HabilidadActiva ha : habilidadesActivas) {
	        if (ha.getTipo() == tipo && ha.getTurnosRestantes() > 0) {
	            if (ha.getObjetivo() == jugador) return true;
	        }
	    }
	    return false;
	}


	@Override
	public void intercambiarPuntos(Entidad jugador, Entidad rival) {
	    int puntosJugador = jugador.getPuntos();
	    int puntosRival   = rival.getPuntos();

	    jugador.puntos = puntosRival;
	    rival.puntos   = puntosJugador;
	}

}