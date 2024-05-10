package filaCircular;

import java.util.Scanner;
import dados.Item;

public class MainFila {
	//  System.out.println("");
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		int tamanho;
		
		System.out.println("Informe o tamanho máximo da fila:");
		tamanho = scan.nextInt();
		
		FilaCircular fila = new FilaCircular(tamanho);
		for (int a = 0; a < tamanho; a++) {
			fila.enfileirar(new Item((int) Math.random() * 101));
		}
		
		do {
			run = Menu(fila);
		} while (run);
	}
	
	static boolean Menu(FilaCircular fila) {
		int escolha;
		
		System.out.println("Selecione o procedimento a executar:");
		System.out.println("1. Enfileirar valor");
		System.out.println("2. Desenfileirar valor");
		System.out.println("3. Imprimir fila");
		System.out.println("4. Retirar valores negativos da fila");
		System.out.println("5. Somar os valores da fila");
		System.out.println("6. Transferir valores de uma pilha para uma fila");
		System.out.println("7. Imprimir documento em ordem decrescente");
		System.out.println("8. Separar pessoas de idade 70+ em fila preferencial");
		System.out.println("9. Inserir valor X acima das ocorrências do valor 10");
		System.out.println("10. Passar alunos desclassificados da fila para uma lista");
		System.out.println("11. Sair do programa");
		
		escolha = scan.nextInt();
		
		if (escolha == 11) {
			System.out.println("O programa será encerrado.");
			return false;
		}
		else {
			switch (escolha) {
			case 1:
				
				return true;
			case 2:
						
				return true;
			case 3:
				
				return true;
			case 4:
				
				return true;
			case 5:
				
				return true;
			case 6:
				
				return true;
			case 7:
				
				return true;
			case 8:
				
				return true;
			case 9:
				
				return true;
			case 10:
				
				return true;
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
		}
		
	}
}