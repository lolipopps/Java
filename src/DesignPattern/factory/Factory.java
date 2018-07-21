package DesignPattern.factory;

import DesignPattern.factory.Compressor.Engine;
import DesignPattern.factory.Compressor.Underpan;
import DesignPattern.factory.Compressor.Wheel;

public class Factory implements IFactory {

	public ICar createCar() {
		// 做了封装 提高代码重用率 适合批量生产
		Compressor compressor = new Compressor();
		Underpan underpan = compressor.new Underpan();
		Engine engine = compressor.new Engine();
		Wheel wheel = compressor.new Wheel();
		ICar car = new Car();
		car.creatFactoryCar(underpan, wheel, engine);
		return car;
	}

	@Override
	public ITrain createTrain() {
		// 做了封装 提高代码重用率 适合批量生产
		Compressor compressor = new Compressor();
		Underpan underpan = compressor.new Underpan();
		Engine engine = compressor.new Engine();
		Wheel wheel1 = compressor.new Wheel();
		Wheel wheel2 = compressor.new Wheel();
		Wheel wheel3 = compressor.new Wheel();
		ITrain train = new Train();
		train.creatFactoryTrain(underpan, wheel1, wheel2, wheel3, engine);
		return train;
	}
}