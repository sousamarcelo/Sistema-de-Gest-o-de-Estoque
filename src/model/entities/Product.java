package model.entities;

public class Product {
	
	private String name;
	private Integer code;
	private Double price;
	private Integer quantityInStok;
	
	public Product(String name, Integer code, Double price, Integer quantityInStok) {
		this.name = name;
		this.code = code;
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
		return "Product [name=" + name + ", code=" + code + ", price=" + price + ", quantityInStok=" + quantityInStok
				+ "]";
	}
}
