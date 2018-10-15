import java.util.*;

public class SameLetters {
	
	public static void main(String[] args) {

		String a = "John Hodson";
		String b = "Amelia Unseth";

		System.out.println(sameLettersQuad(a,b));
		System.out.println(sameLettersLin(a,b));
	}

	public static String sameLettersQuad(String a, String b) {

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < a.length(); i++) {

			for (int j = 0; j < b.length(); j++) {

				if (a.charAt(i) == b.charAt(j)) {
					ans.append(Character.toString(a.charAt(i)));
				}
			}
		}

		return ans.toString();
	}

	public static String sameLettersLin(String a, String b) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int freq;
		for (int i = 0; i < a.length(); i++) {
			if (map.containsKey(a.charAt(i))) {
				freq = map.get(a.charAt(i));
			}
			else {
				freq = 1;
			}
			map.put(a.charAt(i), freq);
		}

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < b.length(); i++) {

			if (map.containsKey(b.charAt(i))) { 
				ans.append(Character.toString(b.charAt(i)));
			}
		}

		return ans.toString();
	}
}