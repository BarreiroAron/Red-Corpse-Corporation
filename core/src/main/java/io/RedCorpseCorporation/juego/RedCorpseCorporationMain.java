package io.RedCorpseCorporation.juego;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class RedCorpseCorporationMain extends Game {
    private SpriteBatch batch;
    private Texture MesaPrincipal;
    private Texture CartelPuntaje;

    private OrthographicCamera camera;
    private Viewport viewport;

    private static final float VIRTUAL_WIDTH = 1920;
    private static final float VIRTUAL_HEIGHT = 1080;
    
    @Override
    public void create() {
        batch = new SpriteBatch();
        MesaPrincipal = new Texture("MesaPrincipal.png");
        CartelPuntaje = new Texture("CartelUno1920-1080.png");
        
        camera = new OrthographicCamera();
        viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
        viewport.apply();

        camera.position.set(VIRTUAL_WIDTH / 2, VIRTUAL_HEIGHT / 2, 0);
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        batch.draw(MesaPrincipal, VIRTUAL_WIDTH/2 - MesaPrincipal.getWidth()/2, 0);
        batch.draw(CartelPuntaje, VIRTUAL_WIDTH - CartelPuntaje.getWidth(), VIRTUAL_HEIGHT - CartelPuntaje.getHeight());
        batch.end();
    }
    
    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void dispose() {
        batch.dispose();
        MesaPrincipal.dispose();
        CartelPuntaje.dispose();
    }
}
