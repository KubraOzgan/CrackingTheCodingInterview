package stacksAndQueues;

import java.util.Stack;

public class StackMin extends Stack<Integer>{
	
	Stack<Integer> s2;
	public StackMin() {
		s2 = new Stack<Integer>();
	}
	
	int min() {
		if(s2.isEmpty())
			return Integer.MAX_VALUE;
		else {
			return s2.peek(); 
		}
	}
	
	void push(int value) {
		if(value <= min()) {
			s2.push(value);
		}
		super.push(value);
	}
	
	public Integer pop() { //int dersek Stack'teki int ile cakisir
		int value = super.pop();
		if(value == min()) { //s2 de varsa zaten bastadir.
			s2.pop();
		}
		return value;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
