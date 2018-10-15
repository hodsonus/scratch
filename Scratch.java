import java.util.*;

public class Scratch {
	public static void main(String[] args) {

		int start = 6;
		int hops = 25;

		long startTime = System.currentTimeMillis();
		int ans = memoizedKnightDialer(start,hops);
		long elapsedTime = System.currentTimeMillis() - startTime ;
		System.out.println("Time elapsed: " + elapsedTime + " ms.");
		System.out.println("Resulting dynamic programming answer: " + ans);

		System.out.print("\n\n");

		startTime = System.currentTimeMillis();
		ans = naiveKnightsDialer(start,hops);
		elapsedTime = System.currentTimeMillis() - startTime ;
		System.out.println("Time elapsed: " + elapsedTime + " ms.");
		System.out.println("Resulting naive answer: " + ans);
	}

	public static int naiveKnightsDialer(int start, int hops) {
		if (hops == 0) return 1;

		int numbers = 0;
		List<Integer> neighbors = getNeighbors(start);
		for (int neighbor : neighbors) {
			numbers += naiveKnightsDialer(neighbor, hops-1);
		}
		return numbers;
	}

	public static int memoizedKnightDialer(int start, int hops) {

		return dynamicHelper(start, hops, new HashMap<String,Integer>());
	}

	//the hashmap maps start -> sequences
	private static int dynamicHelper(int start, int hops, Map<String, Integer> map) {
		if (hops == 0) return 1;
		String key = Integer.toString(start) + "," + Integer.toString(hops);
		if (map.containsKey(key)) return map.get(key);

		int sequences = 0;
		List<Integer> neighbors = getNeighbors(start);
		for (int neighbor : neighbors) {
			sequences += dynamicHelper(neighbor, hops-1, map);
		}

		map.put(key, sequences);
		return sequences;
	}

	private static List<Integer> getNeighbors(int start) {
		if (start == 1) {
			return new ArrayList<Integer>(Arrays.asList(6,8));
		}
		else if (start == 2) {
			return new ArrayList<Integer>(Arrays.asList(7,9));
		}
		else if (start == 3) {
			return new ArrayList<Integer>(Arrays.asList(4,8));
		}
		else if (start == 4) {
			return new ArrayList<Integer>(Arrays.asList(3,9,0));
		}
		else if (start == 5) {
			return new ArrayList<Integer>();
		}
		else if (start == 6) {
			return new ArrayList<Integer>(Arrays.asList(1,7,0));
		}
		else if (start == 7) {
			return new ArrayList<Integer>(Arrays.asList(2,6));
		}
		else if (start == 8) {
			return new ArrayList<Integer>(Arrays.asList(1,3));
		}
		else if (start == 9) {
			return new ArrayList<Integer>(Arrays.asList(2,4));
		}
		else if (start == 0) {
			return new ArrayList<Integer>(Arrays.asList(4,6));
		}
		else return new ArrayList<Integer>();
	}
}