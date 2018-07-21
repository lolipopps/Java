package DesignPattern.factory;

import DesignPattern.factory.Compressor.Engine;
import DesignPattern.factory.Compressor.Underpan;
import DesignPattern.factory.Compressor.Wheel;

/*
 * 定义：定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到其子类。
类型：创建类模式


首先需要说一下工厂模式。工厂模式根据抽象程度的不同分为三种：
简单工厂模式（也叫静态工厂模式）、本文所讲述的工厂方法模式、以及抽象工厂模式。工厂模式是编程中经常用到的一种模式。
它的主要优点有：
• 可以使代码结构清晰，有效地封装变化。在编程中，产品类的实例化有时候是比较复杂和多变的，通过工厂模式，将产品的实例化封装起来，使得调用者根本无需关心产品的实例化过程，只需依赖工厂即可得到自己想要的产品。
• 对调用者屏蔽具体的产品类。如果使用工厂模式，调用者只关心产品的接口就可以了，至于具体的实现，调用者根本无需关心。即使变更了具体的实现，对调用者来说没有任何影响。
• 降低耦合度。产品类的实例化通常来说是很复杂的，它需要依赖很多的类，而这些类对于调用者来说根本无需知道，如果使用了工厂方法，我们需要做的仅仅是实例化好产品类，然后交给调用者使用。对调用者来说，产品所依赖的类都是透明的。
工厂方法模式

工厂方法模式有四个要素：
• 工厂接口。工厂接口是工厂方法模式的核心，与调用者直接交互用来提供产品。在实际编程中，有时候也会使用一个抽象类来作为与调用者交互的接口，其本质上是一样的。
• 工厂实现。在编程中，工厂实现决定如何实例化产品，是实现扩展的途径，需要有多少种产品，就需要有多少个具体的工厂实现。
• 产品接口。产品接口的主要目的是定义产品的规范，所有的产品实现都必须遵循产品接口定义的规范。产品接口是调用者最为关心的，产品接口定义的优劣直接决定了调用者代码的稳定性。同样，产品接口也可以用抽象类来代替，但要注意最好不要违反里氏替换原则。
• 产品实现。实现产品接口的具体类，决定了产品在客户端中的具体行为。

 */
public class FactoryTest {
	
	public static void main(String[] args) {
		// 构建一个静态工厂   接口声明  子类实现
		IFactory factory = new Factory();
		// 工厂生产了一个产品  但是这样的只能 生产一种产品 
		ICar car = factory.createCar();
		
		ITrain train = factory.createTrain();
		
		
		Compressor compressor = new Compressor();
		Underpan underpan = compressor.new Underpan();
		Engine engine = compressor.new Engine();
		Wheel wheel = compressor.new Wheel();
		ICar car1 = new Car(underpan,wheel,engine);
		//动态工厂

	}
}
