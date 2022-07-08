package stacksAndQueues;

import java.util.Stack;

public class QueueViaStacks<T> {
	
	Stack<T> mainStack, tempStack;
	public QueueViaStacks() {
		mainStack = new Stack<T>();
		tempStack = new Stack<T>();
	}
	
	public void add(T value) {
		mainStack.push(value);
	}
	
	//Main = 1,2,3,4 Temp = 4,3,2,1 (1 is temp's top but also the first element (FIFO QUEUE)
	public void mainToTemp() {
		while(tempStack.isEmpty()) {
			if(!mainStack.isEmpty()) {
				tempStack.push(mainStack.pop());
			}
		}
	}
	
	public T peek() {
		mainToTemp();
		return tempStack.peek();
	}
	
	public T remove() {
		mainToTemp();
		return tempStack.pop();
	}
	
	public int size() {
		return mainStack.size() + tempStack.size();
	}
}
