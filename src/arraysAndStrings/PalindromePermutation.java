package arraysAndStrings;

import java.util.*;
import java.util.Map.Entry;

public class PalindromePermutation {
	
	public static boolean isPalindromePermutation(String str) {
		
		int oddCount = 0;
		
		str = str.toLowerCase();
		Map<Character, Integer> countCh = new HashMap<>();
		
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(countCh.containsKey(ch)) {
				countCh.put(str.charAt(i), countCh.get(ch)+1);
			}
			else {
				countCh.put(ch, 1);
			}
		}
		
		for(Entry<Character, Integer> key : countCh.entrySet()) {
			if(key.getValue() % 2 == 1) {
				oddCount++;
			}	
		}
		
		return  (oddCount <=1); //odd olan birden fazla karakter varsa!!!!
	}

	public static void main(String[] args) {
		
		System.out.println(isPalindromePermutation("teabababet")); 

	}

}

// teabababaet true
// teabababet / tebababaet false