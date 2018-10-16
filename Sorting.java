import java.util.*;

public class Sorting {
	
	public static void main(String[] args) {

		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(9, 6, 3, 2, 1, 4, 3, 7));
		insertionSort(nums);

		for(int num : nums) {
			System.out.println(num + " ");
		}
	}

//TODO
	public static void iterativeMergeSort() {

	}

//TODO
	public static void recursiveMergeSort() {

	}

//TODO
	public static void merge() {

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

	public static void bubbleSort(List<Integer> nums) {

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
	}

	public static void insertionSort(List<Integer> nums) {


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
	}

	public static void selectionSort(List<Integer> nums) {

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
	}

	public static void heapSort(List<Integer> nums) {

		MinHeap heap = new MinHeap();

		for (int i = 0; i < nums.size(); i++) {
			heap.insert(nums.get(i));
		}

		int m = 0;
		while (!heap.isEmpty()) {
			nums.set(m++, heap.removeMin());
		}
	}

	public static void swap(List<Integer> nums, int i, int j) {

		int temp = nums.get(j);
		nums.set(j, nums.get(i));
		nums.set(i, temp);
	}
}