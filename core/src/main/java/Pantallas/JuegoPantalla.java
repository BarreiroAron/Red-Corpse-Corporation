package Pantallas;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import Entidades.Entidad;
import cartas.Carta;
import Utiles.Animaciones;
import Utiles.Recursos;
import Utiles.Render;
import cartas.Imagen;
import cartasNormales.ThanksForPlaying;
import juegos.Juego;
import menues.MenuFinPartida;
import menues.MenuOpciones;
import menues.MenuPrincipal;
import sonidos.SonidoManager;

public class JuegoPantalla implements Screen {

    private BitmapFont bitmapFont;

    private Imagen Mesa;
    private Imagen Cartel;
    private Imagen Enemigo;
    private Imagen cartaEspalda;

    private Texture BarraDeTiempo;

    private Carta tfp;

    private long cooldownMs = 500;
    private long ultimoClickTime = 0;

    private final Game game;   // para cambiar pantalla
    private final Juego juego; // tu lógica

    // Cámara y viewport
    private OrthographicCamera camera;
    private Viewport viewport;

    // variables para detectar el mouse (en coords virtuales)
    float mouseX;
    float mouseY;

    private Sound CartaTirada;

    final float ANCHOCARTA = 150f;
    final float LARGOCARTA = 250.f;

    private float ANCHO_PERSONAJE=450f;
	private float LARGO_PERSONAJE=700f;
    
    final float CENTRODEMESAX;
    final float CENTRODEMESAY;

    private boolean menuPausaActivo = false;

    public JuegoPantalla(Game game, Juego juego) {
        this.game = game;
        this.juego = juego;

        // inicializamos la cámara y el viewport con 1920x1080 (virtual)
        camera = new OrthographicCamera();
        viewport = new FitViewport(1920, 1080, camera);
        camera.position.set(1920 / 2f, 1080 / 2f, 0);

        // centro de la mesa según la resolución virtual
        CENTRODEMESAX = (1920 / 2f) - ANCHOCARTA / 2;
        CENTRODEMESAY = 1080 / 2f;
    }

    @Override
    public void show() {
        this.bitmapFont = new BitmapFont();

        this.Mesa = new Imagen(Recursos.MESA_PRINCIPAL);
        this.Cartel = new Imagen(Recursos.CARTEL);
        this.Enemigo = new Imagen(Recursos.RIVAL1);

        this.BarraDeTiempo = new Texture(Recursos.TEXTURA_BARRA);

        this.CartaTirada = Gdx.audio.newSound(Gdx.files.internal("CartaTirada.mp3"));

        this.cartaEspalda = new Imagen(Recursos.MAZO_CARTAS);

        this.tfp = new ThanksForPlaying();
    }

    @Override
    public void render(float delta) {
        update(delta);
        
        this.menuPausaActivo = false;

        if (juego.isPartidaFinalizada()) return;

        Render.limpiarPantalla();

        // muy importante: la cámara debe actualizarse en cada frame
        camera.update();
        Render.batch.setProjectionMatrix(camera.combined);

        Render.batch.begin();

        this.Mesa.dibujar();
        this.Cartel.dibujar();

        dibujarPuntos(juego.getJugadorActual());

        dibujarInterfazJugador(Render.batch, juego.getJugadorActual(), delta);

        dibujarMazo(Render.batch, juego.getJugadorActual(), delta);
        
        dibujarJugadores(Render.batch);

        dibujarMesaCartas(Render.batch);

        dibujarBarraTiempo();
        
        
        
        // actualiza animaciones
        Animaciones.actualizarYDibujarMovimientos(Render.batch, delta);

        Render.batch.end();

        this.juego.actualizar();
        actualizarMouse();
    }

    private void update(float delta) {
    	if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
	        if (!menuPausaActivo) {
	            game.setScreen(new MenuOpciones(game, this));
	            menuPausaActivo = true;
	        }
	    }
        if (juego.isPartidaFinalizada()) {
            game.setScreen(new MenuFinPartida(game));
            return;
        }
    }

    private void actualizarMouse() {
        Vector3 mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        viewport.unproject(mouse); // convierte a coords virtuales
        mouseX = mouse.x;
        mouseY = mouse.y;
    }
    
    private void dibujarJugadores(SpriteBatch batch) {

	    Entidad jugadorActual = juego.getJugadorActual();   // puede ser null

	    int total    = juego.getJugadores().size();

	    int visibles = (jugadorActual == null) ? total : total - 1;

	    if (visibles <= 0) return;
	    
	    float paso        = (float) camera.viewportWidth / (visibles + 1);
	    float alturaBase  = 550f;
	    float delta       = Gdx.graphics.getDeltaTime();   

	    int indiceVisible = 0;

	    for (Entidad jugador : juego.getJugadores()) {

	        if (jugador == jugadorActual) continue;         // saltamos turno

	        float x = paso * (indiceVisible + 1) - LARGO_PERSONAJE / 2f;
	        float y = alturaBase + (((indiceVisible % 2 == 0)&& total>3 )? 75f : 0f);


	        jugador.getCuerpo().draw(batch,                         //se dibuja por frames
	                     (x), (camera.viewportHeight -y),
	                     LARGO_PERSONAJE, ANCHO_PERSONAJE,
	                     delta);
	        
	        indiceVisible++;


	    }


	}

    private void dibujarMazo(SpriteBatch batch, Entidad jugador, float delta) {
        float y = 150f;
        float x = 1650f;
        float anchoCarta = 150f;
        float alturaCarta = 250f;

        boolean hovered = Animaciones.animarHover(
                batch,
                this.cartaEspalda,
                x, y,
                anchoCarta, alturaCarta,
                mouseX, mouseY,
                1.2f,
                8f,
                delta);

        if (hovered && Gdx.input.isTouched()) {
            long tiempoActual = TimeUtils.millis();
            if (tiempoActual - ultimoClickTime >= cooldownMs) {
                juego.robarCartaMazo(jugador);
                juego.siguienteJugador();
                ultimoClickTime = tiempoActual;
            }
        }
    }

    private void dibujarBarraTiempo() {
        float progreso = juego.getProgresoTiempo(); // de 1.0 a 0.0
        float anchoMax = 400;
        float altoBarra = 20;

        float anchoActual = anchoMax * progreso;

        float centroX = camera.viewportWidth / 2f;
        float y = 50;

        float x = centroX - (anchoActual / 2f);

        Render.batch.draw(BarraDeTiempo, x, y, anchoActual, altoBarra);
    }

    private void dibujarInterfazJugador(SpriteBatch batch, Entidad jugadorActual, float delta) {
        dibujarMano(Render.batch, juego.getJugadorActual(), delta);
        dibujarPuntos(jugadorActual);
    }

    private void dibujarPuntos(Entidad jugador) {
        if (jugador == null) return;
        float posX = camera.viewportWidth - 150f;
        float posY = camera.viewportHeight - 50f;
        bitmapFont.draw(Render.batch, jugador.getNombre() + ": " + jugador.getPuntos(), posX, posY);
    }

    private void dibujarMesaCartas(SpriteBatch batch) {
        float anchoCarta = 150f, alturaCarta = 250f;

        if (!juego.getMesa().isEmpty()) {
            Carta cartaSuperior = juego.getMesa().get(juego.getMesa().size() - 1);
            cartaSuperior.getTexturaCarta().dibujar(batch, this.CENTRODEMESAX, this.CENTRODEMESAY, anchoCarta, alturaCarta);
        }
    }

    public void dibujarMano(SpriteBatch batch, Entidad jugador, float delta) {
        ArrayList<Carta> mano = jugador.getMano();

        float anchoCarta = 150f, alturaCarta = 250f, esp = 10f;
        float total = mano.size() * anchoCarta + (mano.size() - 1) * esp;
        float inicioX = (camera.viewportWidth - total) / 2f;

        boolean clicProcesado = false;

        int indice = 0;
        for (Carta carta : mano) {

            float x = inicioX + indice * (anchoCarta + esp);
            float y = 150f;

            boolean hovered = Animaciones.animarHover(
                    batch, carta.getImagenCarta(),
                    x, y,
                    anchoCarta, alturaCarta,
                    mouseX, mouseY,
                    1.2f,
                    8f,
                    delta);

            if (hovered) {
                bitmapFont.draw(batch, carta.getDescripcion(), 20f, camera.viewportHeight - 20f);
            }

            if (!clicProcesado
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
                        new Runnable() {
                            @Override
                            public void run() {
                                sonidoCartaTirada();
                                juego.jugarCarta(carta, jugador);
                                juego.agregarCartaMesa(carta);
                                juego.sumarRonda();
                                jugador.removerCarta(carta);
                            }
                        });

                ultimoClickTime = TimeUtils.millis();
                clicProcesado = true;
            }

            indice++;
        }
    }

    public void sonidoCartaTirada() {
        SonidoManager.i().playSfx(this.CartaTirada);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height); // ajusta la vista cuando cambia la pantalla
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    @Override public void dispose() {}
}
