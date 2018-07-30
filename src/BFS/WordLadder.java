package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
class Pair {
    String str;
    ArrayList<String> path;
    HashSet<String> hash;
    Pair(String str, ArrayList<String> path, HashSet<String> hash) {
        this.str  = str;
        this.path = path;
        this.hash = hash;
    }
}
public class WordLadder {



	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		HashSet<String> dict = new HashSet<String>();
		String[] strings = { "hot", "dot", "dog", "lot", "log" };
		for (String str : strings) {
			dict.add(str);
		}

		//System.out.println(ladderLength(start, end, dict));
		System.out.println(findLadders(start, end, dict));
	}

	public static int ladderLength(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || start.length() == 0 || end.length() == 0 || start.length() != end.length())
			return 0;

		LinkedList<String> wordQueue = new LinkedList<String>(); // 用队列做图的广度优先遍历
		int level = 1; // the start string already count for 1
		int curnum = 1;// the candidate num on current level
		int nextnum = 0;// counter for next level

		wordQueue.add(start);

		while (!wordQueue.isEmpty()) {
			String word = wordQueue.poll();  // 回退一格 计数减一
			curnum--;
			for (int i = 0; i < word.length(); i++) {
				char[] wordunit = word.toCharArray();
				for (char j = 'a'; j <= 'z'; j++) {
					wordunit[i] = j;
					String temp = new String(wordunit);
					if (temp.equals(end))
						return level + 1;
					if (dict.contains(temp)) {
						wordQueue.add(temp);
						nextnum++;
						dict.remove(temp);
					}
				}
			}

			if (curnum == 0) {
				curnum = nextnum;
				nextnum = 0;
				level++;
			}
		}

		return 0;
	}

	public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> path = new ArrayList<String>();
        HashSet<String>   hash = new HashSet<String>();
        if(start==null||end==null||start.length()!=end.length()) {
            return result;
        }
        Queue<Pair> queue = new LinkedList<Pair>();
        path.add(start);
        hash.add(start);
        Pair   node = new Pair(start, path,hash);
        int min_length = -1;
        queue.add(node);
        while(!queue.isEmpty()) {
            node = (Pair)queue.poll();
            String str = node.str;
            for(int i=0;i<str.length();i++) {
                char[] strCharArr = str.toCharArray();
                for(char ch='a';ch<='z';ch++) {
                    if(strCharArr[i]==ch) {
                        continue;
                    }
                    strCharArr[i] = ch;
                    String newWord = new String(strCharArr);
                    if(newWord.equals(end)==true) { // 找到了 最终的答案
                        path = node.path;
                        path.add(newWord);
                        if(min_length==-1) {
                            min_length = path.size();   // 当前长度 min_length 可能会存在多个
                        }
                        if(path.size()>min_length) { // 再一次找到 但是长度变长了了 不要
                            return result;
                        } else {
                            result.add(path);
                            //dict.remove(newWord);
                            continue;
                        }
                    } else {
                        if(dict.contains(newWord)&&!node.hash.contains(newWord)){  // 这个的目的是确保来了的不会再来  比如  aat  bat  aat 来过 再次 aat 又来了
                            path = new ArrayList<String>(node.path);
                            hash = new HashSet<String>(node.hash);
                            path.add(newWord); // 用来存路径
                            hash.add(newWord);
                            Pair newnode = new Pair(newWord, path,hash);
                            queue.add(newnode);
                            //dict.remove(newWord);
                        }
                    }
                }
            }
        }
        return result;
    }
	

}
