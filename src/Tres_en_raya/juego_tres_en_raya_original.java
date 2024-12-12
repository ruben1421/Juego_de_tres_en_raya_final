package Tres_en_raya;

import java.util.Random;
import java.util.Scanner;

public class juego_tres_en_raya_original {

	public static void main(String[] args) {
	
		
		//Damos la bienvenida al juego del Colgado 

		   System.out.println("BIENVENIDOS AL JUEGO DE TRES EN RAYA ");
		   
		    Scanner s = new Scanner(System.in);

	      //Aqui indicamos que si al finalizar el juego, ambos jugadores escogen jugar de nuevo se vuelva
		    // ha ejecutar el juego.
	       
		    
		    
		    // Aqui es donde se inicia el juego, pidiendo que cada jugador ingrese un nombre 
		    
		    System.out.print("Jugador 1, ingresa tu nombre: ");
            String nombreJugador1 = s.nextLine();
            System.out.print("Jugador 2, ingresa tu nombre: ");
            String nombreJugador2 = s.nextLine();

		    boolean jugarDeNuevo = true;
	        while (jugarDeNuevo) {
	  
	         //Introducimos el tablero que en este caso para el juego es una matriz 
	            //3x3 
	            
	            char[][] tablero = new char[3][3];
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    tablero[i][j] = '_'; // Aqui Indicamos que los elementos del tablero se reemplace 
	                    						//por '_' para representar el tablero vacio
	                }
	            }
	            
	            // En este apartado se realiza la eleccion de los jugadores por cara o sello para poder saber
	            // quien empieza el juego
	         
	            System.out.println(nombreJugador1 + ", elige cara (1) o sello (2): ");
	            int eleccionJugador1 = s.nextInt();

	           //Aqui indicamos que si eleccionJugador1 = 1 la eleccionJugador2= 2 si esto no se cumple 
	            //eleccionJugador =1 
	            
	            // utilizamos el ? para decir ? true : false
	            
	            int eleccionJugador2 = (eleccionJugador1 == 1) ? 2 : 1;

	            // En este apartado imprimimos la eleccion de los juagdores
	            
	            System.out.println(nombreJugador1 + " ha elegido: " + (eleccionJugador1 == 1 ? "CARA" : "SELLO"));
	            System.out.println(nombreJugador2 + " ha elegido: " + (eleccionJugador2 == 1 ? "CARA" : "SELLO"));

	           //Aqui incorporamos un Random para que se pueda hacer el sorteo, simulando el lanzamiento de una moneda 
	            // y a quien le toca el turno de manera al azar
	            
	            Random random = new Random();
	            int resultadoSorteo = random.nextInt(2) + 1;

	          // Aqui indicamos que si en el sorteo salio 1 = cara, decimos que comienza el nombreJugador1 y si no el 
	            // El nombreJugador2
	            
	            if (resultadoSorteo == 1) {
	                System.out.println("¡El sorteo ha determinado que " + nombreJugador1 + " comienza con CARA ('X')!");
	            } else {
	                System.out.println("¡El sorteo ha determinado que " + nombreJugador2 + " comienza con SELLO ('O')!");
	            }
	            
	            //Aqui indicamos que si resultado sorteo es 1 puede tocarle X o O
	          
	            char jugadorActual = (resultadoSorteo == 1) ? 'X' : 'O'; 

	            //Aqui incorporamos el espacio entre las lineas del tres en raya 
	            boolean juegoActivo = true;
	            while (juegoActivo) {
	               
	                System.out.println("Tablero actual:");
	                for (int i = 0; i < 3; i++) {
	                    for (int j = 0; j < 3; j++) {
	                        System.out.print(tablero[i][j] + " ");  // Aqui decimos que se separe 
	                        										// Con un espacio la matriz del tablero 
	                    }
	                    System.out.println(); 
	                }

	                //Aqui imprimimos el turno del jugador y de la misma manera le da la opcion de ingresar
	                //la posicion de su ficha en el tablero indicandole que ingrese el numero de filas 
	                //y de Columnas.
	                String jugadorNombre = (jugadorActual == 'X') ? nombreJugador1 : nombreJugador2;
	                String jugadorNombre2 = (jugadorActual == 'O') ? nombreJugador1 : nombreJugador2;
	                System.out.println("Turno de " + jugadorNombre + " (" + jugadorActual + ")");
	                System.out.print("Ingresa la fila (0-2): ");
	                int fila = s.nextInt();
	                System.out.print("Ingresa la columna (0-2): ");
	                int columna = s.nextInt();

	                //Aqui indicamos que si uno de los jugadores escoge una posicion que ya halla sido 
	                // elegida por el otro jugador, le indique que la casilla ya esta ocupada y que elija otra.
	                
	                if (tablero[fila][columna] == '_') {
	                    
	                    tablero[fila][columna] = jugadorActual;
	                } else {
	                    System.out.println("¡La casilla está ocupada! Elige otra.");
	                    continue; 
	                }

	                
	                boolean haGanado = false;

	                // En este apartado indicamos que si el jugador llena la array, tanto de forma vertical, horizontal o diagonal
	                // le reconozca que ha ganado el juego 
	               
	              //Jugador hacerto en columna
	                
	                for (int i = 0; i < 3; i++) {
	                    if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
	                        haGanado = true;
	                        break;
	                    }
	                }

	                //Jugador hacerto en Fila 
	                
	                if (!haGanado) {
	                    for (int j = 0; j < 3; j++) {
	                        if (tablero[0][j] == jugadorActual && tablero[1][j] == jugadorActual && tablero[2][j] == jugadorActual) {
	                            haGanado = true;
	                            break;
	                        }
	                    }
	                }

	              //Jugador hacerto en Diagonal
	                
	                if (!haGanado) {
	                    if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
	                        haGanado = true;
	                    }
	                    if (!haGanado && tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
	                        haGanado = true;
	                    }
	                }

	             //Aqui imprimimos cual de los juagadores ha ganado 
	                
	                if (haGanado) {
	                	 System.out.println("Tablero actual:");
	 	                for (int i = 0; i < 3; i++) {
	 	                    for (int j = 0; j < 3; j++) {
	 	                        System.out.print(tablero[i][j] + " ");  // Aqui decimos que se separe 
	 	                        										// Con un espacio la matriz del tablero 
	 	                    }
	 	                    System.out.println(); 
	 	                }
	                	
	                	System.out.println("¡El jugador " + jugadorNombre + " ha ganado!, bien jugado " + jugadorNombre2);
	                	System.out.println("  _____ _   _ _____   _   _ _   _    ____ ____      _    _   _ \r\n"
	                			+ " |  ___| | | | ____| | | | | \\ | |  / ___|  _ \\    / \\  | \\ | |\r\n"
	                			+ " | |_  | | | |  _|   | | | |  \\| | | |  _| |_) |  / _ \\ |  \\| |\r\n"
	                			+ " |  _| | |_| | |___  | |_| | |\\  | | |_| |  _ <  / ___ \\| |\\  |\r\n"
	                			+ " |_|  _ \\___/|_____|__\\___/|_| \\_|  \\____|_| \\_\\/_/   \\_\\_| \\_|\r\n"
	                			+ "     | | | | | ____/ ___|/ _ \\                                 \r\n"
	                			+ "  _  | | | | |  _|| |  _| | | |                                \r\n"
	                			+ " | |_| | |_| | |__| |_| | |_| |                                \r\n"
	                			+ "  \\___/ \\___/|_____\\____|\\___/                ");
	                	
	                	
	                    juegoActivo = false;
	                    
	                    
	                    
	                    
	                    
	                }
	                
	                //Aqui indicamos cuando ocurre un empate 
	                
	                boolean empate = true;
	                for (int i = 0; i < 3; i++) {
	                    for (int j = 0; j < 3; j++) {
	                        if (tablero[i][j] == '_') {
	                            empate = false; 
	                            break;
	                        }
	                    }
	                }
	                
	               // Aqui indicamos que si hay un ganador no se ejecute tambien como empate
	                if (empate) {
	                	if(haGanado) {
	                		empate = false;
	                		break;
	                	}
	                	 System.out.println("Tablero actual:");
	 	                for (int i = 0; i < 3; i++) {
	 	                    for (int j = 0; j < 3; j++) {
	 	                        System.out.print(tablero[i][j] + " ");  // Aqui decimos que se separe 
	 	                     										// Con un espacio la matriz del tablero 
	 	                    }
	 	                    System.out.println(); 
	 	                }
	                	
	                    System.out.println("¡Es un empate!");
	                    juegoActivo = false;
	                }

	                if (jugadorActual == 'X') {
	                    jugadorActual = 'O';
	                } else {
	                    jugadorActual = 'X';
	                }
	            }
	            
	            // En este apartado preguntamos a los juagdores si quieren volver a jaugar o no 
	            
	            System.out.print(nombreJugador1 + ", ¿quieres jugar otra vez? (si/no): ");
	            String respuestaJugador1 = s.next();
	            System.out.print(nombreJugador2 + ", ¿quieres jugar otra vez? (si/no): ");
	            String respuestaJugador2 = s.next();
        
	            //Si los dos jugadores deciden que si se inicia un nuevo juego 
	            
	            if (respuestaJugador1.equalsIgnoreCase("si") && respuestaJugador2.equalsIgnoreCase("si")) {
	                jugarDeNuevo = true;
	                System.out.println("¡Comencemos una nueva partida!");
	            } else {
	            	
	            	// Si no se da el juego por terminado 
	            	
	                jugarDeNuevo = false;
	                System.out.println("  ____ ____      _    ____ ___    _    ____    ____   ___  ____  \r\n"
	                		+ "  / ___|  _ \\    / \\  / ___|_ _|  / \\  / ___|  |  _ \\ / _ \\|  _ \\ \r\n"
	                		+ " | |  _| |_) |  / _ \\| |    | |  / _ \\ \\___ \\  | |_) | | | | |_) |\r\n"
	                		+ " | |_| |  _ <  / ___ \\ |___ | | / ___ \\ ___) | |  __/| |_| |  _ < \r\n"
	                		+ "  \\____|_| \\_\\/_/__ \\_\\____|___/_/   \\_\\____/  |_|    \\___/|_| \\_\\\r\n"
	                		+ "     | | | | |/ ___|  / \\  |  _ \\                                 \r\n"
	                		+ "  _  | | | | | |  _  / _ \\ | |_) |                                \r\n"
	                		+ " | |_| | |_| | |_| |/ ___ \\|  _ <                                 \r\n"
	                		+ "  \\___/ \\___/_\\____/_/ __\\_\\_|_\\_\\   _        _                   \r\n"
	                		+ " (_) | | |  / \\  / ___|_   _|/ \\    | |      / \\                  \r\n"
	                		+ " | | |_| | / _ \\ \\___ \\ | | / _ \\   | |     / _ \\                 \r\n"
	                		+ " | |  _  |/ ___ \\ ___) || |/ ___ \\  | |___ / ___ \\                \r\n"
	                		+ " |_|_| |_/_/   \\_\\____/_|_/_/_  \\_\\ |_____/_/   \\_\\               \r\n"
	                		+ " |  _ \\|  _ \\ / _ \\ \\/ /_ _|  \\/  |  / \\  | |                     \r\n"
	                		+ " | |_) | |_) | | | \\  / | || |\\/| | / _ \\ | |                     \r\n"
	                		+ " |  __/|  _ <| |_| /  \\ | || |  | |/ ___ \\|_|                     \r\n"
	                		+ " |_|   |_| \\_\\\\___/_/\\_\\___|_|  |_/_/   \\_(_)   ");
	            }
	            
	    }
	    
	}
	
	
	
	
	
}



