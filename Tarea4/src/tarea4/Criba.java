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
			for (i = 2; i < Math.sqrt(dim); i++) {
				if (esPrimo[i]) {
				// Eliminar los multiplos de i
				for (j=2*i; j<dim; j+=i)
						esPrimo[j] = false;
							
				}
			}
			// ¿Cuantos primos hay?
			int cuenta = 0;
			for (i = 0; i<dim; i++) {
					if (esPrimo[i])
							cuenta++;
			}
				
			// Rellenar el vector de numeros primos
			int[] primos = new int[cuenta];
			for (i = 0, j = 0; i<dim; i++) {
				if (esPrimo[i]) 
						primos[j++] = i;

			}
			return primos;
		}else { // max < 2
			return new int[0];
			// Vector vacio
		}
		
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

