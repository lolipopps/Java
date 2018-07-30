package ArrayUtils;


public class Merge {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;

		temp.next = new ListNode(3);
		temp = temp.next;

		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		
		ListNode head2 = new ListNode(2);
		temp = head2;

		temp.next = new ListNode(4);
		temp = temp.next;

		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(8);
		temp = temp.next;
		ListNode Result = Merge(head,head2);
		while(Result !=null) {
			System.out.println(Result.val);
			Result = Result.next;
		}
	}

	public static ListNode Merge(ListNode list1, ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		ListNode result = null;
		if(list1.val > list2.val) {
			result = list2;
			list2 = list2.next;
		}else {
			result = list1;
			list1 = list1.next;
		}
		ListNode temp = result;
		while(list1 != null && list2 != null) {
			if(list1.val <= list2.val) {
				temp.next = list1;
				list1 = list1.next;
			}else {
				temp.next = list2;
				list2 = list2.next;
			}
			temp = temp.next;
		}
		if(list1 == null) {
			temp.next = list2;
		}else { 
			temp.next = list1;
		}

		
		return result;
	}

}
