package util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class HelloPython {
	public static void main(String[] args) {
		ArrayList<String> lists = new ArrayList<>();
		lists.add("S:\\");
		String result = runRemoteWin("192.168.174.130","hyt1","123456","listDir",lists);
		System.out.println("result       "+result);
	}
	public static String runRemoteWin(String ip,String username,String passwd,String methods,ArrayList<String> lists) {
		BufferedReader br = null;
		String[] pythonm = new String[6+lists.size()];
		pythonm[0] = "python";
		pythonm[1] = "G:\\hbsjjxbsgj\\src\\main\\resources\\properties\\RemoteWin.py";
		pythonm[2] = ip;
		pythonm[3] = username;
		pythonm[4] = passwd;
		pythonm[5] = methods;
		for(int i=0;i<lists.size();i++) {
			pythonm[6+i] = lists.get(i);
		}
		try {
 
			Process p = Runtime.getRuntime().exec(pythonm);
			br = new BufferedReader(new InputStreamReader(p.getInputStream(), Charset.forName("GBK")));
			String line = null;
			StringBuilder sb=new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line+"\n");
			}
			p.destroyForcibly();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}