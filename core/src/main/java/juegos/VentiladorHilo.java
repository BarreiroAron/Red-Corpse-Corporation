package juegos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import Utiles.Util;

public class VentiladorHilo {

	private long idSonidoVentilador;
    private Sound sonidoVentilador;
    private boolean audioCorre;
    
    private long idSonidoDisparo;
    private Sound sonidoDisparo;
    final int probabilidadDisparo = 10000000;

    public VentiladorHilo() {
    	sonidoVentilador = Gdx.audio.newSound(Gdx.files.internal("VentiladorPared.ogg"));
    	sonidoDisparo = Gdx.audio.newSound(Gdx.files.internal("SonidoDisparo.mp3"));
    	audioCorre = true;
        start();
    }

    public void start() {
        Thread soundThread = new Thread(new Runnable() {
        	public void run() {
        		while(audioCorre) {
        			 int sonidoArmaAleatorio = Util.sacarNumeroRandom(probabilidadDisparo);
        			idSonidoVentilador = sonidoVentilador.play();
        		try {
        			Thread.sleep(10_000);
        		} catch(InterruptedException  e) {
        			e.printStackTrace();
        		}
        		if(sonidoArmaAleatorio == 777) {
        			sonidoDisparo.play();
        		}
        	}
        }
       });
        soundThread.start();
    }
    
    public void stop() {
    	audioCorre = false;
        if (sonidoVentilador != null) {
        	sonidoVentilador.stop(idSonidoVentilador);
        	sonidoVentilador.dispose();
        }
    }
}
