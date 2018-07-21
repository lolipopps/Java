package DesignPattern.mediator;

/*
 * 中介者模式的结构
  中介者模式又称为调停者模式， 共分为3部分：

• 抽象中介者：定义好同事类对象到中介者对象的接口，用于各个同事类之间的通信。一般包括一个或几个抽象的事件方法，并由子类去实现。
• 中介者实现类：从抽象中介者继承而来，实现抽象中介者中定义的事件方法。从一个同事类接收消息，然后通过消息影响其他同时类。
• 同事类：如果一个对象会影响其他的对象，同时也会被其他对象影响，那么这两个对象称为同事类。在类图中，同事类只有一个，这其实是现实的省略，在实际应用中，
    同事类一般由多个组成，他们之间相互影响，相互依赖。同事类越多，关系越复杂。并且，同事类也可以表现为继承了同一个抽象类的一组实现组成。在中介者模式中，同事类之间必须通过中介者才能进行消息传递。
为什么要使用中介者模式
一般来说，同事类之间的关系是比较复杂的，多个同事类之间互相关联时，他们之间的关系会呈现为复杂的网状结构，这是一种过度耦合的架构，即不利于类的复用，也不稳定。
有六个同事类对象，假如对象1发生变化，那么将会有4个对象受到影响。如果对象2发生变化，那么将会有5个对象受到影响。也就是说，同事类之间直接关联的设计是不好的如
果引入中介者模式，那么同事类之间的关系将变为星型结构，从图中可以看到，任何一个类的变动，只会影响的类本身，以及中介者，这样就减小了系统的耦合。一个好的设计，
必定不会把所有的对象关系处理逻辑封装在本类中，而是使用一个专门的类来管理那些不属于自己的行为。
 
 *
 *同事类：有两个类A和B，类中各有一个数字，并且要保证类B中的数字永远
是类A中数字的100倍。也就是说，当修改类A的数时，将这个数字乘以100赋给类B，而修改类B时，要将数除以
100赋给类A。类A类B互相影响，就称为同事类。

有个缺点就是 同事类写死了  要改的话就要修改 中介者 增加方法 这也是中介者模式的部分,  否则就是观察者模式了。
 */

public class MediatorTest {
	public static void main(String[] args) {
		AbstractColleague collA = new ColleagueA();
		AbstractColleague collB = new ColleagueB();
		AbstractMediator am = new Mediator(collA, collB);

		System.out.println("==========设置A影响B==========");
		collA.setNumber(1288, am);
		System.out.println("collA的number值：" + collA.getNumber());
		System.out.println("collB的number值：" + collB.getNumber());
		System.out.println("==========设置B影响A==========");
		collB.setNumber(87635, am);
		System.out.println("collB的number值：" + collB.getNumber());
		System.out.println("collA的number值：" + collA.getNumber());
	}
}
