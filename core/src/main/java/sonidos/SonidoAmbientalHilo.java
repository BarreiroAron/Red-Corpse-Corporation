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
        sonidoDisparo    = Gdx.audio.newSound(Gdx.files.internal("SonidoDisparo.mp3"));
        audioCorre = true;
        start();
    }

    private void start() {
        Thread t = new Thread(() -> {
            idSonidoVentilador = SonidoManager.i().playAmbientLoop(sonidoVentilador);

            while (audioCorre) {
                if (Util.sacarNumeroRandom(probabilidadDisparo) == 777) {
                    Gdx.app.postRunnable(() ->
                        SonidoManager.i().playSfx(sonidoDisparo));
                }
                try {
					Thread.sleep(10_000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        t.start();
    }

    public void stop(){
        audioCorre = false;
        SonidoManager.i().stopAmbientLoop(idSonidoVentilador);
        sonidoVentilador.dispose();
        sonidoDisparo.dispose();
    }

}
