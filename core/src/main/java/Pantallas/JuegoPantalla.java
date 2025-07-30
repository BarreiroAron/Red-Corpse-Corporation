package Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

import Entidades.Entidad;
import cartas.Carta;
import Utiles.Animaciones;
import Utiles.Recursos;
import Utiles.Render;
import cartas.Imagen;
import cartasEspeciales.IMHERE;
import cartasMalas.PecadoDeLaCodicia;
import cartasNormales.KingDice;
import cartasNormales.Redento;
import cartasNormales.ThanksForPlaying;
import juegos.Juego;

import juegos.HiloTiempoPartida;
import juegos.TiempoListener;


public class JuegoPantalla implements Screen{

	private BitmapFont bitmapFont;
	
	private Imagen Mesa;
	private Imagen Cartel;
	private Imagen Enemigo;
	private Imagen cartaEspalda;
	
	private Texture BarraDeTiempo;
	
	private Carta tfp;
	
	private long cooldownMs = 500; 
	private long ultimoClickTime = 0;
	
	private final Game game; // para cambiar pantalla
	private final Juego juego; // tu lógica
	
	//variables para detectar el mouse
	float mouseX = Gdx.input.getX();
	float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();

	
	 private Sound CartaTirada;
	 
	 final float ANCHOCARTA= 150f;
	 final float LARGOCARTA = 250.f;
	 
	 final float CENTRODEMESAX =  (Gdx.graphics.getWidth()/2.f)-ANCHOCARTA/2;
	 final float CENTRODEMESAY = Gdx.graphics.getHeight()/2.f;
	 
	 public JuegoPantalla(Game game, Juego juego) {
		    this.game = game;
		    this.juego = juego;
	}
	
	@Override
	public void show() {
		this.bitmapFont = new BitmapFont();
		
		this.Mesa = new Imagen(Recursos.MESA_PRINCIPAL);
		this.Cartel = new Imagen(Recursos.CARTEL);
		this.Enemigo = new Imagen(Recursos.RIVAL1);
		
		this.BarraDeTiempo =  new Texture(Recursos.TEXTURA_BARRA);
		
		this.CartaTirada = Gdx.audio.newSound(Gdx.files.internal("CartaTirada.mp3"));
		
		this.cartaEspalda = new Imagen(Recursos.CARTA_ESPALDA);
		
		this.tfp = new ThanksForPlaying();
		
	}
	
	@Override
	public void render(float delta) {
		
		 update(delta);
		 
		 if (juego.isPartidaFinalizada()) return;
		
		Render.limpiarPantalla();
		
		Render.batch.begin();
		
		this.Mesa.dibujar();
		this.Cartel.dibujar();
		
		dibujarPuntos(juego.getJugadorActual());
		
		dibujarInterfazJugador(Render.batch,juego.getJugadorActual(),delta);
		
		dibujarMazo(Render.batch,juego.getJugadorActual(),delta);
		
		dibujarMesaCartas(Render.batch);
		
		dibujarBarraTiempo();
		
		//actaliza animacion
		Animaciones.actualizarYDibujarMovimientos(Render.batch, delta);
		
		Render.batch.end();
		
		
		this.juego.actualizar();
		actualizarMouse();
	}
	
	private void update(float delta) {
		
	    if (juego.isPartidaFinalizada()) {
	    	game.setScreen(new PantallaCarga(game));
	        return;
	    }
	}

	//despues ver de generalizar metodos de aumento y click para dibujar mazo y dibujar mano
	private void dibujarMazo(SpriteBatch batch,Entidad jugador,float delta) {
		float y = 150.f;
		float x = 1650.f;
		float anchoCarta = 150.f;
	    float alturaCarta = 250.f;
		
        boolean hovered = Animaciones.animarHover(
                batch,					//batch
                this.cartaEspalda,			 //imagen de la carta
                x, y,					//ubicacion de carta 
                anchoCarta, alturaCarta, //tamaños de carta 
                mouseX, mouseY,		 //ubiacion de mouse
                1.2f,          	// escala maxima
                8f,            	// rapidez
                delta);
        
            if (hovered && Gdx.input.isTouched()) {
    			long tiempoActual = TimeUtils.millis();
                if (tiempoActual - ultimoClickTime >= cooldownMs) {
                	juego.robarCartaMazo(jugador);
                    ultimoClickTime = tiempoActual; // actualiza cooldown
                }
            }
	}
	
	private void dibujarBarraTiempo() {
	    float progreso = juego.getProgresoTiempo(); // de 1.0 a 0.0
	    float anchoMax = 400;
	    float altoBarra = 20;

	    float anchoActual = anchoMax * progreso;

	    float centroX = Gdx.graphics.getWidth() / 2f;
	    float y = 50;

	    float x = centroX - (anchoActual / 2f);

	    Render.batch.draw(BarraDeTiempo, x, y, anchoActual, altoBarra);
	}

	private void dibujarInterfazJugador(SpriteBatch batch, Entidad jugadorActual,float delta) {
		dibujarMano(Render.batch,juego.getJugadorActual(),delta);
		dibujarPuntos(jugadorActual);
	}

	private void dibujarPuntos(Entidad jugador) {
		 if (jugador == null) return;
		   float posX = Gdx.graphics.getWidth() - 150f;
		    float posY = Gdx.graphics.getHeight() - 50f;
		    bitmapFont.draw(Render.batch, jugador.getNombre() + ": " + jugador.getPuntos(), posX, posY);
	}

	private void dibujarMesaCartas(SpriteBatch batch) {
		float anchoCarta = 150f, alturaCarta = 250f;
		
        if (!juego.getMesa().isEmpty()) {
            Carta cartaSuperior = juego.getMesa().get(juego.getMesa().size() - 1);
            cartaSuperior.getTexturaCarta().dibujar(batch, this.CENTRODEMESAX, this.CENTRODEMESAY, anchoCarta, alturaCarta);
        }
	}

	public void dibujarMano(SpriteBatch batch, Entidad jugador,float delta) {

	    ArrayList<Carta> mano = jugador.getMano();

	    float anchoCarta = 150f, alturaCarta = 250f, esp = 10f;
	    float total = mano.size() * anchoCarta + (mano.size() - 1) * esp;
	    float inicioX = (Gdx.graphics.getWidth() - total) / 2f;
	    
	    
	    boolean clicProcesado = false;   // determina el fin del proceso

	    int indice = 0;
	    for (Carta carta : mano) {

	        float x = inicioX + indice * (anchoCarta + esp);
	        float y = 150f;

	        boolean hovered = Animaciones.animarHover(
	                batch, carta.getImagenCarta(),
	                x, y,
	                anchoCarta, alturaCarta,
	                mouseX, mouseY,
	                1.2f,          // escala maxima
	                8f,            // rapidez
	                delta);  
	        
	        //se dibuja las descripciones
	        if (hovered) {
	            bitmapFont.draw(batch, carta.getDescripcion(),20f, Gdx.graphics.getHeight() - 20f);
	        }

	        //logica del click
	        if (!clicProcesado                      // si se proceso el click
	            && hovered
	            && Gdx.input.justTouched()
	            && TimeUtils.timeSinceMillis(ultimoClickTime) >= cooldownMs) {

	            float destinoX = this.CENTRODEMESAX;
	            float destinoY = this.CENTRODEMESAY;

	            Animaciones.iniciarMovimiento(
	                    carta.getImagenCarta(),
	                    x, y,
	                    destinoX, destinoY,
	                    anchoCarta, alturaCarta,
	                    0.25f,
	                    () -> {
	                        sonidoCartaTirada();
	                        juego.jugarCarta(carta, jugador);
	                        juego.agregarCartaMesa(carta);
	                        juego.sumarRonda();
	                        jugador.removerCarta(carta);
	                    });

	            ultimoClickTime = TimeUtils.millis();
	            clicProcesado   = true;             // ← ya no entra en otros clics
	        }

	        indice++;
	    }
	}

	
	private void actualizarMouse() {
		mouseX = Gdx.input.getX();
		mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
	}
	
	public void sonidoCartaTirada() {
	    this.CartaTirada.play();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	

}