package arraysAndStrings;

public class IsUnique {
	
	public static boolean Unique(String str) {
		str = str.toLowerCase();
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<str.length(); j++) {
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		String str = "TerRa";
		if(Unique(str)) {
			System.out.println("Unique");
		}
		else {
			System.out.println("Not unique");
		}

	}

}
