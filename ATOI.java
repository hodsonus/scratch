import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ATOI {
	public static void main(String[] args) {

		String str = "a123";

		System.out.println(str);

		try {
			System.out.println(atoi(str));
		}
		catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException: " + str);
		}

	}

	public static int atoi(String str) {
		if (str == null || str.length() == 0 || containsInvalidChars(str)) throw new IllegalArgumentException();

		int sign = 1;
		if (str.charAt(0) == '-') {
			str = str.substring(1,str.length());
			sign = -1;
		}

		int digit;
		int res = 0;

		for (int i = str.length()-1, pow = 0; i >= 0; i--, pow++) {
			digit = str.charAt(i) - '0';
			res += Math.pow(10,pow)*digit;
		}

		return res*sign;
	}

	private static boolean containsInvalidChars(String str) {

		if (str.charAt(0) == '-') {
			if (str.length() == 1) return true;
			str = str.substring(1,str.length());
		}

		List<Character> acceptedChars = new ArrayList<Character>(Arrays.asList('0', '1', '2',
																 '3', '4', '5', '6',
																 '7','8', '9'));

		for (int i = 0; i < str.length(); i++) {

		 	if (acceptedChars.contains(str.charAt(i))) continue;
		 	else return true;
		}

		return false;
	}
}