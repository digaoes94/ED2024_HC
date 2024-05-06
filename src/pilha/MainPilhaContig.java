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
		String original;
		
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
			System.out.println("O programa será encerrado.");
			return false;
		}
		else {
			switch (escolha) {
			case 1:
				System.out.println("Qual o valor a ser adicionado?");
				chave = scan.nextInt();
				
				if (pilha.empilhar(new Item(chave))) {
					System.out.println("Valor adicionado.");
				}
				else {
					System.out.println("Valor não adicionado.");
				}
				break;
				
			case 2:
				if (pilha.desempilhar() == null) {
					System.out.println("Pilha vazia, impossível desempilhar.");
				}
				else {
					System.out.println("Valor desempilhado.");
				}
				break;
				
			case 3:
				System.out.print("Digite a palavra ou frase a inverter: ");
				original = scan.nextLine();
				pilha.inverterString(original);
				break;
				
			case 4:
				if (pilha.retiraMaiorQueDez()) {
					System.out.println("Todos os valores maiores que 10 foram retirados.");
				}
				else {
					System.out.println("Não haviam valores maiores que 10 na pilha.");
				}
				break;
				
			case 5:
				System.out.print("Informe quantos valores possui a pilha para comparação: ");
				escolha = scan.nextInt();
				
				PilhaContig pilha2 = new PilhaContig(escolha);
				for (int a = 1; a <= escolha; a++) {
					System.out.print("Informe valor " + a + ": ");
					escolha = scan.nextInt();
					pilha2.empilhar(new Item(escolha));
				}
				
				if (pilha.compararPilhas(pilha2) == 1) {
					System.out.println("As pilhas são iguais.");
				}
				else {
					System.out.println("As pilhas não são iguais.");
				}
				break;
				
			case 6:
				String palavra1, palavra2;
				
				System.out.print("Informe a palavra/frase 1: ");
				palavra1 = scan.nextLine();
				System.out.print("Informe a palavra/frase 2: ");
				palavra2 = scan.nextLine();
				
				if (pilha.compararStringInverso(palavra1, palavra2)) {
					System.out.println("As palavras/frases são inversas entre si.");
				}
				else {
					System.out.println("As palavras/frases não são inversas entre si.");
				}
				break;
				
			case 7:
				System.out.print("Informe o número base do fatorial: ");
				escolha = scan.nextInt();
				System.out.println(pilha.calculaFatorial(escolha));
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
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
			
			return true;
		}
	}
}
