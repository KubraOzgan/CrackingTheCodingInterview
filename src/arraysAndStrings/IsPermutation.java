package arraysAndStrings;

import java.util.Arrays;

public class IsPermutation {
	
	public static boolean permutation(String str, String s) {
		if(str.length() != s.length())
			return false;
		
		str = str.toLowerCase();
		s = s.toLowerCase();
		
		char[] strArray = str.toCharArray(), sArray = s.toCharArray();
		Arrays.sort(strArray);
		Arrays.sort(sArray);
		
		for(int i=0; i<str.length(); i++) {
			if(strArray[i] != sArray[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		
		if(permutation("Terra", "tERra")) {
			System.out.println("Permutation");
		}
		else {
			System.out.println("Not permutation");
		}

	}
}

/*If two strings are permutations, then we know they have the same characters, but in different orders. Therefore,
sorting the strings will put the characters from two permutations in the same order. We just need to
compare the sorted versions of the strings.

 String sort(String s) {
	 char[] content= s.toCharArray();
	 java.util.Arrays.sort(content);
	 return new String(content);
 }

 boolean permutation(String s, String t) {
	 if (s.length() != t.length()) {
	 	return false;
	 }3
	 return sort(s).equals(sort(t));
}*/
