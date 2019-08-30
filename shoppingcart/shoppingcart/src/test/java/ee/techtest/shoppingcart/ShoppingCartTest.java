package ee.techtest.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void testSingleAddWithMultipleUnits() {
		final ShoppingCart cart = new ShoppingCart();
		final Product doveSoapProduct = new Product("Dove soap", new BigDecimal(39.99));
		final int quantity = 5;
		final double totalPrice = 199.95;
		
		cart.add(doveSoapProduct, quantity);
		
		final List<Product> products = cart.getProducts();
		assertEquals("Total price in cart is incorrect", cart.getTotalPrice().doubleValue(), totalPrice, 0);
		assertEquals("Number of products is incorrect", products.size(), quantity);
		
		for(Product product:products) {
			assertEquals("Invalid product", product, doveSoapProduct);
		}
	}
	
	@Test
	public void testMultipleAddsWithMultipleUnits() {
		final ShoppingCart cart = new ShoppingCart();
		final Product doveSoapProduct = new Product("Dove soap", new BigDecimal(39.99));
		final int firstQuantity = 5;
		final int secondQuantity = 3;
		final double firstTotalPrice = 199.95;
		final double secondTotalPrice = 119.97;
		
		cart.add(doveSoapProduct, firstQuantity);
		cart.add(doveSoapProduct, secondQuantity);
		
		final List<Product> products = cart.getProducts();
		assertEquals("Total price in cart is incorrect", cart.getTotalPrice(), new BigDecimal(firstTotalPrice + secondTotalPrice).setScale(2, RoundingMode.HALF_UP));
		assertEquals("Number of products is incorrect", products.size(), firstQuantity + secondQuantity);
		
		for(Product product:products) {
			assertEquals("Invalid product", product, doveSoapProduct);
		}
	}
	
}
