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
		System.out.println("4. Concatenar listas");
		System.out.println("5. Pegar primeira metade da lista");
		System.out.println("6. Ver maior valor da lista");
		System.out.println("7. Média dos valores da lista");
		System.out.println("8. Retirar o número 0 da lista");
		System.out.println("9. Retirar números repetidos da lista");
		System.out.println("10. Mostrar jogadores acima de 2 metros de altura");
		System.out.println("11. Criar lista com produtos enlatados");
		System.out.println("12. Verificar palíndromo");
		System.out.println("13. Ordenar e/ou aumentar lista ordenada");
		System.out.println("14. Sair");
		
		procedimento = scan.nextInt();
		
		if (procedimento == 14) {
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
			case 4:
				int qtdNos, novoValor;
				ListaDupla L2 = new ListaDupla();
				System.out.println("Crie uma segunda lista (L2).");
				System.out.print("Informe quantos nós terá a L2: ");
				qtdNos = scan.nextInt();
				
				for (int i = 1; i <= qtdNos; i++) {
					System.out.print("Informe o valor " + i + ": ");
					novoValor = scan.nextInt();
					L2.inserirUltimo(new Item(novoValor));
				}
				
				L1.concatenarListas(L2);
				System.out.println("Nova lista:\n" + L1.toString());
				return true;
			case 5:
				System.out.println("Primeira metade da lista");	
				System.out.println(L1.primeiraMetade().toString());
				return true;
			case 6:
				System.out.print("Maior valor da lista: " + L1.maiorValor());
				return true;
			case 7:
				System.out.print("Média da lista: " + L1.mediaAritmetica());
				return true;
			case 8:
				System.out.println(L1.retiraZero());
				return true;
			case 9:
				L1.retiraRepetidos();
				return true;
			case 10:
				//  NÃO TESTAR, VAI DAR RUIM
				System.out.println(L1.atletasAcimaDe2m());
				return true;
			case 11:
				ListaDupla L3 = new ListaDupla();
				L1.produtosEnlatados(L3);
				return true;
			case 12:
				System.out.print("Informe a palavra a ser testada: ");
				String original = scan.next();
				
				if (L1.palindromo(original)) {
					System.out.println("A palavra é um palíndromo.");
				}
				else {
					System.out.println("A palavra não é um palíndromo.");
				}
				return true;
			case 13:
				System.out.print("Informe o valor a adicionar: ");
				novoValor = scan.nextInt();
				L1.inserirEmOrdem(novoValor);
				return true;
			default:
				System.out.println("Opção inválida, o programa será encerrado.");
				return false;
			}
		}
	}
}