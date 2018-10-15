import java.util.*;
import Key;

public class Knapsack {
	
	public static void main(String[] args) {


		int values[] = new int[]{60, 100, 120, 200, 240, 250, 300, 110, 120, 140, 123, 145, 165, 137, 17, 190, 15, 16, 147, 120}; 
        int weights[] = new int[]{10, 20, 30, 30, 30, 20, 22, 12, 15, 19, 12, 13, 14, 15, 16, 17, 17, 18, 19, 20}; 
    	int Weight = 100; 
    	int Num = values.length; 
    	Knapsack sut = new Knapsack();

    	long startTime = System.currentTimeMillis();
		int ans = sut.dpKnapsack(weights, values, Num, Weight, new HashMap<Key, Integer>());
		long elapsedTime = System.currentTimeMillis() - startTime ;
		System.out.println("Time elapsed: " + elapsedTime + " ms.");
		System.out.println("Resulting dynamic programming answer: " + ans);

		System.out.println("\n");

		startTime = System.currentTimeMillis();
		ans = sut.naiveKnapsack(weights, values, Num, Weight);
		elapsedTime = System.currentTimeMillis() - startTime ;
		System.out.println("Time elapsed: " + elapsedTime + " ms.");
		System.out.println("Resulting naive answer: " + ans);
	}

	/* weights and values correspond to the values of the ith index in the array, 
	n represents the number of items in the sack (from 0 to n) and W represents 
	the total weight that our knapsack can hold, the map maps key () -> Value of bag*/
	public int dpKnapsack(int weights[], int values[], int Num, int Weight, Map<Key, Integer> map) {

		if (Num == 0 || Weight == 0) return 0;

		Key currKey = new Key(Num, Weight);
		if (map.containsKey(currKey)) return map.get(currKey);

		if (weights[Num-1] > Weight) return dpKnapsack(weights, values, Num-1, Weight, map);

		int currSol = Math.max(values[Num-1] + dpKnapsack(weights, values, Num-1, Weight-weights[Num-1], map),
						dpKnapsack(weights, values, Num-1, Weight, map));

		map.put(currKey, currSol);

		return currSol;
	}

	public int naiveKnapsack(int weights[], int values[], int Num, int Weight) {
		if (Num == 0 || Weight == 0) return 0;

		if (weights[Num-1] > Weight) return naiveKnapsack(weights, values, Num-1, Weight);

		return Math.max(values[Num-1] + naiveKnapsack(weights, values, Num-1, Weight-weights[Num-1]),
						naiveKnapsack(weights, values, Num-1, Weight));
	}

	private class Key {

		private int num;
		private int weight;

		public Key(int num, int weight) {
			this.num = num;
			this.weight = weight;
		}

		@Override
		public boolean equals(Object obj) {

			if (obj instanceof Key) {

				Key foreignKey = (Key) obj;
				return this.num == foreignKey.num && this.weight == foreignKey.weight;
			}
			else {

				return false;
			}
		}

		@Override
		public int hashCode() {

			//Cantor pairing function
			return (num+weight)*(num+weight+1)/2+weight;
		}
	}
}