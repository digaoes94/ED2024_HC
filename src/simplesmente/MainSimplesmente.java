package simplesmente;

import java.util.Scanner;

import dados.Item;

public class MainSimplesmente {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		//  System.out.println("");
		boolean run = true;
		
		System.out.println("Gerenciador de Lista Simplesmente Encadeada.");
		System.out.println("Vamos criar duas listas, a L1 e a L2, ambas com 4 valores.");
		
		int chave = 0;
		
		System.out.println();  //mera estética
		ListaSimples L1 = new ListaSimples();
		System.out.println("Lista L1");
		
		for (int a = 0; a < 4; a++) {
			System.out.print("Digite o valor " + (a + 1) + " da L1: ");
			chave = scan.nextInt();
			L1.inserirUltimo(new Item(chave));
		}
		
		System.out.println();  //mera estética
		ListaSimples L2 = new ListaSimples();
		System.out.println("Lista L2");
		
		for (int a = 0; a < 4; a++) {
			System.out.print("Digite o valor " + (a + 1) + " da L2: ");
			chave = scan.nextInt();
			L2.inserirUltimo(new Item(chave));
		}
		
		System.out.println();
		
		do {
			run = Menu(L1, L2);
		} while (run);
	}
	
	public static boolean Menu(ListaSimples L1, ListaSimples L2) {
		System.out.println("Informe o procedimento a executar:");
		System.out.println("1. Inserir valor em lista");
		System.out.println("2. Remover valor em lista");
		System.out.println("3. Pesquisar por valor em lista");
		System.out.println("4. Soma dos valores em lista");
		System.out.println("5. Média dos valores em lista");
		System.out.println("6. Listas valores pares");
		System.out.println("7. Adicionar 50 em lista");
		System.out.println("8. Buscar ocorrências ou adicionar valor");
		System.out.println("9. Comparar listas");
		System.out.println("10. Ver valores de uma lista");
		System.out.println("11. Sair");
		
		int escolha = scan.nextInt();
		
		if (escolha == 11) {
			System.out.println("O programa será encerrado.");
			return false;
		}
		else {
			switch (escolha) {
			case 1:
				String opcaoLista = "";
				int novoValor;
				
				System.out.println("Inserir na L1 ou L2?");
				opcaoLista = scan.next();
				System.out.println("Qual o valor a inserir?");
				novoValor = scan.nextInt();
				
				if (opcaoLista == "L1") {
					L1.inserirUltimo(new Item(novoValor));
				}
				if (opcaoLista == "L2") {
					L2.inserirUltimo(new Item(novoValor));
				}
				System.out.println();
				return true;
				
			case 2:
				System.out.println("Remover da L1 ou L2?");
				opcaoLista = scan.next();
				System.out.println("Qual o valor a remover?");
				int retirarValor = scan.nextInt();
				
				if (opcaoLista == "L1") {
					if (L1.removerNo(retirarValor)) {
						System.out.println("Valor removido.");
					}
					else {
						System.out.println("Valor inexistente na lista.");
					}
				}
				if (opcaoLista == "L2") {
					if (L2.removerNo(retirarValor)) {
						System.out.println("Valor removido.");
					}
					else {
						System.out.println("Valor inexistente na lista.");
					}
				}
				System.out.println();
				return true;
				
			case 3:
				System.out.println("Pesquisar na L1 ou L2?");
				opcaoLista = scan.next();
				System.out.print("Digite o valor a pesquisar: ");
				int pesquisarValor = scan.nextInt();
				
				if (opcaoLista == "L1") {
					if (L1.pesquisarNo(pesquisarValor) == null) {
						System.out.println("Valor não encontrado.");
					}
					else {
						System.out.println("Valor " + pesquisarValor + " encontrado.");
					}
				}
				
				if (opcaoLista == "L2") {
					if (L2.pesquisarNo(pesquisarValor) == null) {
						System.out.println("Valor não encontrado.");
					}
					else {
						System.out.println("Valor " + pesquisarValor + " encontrado.");
					}
				}
				System.out.println();
				return true;
				
			case 4:
				System.out.println("Soma da L1 ou L2?");
				opcaoLista = scan.next();
				
				if (opcaoLista == "L1") {
					System.out.println("Soma dos valores da L1: " + L1.somaValores());
				}
				if (opcaoLista == "L2") {
					System.out.println("Soma dos valores da L2: " + L2.somaValores());
				}
				System.out.println();
				return true;
				
			case 5:
				System.out.println("Média da L1 ou L2?");
				opcaoLista = scan.next();
				
				if (opcaoLista == "L1") {
					System.out.println("Média da L1: " +  String.format("%.2f", L1.mediaValores()));
				}
				if (opcaoLista == "L2") {
					System.out.println("Média da L2: " + String.format("%.2f", L2.mediaValores()));
				}
				System.out.println();
				return true;
				
			case 6:
				System.out.println("Pares da L1 ou L2?");
				opcaoLista = scan.next();
				
				if (opcaoLista == "L1") {
					System.out.println("Valores pares da L1:\n" + L1.valoresPar());
				}
				if (opcaoLista == "L2") {
					System.out.println("Valores pares da L2:\n" + L2.valoresPar());
				}
				System.out.println();
				return true;
				
			case 7:
				System.out.println("Trocar na L1 ou L2?");
				opcaoLista = scan.next();
				System.out.print("Digite o valor a pesquisar: ");
				pesquisarValor = scan.nextInt();
				
				if (opcaoLista == "L1") {
					System.out.println(L1.trocar50(pesquisarValor));
				}
				if (opcaoLista == "L2") {
					System.out.println(L2.trocar50(pesquisarValor));
				}
				System.out.println();
				return true;
				
			case 8:
				System.out.println("Buscar/adicionar na L1 ou L2?");
				opcaoLista = scan.next();
				System.out.print("Digite o valor a pesquisar: ");
				pesquisarValor = scan.nextInt();
				
				if (opcaoLista == "L1") {
					if (L1.encontraOuAdiciona(pesquisarValor) == 0) {
						System.out.println("O valor não existia na lista, portanto foi adicionado.");
					}
					if (L1.encontraOuAdiciona(pesquisarValor) > 0) {
						System.out.println("Existem " + L1.encontraOuAdiciona(pesquisarValor) + " ocorrências do valor.");
					}
				}
				if (opcaoLista == "L2") {
					if (L2.encontraOuAdiciona(pesquisarValor) == 0) {
						System.out.println("O valor não existia na lista, portanto foi adicionado.");
					}
					if (L2.encontraOuAdiciona(pesquisarValor) > 0) {
						System.out.println("Existem " + L2.encontraOuAdiciona(pesquisarValor) + " ocorrências do valor.");
					}
				}
				System.out.println();
				return true;
				
			case 9:
				if (L1.compararListas(L1, L2)) {
					System.out.println("As listas são iguais.");
				}
				else {
					System.out.println("As listas não são iguais.");
				}
				System.out.println();
				return true;
				
			case 10:
				System.out.println("Ver valores de L1 ou L2?");
				opcaoLista = scan.next();
				
				if (opcaoLista == "L1") {
					System.out.println(L1.toString());
				}
				if (opcaoLista == "L2") {
					System.out.println(L2.toString());
				}
				System.out.println();
				return true;
				
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
		}
	}
}