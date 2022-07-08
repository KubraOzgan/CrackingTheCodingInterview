package stacksAndQueues;

public class ThreeInOne {
	
	static class KStack {
		int arr[]; // size n, actual content
		int top[]; // size k, store indexes of top elements of stacks
		int next[]; //size n, store next entry in all stacks and also free list
		
		int n, k, free; // free is to store beginning index of free list
		
		KStack(int k, int n) {
			this.k = k;
			this.n = n;
			arr = new int[n];
			top = new int[k];
			next = new int[n];
			
			// All stacks are empty 
			for(int i=0; i<k; i++) { 
				top[i] = -1;
			}
			
			//All spaces free
			free = 0;
			for(int i=0; i<n-1; i++) {
				next[i] = i+1;
			}
			next[n-1] = -1; // Indicate end of a free list, when we get free = -1, we'll know that is full
		}
		
		boolean isFull() {
			return free == -1;
		}
		
		boolean isEmpty(int stackNo) 
        {
            return (top[stackNo] == -1);
        }
		
		void push(int item, int stackNo) {
			if(isFull()) {
				System.out.println("Full");
				return;
			}
			int index = free;
			free = next[index];
			
			next[index] = top[stackNo];
			top[stackNo] = index; // Top element of this stack (added last will be top)
			arr[index] = item;
		}
		
		int pop(int stackNo) {
			if(isEmpty(stackNo) ) {
				System.out.println("Empty");
				return Integer.MAX_VALUE;
			}
			int index = top[stackNo];
			top[stackNo] = next[index]; //Change top to store next of previous top
			
			// Attach the previous top to the beginning of free list
			next[index] = free; //index 3 icin freenin nexti 3 oldu
			free = index;
			
			return arr[index];
			
		}
		
	}

	public static void main(String[] args) {
		 int k = 3, n = 10;
         
	        KStack ks = new KStack(k, n);
	  
	        ks.push(15, 2);
	        ks.push(45, 2);
	  
	        // Let us put some items in stack number 1
	        ks.push(17, 1);
	        ks.push(49, 1);
	        ks.push(39, 1);
	  
	        // Let us put some items in stack number 0
	        ks.push(11, 0);
	        ks.push(9, 0);
	        ks.push(7, 0);
	  
	        System.out.println("Popped element from stack 2 is " + ks.pop(2));
	        System.out.println("Popped element from stack 1 is " + ks.pop(1));
	        System.out.println("Popped element from stack 0 is " + ks.pop(0));

	}

}
