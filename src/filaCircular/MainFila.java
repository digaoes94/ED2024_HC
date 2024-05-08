package filaCircular;

import java.util.Scanner;
import dados.Item;

public class MainFila {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		int tamanho;
		
		System.out.println("Informe o tamanho máximo da fila:");
		tamanho = scan.nextInt();
		
		FilaCircular fila = new FilaCircular(tamanho);
		
		do {
			run = Menu();
		} while (run);
	}
	
	static boolean Menu() {
		
	}
}