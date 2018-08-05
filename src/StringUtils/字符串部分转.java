package StringUtils;

public class 字符串部分转 {
	public static void main(String[] args) {
		ReverseSentence("  ");
	}

	public static String ReverseSentence(String str) {
		if(str == null || str.equals("")) {
			return str;
		}
		if(str.replaceAll(" ","").equals("")) {
			return str;
		}
		StringBuffer buffer = new StringBuffer();
		String[] strings = str.split(" ");
		for (int i = strings.length-1; i >= 0; i--) {
			buffer.append(strings[i] + " ");
		}
		buffer.replace(buffer.length()-1,buffer.length(),"");
		System.out.println(buffer.toString());
		return buffer.toString(); 
	}

}
