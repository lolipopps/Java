package Structs;

public class LinkList {
	ListNode head;
	ListNode current;// 当前结点对象
	int size;// 结点个数

	public int getSize() {
		return size;
	}

	// 初始化一个空链表
	// 初始化一个空链表
	public LinkList() {
		// 初始化头结点，让头指针指向头结点。并且让当前结点对象等于头结点。
		this.head = current = new ListNode();
		this.size = 0;// 单向链表，初始长度为零。
	}

	// 计算链表的长度
	public int ListLength(ListNode headNode) {
		int length = 0;
		ListNode currentNode = headNode;
		while (currentNode != null) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	ListNode InsertNode(ListNode headNode, ListNode nodeToInsert, int position) {
		if (headNode == null) { // 空链表直接插入
			return nodeToInsert;
		}
		if (position > size + 1 || position < 1) {
			System.out.println("Error position");
			return headNode;
		}
		if (position == 1) { // 插入到表头
			nodeToInsert.setNext(headNode);
			return nodeToInsert;
		} else {
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position - 1) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			nodeToInsert.setNext(currentNode);
			previousNode.setNext(nodeToInsert);
			size++;
		}
		return nodeToInsert;

	}

	ListNode DeleteNode(ListNode headNode, int position) {
		if (position > size || position < 1) {
			System.out.println("Error position");
			return headNode;
		}

		if (position == 1) { // 删除链表头
			ListNode currentNode = headNode.getNext();
			headNode = null;
			return currentNode;
		} else {
			ListNode previousNode = headNode;
			int count = 1;
			while (count < position) {
				previousNode = previousNode.getNext();
				count++;
			}
			ListNode currentNode = previousNode.getNext();
			previousNode.setNext(currentNode);
			currentNode = null;
			size--;
		}
		return headNode;
	}

	void DeleteList(ListNode headNode) {
		ListNode iterator = headNode;
		ListNode temp;
		while (iterator != null) {

			temp = iterator.getNext();
			iterator = null;
			iterator = temp;
		}

	}

}
