package menues;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import Utiles.Recursos;
import Utiles.Render;

public class MenuCartas implements Screen {
	
    private final Game game;
    private final Screen pantallaAnterior;
    private Stage stage;
    private Texture fondoTexture;
    private Texture texSalirUp, texSalirDn;
    private OrthographicCamera camera;
    private Viewport viewport;
    private static final float VIRTUAL_WIDTH = 1920f;
    private static final float VIRTUAL_HEIGHT = 1080f;
    
    public MenuCartas(Game game, Screen pantallaAnterior) {
        this.game = game;
        this.pantallaAnterior = pantallaAnterior;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        viewport = new FitViewport(VIRTUAL_WIDTH, VIRTUAL_HEIGHT, camera);
        camera.position.set(VIRTUAL_WIDTH / 2f, VIRTUAL_HEIGHT / 2f, 0);
        stage = new Stage(viewport, Render.batch);
        Gdx.input.setInputProcessor(stage);
        fondoTexture = new Texture(Gdx.files.internal(Recursos.FONDO));
        texSalirUp = new Texture(Gdx.files.internal("salirBoton.png"));
        texSalirDn = new Texture(Gdx.files.internal("salirBoton.png"));
        
        Image fondo = new Image(new TextureRegionDrawable(fondoTexture));
        fondo.setFillParent(true);
        stage.addActor(fondo);
        Table root = new Table();
        root.setFillParent(true);
        root.center().top().padTop(100);

        int cartasPorFila = 5;
        int totalCartas = Recursos.CARTAS.size();
        for (int i = 0; i < totalCartas; i++) {
            Texture cartaTexture = new Texture(Gdx.files.internal(Recursos.CARTAS.get(i)));
            Image carta = new Image(new TextureRegionDrawable(cartaTexture));
            carta.setSize(250, 350);
            root.add(carta).pad(20);
            if ((i + 1) % cartasPorFila == 0)
                root.row();
            }

        ImageButtonStyle salirStyle = new ImageButtonStyle();
        salirStyle.up = new TextureRegionDrawable(texSalirUp);
        salirStyle.down = new TextureRegionDrawable(texSalirDn);
        ImageButton btnSalir = new ImageButton(salirStyle);
        btnSalir.addListener(new ChangeListener() {
        	
            @Override
            public void changed(ChangeEvent event, com.badlogic.gdx.scenes.scene2d.Actor actor) {
            	game.setScreen(pantallaAnterior);
            	dispose();
                }
            });

        Table contenedorSalir = new Table();
        contenedorSalir.bottom().right().pad(50);
        contenedorSalir.setFillParent(true);
        contenedorSalir.add(btnSalir).size(200, 80);
        stage.addActor(root);
        stage.addActor(contenedorSalir);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        stage.act(delta);
        stage.draw();
    }
    
    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override public void pause() {}
    @Override public void resume() {}
    @Override public void hide() {}
    
    @Override
    public void dispose() {
        stage.dispose();
        fondoTexture.dispose();
        texSalirUp.dispose();
        texSalirDn.dispose();
    }
}