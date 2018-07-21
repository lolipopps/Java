package DesignPattern.builder;

public class Director {
	// 在工厂模式上加了一层封装 导演类 可以返回任意一种类型的商品不像工厂的批量生产
	private Builder builder = new ConcreteBuilder();

	public Product getAProduct() {
		builder.setPart("宝马汽车", "X7", "白色");
		return builder.getProduct();
	}

	public Product getBProduct() {
		builder.setPart("奥迪汽车", "Q5", "黑色");
		return builder.getProduct();
	}

	public Product getCProduct() {
		builder.setPart("奔驰汽车", "B6", "红色色");
		return builder.getProduct();
	}
}
