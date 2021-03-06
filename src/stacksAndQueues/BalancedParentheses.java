package stacksAndQueues;

import java.util.Stack;

public class BalancedParentheses {
	
	public static char[][] tokens = {
			{'{', '}'}, {'[', ']'}, {'(', ')'}
	};
	
	public static boolean isOpenTerm(char c) {
		for(char[] array : tokens) {
			if(array[0] == c) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean matches(char openTerm, char closeTerm) {
		for(char[] array : tokens) {
			if(array[0] == openTerm) {
				return array[1] == closeTerm;
			}
		}
		return false;
	}
	
	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		
		for(char c : expression.toCharArray()) {
			if(isOpenTerm(c)) {
				stack.push(c);
			}
			else {
				if(stack.isEmpty() || !matches(stack.pop(), c)) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String exp1 = "[()]{}{[()()]()}", exp2 = "[(])";
		
		System.out.println(isBalanced(exp1));
		System.out.println(isBalanced(exp2));
		
	}

}
