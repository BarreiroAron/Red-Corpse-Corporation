package menues;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.audio.Sound;

import Pantallas.PantallaCarga;
import Utiles.Animaciones;
import Utiles.Render;
import Utiles.Util;
import cartas.Imagen;
import sonidos.SonidoAmbientalHilo;
import sonidos.SonidoMenuPrincipalHilo;

public class MenuPrincipal implements Screen {

    private final Game game;
    private SpriteBatch batch;

    private Imagen fondo;
    private Imagen botonJugar;
    private Imagen botonOpciones;
    private Imagen botonSalir;

    private float xBoton, yBotonJugar, yBotonOpciones, yBotonSalir;
    private float anchoBoton = 309, altoBoton = 115;

    SonidoMenuPrincipalHilo sonidoMenuPrincipalHilo;
    
    private Screen pantallaAnterior;
    private boolean pausa = false;
    
    private Sound redCorpseCorporationAudio;
    private long idRedCorpseCorporationAudio;
    
    public MenuPrincipal(Game game) {
        this.game = game;
    }
    
    public MenuPrincipal(Game game, Screen pantallaAnterior) {
        this.game = game;
        this.pantallaAnterior = pantallaAnterior;
        this.pausa = true;
    }

    @Override
    public void show() {
    	
        batch = Render.batch;

        fondo = new Imagen("FondoCarga.jpg");
        botonJugar = new Imagen("jugarBoton.png");
        botonOpciones = new Imagen("opcionesBoton.png");
        botonSalir = new Imagen("salirBoton.png");
        
        startAudio();
        
        this.sonidoMenuPrincipalHilo = new SonidoMenuPrincipalHilo();
		this.sonidoMenuPrincipalHilo.start();

        xBoton = (Util.getAnchoPantalla() - anchoBoton) / 2f;
        yBotonJugar = 400f;
        yBotonOpciones = 250f;
        yBotonSalir = 100f;
    }

    @Override
    public void render(float delta) {
        Render.limpiarPantalla();

        float mouseX = Gdx.input.getX();
        float mouseY = Util.getAltoPantalla() - Gdx.input.getY();

        batch.begin();
        fondo.dibujar(batch, 0, 0, Util.getAnchoPantalla(), Util.getAltoPantalla());

        boolean hoverJugar = Animaciones.animarHover(batch, botonJugar, xBoton, yBotonJugar, anchoBoton, altoBoton, mouseX, mouseY, 1.1f, 10f, delta);
        boolean hoverOpciones = Animaciones.animarHover(batch, botonOpciones, xBoton, yBotonOpciones, anchoBoton, altoBoton, mouseX, mouseY, 1.1f, 10f, delta);
        boolean hoverSalir = Animaciones.animarHover(batch, botonSalir, xBoton, yBotonSalir, anchoBoton, altoBoton, mouseX, mouseY, 1.1f, 10f, delta);
        
        batch.end();
        
        if (Gdx.input.justTouched() && Gdx.input.isButtonPressed(Buttons.LEFT)) {
            if (hoverJugar) {
                if (pausa && pantallaAnterior != null) {
                    game.setScreen(pantallaAnterior);
                } else {
                    game.setScreen(new PantallaCarga(game));
                }
            } else if (hoverOpciones) {
                game.setScreen(new MenuOpciones(game, this));
            } else if (hoverSalir) {
                Gdx.app.exit();
            }
        }


    }

    private boolean estaDentro(float mx, float my, float x, float y, float w, float h) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }
    
    public void startAudio() {
        if (redCorpseCorporationAudio == null) {
            redCorpseCorporationAudio = Gdx.audio.newSound(Gdx.files.internal("RedCorpseCorporationAudio.wav")); // Cambiá el nombre si hace falta
            idRedCorpseCorporationAudio = redCorpseCorporationAudio.play();
            redCorpseCorporationAudio.setLooping(idRedCorpseCorporationAudio, false); // No se repite
        }
    }

    public void stopAudio() {
        if (redCorpseCorporationAudio != null) {
            redCorpseCorporationAudio.stop(idRedCorpseCorporationAudio);
            redCorpseCorporationAudio.dispose();
            redCorpseCorporationAudio = null;
        }
    }


    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() { sonidoMenuPrincipalHilo.stop();}
    @Override public void dispose() { sonidoMenuPrincipalHilo.stop();
    }
}
