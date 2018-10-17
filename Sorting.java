import java.util.*;

public class Sorting {
	
	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(9, 6, 3, 2, 1, 4, 3, 7));
		nums = iterativeMergeSort(nums);

		for(int num : nums) {
			System.out.println(num + " ");
		}
	}

	public static List<Integer> iterativeMergeSort(List<Integer> nums) {

		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();

		for (int num : nums) {
			queue.add(new ArrayList<Integer>(Arrays.asList(num)));
		}

		while (queue.size() > 1) {
			queue.add(merge(queue.remove(),queue.remove()));
		}

		return queue.remove();
	}

	public static List<Integer> recursiveMergeSort(List<Integer> nums) {

		if (nums.size() == 1) return nums;

		List<Integer> a = recursiveMergeSort(nums.subList(0,nums.size()/2));
		List<Integer> b = recursiveMergeSort(nums.subList(nums.size()/2, nums.size()));

		return merge(a,b);
	}

	public static List<Integer> merge(List<Integer> a, List<Integer> b) {

		int i = 0;
		int j = 0;
		List<Integer> merged = new ArrayList<Integer>();

		while (i < a.size() && j < b.size()) {

			if (a.get(i) == b.get(j)) {
				merged.add(a.get(i));
				merged.add(b.get(j));
				i++;
				j++;
			}
			else if (a.get(i) < b.get(j)) {
				merged.add(a.get(i));
				i++;
			}
			else { //a.get(i) > b.get(j)
				merged.add(b.get(j));
				j++;
			}
		}

		while (i < a.size()) {
			merged.add(a.get(i));
			i++;
		}

		while (j < b.size()) {
			merged.add(b.get(j));
			j++;
		}

		return merged;
	}

//TODO
	public static void countingSort() {

	}

//TODO
	public static void iterativeQuickSort() {

	}

//TODO
	public static void recursiveQuickSort() {

	}

//TODO
	public static void partition() {

	}

	public static List<Integer> bubbleSort(List<Integer> nums) {

		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = 1; i < nums.size(); i++) {
				if (nums.get(i-1) > nums.get(i)) {
					swapped = true;
					swap(nums, i, i-1);
				}
			}
		}

		return nums;
	}

	public static List<Integer> insertionSort(List<Integer> nums) {


		for (int i = 1; i < nums.size(); i++) {
			//the number to place into the sorted array is i

			int j = i-1;
			int toInsert = nums.get(i);

			while (j>=0 && nums.get(j) > toInsert) {
				nums.set(j+1, nums.get(j));
				j--;
			}

			 nums.set(j+1, toInsert);
		}

		return nums;
	}

	public static List<Integer> selectionSort(List<Integer> nums) {

		int min;

		for (int i = 0; i < nums.size()-1; i++) {

			min = i;
			for (int j = i; j < nums.size(); j++) {

				if (nums.get(j) < nums.get(min)) {
					min = j;
				}
			}

			swap(nums, i, min);
		}

		return nums;
	}

	public static List<Integer> heapSort(List<Integer> nums) {

		MinHeap heap = new MinHeap();

		for (int i = 0; i < nums.size(); i++) {
			heap.insert(nums.get(i));
		}

		int m = 0;
		while (!heap.isEmpty()) {
			nums.set(m++, heap.removeMin());
		}

		return nums;
	}

	public static void swap(List<Integer> nums, int i, int j) {

		int temp = nums.get(j);
		nums.set(j, nums.get(i));
		nums.set(i, temp);
	}
}