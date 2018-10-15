import java.util.*;

public class CutRod {
	
	public static void main(String[] args) {

		int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
		int[] lengths = {1, 2, 3, 4, 5,  6,  7,  8};

		int length = 4;

		CutRod sut = new CutRod();

		System.out.println(sut.maxPrice(prices, length));
	}

	Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int maxPrice(int[] prices, int length) {

		if (length == 0) return 0;

		if (map.containsKey(length)) return map.get(length);

		int ans = Integer.MIN_VALUE;

		int curr;
		for (int i = 1; i <= length; i++) {

			curr = prices[i-1] + maxPrice(prices, length - i);
			if (curr > ans) {
				ans = curr;
			}
		}

		map.put(length, ans);
		return ans;
	}

}