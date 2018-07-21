package DesignPattern.factory;

import DesignPattern.factory.Compressor.Engine;
import DesignPattern.factory.Compressor.Underpan;
import DesignPattern.factory.Compressor.Wheel;

public interface ICar {
	public void creatFactoryCar(Underpan underpan, Wheel wheel, Engine engine);
}