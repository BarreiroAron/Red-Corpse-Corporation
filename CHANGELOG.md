# Changelog

Este archivo documenta los cambios importantes realizados en el proyecto **RED CORPSE CORPORATION**.

---

## [Unreleased]

---

## [Alpha 0.1]

---

### Añadidos
- README.md creado. -- 2025-05-18 --
- Proyecto inicial de `libGDX` configurado y compilado correctamente en Eclipse / IntelliJ. -- 2025-05-18 --
- Instalación y configuración de Git con conexión al repositorio GitHub. -- 2025-05-18 --
- Primeros sprites integrados (creados entre mayo 18 y julio 2). -- 2025-07-02 --
- Pantalla principal con menús funcionales: "Jugar", "Opciones" y "Salir". -- 2025-07-30 --
- Implementación de sonido en el menú y dentro del juego (cartas, ventilación, skillcheck, etc.). -- 2025-07-20 --
- División del audio en "ambiente" y "efectos", con control deslizante desde el menú de opciones. -- 2025-07-30 --
- Pantalla de carga integrada. -- 2025-07-02 --
- Mazo de cartas creado con lógica inicial. -- 2025-07-10 --
- Sistema de jugador y jugador rival añadido. -- 2025-07-10 --
- Se agregó clase `Carta` y sus efectos base. -- 2025-07-14 --
- Implementación de hilos para controlar el tiempo de ronda (2 minutos por partida). -- 2025-07-18 --
- Al terminar el tiempo, se determina un ganador. -- 2025-07-18 --
- Sistema de puntajes implementado y modificado por efectos de cartas. -- 2025-07-14 --
- SonidoManager incorporado para controlar audio dinámicamente. -- 2025-07-20 --
- Sistema de pausa implementado mediante tecla `Esc`. -- 2025-08-01 --
- Nuevos assets: reemplazo del `Mímico` provisorio y música ambiental provisoria. -- 2025-08-01 --
- Nuevas funciones de cartas: Añadidos Redento, Snake, King Dice -- 2025-09-24 --
- - Nuevas funciones de cartas: Añadidos Chester, Sonambulo -- 2025-09-25 --

### Cambios
- FPS limitados a 60 para estabilidad general del juego. -- 2025-07-10 --
- Dimensiones de pantalla ajustadas a resolución estándar de monitores de PC. -- 2025-07-10 --
- Sprites redimensionados para mejor ajuste gráfico. -- 2025-07-10 --
- Rediseño completo del control de cartas:  
  - Ahora cada carta tiene posición X/Y, imagen, tipo y descripción dinámica visible con el mouse.  
  - Cartas descartadas correctamente tras su uso. -- 2025-07-14 --
- Reorganización del código bajo el principio de responsabilidad única:  
  - Se creó `ControladorDeJuego` con interfaces para facilitar efectos complejos. -- 2025-07-14 --
- Implementación de `enum EnemigoDeterminado` para lógica de objetivo dinámico. -- 2025-07-14 --
- Las cartas “Cambio de Ronda” y “Saltamontes” ahora aplican sus efectos correctamente. -- 2025-07-18 --
- Lógica del mazo mejorada: si se acaba, se reutilizan cartas de la mesa. -- 2025-07-18 --
- Animaciones refactorizadas para ser dinámicas y reutilizables. -- 2025-07-22 --
- Mejora visual en el menú principal y en la pantalla de opciones. -- 2025-07-30 --

### Arreglos
- Bug del sonido ambiental (ventilador) que seguía activo al cerrar el juego fue solucionado. -- 2025-07-30 --
- Correcciones menores visuales y de lógica durante la transición entre pantallas. -- 2025-07-22 --
- Se optimizó el uso de hilos para evitar errores al finalizar partidas. -- 2025-07-22 --
- Se reparo el error de resolucion para que sea adaptable a diferentes pantallas -- 2025-08-03 --
- Error de resolucion persistente, finalmente arreglado completamente en todas las pantallas -- 2025-9-06 --



---


## Fechas significativas:

- **Mayo 18, 2025** – Inicio del proyecto, creación del README.md, configuración de libGDX y Git.
- **Julio 2–10, 2025** – Se integran gráficos, lógica básica del juego, cartas, jugadores, y pantalla de carga.
- **Julio 14–22, 2025** – Lógica avanzada de cartas, puntos, rondas, hilos, audio y efectos implementados.
- **Julio 30, 2025** – Introducción del menú principal, opciones de audio, fixes críticos y pantalla de opciones.
- **Agosto 1, 2025** – Mejora de la gestión de sonido, implementación de menú de pausa y nuevos assets.


---



- Cambios con mas explicación a fondo:


1)  -- Mayo 18 2025 -- Creamos el README.md.

2)  -- Mayo 18 2025 -- Creamos el proyecto libGDX y lo compilamos para ver que ande en el eclipse o InteliJ.  

3)  -- Mayo 18 2025 -- Instalamos git y lo conectamos con el proyecto para poder subir el proyecto a github.

4)  -- Julio 2 2025 -- Nuevos cambios sobre FPS, Tamaño de pantalla, tamaño de sprites. Poniendo los primeros sprites ya creados en el lapso de Mayo 18 2025 hasta Julio 2 2025.                            Los fps fueron limitados en 60 para limitar todo lo que contiene el juego a 60 FPS o menos. Modificamos los tamaños de los sprites y los tamaños de la                               pantalla para que pueda entrar perfectamente en la dimension del monitor de las pc's. 
   
5)  -- Julio 4 2025 - Creamos los sprites y los subimos para que el juego empiece a tener sus primeros graficos. También acomodamos la pantalla para que en la parte grafica se vea                         comodamente y bien dimensionada. Añadimos codigo sobre FPS para que el juego tenga un limitante de hasta 60 FPS o menos a la hora de tener el juego                               abierto.  

6) -- Julio 5 2025 -- Añadimos efectos base de las cartas, algunos efectos que aun no estan completados, la clase Carta para que las cartas tengan su extension, añadimos jugador y                         jugador rival. Tambien agregamos pantalla de carga y herramientas como utiles, imagen y render.

7) -- Julio 6 2025 -- La pantalla de carga ahora es limpiada al desvanecerse para pasar directo a la pantalla del juego y poder jugar.

8) -- Julio 9 2025 -- Las cartas fueron añadidas con posiciones X e Y y un tipo imagen, por lo cual gracias a esto. Ahora son visibles en el juego junto a la funcion que tambien                         fue agregada este dia para poder dibujar las cartas y renderizarlas en la pantalla. 

9) -- Julio 9 2025 -- En el mismo dia, fue modificada la carta: THANKS FOR PLAYING, teniendo una modificacion en cuanto a sus graficos y forma para meterla al juego. Esta carta                            fue la carta usada como "experimental" para probar meter cartas. Una vez introducida en el juego, nos propusimos a añadir al mazo las cartas faltantes.                             

10) -- Julio 9 2025 -- Avanzando en la logica y creando el mazo. 

11)  -- Julio 10 2025 -- Se crean entidades en la logica, se crean mazo y se reparte a las entidades, en render se muestra la mano de la entidad seleccionada.

12) -- Julio 10 2025 -- Completamos clases de las cartas que aun le faltaban poner pequeñas cosas, añadimos una nueva variable a las cartas (descripcion) para poder implementar                            una descripcion cada vez que el mouse se ponga arriba de x carta (en donde saldra la descripcion correspondiente a esa x carta).

13) -- Julio 10 2025 -- Subimos los assets BETA que hemos puesto. (Los assets BETA van a ser unos PNG los cuales van a estar temporalmente en el codigo hasta que se creen los                               sprites correctos para el juego).

14) -- Julio 14 2025 -- Se descartan tanto graficamente como logicamente las cartas usadas y usa sus abilidades.

15) -- Julio 15 2025 -- Se pasan cartas a mesa principal y reacomodacion de cartas de mano. añadimos una mejora al futuro cartel de la descripcion de las cartas

16) -- Julio 16 2025 -- Ahora se muestra la mano por index de jugador, el rival que se va a atacar la carta (si es que lo hace) se determina por variable de la carta , se puso                             izquiera por defaul para testear. Creamos el enum de EnemigoDeterminado para devolverlo y asi sea mas dinamico.

17) -- Julio 17 2025 -- Actualizamos las cartas: CAMBIO DE RONDA y SALTAMONTES para que ahora esten funcionando con sus efectos correspondientes a la hora de jugar. Tambien                                añadimos los puntos de los jugadores los cuales segun cada carta y su efecto correspondiente, van a estar siendo modificados.

18) -- Julio 18 2025 -- Se cambio la forma de agregar los puntos de forma mas general y de cambiar orden de la ronda, se muestran los puntos y se pueden agregar catas a la mano de                         manera indefinida

19) -- Julio 19 2025 -- Trabajamos en la funcion REINICIAR_CARTA de Company para su futuro funcionamiento en el juego. Actualmente se encuentra en proceso de ser terminada.

20) -- Julio 19 2025 -- Se realizo un cambio drastico en cuanto al ordenamiento (principio de responsabilidad unica) del codigo. Ahora presenta un apartado de ControladorDeJuego                            en donde se aprecian varias funciones usadas por cartas complejas del juego. Este ordenamiento en donde se uso "Interface", permitio una facilidad mayor a                            la anterior a la hora de crear los efectos de las cartas. Una vez implementado esto, se termino de realizar los efectos de la funcion REINICIAR_CARTA                               usada por la carta "Company".

21) -- Julio 19 2025 -- Se introdujeron los hilos al codigo del juego! Estos primeramente fueron usados para el tiempo de las partidas del juego, teniendo una duración actualmente                         de 2 minutos. Al terminar la partida, futuramente se va a tomar como victorioso al jugador con menos puntos en su contador, y a los tres jugadores                                  restantes como perdedores al finalizar el tiempo. Actualmente el tiempo se mide en una barra roja que es impresa bajo las cartas del jugador, indicando                            cuanto le falta a la ronda para terminar.
                                       La barra de tiempo al llegar a 0, actualmente imprime un mensaje por terminal indicando que el tiempo se ha acabado.

22) -- Julio 20 2025 -- Se introdujo sonido al videojuego mediante las librerias com.badlogic.gdx.Gdx y com.badlogic.gdx.audio.Sound. Introduciendo sonido al tirar las                                     cartas y un sonido ambiental de una ventilacion de aire en la pared. Como sonido ambiental tambien fue agregado un skillcheck con sonido de disparos a                            las afueras de la compañia (estas funciones fueron metidas en un hilo). Tambien se agrego el funcioaniento de OjoQueTodoLoVe y provisoriamente se agrego                            una alerta para comprobar que la carta es funcional a la hora de jugar el videojuego.

23) -- Julio 21 2025 -- Se eliminan jugadores al terminar el contador y la informacion de el progreso del hilo es directo en juego y no son dos distintos.

24) -- Julio 22 2025 -- Cuando se termina el contador y solo queda 1 jugador se da como jugador ganado y se reinicia el juego, tambien las cartas de los jugadores muertos se                               agregan al mazo y si se termina las cartas del mazo se agarran las de la mesa.

25) -- Julio 30 2025 -- Se realizo cambios en las animaciones para poder hacerlas de manera mas dinamicas y aplicables a toda imagen sin problemas de manera que no se repita                               codigo.

26) -- Juluo 30 2025 -- Se introdujo al codigo un menu con las opciones de "Jugar" (nos manda directamente al videojuego), "Opciones" (aun no hace sus respectivas funciones) y                            "Salir" (cierra el juego). Como extra: Tambien se introdujo sonidos al menu nuevo.
                                 Se arreglo un bug que el codigo del sonido ambiental del ventilador tenia, a la hora de cerrar el juego, el hilo del ventilador seguia corriendo y                         por ende, habia un momento en donde tiraba error este hilo. No afectaba nada al juego ya que tiraba error a la hora de cerrar todo. Pero claramente es una                         mala practica asi que decidimos arreglarlo (tambien el bug presentaba cosas extrañas como que a la hora de cerrar el codigo, se apagaba y se volvia a                               encender pero sin nada).

27) -- Julio 30 2025 -- Se agrego la pantalla de opciones funcional y se puede gestionar el audio dividido en ambiente y efectos, ahora se gestiona el sonido por SonidoManager

28) -- Agosto 1 2025 -- Se cambiaron los criterios de la barra de sonidos (ahora la barra de arriba baja la musica y ventilador, la de abajo baja el sonido de las cartas).
                                                Se agrego un menu de pausa el cual se activa mediante la tecla de "Esc" en el teclado, este menu fue creado con la reeutilizacion                            del codigo de "MenuPrincipal".
                                                 Se agregaron nuevos assets, modfificando asi el asset provisorio de "Mimico", sustituyendolo por el asset final y tambien se                               agrego un asset de musica provisoria.   -- Alpha 0.1 --

29) -- Agosto 2 2025 -- Implementamos animaciones por frames con TextureRegion, creamops las clases para que los personajes los tenga por cuenta propia;

30) -- Septiembre 03 2025 -- Modificamos el codigo de la pantalla de juego para que ahora tenga una resolucion escalable a cualquier monitor. Antes, solo se podia ver completamente el juego si es que se jugaba en una resolucion de 1080 x 1200. Ahora, el juego es jugable en cualquie monnitor con resolucion diferente a la antes mencionada.

31) -- Septiembre 6 2025 -- Agregamos la resolucion de pantalla para todas las computadoras a la pantalla de carga y al menu princpial para que ya no se vean de una manera errada en resoluciones de monitores que sean diferentes a una de 1080 x 1200. El juego ya es adaptable a cualquier resolcion de monitor.


32) -- Septiembre 10 2025 -- Se agrega pantalla de fin de juego solo al ganar un jugador, solo con botones para reiniciar partida y volver al menu con imagenes provisorias.

33) -- Septiembre 19 2025 -- cambie los datos que se toma como centro en personajes para que se centre segun la camara y agrege el tipo de carta, normal , mala y especial para futuras implementaciones con efectos de cartas donde se busca si la carta es buena o mala.

34) -- Septiembre 19 2025 -- se agrego kingdice y ademas agrege el tipo de carta de mala,normal y especial.


35) -- Septiembre 22 2025 -- Se agrego tipo de enemigo determinado global y se implemento el tema de habilidades activas a lo largo de la partida, tambien se agrego la carta de redento con funcion de bloquear agarrar mas cartas.

36) -- Septiembre 24 2025 -- Se agrego la habilidad de snake de ver pos puntos de los demas.

37) -- Septiembre 25 2025 -- Se agrego la carta Chester que sirve para intercambiarl os putnos con el rival siguiente de la ronda y se añadio tambien la carta de "Pecado de la codicia" Carta la cual hace perder 4 cartas de tu mano y esta carta, permanecer en ella. Esta carta cuando es tirada desde tu mano te resta 5 puntos y le suma 1 punto al rival.
