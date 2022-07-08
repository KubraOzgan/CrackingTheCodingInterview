package stacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class StackOfPlates<T> {
	
	ArrayList<Stack <T>> stacksList = new ArrayList<>();
	public int capacity=3;
	
//	public StackOfPlates(int capacity) {
//		this.capacity =  capacity;
//	}
	
	public Stack<T> getLastStack() {
		if(stacksList.size() == 0)  {
			return null;
		}
		return stacksList.get(stacksList.size() - 1); // return the stack inside array list
	}
	
	public void push(T value) {
		Stack<T> last = getLastStack();
		
		if(last != null && last.size() < capacity) { // add to last stack
			last.push(value);
		}
		else { // must create new stack
			Stack<T> stack = new Stack<>();
			stack.push(value);
			stacksList.add(stack);
		}
	}
	
	public T pop() {
		Stack<T> last = getLastStack();
		if(last == null) {
			throw new EmptyStackException();
		}
		T value = last.pop();
		if(last.isEmpty()) {
			stacksList.remove(stacksList.size() - 1);
		}
		
		return value;
	}
	
	public T popAt(int index) {
		T item = stacksList.get(index).pop();
		
		for(int i=index; i<stacksList.size() - 1; i++) {
			T next = stacksList.get(i+1).remove(0);
			stacksList.get(i).push(next);
		}
		Stack<T> last = getLastStack();
		if(last.isEmpty()) {
			stacksList.remove(stacksList.size() - 1);
		}
		return item;
	}
	
	 public void printStacks() {
	        for (Stack<T> stack : stacksList) {
	            for (T item : stack)
	                System.out.print(item + " ");
	            System.out.println("[TOP]");
	        }
	    }
	
	public static void main(String[] args) {
		StackOfPlates<Integer> setOfStacks = new StackOfPlates();
	    setOfStacks.push(1); setOfStacks.push(2); setOfStacks.push(3);
	    setOfStacks.push(4); setOfStacks.push(5); setOfStacks.push(6);
        setOfStacks.push(7); setOfStacks.push(8); setOfStacks.push(9);
        setOfStacks.printStacks();
        System.out.println();
        setOfStacks.popAt(1);
        setOfStacks.popAt(0);
        setOfStacks.printStacks();

	}

}
