package Tres_en_raya;

import java.util.Random;
import java.util.Scanner;

public class juego_tres_en_raya_original {

	public static void main(String[] args) {
	

		
	

		   System.out.println("BIENVENIDOS AL JUEGO DE TRES EN RAYA ");
		   
		    Scanner s = new Scanner(System.in);

	      
	        boolean jugarDeNuevo = true;
	        while (jugarDeNuevo) {
	            
	            System.out.print("Jugador 1, ingresa tu nombre: ");
	            String nombreJugador1 = s.nextLine();
	            System.out.print("Jugador 2, ingresa tu nombre: ");
	            String nombreJugador2 = s.nextLine();

	         
	            char[][] tablero = new char[3][3];
	            for (int i = 0; i < 3; i++) {
	                for (int j = 0; j < 3; j++) {
	                    tablero[i][j] = '_'; 
	                }
	            }

	         
	            System.out.println(nombreJugador1 + ", elige cara (1) o sello (2): ");
	            int eleccionJugador1 = s.nextInt();

	           
	            int eleccionJugador2 = (eleccionJugador1 == 1) ? 2 : 1;

	            // Mostrar las elecciones
	            System.out.println(nombreJugador1 + " ha elegido: " + (eleccionJugador1 == 1 ? "CARA" : "SELLO"));
	            System.out.println(nombreJugador2 + " ha elegido: " + (eleccionJugador2 == 1 ? "CARA" : "SELLO"));

	           
	            Random random = new Random();
	            int resultadoSorteo = random.nextInt(2) + 1;

	          
	            if (resultadoSorteo == 1) {
	                System.out.println("¡El sorteo ha determinado que " + nombreJugador1 + " comienza con CARA ('X')!");
	            } else {
	                System.out.println("¡El sorteo ha determinado que " + nombreJugador2 + " comienza con SELLO ('O')!");
	            }

	          
	            char jugadorActual = (resultadoSorteo == 1) ? 'X' : 'O'; 

	         
	            boolean juegoActivo = true;
	            while (juegoActivo) {
	               
	                System.out.println("Tablero actual:");
	                for (int i = 0; i < 3; i++) {
	                    for (int j = 0; j < 3; j++) {
	                        System.out.print(tablero[i][j] + " ");  
	                    }
	                    System.out.println(); 
	                }

	               
	                String jugadorNombre = (jugadorActual == 'X') ? nombreJugador1 : nombreJugador2;
	                System.out.println("Turno de " + jugadorNombre + " (" + jugadorActual + ")");
	                System.out.print("Ingresa la fila (0-2): ");
	                int fila = s.nextInt();
	                System.out.print("Ingresa la columna (0-2): ");
	                int columna = s.nextInt();

	           
	                if (tablero[fila][columna] == '_') {
	                    
	                    tablero[fila][columna] = jugadorActual;
	                } else {
	                    System.out.println("¡La casilla está ocupada! Elige otra.");
	                    continue; 
	                }

	                
	                boolean haGanado = false;

	               
	                for (int i = 0; i < 3; i++) {
	                    if (tablero[i][0] == jugadorActual && tablero[i][1] == jugadorActual && tablero[i][2] == jugadorActual) {
	                        haGanado = true;
	                        break;
	                    }
	                }

	           
	                if (!haGanado) {
	                    for (int j = 0; j < 3; j++) {
	                        if (tablero[0][j] == jugadorActual && tablero[1][j] == jugadorActual && tablero[2][j] == jugadorActual) {
	                            haGanado = true;
	                            break;
	                        }
	                    }
	                }

	             
	                if (!haGanado) {
	                    if (tablero[0][0] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][2] == jugadorActual) {
	                        haGanado = true;
	                    }
	                    if (!haGanado && tablero[0][2] == jugadorActual && tablero[1][1] == jugadorActual && tablero[2][0] == jugadorActual) {
	                        haGanado = true;
	                    }
	                }

	             
	                if (haGanado) {
	                    System.out.println("¡El jugador " + jugadorNombre + " ha ganado!");
	                    juegoActivo = false;
	                }

	                
	                boolean empate = true;
	                for (int i = 0; i < 3; i++) {
	                    for (int j = 0; j < 3; j++) {
	                        if (tablero[i][j] == '_') {
	                            empate = false; 
	                            break;
	                        }
	                    }
	                }
	                if (empate) {
	                    System.out.println("¡Es un empate!");
	                    juegoActivo = false;
	                }

	                if (jugadorActual == 'X') {
	                    jugadorActual = 'O';
	                } else {
	                    jugadorActual = 'X';
	                }
	            }
	            System.out.print(nombreJugador1 + ", ¿quieres jugar otra vez? (si/no): ");
	            String respuestaJugador1 = s.next();
	            System.out.print(nombreJugador2 + ", ¿quieres jugar otra vez? (si/no): ");
	            String respuestaJugador2 = s.next();
        
	    }
	    
	}
	
}



