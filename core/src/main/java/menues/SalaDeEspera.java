package menues;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Input.Buttons;

import Utiles.Imagen;
import Utiles.Animaciones;
import Utiles.Render;

import Pantallas.PantallaCarga;
import red.HiloCliente;

public class SalaDeEspera implements Screen {

    private final Game game;
    private final HiloCliente hiloCliente;

    private SpriteBatch batch;
    private BitmapFont font;

    private Imagen fondo;
    private Imagen botonListo;
    private Imagen botonVolver;

    private OrthographicCamera camera;
    private Viewport viewport;

    private float xBotonListo, yBotonListo;
    private float xBotonVolver, yBotonVolver;
    private float anchoBoton = 309, altoBoton = 115;

    private float mouseX, mouseY;

    private static final float VIRTUAL_WIDTH = 1920;
    private static final float VIRTUAL_HEIGHT = 1080;

    private boolean listo = false;
    private static int jugadoresConectados = 1;

    public SalaDeEspera(Game game, HiloCliente hiloCliente) {
        this.game = game;
        this.hiloCliente = hiloCliente;
    }

    public static void setJugadoresConectados(int n) {
        jugadoresConectados = n;
    }

    @Override
    public void show() {
        batch = Render.batch;
        font = new BitmapFont();

        fondo = new Imagen("FondoCarga.jpg");
        botonListo = new Imagen("jugarBoton.png");
        botonVolver = new Imagen("salirBoton.png"); // usamos la misma textura que “salir” del menú

        camera = new OrthographicCamera();
        viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
        camera.position.set(VIRTUAL_WIDTH / 2f, VIRTUAL_HEIGHT / 2f, 0);

        // posiciones
        xBotonListo = (VIRTUAL_WIDTH - anchoBoton) / 2f;
        yBotonListo = 250f;

        xBotonVolver = 100f;
        yBotonVolver = 100f;
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla();

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        Vector3 mouse = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        viewport.unproject(mouse);
        mouseX = mouse.x;
        mouseY = mouse.y;

        batch.begin();

        fondo.dibujar(batch, 0, 0, VIRTUAL_WIDTH, VIRTUAL_HEIGHT);

        // --- Texto principal ---
        String textoJugadores = "Jugadores conectados: " + jugadoresConectados + "/2";
        font.draw(batch, textoJugadores, 50f, VIRTUAL_HEIGHT - 50f);

        String textoEstado = listo
                ? "Esperando a que todos los jugadores pongan LISTO..."
                : "Toca el boton LISTO cuando quieras empezar la partida.";
        font.draw(batch, textoEstado, 50f, VIRTUAL_HEIGHT - 100f);

        // --- Dibujar botones ---
        botonListo.dibujar(batch, xBotonListo, yBotonListo, anchoBoton, altoBoton);
        botonVolver.dibujar(batch, xBotonVolver, yBotonVolver, anchoBoton, altoBoton);

        // Hover animaciones
        boolean hoverListo = Animaciones.animarHover(
                batch,
                botonListo,
                xBotonListo, yBotonListo,
                anchoBoton, altoBoton,
                mouseX, mouseY,
                1.1f,
                10f,
                delta
        );

        boolean hoverVolver = Animaciones.animarHover(
                batch,
                botonVolver,
                xBotonVolver, yBotonVolver,
                anchoBoton, altoBoton,
                mouseX, mouseY,
                1.1f,
                10f,
                delta
        );

        batch.end();

        // --- Clicks ---
        if (Gdx.input.justTouched() && Gdx.input.isButtonPressed(Buttons.LEFT)) {

            if (!listo && hoverListo) {
                hiloCliente.enviarListo();
                listo = true;
            }

            if (hoverVolver) {
                // Cerrar conexión y volver al menú
                if (hiloCliente != null) {
                    hiloCliente.cerrarConexion();
                }
                game.setScreen(new MenuPrincipal(game));
                return; // salir del render para evitar que siga procesando
            }
        }

        // --- Si el server manda "Empieza" ---
        if (MenuPrincipal.isConectado()) {
            game.setScreen(new PantallaCarga(game,hiloCliente));
        }
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
