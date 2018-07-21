package DesignPattern.factory;

import DesignPattern.factory.Compressor.Engine;
import DesignPattern.factory.Compressor.Underpan;
import DesignPattern.factory.Compressor.Wheel;

public class Car implements ICar {  // 定义了一个车
	// 不用工厂模式
	public Car(Underpan underpan, Wheel wheel, Engine engine) {
		System.out.println("不用工厂模式 生产了一个汽车");
	}
	
	public Car() {
		
	}

	public void creatFactoryCar(Underpan underpan, Wheel wheel, Engine engine) {
		System.out.println("工厂模式生产了一个 汽车");
	}
}