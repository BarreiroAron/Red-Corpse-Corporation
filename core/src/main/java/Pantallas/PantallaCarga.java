package Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Entidades.CuerpoAnimado;
import Entidades.Entidad;
import Entidades.Jugador;
import Entidades.Rival;
import Utiles.Imagen;
import Utiles.Recursos;
import Utiles.Render;
import Utiles.Util;
import cartas.Carta;
import cartasEspeciales.IMHERE;
import cartasEspeciales.Inanicion;
import cartasMalas.PecadoDeLaCodicia;
import cartasMalas.Sonambulo;
import cartasNormales.CambioDeRonda;
import cartasNormales.Chester;
import cartasNormales.Colera;
import cartasNormales.Company;
import cartasNormales.HambreContenida;
import cartasNormales.KingDice;
import cartasNormales.Mimico;
import cartasNormales.NotToday;
import cartasNormales.OjoQueTodoLoVe;
import cartasNormales.Redento;
import cartasNormales.Saltamontes;
import cartasNormales.Snake;
import cartasNormales.ThanksForPlaying;
import juegos.Juego;
import red.Cliente;

public class PantallaCarga implements Screen {
	
	private final Game game;
	
	private Imagen fondo;
	private final float sumaDeTransparencia = 0.1f;
	private SpriteBatch i;
	private float f = 0;
	private float contadorTiempo = 0, tiempoEsperado = 1.5f;
	private boolean procesoFadeTerminado = false;
	
	private ArrayList<Entidad> jugadores = new ArrayList<>();
	private CuerpoAnimado[] personajesAnimados = Utiles.Util.crearListaImagPerRan();
	
	private Juego juego;
	
	// cámara y viewport
	private OrthographicCamera camera;
	private Viewport viewport;
	
	private static final float VIRTUAL_WIDTH = 1920;
	private static final float VIRTUAL_HEIGHT = 1080;

	public PantallaCarga(Game game) {
        this.game = game;
    }
	
	@Override
	public void show() { 
		fondo = new Imagen(Recursos.FONDO);
		i = Render.batch;
		fondo.setTransparencia(f);
		for(int i=0 ; i<Cliente.getJugadores().size();i++) {
			CuerpoAnimado cuerpo= Util.crearImagPerPorNombre(Cliente.getIdPersonajesJugadores().get(i));
			
			Cliente.getJugadores().get(i).setCuerpoAnimado(cuerpo);
		}
		
		jugadores.addAll(Cliente.getJugadores());

		// inicializar cámara y viewport
		camera = new OrthographicCamera();
		viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
		camera.position.set(VIRTUAL_WIDTH / 2f, VIRTUAL_HEIGHT / 2f, 0);
	}
	
	@Override
	public void render(float delta) {
		Render.limpiarPantalla();

		// actualizar cámara
		camera.update();
		i.setProjectionMatrix(camera.combined);

		i.begin();
			// dibujar fondo en coords virtuales
			fondo.dibujar(i, 0, 0, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);
		i.end();
		
		procesarFade();
	}

	private void procesarFade() {
		if (!procesoFadeTerminado) {
			f += sumaDeTransparencia;
			if (f > 1) {
				f = 1;
				procesoFadeTerminado = true;
			}
		} else {
			contadorTiempo += sumaDeTransparencia;
			if (contadorTiempo > tiempoEsperado) {
				f -= 0.01f;
				if (f < 0) {
				    f = 0;

				    // 1) Crear el juego local con tu lista de jugadores
				    Juego juego = new Juego(jugadores, false);  // ✅ modo cliente, sin mazo/reparto


				    // 2) Sincronizar ese juego con lo que dijo el servidor (INIT)
				    aplicarDatosDeServidorAlJuego(juego);
				    
				    int playerIndex = Cliente.getPlayerIndex();
				    String nombreEntidad = Cliente.getNombreEntidad();
				    String[] cartasIds = Cliente.getCartasIniciales();

				    Entidad miEntidad = juego.getJugadores().get(playerIndex);
				    miEntidad.nombre = nombreEntidad;

				    ArrayList<Carta> mano = new ArrayList<>();
				    for (String id : cartasIds) {
				        Carta c = crearCartaDesdeId(id);   // usando el ID único de carta
				        if (c != null) mano.add(c);
				    }
				    miEntidad.setMano(mano);
				    
				    // 3) Pasar a la pantalla de juego con ese juego sincronizado
				    game.setScreen(new JuegoPantalla(game, juego));
				}
			}
		}
		fondo.setTransparencia(f);
	}
	
	private void aplicarDatosDeServidorAlJuego(Juego juego) {

	    // Si todavía no recibiste INIT, no hacemos nada
	    if (Cliente.getCartasIniciales() == null) {
	        System.out.println("[CLIENTE] No hay datos INIT del servidor todavía.");
	        return;
	    }

	    int playerIndex = Cliente.getPlayerIndex();
	    String nombreEntidad = Cliente.getNombreEntidad();
	    String[] cartasCodigos = Cliente.getCartasIniciales();

	    // 1) Buscar TU entidad dentro del Juego según playerIndex
	    //    OJO: asegurate que el orden de 'jugadores' que armaste
	    //    en el cliente coincida con el orden que usa el servidor.
	    Entidad miEntidad = juego.getJugadores().get(playerIndex);

	    // Actualizar el nombre de la entidad para que coincida
	    miEntidad.nombre = nombreEntidad;  // 'nombre' es public en Entidad

	    // 2) Construir la mano EXACTA que mandó el servidor
	    ArrayList<Carta> mano = new ArrayList<>();

	    for (String cod : cartasCodigos) {
	        if (cod == null || cod.isEmpty()) continue;

	        Carta carta = crearCartaDesdeId(cod);

	        if (carta != null) {
	            mano.add(carta);
	        }
	    }

	    // 3) Reemplazar la mano local por la mano que definió el servidor
	    miEntidad.setMano(mano);

	    System.out.println("[CLIENTE] Mano sincronizada con servidor para playerIndex=" + playerIndex);
	}

	
	private Carta crearCartaDesdeId(String id) {
	    switch (id) {
	        case "INANICION":
	            return new Inanicion();
	        case "MIMICO":
	            return new Mimico();
	        case "IMHERE":
	            return new IMHERE();
	        case "PECADO_DE_LA_CODICIA":
	            return new PecadoDeLaCodicia();
	        case "CAMBIO_DE_RONDA":
	            return new CambioDeRonda();
	        case "CHESTER":
	            return new Chester();
	        case "COLERA":
	            return new Colera();
	        case "COMPANY":
	            return new Company();
	        case "ESTENIMIENTO":
	            return new Inanicion();
	        case "HAMBRE_CONTENIDA":
	            return new HambreContenida();
	        case "KING_DICE":
	            return new KingDice();
	        case "NOT_TODAY":
	            return new NotToday();
	        case "OJO_QUE_TODO_LO_VE":
	            return new OjoQueTodoLoVe();
	        case "REDENTO":
	            return new Redento();
	        case "SALTAMONTES":
	            return new Saltamontes();
	        case "SNAKE":
	            return new Snake();
	        case "THANKS_FOR_PLAYING":
	            return new ThanksForPlaying();
	        case "SONAMBULO":
	            return new Sonambulo();
	       
	        default:
	            System.out.println("[CLIENTE] ID desconocido: " + id);
	            return null;
	    }
	}
	
	


	public ArrayList<Entidad> getJugadores() {
		return jugadores;
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}

	@Override public void pause() {}
	@Override public void resume() {}
	@Override public void hide() {}
	@Override public void dispose() {}
}
