package pilha;

import java.util.Scanner;
import dados.Item;
import dados.ItemChar;

public class MainPilhaContig {
	//  System.out.println("");
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		
		System.out.print("Informe o tamanho máximo da pilha: ");
		int qtd = scan.nextInt();
		PilhaContig pilha = new PilhaContig(qtd);
		
		do {
			run = Menu(pilha);
		} while(run);
	}
	
	public static boolean Menu(PilhaContig pilha) {
		int chave, escolha;
		Item item;
		
		System.out.println("Informe o procedimento a realizar:");
		System.out.println("1. Adicionar valor à pilha");
		System.out.println("2. Retirar valor da pilha");
		System.out.println("3. Inverter palavra ou frase");
		System.out.println("4. Retirar valores maiores do que 10 da pilha");
		System.out.println("5. Comparar se pilhas são iguais");
		System.out.println("6. Checar se uma palavra é o inverso de outra");
		System.out.println("7. Calcular fatorial de um número");
		System.out.println("8. Converter número da base decimal para a base binária");
		System.out.println("9. Transferir valores de uma Pilha para uma Lista Duplamente Encadeada");
		System.out.println("10. Retirar todas as ocorrências de um valor X da pilha");
		System.out.println("11. Transferir todas as ocorrências do valor X de uma Lista Duplamente Encadeada para uma Pilha");
		System.out.println("12. Verificar se a palavra é um palíndromo");
		System.out.println("13. Calcular a potência da pilha");
		System.out.println("14. Adicionar duas pilhas a um único vetor");
		System.out.println("15. Verificar se uma palavra é o inverso da outra, e se ambas só apresentam as letras A e B");
		System.out.println("16. Sair do programa");
		
		escolha = scan.nextInt();
		
		if (escolha == 16) {
			return false;
		}
		else {
			switch (escolha) {
			case 1:
				
				break;
			case 2:
						
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				
				break;
			case 12:
				
				break;
			case 13:
				
				break;
			case 14:
				
				break;
			case 15:
				
				break;
			}
			
			return true;
		}
	}
}
