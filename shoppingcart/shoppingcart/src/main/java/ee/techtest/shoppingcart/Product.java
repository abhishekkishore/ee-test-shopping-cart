package ee.techtest.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {
	private String name;
	private BigDecimal price;
	public Product(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else {
			// Bring up both prices to the same scale before comparing. Not doing this, let's assume a scale of 2.
//			int scale = price.scale() > other.price.scale()?price.scale():other.price.scale();
			final int scale = 2;
			if (!price.setScale(scale, RoundingMode.HALF_UP).equals(other.price.setScale(scale, RoundingMode.HALF_UP)))
				return false;
		}
		return true;
	}
}