package Structs;

public class Test {

	public static void main(String[] args) {
		ADT adt = new ADT();
		adt.QuickMakeSet(10);
		
		adt.QuickUnion(1,3);	

		adt.QuickUnion(2,6);
		
		adt.QuickUnion(1,2);
		adt.showS();
	}

}
