package DesignPattern.factory;

import DesignPattern.factory.Compressor.Engine;
import DesignPattern.factory.Compressor.Underpan;
import DesignPattern.factory.Compressor.Wheel;

public class Train implements ITrain {
	public Train() {

	}

	public Train(Underpan underpan, Wheel wheel1, Wheel whee2, Wheel wheel3, Engine engine) {
		System.out.println("不用工厂模式 生产了一个火车");
	}

	@Override
	public void creatFactoryTrain(Underpan underpan, Wheel wheel1, Wheel wheel2, Wheel wheel3, Engine engine) {
		System.out.println("工厂模式生产了一个火车");
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

}
