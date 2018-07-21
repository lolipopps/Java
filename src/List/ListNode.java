package List;

public class ListNode {
     public int val;
     public ListNode next;
     public ListNode(int x) { val = x; }
     public ListNode() {
		
	}
	public int getData() {
 		return val;
 	}
 	public void setData(int data) {
 		this.val = data;
 	}
 	public ListNode getNext() {
 		return next;
 	}
 	public void setNext(ListNode next) {
 		this.next = next;
 	}
     public static  ListNode getList(int[] num) {
    	 if(num.length ==0)
    		 return null;
    	 ListNode root = new ListNode(num[0]);
    	 ListNode p = root ;
    	 for(int i=0;i<num.length;i++) {
    		 ListNode temp = new ListNode(num[i]);
    		 p.next = temp;
    		 p = p.next;
    	 }
    	 return root;
     }
}
