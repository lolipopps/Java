package StringUtils;

import java.util.HashMap;

public class 只出现一次的字符 {

	public static void main(String[] args) {
		FirstNotRepeatingChar("google");
 
	}

	public static int FirstNotRepeatingChar(String str) {
		HashMap<Character, String> chs = new HashMap<Character, String>();
		int index = 0;
		String[] temp = null;
		for (char ch : str.toCharArray()) {
			if (!chs.containsKey(ch)) {
				chs.put(ch, "1-" + index);
			} else {
				temp = chs.get(ch).split("-");
				chs.put(ch, (Integer.parseInt(temp[0]) + 1) + "-" + temp[1]);
			}
			index++;
		}
		Character res = null;
		int nums = Integer.MAX_VALUE;
		for (Character ch : chs.keySet()) {
			temp= chs.get(ch).split("-");
			if(Integer.parseInt(temp[0])>1) {
				continue;
			}else {
				if(Integer.parseInt(temp[1]) <nums) {
					nums = Integer.parseInt(temp[1]);
					res = ch;
				}
			}
		}
		System.out.println(nums);
		if(res==null) {
			return -1;
		}else {
			return nums;
		}
		
	}
}
