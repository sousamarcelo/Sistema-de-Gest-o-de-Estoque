package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite tamanho do estoque: ");
		int stockSize = sc.nextInt();
		
		//criado lista de produtos
		Product[] products = new Product[stockSize];
		
		// a lista foi inicializada com null
		Product product = null;
		
		// está variavel será utilizada nas opções do swith/case
		int chosenNumber = 0;
		
		//variavel utilizada para controle de lista vazia ou não, é utilizada como referencia para o codigo
		boolean voidList = true;
		
		// optei por utiliza a estrutura de repetição "do/while", desta forma, pelo menos uma vez, será executado a menu de opçoes, antes de ser validado no while
		do {
			
			//Menu de opções
			System.out.println();
			System.out.println("Escolha as uma das opções abaixo: ");
			System.out.println("(1) ->  Adicionar um novo produto ao estoque");
			System.out.println("(2) ->  Atualizar informações de um produto existente.");
			System.out.println("(3) ->  Remover um produto do estoque.");
			System.out.println("(4) ->  Exibir a lista de produtos e suas informações.");
			System.out.println("(5) ->  Encerrar o programa. \n");
			System.out.print("Digite aqui: ");
			chosenNumber = sc.nextInt();
			System.out.println();
			
			
			
			switch (chosenNumber) {			
			
			// Caso 1: adicionar itens na lista
			case 1:
				boolean addProduct = false;
								
				System.out.println("Digite os dados do produto: ");
				System.out.print("Codigo: ");
				int code = sc.nextInt();
				sc.nextLine();
				System.out.print("Nome: ");
				String name = sc.nextLine();				
				System.out.print("Preço: ");				
				double price = sc.nextDouble();
				System.out.print("Quantidade em estoque: ");
				int quantityInStok = sc.nextInt();
								
				for (int i = 0; i < products.length; i++) {
					if (products[i] == null) {
						product = new Product(code, name, price, quantityInStok);						
						products[i] = product;
						addProduct = true;
						voidList = false;
						break;
					}									
				}
				
				System.out.println();
				if (addProduct) {
					System.out.println("Produto adicionado com sucesso!");
				}
								
				System.out.println();
				
				break;
			
			//Caso 2 atualiza itens na lista
			case 2:
				
				if (voidList) {
					System.out.println("Não existe produtos na lista");
				} else {
					
					System.out.print("Digite o codigo do produto que será atualizado: ");
					int codeUpdateAux = sc.nextInt();
					//sc.nextLine();
					boolean exist = false;
					for (int i = 0; i < products.length; i++) {
						if (codeUpdateAux == products[i].getCode()) {
							
							System.out.println("Digite os dados do produto: " + products[i].getName());
							System.out.print("Codigo: ");
							int codeUpdate = sc.nextInt();						
							System.out.print("Nome: ");
							String nameUpdate2 = sc.nextLine();
							sc.nextLine();
							System.out.print("Preço: ");						
							double priceUpdate = sc.nextDouble();
							System.out.print("Quantidade em estoque: ");
							int quantityInStokUpdate = sc.nextInt();
							
							products[i] = new Product(codeUpdate, nameUpdate2, priceUpdate, quantityInStokUpdate);
							exist = true;
							break;
						}
					}
					
					System.out.println();
					if (exist == false) {
						System.out.println("Produto não existe no estoque.");
					} else {
						System.out.println("Produto atualizado com sucesso!");
					}
				
				}
				
				break;		
			
			//Caso 3 remover itens da lista	
			case 3:
				if (voidList) {
					System.out.println("Não existe produtos na lista");
				} else {				
					System.out.print("Digite o codigo do produto que será removido: ");
					int codeRemove = sc.nextInt();				
					boolean remove = false;
					for (int i = 0; i < products.length; i++) {
						if (codeRemove == products[i].getCode()) {																		
							remove = true;
							products[i] = null;	
							//break;
						}
					}
					
					if (remove == false) {
						System.out.println("Produto não existe no estoque.");
					} else {
						System.out.println();
						System.out.println("X Produto removido com sucesso! X");
					}				
				}
				
				break;
			
			//Caso 4 listar itens adicionados
			case 4:
				System.out.println("Lista de produtos em estoque: ");
				voidList = true;
				for (Product p : products) {
					if (p != null) {
						System.out.println(p);
						voidList = false;
					}
				}
				
				if (voidList) {
					System.out.println("Lista vazia!");
				}
				System.out.println();
				
				break;
			
			default:
				if (chosenNumber != 5) {
					System.out.println("Digite um valor valido!");
				}
				
				break;
			}
			
			//chosenNumber = 0;
			
		} while (chosenNumber != 5);		
		
		System.out.println("Programa encerrado, obrigado!");
				
		sc.close();

	}

}
