package duplamente;

import java.util.Scanner;

import dados.Item;

public class MenuPrincipalDupla {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//  System.out.println("");
		ListaDupla L1 = new ListaDupla();
		boolean run = true;
		
		System.out.println("Programa principal - Lista Linear Duplamente Encadeada");
		do {
			run = Menu(L1);
		} while (run);
	}
	
	public static boolean Menu(ListaDupla L1) {
		int procedimento = 0, chave = 0;
		
		
		System.out.println("Informar número do procedimento pretendido:");
		System.out.println("1. Inserir valor");
		System.out.println("2. Pesquisar valor");
		System.out.println("3. Remover valor");
		System.out.println("4. Sair");
		
		procedimento = scan.nextInt();
		
		if (procedimento == 4) {
			System.out.println("O programa será encerrado.");
			return false;
		}
		else {
			switch (procedimento) {
			case 1:
				System.out.print("Informar valor a inserir: ");
				chave = scan.nextInt();
				
				L1.inserirUltimo(new Item(chave));
				System.out.println("Valor adicionado.");
				return true;
			case 2:
				System.out.print("Informar valor a pesquisar: ");
				chave = scan.nextInt();
				
				if (L1.pesquisarNo(chave) == null) {
					System.out.println("Valor não encontrado.");
				}
				else {
					System.out.println("O valor " + L1.pesquisarNo(chave) + " foi encontrado na lista.");
				}
				return true;
			case 3:
				System.out.print("Informar valor a remover: ");
				chave = scan.nextInt();
				
				if (L1.removerNo(chave) == false) {
					System.out.println("O valor não foi removido por não estar na lista.");
				}
				else {
					System.out.println("O valor " + chave + " foi removido da lista.");
				}
				return true;
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
		}
	}
}