package DesignPattern.factory;

import DesignPattern.factory.Compressor.Engine;
import DesignPattern.factory.Compressor.Underpan;
import DesignPattern.factory.Compressor.Wheel;

public interface ITrain {
	// 生产火车
	public void show();
	public void creatFactoryTrain(Underpan underpan, Wheel wheel1, Wheel wheel2, Wheel wheel3, Engine engine);
}
