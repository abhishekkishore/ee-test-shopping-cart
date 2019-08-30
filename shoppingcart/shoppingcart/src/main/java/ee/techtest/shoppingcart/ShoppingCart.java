package ee.techtest.shoppingcart;

import java.util.Collections;
import java.util.List;

public class ShoppingCart {
	private Product product = null;
	private int quantity = 0;
	
	public double getTotalPrice() {
		return Math.round((product.getPrice() * quantity) * 100)/100.0;
	}
	
	public List<Product> getProducts() {
		return Collections.nCopies(quantity, product);
	}
	
	public void add(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}