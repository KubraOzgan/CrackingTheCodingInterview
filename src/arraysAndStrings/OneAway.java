package arraysAndStrings;

public class OneAway {
	
	public static boolean edit(String str, String newStr) {
		
		str = str.toLowerCase();
		newStr = newStr.toLowerCase();
		
		if (str.length() == newStr.length()) {
			return replaceOneCharacter(str, newStr);
		} 
		else if (str.length()+ 1 == newStr.length()) {
			return insertOneCharacter(str, newStr);
		} 
		else if (str.length() - 1 == newStr.length()) {
			return insertOneCharacter(newStr, str);
		}
		
		return false;
	}
	
	public static boolean replaceOneCharacter(String str, String newStr) {
		
		boolean dif = false;
		for(int i=0 ; i<str.length(); i++) {
			if(str.charAt(i) != newStr.charAt(i)) {
				if(dif) { //If it is true then it means there MORE than one character replaced
					return false;
				}
				dif = true;
			}
		}
		return true;
	}
	
	public static boolean insertOneCharacter(String str, String newStr) { //Insert a character into str
		int index1 = 0, index2 = 0;
		
		while(index2 < newStr.length() && index1 < str.length()) {
			if(str.charAt(index1) != newStr.charAt(index2)) {
				if(index1 != index2) // It  means there is a difference at difference indexs
					return false;//aplex applea (4 ve 5 te de farkli olurlar)
				index2++; // yani index2nin yeni degerinden oncesine eklenmis: aple -> apple : index1=2(l) ve index2=2(p) de farklýlýk var, index2'yi bir arttýrýp 3 yap, orda eslesip devam et.
				//Bir deger atladik index1 2 ve index2 3 te ayni oldular.
			}
			else {
				index1++; 
				index2++;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		
		System.out.println(edit("aple", "apple"));

	}

}

/*
 aple -> apple
 index1  index2
  0			0
  1			1 
  2			2 Farklýlýk	
  2			3 Ayný oldu
  3			4 
  while'dan cikar
 */




/*One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false */