package List;

import java.util.HashMap;
import java.util.HashSet;

public class 查找公共节点 {
	public static void main(String[] args) {
		ListNode root1 = ListNode.getList(new int[] { 1, 2, 3, 4, 5 });
		ListNode root2 = ListNode.getList(new int[] { 6, 8, 9, 4, 3 });
		System.out.println(FindFirstCommonNode(root1, root2));
	}

	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		HashSet<String> set = new HashSet<String>();
		ListNode temp = pHead1;
		while (temp.next != null) {
			set.add(temp.toString());
			temp = temp.next;
		}
		temp = pHead2;
		ListNode result = null;
		while (temp.next != null) {
			if(set.contains(temp.toString())) {
				return temp;
			}
			temp = temp.next;
		}
		return result;

	}
}
