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
    
    // Guardamos la posición original para poder agrandarlo desde el centro
    private float xOriginal, yOriginal;
    private float tamanoBase = 80f;
    private float tamanoHover = 90f; // Qué tan grande se pone

    public Cuadrado() {
        // Posición base (Abajo a la derecha)
        float x = 1920f - tamanoBase - 30f;
        float y = 30f; 
        
        this.xOriginal = x;
        this.yOriginal = y;
        
        cuadrado = new Rectangle(x, y, tamanoBase, tamanoBase);
        shape = new ShapeRenderer();
        fuenteColor = new BitmapFont();
        
        // Configuramos la fuente aquí por defecto, pero se sobreescribe en MenuPrincipal
        fuenteColor.setColor(Color.BLACK);
        fuenteColor.getData().setScale(1.4f);
        
        sonidoHablar = Gdx.audio.newSound(Gdx.files.internal("CartaTirada.mp3"));
    }

    // AHORA RECIBE mouseX y mouseY DESDE EL MENU PRINCIPAL
    public void update(float delta, float mouseX, float mouseY) {
        // 1. Detectar Hover con las coordenadas correctas
        hovered = cuadrado.contains(mouseX, mouseY);
        
        // 2. Efecto de Agrandarse (Scaling)
        if (hovered) {
            // Si el mouse está encima, agrandamos y centramos
            float diferencia = tamanoHover - tamanoBase;
            cuadrado.setSize(tamanoHover, tamanoHover);
            cuadrado.setPosition(xOriginal - (diferencia / 2), yOriginal - (diferencia / 2));
        } else {
            // Si no, volvemos al tamaño normal
            cuadrado.setSize(tamanoBase, tamanoBase);
            cuadrado.setPosition(xOriginal, yOriginal);
        }

        // 3. Detectar Clic para hablar
        if (hovered && Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
            sonidoHablar.play(0.5f);
            mostrandoTexto = true;
            // Generar nuevo texto aleatorio
            textoActual = TextosCuadrado.obtenerTextoAleatorio();
            textoVisible = "";
            indiceLetra = 0;
            temporizador = 0;
        }

        // 4. Efecto de máquina de escribir
        if (mostrandoTexto && indiceLetra < textoActual.length()) {
            temporizador += delta;
            if (temporizador >= tiempoLetra) {
                temporizador = 0;
                textoVisible += textoActual.charAt(indiceLetra);
                indiceLetra++;
            }
        }
    }

    public void renderShape() {
        shape.begin(ShapeRenderer.ShapeType.Filled);
        // Usamos Color.BLACK para el fondo del cuadrado como pediste antes
        shape.setColor(Color.BLACK);
        shape.rect(cuadrado.x, cuadrado.y, cuadrado.width, cuadrado.height);
        shape.end();
    }

    public void renderTexto(SpriteBatch batch) {
        if (mostrandoTexto) {
            // Dibuja el texto en una posición fija (izquierda abajo)
            // Si quieres que el texto salga al lado del cubo, cambia 50, 100 por coords cercanas a xOriginal
            fuenteColor.draw(batch, textoVisible, 50, 100);
        }
    }

    public void dispose() {
        shape.dispose();
        fuenteColor.dispose();
        sonidoHablar.dispose();
    }
}