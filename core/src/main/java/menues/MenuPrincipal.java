package menues;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Input.Buttons;

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
    
    public MenuPrincipal(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
    	
        batch = Render.batch;

        fondo = new Imagen("FondoCarga.jpg");
        botonJugar = new Imagen("jugarBoton.png");
        botonOpciones = new Imagen("opcionesBoton.png");
        botonSalir = new Imagen("salirBoton.png");

        
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
                game.setScreen(new PantallaCarga(game));
            }else if(hoverOpciones) {
            	game.setScreen(new MenuOpciones(game, this));
            }
            else if (hoverSalir) {
                Gdx.app.exit();
            }
        }

    }

    private boolean estaDentro(float mx, float my, float x, float y, float w, float h) {
        return mx >= x && mx <= x + w && my >= y && my <= y + h;
    }

    @Override public void resize(int width, int height) {}
    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() { sonidoMenuPrincipalHilo.stop();}
    @Override public void dispose() { sonidoMenuPrincipalHilo.stop();
    }
}
