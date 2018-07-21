package DesignPattern.builder;

public class BuilderTest {
	public static void main(String[] args) {
		Director director = new Director();
		Product product1 = director.getAProduct();
		product1.showProduct();
		
		Product product2 = director.getBProduct();
		product2.showProduct();
		
		Product product3 = director.getCProduct();
		product3.showProduct();

		TBuilder tBuilder = TBuilder.custom().setName("大众汽车").setType("D9").build();
		TBuilder tBuilder2 = TBuilder.custom().setName("路虎汽车").setType("L10").setColor("蓝色").setLength(2).build();
		System.out.println(tBuilder);
		System.out.println(tBuilder2);
	}
}
