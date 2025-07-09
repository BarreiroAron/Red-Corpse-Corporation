package cartas;

import juegos.Juego;
import jugadores.Jugador;

public enum Habilidad {

    MODIFICAR_PUNTOS { //modifica puntos en general
        @Override
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            jugador.modificarPuntos(carta.getPuntosDisminuidos());
            rival.modificarPuntos(carta.getPuntosAumentadosRival());
        }
    },
    BLOQUEAR_ROBO { //Para efectos generales (seguramente "Not today" va a usarla si o si) y redento
        @Override
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            jugador.bloquearRobo();
        }
    },
    
    BLOQUEAR_EFECTO { //Sirve para efecto de Not today
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    CAMBIO_DIRECCION { //Sirve para efecto de Cambio de ronda
        @Override
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
			//juego.setDireccionRonda(1); por ahora no se
        }
    },
    
    VER_CARTAS_SIGUIENTES() { //sirve para efectos de Ojo que todo lo ve
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    MEZCLAR_MAZO() { //Sirve para efectos de King Dice
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    REINICIAR_PARTIDA() { //Sirve para efectos de Company
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }	
    },
    
    SALTEAR_TURNO() { //sirve para efectos de Saltamontes
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    INTERCAMBIO_PUNTOS() { //sirve para efectos de Chester
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    SIN_CARTAS_EN_LA_MANO() { //sirve para efectos de Inanicion
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    APARICION_ALEATORIA() { //sirve para efectos de IM HERE
        public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
            
        }
    },
    
    ROBAR_CARTA() { //Esta carta esta hecha para el pecado de la codicia
    	public void ejecutar(Carta carta, Jugador jugador, Jugador rival) {
    		
    	}
    }
    ;
	
	
	
    public abstract void ejecutar(Carta carta, Jugador jugador, Jugador rival);
}
