package DesignPattern.Prototype;

import java.util.ArrayList;
import java.util.Iterator;

// 通过重写 clone 方法
class Prototype implements Cloneable {
	public ArrayList<String> list = new ArrayList<String>();
	Prototype(){
		list.add(this.toString());
	}
	public Prototype clone() {
		Prototype prototype = null;
		try {
			prototype = (Prototype) super.clone();
			prototype.list = new ArrayList<String>();
			Iterator<String> aIterable = this.list.iterator();
			while(aIterable.hasNext()) {
				prototype.list.add(aIterable.next()); // 这样也不行 这个只是 浅拷贝
			}
			list.add(this.toString());
			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return prototype;
	}
}

class ConcretePrototype extends Prototype {
	public void show() {
		System.out.println("    原型模式实现类  ");
		Iterator<String> aIterable = this.list.iterator();
		while(aIterable.hasNext()) {
			System.out.print(aIterable.next()+"   "); // 这样也不行 这个只是 浅拷贝
		}
	}
}
