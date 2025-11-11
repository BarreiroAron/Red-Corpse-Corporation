package Entidades;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;
import Utiles.TextosCuadrado;

public class Cuadrado {

    public Rectangle cuadrado;
    private boolean hovered;
    public boolean mostrandoTexto;
    private String textoActual = "";
    public String textoVisible = "";
    private float tiempoLetra = 0.05f;
    private float temporizador = 0;
    private int indiceLetra = 0;

    public BitmapFont fuenteColor;
    public ShapeRenderer shape;
    private Sound sonidoHablar;
    private Random random = new Random();
    Color colorCorporation = new Color(0.36f, 0.09f, 0.09f, 1f);

    public Cuadrado() {
    	float ancho = 80f;
    	float alto = 80f;
    	float x = 1920f - ancho - 30f;
    	float y = 30f; 
        cuadrado = new Rectangle(x, y, ancho, alto);
        shape = new ShapeRenderer();
        fuenteColor = new BitmapFont();
        //fuenteColor.setColor(colorCorporation);
        fuenteColor.setColor(Color.BLACK);
        fuenteColor.getData().setScale(1.4f);
        sonidoHablar = Gdx.audio.newSound(Gdx.files.internal("CartaTirada.mp3"));
    }

    public void update(float delta) {
        float mouseX = Gdx.input.getX();
        float mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        hovered = cuadrado.contains(mouseX, mouseY);
        float escala = hovered ? 1.1f : 1.0f;
        cuadrado.setSize(80 * escala, 80 * escala);
        if (hovered && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            sonidoHablar.play(0.5f);
            mostrandoTexto = true;
            textoActual = TextosCuadrado.obtenerTextoAleatorio();
            textoVisible = "";
            indiceLetra = 0;
            temporizador = 0;
        }

        if (mostrandoTexto && indiceLetra < textoActual.length()) {
            temporizador += delta;
            if (temporizador >= tiempoLetra) {
                temporizador = 0;
                textoVisible += textoActual.charAt(indiceLetra);
                indiceLetra++;
            }
        }
    }

    public void render(SpriteBatch batch) {
        batch.end();
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BLACK);
        shape.rect(cuadrado.x, cuadrado.y, cuadrado.width, cuadrado.height);
        shape.end();
        batch.begin();
        if (mostrandoTexto) {
            fuenteColor.draw(batch, textoVisible, 50, 100);
        }
    }
    
    public void renderShape() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.BLACK);
        shape.rect(cuadrado.x, cuadrado.y, cuadrado.width, cuadrado.height);
        shape.end();
    }

    public void renderTexto(SpriteBatch batch) {
        if (mostrandoTexto) {
            fuenteColor.draw(batch, textoVisible, 50, 100);
        }
    }

    public void dispose() {
        shape.dispose();
        fuenteColor.dispose();
        sonidoHablar.dispose();
    }
}