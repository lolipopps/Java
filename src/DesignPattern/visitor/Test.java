package DesignPattern.visitor;

class A {
	public void method1() {
		System.out.println("我是A");
	}

	public void method2(B b) {
		b.showA(this);
	}
}

class B {
	public void showA(A a) {
		a.method1();
	}
}

public class Test {
	public static void main(String[] args) {
		A a = new A();
		a.method1();   // 对于类A来说，类B就是一个访问者。  类似于通过 A 访问 B 中的 访问A的方法 绕了一圈
		a.method2(new B());
	}
}