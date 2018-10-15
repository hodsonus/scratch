import java.util.*;

public class Permutation {

	public static void main(String[] args) {

		List<String> permutations = generatePermutations("abcdefghij");

		for (int i = 0; i < permutations.size(); i++) {
			System.out.println(permutations.get(i));
		}
	}

	public static List<String> generatePermutations(String str) {

		return permutationsHelper(str, new HashMap<String, List<String>>());
	}

	private static List<String> permutationsHelper(String str, Map<String, List<String>> map) {

		if (map.containsKey(str)) return map.get(str);

		List<String> allPerms = new ArrayList<String>();

		if (str.length() == 1) {
			allPerms.add(str);
			return allPerms;
		}

		for (int i = 0; i < str.length(); i++) {
			 List<String> subPerms = permutationsHelper(removeChar(str, i), map);
			 for (int j = 0; j < subPerms.size(); j++) {
			 	allPerms.add(characterAt(str,i) + subPerms.get(j));
			 }
		}

		map.put(str, allPerms);

		return allPerms;
	}

	private static String characterAt(String str, int i) {

		return str.substring(i,i+1);
	}

	private static String removeChar(String str, int i) {

		return str.substring(0,i) + str.substring(i+1,str.length());
	}
}