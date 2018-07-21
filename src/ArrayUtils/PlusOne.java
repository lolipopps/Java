package ArrayUtils;

public class PlusOne {

	public static void main(String[] args) {
		int[] result = plusOne(new int[] {9,3,9});
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}

	}
	public static int[] plusOne(int[] digits) {
		int temp = 0;
		int[] b=new int[digits.length+1];//新数组
		for(int i=digits.length-1;i>=0;i--) {
			temp = digits[i] + 1;
			digits[i] = temp % 10;
			if(temp<10) {
				return digits;
			}else if(i==0) {
				System.arraycopy(digits, 0, b, 1, digits.length);//将a数组内容复制新数组b
				b[0] = 1;
				return b;
			}
		}
		return digits;
    }

}
