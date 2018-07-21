package DesignPattern.Prototype;

/*
原型模式主要用于对象的复制，它的核心是就是类图中的原型类Prototype。Prototype类需要具备以下两个条件：
• 实现Cloneable接口。在java语言有一个Cloneable接口，它的作用只有一个，就是在运行时通知虚拟机可以安全地在实现了此接口的类上使用clone方法。
    在java虚拟机中，只有实现了这个接口的类才可以被拷贝，否则在运行时会抛出CloneNotSupportedException异常。

• 重写Object类中的clone方法。Java中，所有类的父类都是Object类，Object类中有一个clone方法，作用是返回对象的一个拷贝，但是其作用域protected类型的，
    一般的类无法调用，因此，Prototype类需要将clone方法的作用域修改为public类型。原型模式是一种比较简单的模式，也非常容易理解，实现一个接口，
    重写一个方法即完成了原型模式。在实际应用中，原型模式很少单独出现。经常与其他模式混用，他的原型类Prototype也常用抽象类来替代。

原型模式的优点及适用场景
使用原型模式创建对象比直接new一个对象在性能上要好的多，因为Object类的clone方法是一个本地方法，它
直接操作内存中的二进制流，特别是复制大对象时，性能的差别非常明显。
使用原型模式的另一个好处是简化对象的创建，使得创建对象就像我们在编辑文档时的复制粘贴一样简单。
因为以上优点，所以在需要重复地创建相似对象时可以考虑使用原型模式。比如需要在一个循环体内创建对
象，假如对象创建过程比较复杂或者循环次数很多的话，使用原型模式不但可以简化创建过程，而且可以使系统
的整体性能提高很多。
原型模式的注意事项
• 使用原型模式复制对象不会调用类的构造方法。因为对象的复制是通过调用Object类的clone方法来完成
的，它直接在内存中复制数据，因此不会调用到类的构造方法。不但构造方法中的代码不会执行，甚至连访
问权限都对原型模式无效。还记得单例模式吗？单例模式中，只要将构造方法的访问权限设置为private
型，就可以实现单例。但是clone方法直接无视构造方法的权限，所以，单例模式与原型模式是冲突的，在使
用时要特别注意。
• 深拷贝与浅拷贝。Object类的clone方法只会拷贝对象中的基本的数据类型，对于数组、容器对象、引用对
象等都不会拷贝，这就是浅拷贝。如果要实现深拷贝，必须将原型模式中的数组、容器对象、引用对象等另
行拷贝。例如：
 */
public class PrototypeTest {
	public static void main(String[] args) {
		ConcretePrototype cp = new ConcretePrototype();
		for (int i = 0; i < 10; i++) {
			ConcretePrototype clonecp = (ConcretePrototype) cp.clone();
			System.out.println(clonecp);
	
			//clonecp.show();
		}
	}
}