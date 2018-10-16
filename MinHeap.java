import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	
	private List<Integer> nodes;
	private int size;

	public MinHeap() {

		nodes = new ArrayList<Integer>();
		size = 0;
	}

	private int leftChildIndex(int i) {

		return (2*i)+1;
	}

	private int rightChildIndex(int i) {

		return (2*i)+2;
	}

	private int parentIndex(int i) {

		return (i-1)/2;
	}

	public int removeMin() {

		if (this.size == 0) return Integer.MAX_VALUE;
		else if (this.size == 1) {
			this.size--;
			return nodes.remove(0);
		}

		//save the min and set the last element as the root node of the heap
		int min = nodes.get(0);
		nodes.set(0, nodes.get(size-1));
		nodes.remove(size-1);
		this.size--;


		//reheapify
		int parent = 0, left = leftChildIndex(0), right = rightChildIndex(0), toSwap = -1, temp = -1;

		/* repeat so long as the left and the right indexes are contained within the heap  
		   and the children nodes are less than the parent node */
		while (true) {

	 		if (right >= size) {

                  if (left >= size) break;
                  else toSwap = left;
            }
			else {
                  
                  if (nodes.get(left) <= nodes.get(right)) toSwap = left;
                  else toSwap = right;
            }
			if (nodes.get(parent) > nodes.get(toSwap)) {

				swap(parent, toSwap);

	 			parent = toSwap;
	 			left = leftChildIndex(parent);
	 			right = rightChildIndex(parent);
	 		}
	 		else break;
	 	}
	 	return min;
	}

	public int getMin() {

		if (nodes == null || this.size <= 0) return Integer.MAX_VALUE;

		return nodes.get(0);
	}

	public void insert(int num) {

		this.size++;
		nodes.set(size-1, num); //insert at size-1
		if (size == 1) return;

		int i = size-1;
		int parent = parentIndex(size);

		//check for parent violations
		while (parent != i && nodes.get(i) < nodes.get(parent)) {

		swap(i, parent);
		i = parent;
		parent = parentIndex(i);
	}

		return;
	}

	public boolean isEmpty() {

		return size == 0 || nodes == null;
	}

	private void swap(int i, int j) {

		int temp = nodes.get(j);
		nodes.set(j, nodes.get(i));
		nodes.set(i, temp);
	}
}