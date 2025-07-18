package cartas;

import Entidades.Entidad;
import Entidades.Jugador;
import juegos.Juego;

public enum Habilidad {

    MODIFICAR_PUNTOS { //modifica puntos en general
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
           // jugador.modificarPuntos(carta.getPuntosDisminuidos());
           // rival.modificarPuntos(carta.getPuntosAumentadosRival());
        }
    },
    BLOQUEAR_ROBO { //Para efectos generales (seguramente "Not today" va a usarla si o si) y redento
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
           // jugador.bloquearRobo();
        }
    },
    
    BLOQUEAR_EFECTO { //Sirve para efecto de Not today
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }
    },
    
    CAMBIO_DIRECCION { //Sirve para efecto de Cambio de ronda
        @Override
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
        	juego.setDireccionRonda(juego.getDireccionRonda() * -1);
			System.out.println("Dirección cambiada a: " + juego.getDireccionRonda());
			Jugador modificarPuntos = new Jugador(jugador.nombre, jugador.puntos);
			System.out.println("Puntos antes: " + jugador.puntos);//Esta linea es para ver si los puntos son modificados
			jugador.modificarPuntos(jugador.puntos, 0.6);
			System.out.println("Puntos despues: " + jugador.puntos);//Esta linea es para ver si los puntos son modificados
        }
    },
    
    VER_CARTAS_SIGUIENTES() { //sirve para efectos de Ojo que todo lo ve
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }
    },
    
    MEZCLAR_MAZO() { //Sirve para efectos de King Dice
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }
    },
    
    REINICIAR_PARTIDA() { //Sirve para efectos de Company
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }	
    },
    
    SALTEAR_TURNO() { //sirve para efectos de Saltamontes
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
        	juego.siguienteJugador();
        	System.out.println("Salteamos turno");
        }
    },
    
    INTERCAMBIO_PUNTOS() { //sirve para efectos de Chester
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }
    },
    
    SIN_CARTAS_EN_LA_MANO() { //sirve para efectos de Inanicion
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }
    },
    
    APARICION_ALEATORIA() { //sirve para efectos de IM HERE
        public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
            
        }
    },
    
    ROBAR_CARTA() { //Esta carta esta hecha para el pecado de la codicia
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
    		
    	}
    },
    
    ESTRENIMIENTO() { //Carta para estrenimiento
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
    	}
    },
    
    HAMBRE() { //Carta que se va a usar para la carta de HAMBRE CONTENIDA
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
    		
    	}
    }, 
    
    MIMICO() { //Carta que se va a usar para mimico
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
    		
    	}
    },
    
    VER_PUNTOS_RIVAL() {
    	public void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego) {
    		
    	}
    }
    ;
	
	
	
    public abstract void ejecutar(Carta carta, Entidad jugador, Entidad rival, Juego juego);

}
