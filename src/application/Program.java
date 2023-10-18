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
		
		Product[] products = new Product[stockSize];
		Product product = null;
		
		int chosenNumber = 0;
		
		
		do {
			
			System.out.println();
			System.out.println("Escolha as uma das opções abaixo: ");
			System.out.println("(1) -> Adicionar um novo produto ao estoque");
			System.out.println("(2) ->  Atualizar informações de um produto existente.");
			System.out.println("(3) ->  Remover um produto do estoque.");
			System.out.println("(4) ->  Exibir a lista de produtos e suas informações.");
			System.out.println("(5) ->  Encerrar o programa. \n");
			System.out.print("Escolha: ");
			chosenNumber = sc.nextInt();
			System.out.println();
			
			switch (chosenNumber) {
			
			case 1:
				
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
				
				System.out.println("Debug - nameNew: " + name);
				
				boolean addProduct = false;
				
				for (int i = 0; i < products.length; i++) {
					if (products[i] == null) {
						product = new Product(code, name, price, quantityInStok);						
						products[i] = product;
						addProduct = true;
						break;
					}
				}
				
				if (addProduct) {
					System.out.println("Produto adicionado com sucesso!");
				}
				System.out.println();
				
				break;
				
			case 2:
				System.out.print("Digite o nome do produto que será atualizado: ");
				String nameUpdate = sc.nextLine();
				sc.nextLine();
				boolean exist = false;
				for (int i = 0; i < products.length; i++) {
					if (nameUpdate.toUpperCase() == products[i].getName().toUpperCase()) {
						
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
				
				if (exist == false) {
					System.out.println("Produto não existe no estoque.");
				} else {
					System.out.println("Produto atualizado com sucesso!");
				}
				
				break;
			
				
			case 3:				
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
				
				break;
				
			case 4:
				System.out.println("Lista de produtos em estoque: ");
				boolean voidList = true;
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
