package DesignPattern.builder;

public class ConcreteBuilder extends Builder {
	private Product product = new Product();

	@Override
	public void setPart(String arg1, String arg2, String args) {
		product.setName(arg1);
		product.setType(arg2);
		product.setColor(args);
	}

	@Override
	public Product getProduct() {
		return product;
	}

}
