package Stack;

import java.util.Stack;



public class Stack_to_Queue {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void main(String[] args) {
		push(10);
		push(20);
		push(2);
		System.out.println(pop());
		System.out.println(pop());
		push(1);
		push(2);
		System.out.println(pop());
		System.out.println(pop());
	}

	public static void push(int node) {
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		stack1.push(node);
	}

	public static int pop() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();

	}

}
