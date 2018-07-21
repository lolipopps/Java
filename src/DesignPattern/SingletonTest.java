package DesignPattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 通过反射机制 得到单例 不安全 这样
		// java中，饿汉式单例要优于懒汉式单例。C++中则一般使用懒汉式单例。
		Singleton singleton = Singleton.getInstance1();
		System.out.println(singleton.toString()+"  hashCode"+singleton.hashCode());
		Singleton singleton1 = Singleton.getInstance1();
		System.out.println(singleton1.toString()+"  hashCode"+singleton1.hashCode());
		Class c = Class.forName(Singleton.class.getName());
		Constructor ct = c.getDeclaredConstructor();
		ct.setAccessible(true);
		Singleton singleton2 = (Singleton)ct.newInstance();
		System.out.println(singleton2.toString()+"  hashCode"+singleton2.hashCode());
	}
}
