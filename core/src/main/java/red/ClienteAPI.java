package red;

import Pantallas.JuegoPantalla;

public interface ClienteAPI {
	 void enviarFinDeTurno();
	 void enviarJugarCarta(int indiceCarta);
	 void solicitarCartaMazo();
	 void setListener(ClienteListener listener);
}

