package tarea4;

import java.util.Scanner;

public class Criba {	
	
	//Generar numeros primos del 1 al max
	public static int[] generarPrimos(int max) 
	{
	
		int i,j;
		if (max >= 2) {
			// Declaraciones
			int dim = max + 1; // Tamaño del array
			boolean[] esPrimo = new boolean[dim];
			// Inicializar el array
			for (i = 0; i < dim; i++) 
				esPrimo[i] = true;
			// Eliminar el 0 y el 1, que no son primos
			esPrimo[0] = esPrimo[1] = false;
			// Criba
			i = criba(dim, esPrimo);
			// ¿Cuantos primos hay?
			int cuenta = cuantosPrimos(dim, esPrimo);
				
			// Rellenar el vector de numeros primos
			int[] primos = rellenaVector(dim, esPrimo, cuenta);
			
			return primos;
		}else { // max < 2
			return new int[0];
			// Vector vacio
		}
		
	}
	private static int criba(int dim, boolean[] esPrimo) {
		int i;
		int j;
		for (i = 2; i < Math.sqrt(dim); i++) {
			if (esPrimo[i]) {
			// Eliminar los multiplos de i
			j = eliminarMultiplosI(i, dim, esPrimo);
						
			}
		}
		return i;
	}
	private static int eliminarMultiplosI(int i, int dim, boolean[] esPrimo) {
		int j;
		for (j=2*i; j<dim; j+=i)
				esPrimo[j] = false;
		return j;
	}
	private static int[] rellenaVector(int dim, boolean[] esPrimo, int cuenta) {
		int i;
		int j;
		int[] primos = new int[cuenta];
		for (i = 0, j = 0; i<dim; i++) {
			if (esPrimo[i]) 
					primos[j++] = i;

		}
		return primos;
	}
	private static int cuantosPrimos(int dim, boolean[] esPrimo) {
		int i;
		int cuenta = 0;
		for (i = 0; i<dim; i++) {
				if (esPrimo[i])
						cuenta++;
		}
		return cuenta;
	}
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Intdroduce el numero para la criba de Erastotenes");
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		System.out.println("\nVector inicial hasta:" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10 == 0) System.out.println();
			System.out.print(i+1+"\t");
		}
		vector = generarPrimos(dato);
		System.out.println("\nVector de primos hasta:" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i%10 == 0) System.out.println();
			System.out.print(vector[i]+"\t");
		}
		
		
	}
	
}

