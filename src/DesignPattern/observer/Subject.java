package DesignPattern.observer;

import java.util.Vector;

public abstract class Subject {
	private Vector<Observer> obs = new Vector<Observer>();

	public void addObserver(Observer obs) {
		this.obs.add(obs);
	}

	public void delObserver(Observer obs) {
		this.obs.remove(obs);
	}

	protected void notifyObserver() {
		for (Observer o : obs) {
			o.update();
		}
	}

	public abstract void doSomething();
}