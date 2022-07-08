package arraysAndStrings;

public class StringCompression {
	//aabcccccaaa would become a2blc5a3
	public static String compression(String str) {
		String newStr = "";
		int count = 0, i = 0;
		
		while(i != str.length()) {
			count++;
			if( i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				newStr += str.charAt(i) + "" + count;
				count = 0;
			}
			i++;
			
		}
		
		return newStr.length() < str.length() ? newStr : str;
		//newStr.length() < str.length() return newStr ? return str
	}

	public static void main(String[] args) {
		
		System.out.println(compression("abcccccaaa")); //abc => returns abc

	}

}
