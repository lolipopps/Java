package util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Java 实现深度复制
 *
 */
public class DeepCopy implements Serializable{
	String name = "Test";
	int   age = 10;
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		demo1();
		demo2();
	}
	/**
	 * 深度复制，实参类必须Serializable接口
	 */
	public static Object deepCopy(Object o) throws IOException, ClassNotFoundException {
//		//先序列化，写入到流里
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(o);
		//然后反序列化，从流里读取出来，即完成复制
		ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
		ObjectInputStream oi = new ObjectInputStream(bi);
		return oi.readObject();
	}
	
	
	/**
	 * 引用传递与深度复制
	 */
	public static void demo1() throws ClassNotFoundException, IOException {
		System.out.println("===========未使用深度复制=========");
		DeepCopy dc1 = new DeepCopy();
		dc1.age = 1;//初始化dc1里i的值
		DeepCopy dc2 = dc1;
		dc1.age = 2;//改变dc1里i的值
		System.out.println("dc1 : " + dc1.age);
		System.out.println("dc2(引用传递) : " + dc2.age);
		System.out.println("===========使用深度复制=========");
		DeepCopy dc3 = new DeepCopy();
		dc3.age = 1;//初始化dc3里i的值
		DeepCopy dc4 = (DeepCopy)deepCopy(dc3);
		dc3.age = 2;//改变dc3里i的值
		System.out.println("dc3 : " + dc3.age);
		System.out.println("dc4(深度复制) : " + dc4.age);
	}
	/**
	 * 集合的值复制与深度复制
	 */
	public static void demo2() throws ClassNotFoundException, IOException {
		System.out.println("===========未使用深度复制=========");
		//创建DeepCopy对象，并初始化i的值，添加到list1集合
		DeepCopy dc = new DeepCopy();
		dc.age = 1;//初始化dc1里i的值
		List<DeepCopy> list1 = new ArrayList<DeepCopy>();
		list1.add(dc);
		//未使用深度复制
		List<DeepCopy> list2 = new ArrayList<DeepCopy>(list1);//这里与使用Collections.copy(dest, src)结果一样
		//改变list1中元素的值
		for(DeepCopy d1 : list1) {
			//改变dc1里i的值
			d1.age = 2;
		}
		//遍历list
		for(DeepCopy d1 : list1) {
			System.out.println("list1 : " + d1.age);
		}
		//遍历list2
		for(DeepCopy d2 : list2) {
			System.out.println("list2(复制） : " + d2.age);
		}
		System.out.println("===========使用深度复制后=========");
		DeepCopy dc3 = new DeepCopy();
		dc3.age = 1;//初始化dc3里i的值
		List<DeepCopy> list3 = new ArrayList<DeepCopy>();
		list3.add(dc3);
		List<DeepCopy> list4 = (List<DeepCopy>) deepCopy(list3); 
		for(DeepCopy d : list3) {
			//改变dc3里i的值
			d.age = 2;
		}
		for(DeepCopy d3 : list3) {
			System.out.println("list3 : " + d3.age);
		}
		for(DeepCopy d4 : list4) {
			System.out.println("list4(深度复制）: " + d4.age);
		}
	}
	
}
