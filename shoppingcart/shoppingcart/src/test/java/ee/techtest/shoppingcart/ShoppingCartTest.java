package ee.techtest.shoppingcart;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.Test;

public class ShoppingCartTest {

	@Test
	public void testSingleAddWithMultipleUnits() {final ShoppingCart cart = new ShoppingCart();
	final Product doveSoapProduct = new Product("Dove soap", new BigDecimal(39.99));
	final int quantity = 5;
	final BigDecimal totalPrice = new BigDecimal(199.95).setScale(2, RoundingMode.HALF_UP);
	
	cart.add(doveSoapProduct, quantity);
	
	final List<Product> products = cart.getProducts();
	assertEquals("Total price in cart is incorrect", cart.getTotalPrice(), totalPrice);
	assertEquals("Number of products is incorrect", products.size(), quantity);
	
	for(Product product:products) {
		assertEquals("Invalid product", product, doveSoapProduct);
	}}
	
}
