package arraysAndStrings;

public class StringRotation {
	
	public static boolean isSubstring(String str1, String str2) {
		return (str1.length() == str2.length() && 
				(str1 + str1).indexOf(str2) != -1);
	}
	
	public static void main(String[] args) {
		
		String str1 = "waterbottle", str2 = "erbottlewat";
		
		if(isSubstring(str1, str2)) {
			System.out.println(str2 + " is a rotation of " + str1);
		}
		else {
			System.out.println(str2 + " is not a rotation of " + str1);
		}

	}

}

// str1 + str1 = wat(erbottlewat)erbottle
