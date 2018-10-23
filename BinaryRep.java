public class BinaryRep {
	
	public static void main(String[] args) {

		int num = 7;
		System.out.println(getBinaryRep(8));
	}

	public static int getOnesInBinaryRep(int num) {
		int count = 0;
		while (num > 0) {
			if (num%2 == 1) {
				count++;
			}
			num/=2;
		}
		return count;
	}

	public static String getBinaryRep(int num) {

		StringBuilder res = new StringBuilder();

		while (num > 0) {
			if (num%2 == 1) {
				res.append("1");
			}
			else {
				res.append("0");
			}
			num/=2;
		}

		return reverse(res.toString());
	}

	public static String getHexRep(int num) {

		StringBuilder res = new StringBuilder();

		while (num > 0) {
			res.append(getHexDig(num%16));
			num/=16;
		}

		return reverse(res.toString());
	}

	private static String getHexDig(int dig) {

		
	}

	private static String reverse(String str) {

		char[] arr = str.toCharArray();

		int i = 0, j = arr.length-1;
		while (i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}

		return new String(arr);
	}

	private static void swap(char[] arr, int i, int j) {

		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}