import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line="";
		System.out.println("历史关键词列表范例: ");
		TreeMap<String, Integer> map = new TreeMap<String,Integer>();
		while((line=in.nextLine()) !=null) {
			if(line.equals("")) {
				break;
			}
			String[] string = line.split(" ");
			try {
			map.put(string[0], Integer.parseInt(string[1]));
			}catch (Exception e) {
				System.out.println("输入的数据有误请重新输入。");
				map.clear();
			}
		
		}
		System.out.println("查询关键词范例: ");
		String key = in.nextLine();
		for(String str:map.keySet()) {
			if(isSame(key, str)) {
				System.out.println(str+" "+map.get(str));

			}
		}
	}
	
	// 判断字符转的元素是否一致
	public static boolean isSame(String s1, String s2) {
		int[] map = new int[5001];  
		// 13 是自己定义的长度 这个有可能会有问题会有hash 冲突两个不一样的值hash只是一样的导致会有问题 可以调大一点
		//但是会损失空间  汉字有几千个 可以 new 一个 几千个空间   5001 默认不超过 10000 个汉字
		if (s1.length() != s2.length()) {
			return false;
		}
		for (char ch : s1.toCharArray()) {
			map[(int) ch%5001]++;
		}
		for (char ch : s2.toCharArray()) {
			map[(int) ch%5001]--;
			if (map[(int) ch%5001] < 0) {
				return false;
			}
		}
		return true;

	}

}
