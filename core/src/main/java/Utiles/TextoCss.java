package Utiles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TextoCss extends ApplicationAdapter {

    private SpriteBatch batch;
    private BitmapFont fuente;
    private OrthographicCamera camara;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        camara = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camara.setToOrtho(false);
        fuente = new BitmapFont(Gdx.files.internal("fuente.fnt"));
        PersonalizarTexto.configurarFuente(fuente, 1.5f, Color.GOLD, Color.BLACK);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camara.combined);
        batch.begin();
        String descripcion = null;
        PersonalizarTexto.textoCarta(fuente, batch, descripcion, 100, 200);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        fuente.dispose();
    }
}