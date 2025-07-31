package sonidos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import Utiles.Util;

public class SonidoAmbientalHilo {
	//Toda la parte del codigo que llamamos con runnable lo que hace es ejecutarlo en el hilo principal
    private long idSonidoVentilador;
    private Sound sonidoVentilador;
    private boolean audioCorre;

    private Sound sonidoDisparo;
    final int probabilidadDisparo = 10000000;

    public SonidoAmbientalHilo() {
        sonidoVentilador = Gdx.audio.newSound(Gdx.files.internal("VentiladorPared.ogg"));
        sonidoDisparo = Gdx.audio.newSound(Gdx.files.internal("SonidoDisparo.mp3"));
        audioCorre = true;
        start();
    }

    public void start() {
        Thread soundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (audioCorre) {
                    final int sonidoArmaAleatorio = Util.sacarNumeroRandom(probabilidadDisparo);

                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            if (sonidoVentilador != null && audioCorre) {
                                idSonidoVentilador = sonidoVentilador.play();
                            }
                        }
                    });

                    try {
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (sonidoArmaAleatorio == 777) {
                        Gdx.app.postRunnable(new Runnable() {
                            @Override
                            public void run() {
                                if (sonidoDisparo != null && audioCorre) {
                                    sonidoDisparo.play();
                                }
                            }
                        });
                    }
                }
            }
        });

        soundThread.start();
    }

    public void stop() {
        audioCorre = false;

        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                if (sonidoVentilador != null) {
                    sonidoVentilador.stop(idSonidoVentilador);
                    sonidoVentilador.dispose();
                    sonidoVentilador = null;
                }

                if (sonidoDisparo != null) {
                    sonidoDisparo.dispose();
                    sonidoDisparo = null;
                }
            }
        });
    }
}
