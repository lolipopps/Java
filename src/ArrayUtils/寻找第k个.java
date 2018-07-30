package ArrayUtils;

public class 寻找第k个 {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;

		temp.next = new ListNode(2);
		temp = temp.next;

		temp.next = new ListNode(3);
		temp = temp.next;
		temp.next = new ListNode(4);
		temp = temp.next;
		temp.next = new ListNode(5);
		temp = temp.next;
		temp.next = new ListNode(6);
		findKthToTail(head, 7);
//		ListNode haed = ReverseList(head);
		while(head !=null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	public static ListNode findKthToTail(ListNode head, int k) {
		if (k == 0) {
			return null;
		}
		int num = 0;
		ListNode temp = head;
		while (temp != null && num < k) {
			temp = temp.next;
			num++;
		}
		if (num < k) {
			return null;
		}
		while (temp != null) {
			temp = temp.next;
			head = head.next;
			System.out.println(head.val);
		}
		
		return head;

	}

	public static ListNode ReverseList(ListNode head) { // ͷ�巨
		  if(head == null){
              return null;
          }
	ListNode temp = head;
		ListNode now = head;
		ListNode result = head;
		while (temp.next != null) {
			
			now = temp.next;
			temp.next = now.next;
			now.next = result;
			result = now;
		}
		return result;

	}

}
