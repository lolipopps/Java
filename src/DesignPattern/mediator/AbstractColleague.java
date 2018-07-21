package DesignPattern.mediator;

public abstract class AbstractColleague { // 抽象的同事类
	protected int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// 注意这里的参数不再是同事类，而是一个中介者   通过中介者修改值
	public abstract void setNumber(int number, AbstractMediator am);
}
 
class ColleagueA extends AbstractColleague {   // 同事A类  通过中介者修改值
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.AaffectB();
	}
}

class ColleagueB extends AbstractColleague {   // 同事B类  通过中介者修改值
	@Override
	public void setNumber(int number, AbstractMediator am) {
		this.number = number;
		am.BaffectA();
	}
}
