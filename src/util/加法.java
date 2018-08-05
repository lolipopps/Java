package util;

public class 加法 {

	public static void main(String[] args) {
		System.out.println(Add(1, 2));

	}

	public static int Add(int num1, int num2) {
		if (num2 == 0)
	          return num1;
	     else
	          return Add(num1^num2, (num1&num2) << 1);


	}

}
