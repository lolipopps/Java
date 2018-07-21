package DesignPattern.builder;

public class Product {
	private String name;
	private String type;
	private String color;

	public void showProduct() {
		System.out.println("Director  名称： " + name + "  型号：" + type+"  颜色：" + color);
	
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
