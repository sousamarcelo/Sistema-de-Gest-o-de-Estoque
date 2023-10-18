package model.entities;

public class Product {	
	
	private Integer code;
	private String name;
	private Double price;
	private Integer quantityInStok;
	
	public Product(Integer code, String name, Double price, Integer quantityInStok) {
		this.code = code;
		this.name = name;		
		this.price = price;
		this.quantityInStok = quantityInStok;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantityInStok() {
		return quantityInStok;
	}

	public void setQuantityInStok(Integer quantityInStok) {
		this.quantityInStok = quantityInStok;
	}

	@Override
	public String toString() {
		return "Codigo: " +  getCode() + ", Nome: " + getName() + ", Preço: " + getPrice() + ", Estoque: " + getQuantityInStok();
	}
}
