package ee.techtest.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

public class ShoppingCart {
	private Product product = null;
	private int quantity = 0;
	
	public BigDecimal getTotalPrice() {
		return product.getPrice().multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_UP);
	}
	
	public List<Product> getProducts() {
		return Collections.nCopies(quantity, product);
	}
	
	public void add(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
}