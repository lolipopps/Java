package DesignPattern.observer;

public class ConcreteSubject extends Subject {
	public void doSomething() {
		System.out.println("被观察者事件反生");
		this.notifyObserver();
	}
}