package NiuKe.Stack;

import java.util.Iterator;
import java.util.Stack;

public class Stack_min {
	public static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		push(1);
		push(2);
		push(7);
		push(11);
		push(-12);
		push(2);
		push(20);
	    pop();
		System.out.println(top());
		System.out.println(min());
	}

	public static void push(int node) {
		stack.push(node);

	}

	public static void pop() {
		stack.pop();
	}

	public static int top() {
		return stack.peek();

	}

	public static int min() {
		int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (min>tmp){
                min = tmp;
            }
        }
        return min;
	}
}
